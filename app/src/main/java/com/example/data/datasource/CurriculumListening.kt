package com.example.data.datasource

import com.example.data.model.ListeningExercise

object CurriculumListening {

    val allExercises: List<ListeningExercise> = listOf(
        // LEVEL 1: Short, simple sentences
        ListeningExercise(
            id = "list_1_1",
            levelId = 1,
            title = "Morning Coffee Order",
            spanishAudioScript = "Hola, buenos días. Quiero un café con leche y una tostada, por favor.",
            englishTranslation = "Hello, good morning. I want a coffee with milk and a toast, please.",
            difficulty = "Level 1: Slow & Simple",
            contextNote = "A simple everyday cafe order in Spain.",
            comprehensionQuestion = "What two things did the speaker order?"
        ),
        ListeningExercise(
            id = "list_1_2",
            levelId = 1,
            title = "Asking for Directions",
            spanishAudioScript = "Disculpe, ¿dónde está la estación de metro más cercana?",
            englishTranslation = "Excuse me, where is the nearest metro station?",
            difficulty = "Level 1: Slow & Simple",
            contextNote = "A polite tourist question on the street.",
            comprehensionQuestion = "What place is the person looking for?"
        ),
        ListeningExercise(
            id = "list_1_3",
            levelId = 1,
            title = "Personal Introduction",
            spanishAudioScript = "Me llamo Carlos, soy de Madrid y trabajo como profesor de inglés.",
            englishTranslation = "My name is Carlos, I am from Madrid, and I work as an English teacher.",
            difficulty = "Level 1: Slow & Simple",
            contextNote = "A brief self-introduction.",
            comprehensionQuestion = "What is Carlos's profession and where is he from?"
        ),
        ListeningExercise(
            id = "list_1_4",
            levelId = 1,
            title = "Evening Routine",
            spanishAudioScript = "Tengo que ir al supermercado ahora porque no tengo comida en casa.",
            englishTranslation = "I have to go to the supermarket now because I have no food at home.",
            difficulty = "Level 1: Slow & Simple",
            contextNote = "Everyday errand explanation using 'tengo que' and 'porque'.",
            comprehensionQuestion = "Why does the speaker have to go to the supermarket?"
        ),

        // LEVEL 2: Longer sentences with connecting words & modifiers
        ListeningExercise(
            id = "list_2_1",
            levelId = 2,
            title = "Weekend Weather Plans",
            spanishAudioScript = "Hoy hace bastante calor en la ciudad, pero mañana va a llover bastante temprano.",
            englishTranslation = "Today it is quite hot in the city, but tomorrow it is going to rain quite early.",
            difficulty = "Level 2: Expanding Sentences",
            contextNote = "Weather observation comparing today and tomorrow.",
            comprehensionQuestion = "What will the weather be like tomorrow early morning?"
        ),
        ListeningExercise(
            id = "list_2_2",
            levelId = 2,
            title = "Looking for a Friend",
            spanishAudioScript = "No conozco a nadie en esta reunión y tampoco sé dónde está mi amigo Juan.",
            englishTranslation = "I don't know anyone in this meeting and I also don't know where my friend Juan is.",
            difficulty = "Level 2: Expanding Sentences",
            contextNote = "Social scenario using 'nadie', 'tampoco', and saber vs conocer.",
            comprehensionQuestion = "Who is the speaker looking for and does he know people there?"
        ),
        ListeningExercise(
            id = "list_2_3",
            levelId = 2,
            title = "Restaurant Recommendation",
            spanishAudioScript = "Este restaurante italiano es muy acogedor, aunque los platos son un poco caros.",
            englishTranslation = "This Italian restaurant is very cozy, although the dishes are a little expensive.",
            difficulty = "Level 2: Expanding Sentences",
            contextNote = "Opinion with contrasting connector 'aunque'.",
            comprehensionQuestion = "What is good about the restaurant, and what is the drawback?"
        ),
        ListeningExercise(
            id = "list_2_4",
            levelId = 2,
            title = "Daily Grocery Schedule",
            spanishAudioScript = "Siempre hago la compra los sábados por la mañana porque hay menos gente en el mercado.",
            englishTranslation = "I always do the groceries on Saturday mornings because there are fewer people at the market.",
            difficulty = "Level 2: Expanding Sentences",
            contextNote = "Habit explanation with 'hago', 'menos', and time expressions.",
            comprehensionQuestion = "When does the speaker shop and why?"
        ),

        // LEVEL 3: Past and future sentences (Preterite, Imperfect, Combining)
        ListeningExercise(
            id = "list_3_1",
            levelId = 3,
            title = "A Busy Yesterday",
            spanishAudioScript = "Ayer trabajé hasta las siete de la tarde y luego fui a cenar con mis compañeros de trabajo.",
            englishTranslation = "Yesterday I worked until seven in the evening and then I went to have dinner with my coworkers.",
            difficulty = "Level 3: Talking About the Past",
            contextNote = "Sequence of completed past actions in the preterite.",
            comprehensionQuestion = "What did the speaker do after working until 7 PM?"
        ),
        ListeningExercise(
            id = "list_3_2",
            levelId = 3,
            title = "Childhood Memories",
            spanishAudioScript = "Cuando era pequeño, vivía cerca del mar y siempre íbamos a la playa con mis abuelos.",
            englishTranslation = "When I was little, I used to live near the sea and we always used to go to the beach with my grandparents.",
            difficulty = "Level 3: Talking About the Past",
            contextNote = "Imperfect tense used for habitual past activities and background setting.",
            comprehensionQuestion = "Where did the speaker use to live and who did they go to the beach with?"
        ),
        ListeningExercise(
            id = "list_3_3",
            levelId = 3,
            title = "The Unexpected Call",
            spanishAudioScript = "Estaba durmiendo plácidamente cuando de repente sonó la alarma del coche en la calle.",
            englishTranslation = "I was sleeping peacefully when suddenly the car alarm went off on the street.",
            difficulty = "Level 3: Talking About the Past",
            contextNote = "Imperfect background interrupted by a sudden preterite event.",
            comprehensionQuestion = "What interrupted the speaker while sleeping?"
        ),
        ListeningExercise(
            id = "list_3_4",
            levelId = 3,
            title = "Life Experiences",
            spanishAudioScript = "He viajado por muchos países de América Latina, pero todavía no he visitado Argentina.",
            englishTranslation = "I have traveled through many Latin American countries, but I have not yet visited Argentina.",
            difficulty = "Level 3: Talking About the Past",
            contextNote = "Present perfect expressing life experience up to the present moment.",
            comprehensionQuestion = "Which specific country has the speaker NOT visited yet?"
        ),

        // LEVEL 4: Everyday conversations and longer spoken passages
        ListeningExercise(
            id = "list_4_1",
            levelId = 4,
            title = "Checking into a Boutique Hotel",
            spanishAudioScript = "Buenas tardes. Tengo una reserva a nombre de García por tres noches. ¿Me podría confirmar si el desayuno está incluido?",
            englishTranslation = "Good afternoon. I have a reservation under the name of García for three nights. Could you confirm for me if breakfast is included?",
            difficulty = "Level 4: Natural Conversation",
            contextNote = "Polite hotel receptionist dialogue using indirect object pronouns and natural pacing.",
            comprehensionQuestion = "What is the name on the reservation and what question is asked?"
        ),
        ListeningExercise(
            id = "list_4_2",
            levelId = 4,
            title = "Discussing an Apartment",
            spanishAudioScript = "La verdad es que el piso me encanta porque es muy luminoso, pero el precio me parece un poco excesivo para esta zona.",
            englishTranslation = "To be honest, I love the apartment because it is very bright, but the price seems a bit excessive for this area.",
            difficulty = "Level 4: Natural Conversation",
            contextNote = "Expressing opinions, nuance, and verbs like encantar and parecer.",
            comprehensionQuestion = "Why does the speaker like the flat, and what is the hesitation?"
        ),
        ListeningExercise(
            id = "list_4_3",
            levelId = 4,
            title = "Making Plans Spontaneously",
            spanishAudioScript = "Bueno, a ver... si terminas temprano hoy, podemos encontrarnos en la plaza central y tomar unas tapas tranquilamente.",
            englishTranslation = "Well, let's see... if you finish early today, we can meet up in the central square and have some tapas quietly.",
            difficulty = "Level 4: Natural Conversation",
            contextNote = "Natural conversational fillers, conditional suggestion, and idiomatic phrasing.",
            comprehensionQuestion = "Where does the speaker suggest meeting if the friend finishes early?"
        ),
        ListeningExercise(
            id = "list_4_4",
            levelId = 4,
            title = "Giving Career Advice",
            spanishAudioScript = "En mi opinión, deberías aceptar la oferta de trabajo. O sea, vas a aprender mucho y sin duda vale la pena el esfuerzo.",
            englishTranslation = "In my opinion, you should accept the job offer. I mean, you are going to learn a lot and without doubt the effort is worth it.",
            difficulty = "Level 4: Natural Conversation",
            contextNote = "Expressing advice, conversational discourse markers, and idiomatic expressions.",
            comprehensionQuestion = "What advice is given and why is it worth it?"
        )
    )
}
