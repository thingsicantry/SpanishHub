package com.example

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.datasource.CurriculumLessons
import com.example.ui.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("My Spanish Tutor", appName)
  }

  @Test
  fun `curriculum lessons exist for all four levels`() {
    val lessons = CurriculumLessons.allLessons
    assertTrue(lessons.isNotEmpty())
    val levels = lessons.map { it.levelId }.toSet()
    assertEquals(setOf(1, 2, 3, 4), levels)
  }

  @Test
  fun `main activity launches without crashing`() {
    val controller = Robolectric.buildActivity(MainActivity::class.java).setup()
    val activity = controller.get()
    assertNotNull(activity)
  }

  @Test
  fun `main viewmodel initializes successfully`() {
    val app = ApplicationProvider.getApplicationContext<Application>()
    val vm = MainViewModel(app)
    assertNotNull(vm)
    assertEquals(1, vm.selectedLevelId.value)
  }
}
