package com.example.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.outlined.AutoStories
import androidx.compose.material.icons.outlined.Headphones
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.model.LevelType
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.LessonsScreen
import com.example.ui.screens.ListeningScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.ReadingWritingScreen
import com.example.ui.screens.SpeakingScreen
import com.example.ui.screens.TestsScreen
import com.example.ui.screens.VocabularyScreen
import kotlinx.coroutines.launch

data class NavItem(
    val screen: Screen,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

// Primary bottom navigation items (5 clean, accessible touch targets)
private val BOTTOM_NAV_ITEMS = listOf(
    NavItem(Screen.HOME, "Home", Icons.Filled.Home, Icons.Outlined.Home),
    NavItem(Screen.LESSONS, "Lessons", Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
    NavItem(Screen.LISTENING, "Listening", Icons.Filled.Headphones, Icons.Outlined.Headphones),
    NavItem(Screen.SPEAKING, "Speaking", Icons.Filled.Mic, Icons.Outlined.Mic),
    NavItem(Screen.PROGRESS, "Progress", Icons.Filled.TrendingUp, Icons.Outlined.TrendingUp)
)

// All 8 navigation sections for the Navigation Drawer
private val ALL_SECTIONS = listOf(
    NavItem(Screen.HOME, "Home / Dashboard", Icons.Filled.Home, Icons.Outlined.Home),
    NavItem(Screen.LESSONS, "My Lessons", Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
    NavItem(Screen.LISTENING, "Listening Practice", Icons.Filled.Headphones, Icons.Outlined.Headphones),
    NavItem(Screen.SPEAKING, "Speaking Practice", Icons.Filled.Mic, Icons.Outlined.Mic),
    NavItem(Screen.READING_WRITING, "Reading & Writing", Icons.Filled.AutoStories, Icons.Outlined.AutoStories),
    NavItem(Screen.VOCABULARY, "Vocabulary", Icons.Filled.Translate, Icons.Outlined.Translate),
    NavItem(Screen.TESTS, "Tests & Assessments", Icons.Filled.Quiz, Icons.Outlined.Quiz),
    NavItem(Screen.PROGRESS, "My Progress", Icons.Filled.TrendingUp, Icons.Outlined.TrendingUp)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(viewModel: MainViewModel = viewModel()) {
    val currentScreen by viewModel.currentScreen.collectAsState()
    val selectedLevelId by viewModel.selectedLevelId.collectAsState()

    var showLevelMenu by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.width(300.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "🇪🇸 My Spanish Tutor",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "From A1 Foundations to Natural Fluency",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                HorizontalDivider()
                Spacer(modifier = Modifier.height(8.dp))

                ALL_SECTIONS.forEach { item ->
                    val isSelected = (currentScreen == item.screen)
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title,
                                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            viewModel.navigateTo(item.screen)
                            scope.launch { drawerState.close() }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                HorizontalDivider()
                Text(
                    text = "Current: Level $selectedLevelId (${LevelType.fromId(selectedLevelId).code})",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                if (currentScreen != Screen.LESSON_DETAIL) {
                    CenterAlignedTopAppBar(
                        navigationIcon = {
                            IconButton(
                                onClick = { scope.launch { drawerState.open() } },
                                modifier = Modifier.testTag("drawer_menu_button")
                            ) {
                                Icon(
                                    Icons.Default.Menu,
                                    contentDescription = "Open Menu",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        },
                        title = {
                            Text(
                                text = "My Spanish Tutor",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        actions = {
                            // Level Switcher Dropdown
                            Box {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .testTag("level_switcher_button")
                                ) {
                                    TextButton(
                                        onClick = { showLevelMenu = true },
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Text(
                                            text = "Lvl $selectedLevelId ▼",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }

                                DropdownMenu(
                                    expanded = showLevelMenu,
                                    onDismissRequest = { showLevelMenu = false }
                                ) {
                                    LevelType.entries.forEach { level ->
                                        DropdownMenuItem(
                                            text = {
                                                Column {
                                                    Text(
                                                        text = "Level ${level.id} (${level.code})",
                                                        fontWeight = if (selectedLevelId == level.id) FontWeight.Bold else FontWeight.Normal
                                                    )
                                                    Text(
                                                        text = level.subtitle,
                                                        style = MaterialTheme.typography.bodySmall,
                                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                                    )
                                                }
                                            },
                                            onClick = {
                                                viewModel.setSelectedLevel(level.id)
                                                showLevelMenu = false
                                            }
                                        )
                                    }
                                }
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            },
            bottomBar = {
                if (currentScreen != Screen.LESSON_DETAIL) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 6.dp
                    ) {
                        BOTTOM_NAV_ITEMS.forEach { item ->
                            val isSelected = (currentScreen == item.screen)
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { viewModel.navigateTo(item.screen) },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.title,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        maxLines = 1
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                ),
                                modifier = Modifier.testTag("nav_item_${item.title.lowercase()}")
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedContent(
                    targetState = currentScreen,
                    transitionSpec = { fadeIn() togetherWith fadeOut() },
                    label = "ScreenTransition"
                ) { targetScreen ->
                    when (targetScreen) {
                        Screen.HOME -> HomeScreen(viewModel)
                        Screen.LESSONS -> LessonsScreen(viewModel)
                        Screen.LESSON_DETAIL -> LessonDetailScreen(viewModel)
                        Screen.LISTENING -> ListeningScreen(viewModel)
                        Screen.SPEAKING -> SpeakingScreen(viewModel)
                        Screen.READING_WRITING -> ReadingWritingScreen(viewModel)
                        Screen.VOCABULARY -> VocabularyScreen(viewModel)
                        Screen.TESTS -> TestsScreen(viewModel)
                        Screen.PROGRESS -> ProgressScreen(viewModel)
                    }
                }
            }
        }
    }
}
