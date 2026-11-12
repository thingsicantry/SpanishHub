package com.example.data.model

enum class LevelType(val id: Int, val code: String, val title: String, val subtitle: String, val description: String) {
    LEVEL_1(
        id = 1,
        code = "A1",
        title = "Beginner A1: Foundations",
        subtitle = "Core verbs, sentence structure & daily basics",
        description = "Learn essential verbs (querer, poder, tener que, ir), regular verb endings, ser vs estar, question words, and build everyday sentences."
    ),
    LEVEL_2(
        id = 2,
        code = "Developing A1",
        title = "Developing A1: Expanding Sentences",
        subtitle = "Saber vs conocer, modifiers & longer thoughts",
        description = "Expand into saber vs conocer, decir, dar, ver, negative structures, time expressions, and multi-clause sentences."
    ),
    LEVEL_3(
        id = 3,
        code = "A1 to A2",
        title = "A1 to A2: Talking About the Past",
        subtitle = "Preterite vs imperfect, numbers & past experiences",
        description = "Master telling time, preterite (completed past), imperfect (ongoing background), present perfect, and combining past, present, and future."
    ),
    LEVEL_4(
        id = 4,
        code = "Developing A2",
        title = "Developing A2: Natural Conversation",
        subtitle = "Object pronouns, reflexives & spontaneous fluency",
        description = "Direct and indirect object pronouns, reflexive verbs, expressing opinions, natural idioms, and fluent spontaneous conversation without translating word-for-word."
    );

    companion object {
        fun fromId(id: Int): LevelType = entries.find { it.id == id } ?: LEVEL_1
    }
}
