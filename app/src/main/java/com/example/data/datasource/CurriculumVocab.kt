package com.example.data.datasource

import com.example.data.model.VocabItem

object CurriculumVocab {

    val allVocab: List<VocabItem> = listOf(
        // LEVEL 1: FOUNDATIONS - Core Verbs & Daily Basics
        VocabItem(
            id = "v_1_1",
            spanish = "querer",
            english = "to want / to love",
            levelId = 1,
            topic = "Core Verbs",
            partOfSpeech = "verb (stem-changing e->ie)",
            exampleEs = "Quiero aprender español.",
            exampleEn = "I want to learn Spanish.",
            conjugations = mapOf("yo" to "quiero", "tú" to "quieres", "él/ella" to "quiere", "nosotros" to "queremos", "ellos" to "quieren")
        ),
        VocabItem(
            id = "v_1_2",
            spanish = "poder",
            english = "to be able to / can",
            levelId = 1,
            topic = "Core Verbs",
            partOfSpeech = "verb (stem-changing o->ue)",
            exampleEs = "¿Puedes ayudarme con esto?",
            exampleEn = "Can you help me with this?",
            conjugations = mapOf("yo" to "puedo", "tú" to "puedes", "él/ella" to "puede", "nosotros" to "podemos", "ellos" to "pueden")
        ),
        VocabItem(
            id = "v_1_3",
            spanish = "tener",
            english = "to have",
            levelId = 1,
            topic = "Core Verbs",
            partOfSpeech = "verb (irregular)",
            exampleEs = "Tengo treinta años y tengo un gato.",
            exampleEn = "I am thirty years old and I have a cat.",
            conjugations = mapOf("yo" to "tengo", "tú" to "tienes", "él/ella" to "tiene", "nosotros" to "tenemos", "ellos" to "tienen")
        ),
        VocabItem(
            id = "v_1_4",
            spanish = "ir",
            english = "to go",
            levelId = 1,
            topic = "Core Verbs",
            partOfSpeech = "verb (highly irregular)",
            exampleEs = "Voy al mercado con mi madre.",
            exampleEn = "I am going to the market with my mother.",
            conjugations = mapOf("yo" to "voy", "tú" to "vas", "él/ella" to "va", "nosotros" to "vamos", "ellos" to "van")
        ),
        VocabItem(
            id = "v_1_5",
            spanish = "el café",
            english = "coffee / cafe",
            levelId = 1,
            topic = "Food & Dining",
            partOfSpeech = "noun (m)",
            gender = "masculine",
            exampleEs = "Me gusta tomar un café caliente por la mañana.",
            exampleEn = "I like drinking a hot coffee in the morning."
        ),
        VocabItem(
            id = "v_1_6",
            spanish = "la cuenta",
            english = "the bill / check",
            levelId = 1,
            topic = "Food & Dining",
            partOfSpeech = "noun (f)",
            gender = "feminine",
            exampleEs = "Camarero, ¿me trae la cuenta, por favor?",
            exampleEn = "Waiter, could you bring me the bill, please?"
        ),
        VocabItem(
            id = "v_1_7",
            spanish = "el agua",
            english = "water",
            levelId = 1,
            topic = "Food & Dining",
            partOfSpeech = "noun (f - uses 'el' in singular)",
            gender = "feminine",
            exampleEs = "¿Nos trae una botella de agua fresca?",
            exampleEn = "Could you bring us a bottle of cold water?"
        ),
        VocabItem(
            id = "v_1_8",
            spanish = "la casa",
            english = "house / home",
            levelId = 1,
            topic = "Daily Activities",
            partOfSpeech = "noun (f)",
            gender = "feminine",
            exampleEs = "Estoy en casa descansando.",
            exampleEn = "I am at home resting."
        ),
        VocabItem(
            id = "v_1_9",
            spanish = "trabajar",
            english = "to work",
            levelId = 1,
            topic = "Work & Career",
            partOfSpeech = "verb (regular -ar)",
            exampleEs = "Trabajo cinco días a la semana.",
            exampleEn = "I work five days a week.",
            conjugations = mapOf("yo" to "trabajo", "tú" to "trabajas", "él/ella" to "trabaja", "nosotros" to "trabajamos", "ellos" to "trabajan")
        ),
        VocabItem(
            id = "v_1_10",
            spanish = "el amigo / la amiga",
            english = "friend",
            levelId = 1,
            topic = "Family & People",
            partOfSpeech = "noun (m/f)",
            gender = "masculine / feminine",
            exampleEs = "Voy a cenar con mis amigos.",
            exampleEn = "I am going to have dinner with my friends."
        ),

        // LEVEL 2: EXPANDING SENTENCES - Modifiers, Saber/Conocer & Negatives
        VocabItem(
            id = "v_2_1",
            spanish = "saber",
            english = "to know (facts / skills)",
            levelId = 2,
            topic = "Core Verbs",
            partOfSpeech = "verb (irregular yo: sé)",
            exampleEs = "Sé hablar un poco de español.",
            exampleEn = "I know how to speak a little Spanish.",
            conjugations = mapOf("yo" to "sé", "tú" to "sabes", "él/ella" to "sabe", "nosotros" to "sabemos", "ellos" to "saben")
        ),
        VocabItem(
            id = "v_2_2",
            spanish = "conocer",
            english = "to know (people / places)",
            levelId = 2,
            topic = "Core Verbs",
            partOfSpeech = "verb (irregular yo: conozco)",
            exampleEs = "Conozco muy bien el centro histórico.",
            exampleEn = "I know the historic center very well.",
            conjugations = mapOf("yo" to "conozco", "tú" to "conoces", "él/ella" to "conoce", "nosotros" to "conocemos", "ellos" to "conocen")
        ),
        VocabItem(
            id = "v_2_3",
            spanish = "hacer",
            english = "to do / to make",
            levelId = 2,
            topic = "Core Verbs",
            partOfSpeech = "verb (irregular yo: hago)",
            exampleEs = "¿Qué haces en tu tiempo libre?",
            exampleEn = "What do you do in your free time?",
            conjugations = mapOf("yo" to "hago", "tú" to "haces", "él/ella" to "hace", "nosotros" to "hacemos", "ellos" to "hacen")
        ),
        VocabItem(
            id = "v_2_4",
            spanish = "decir",
            english = "to say / to tell",
            levelId = 2,
            topic = "Core Verbs",
            partOfSpeech = "verb (irregular yo: digo, stem e->i)",
            exampleEs = "Siempre digo lo que pienso.",
            exampleEn = "I always say what I think.",
            conjugations = mapOf("yo" to "digo", "tú" to "dices", "él/ella" to "dice", "nosotros" to "decimos", "ellos" to "dicen")
        ),
        VocabItem(
            id = "v_2_5",
            spanish = "nadie",
            english = "nobody / anyone",
            levelId = 2,
            topic = "Negatives",
            partOfSpeech = "pronoun",
            exampleEs = "No hay nadie en la oficina hoy.",
            exampleEn = "There is nobody in the office today."
        ),
        VocabItem(
            id = "v_2_6",
            spanish = "tampoco",
            english = "neither / not either",
            levelId = 2,
            topic = "Negatives",
            partOfSpeech = "adverb",
            exampleEs = "Yo tampoco he terminado la tarea.",
            exampleEn = "I haven't finished the assignment either."
        ),
        VocabItem(
            id = "v_2_7",
            spanish = "temprano",
            english = "early",
            levelId = 2,
            topic = "Time & Dates",
            partOfSpeech = "adverb",
            exampleEs = "Mañana tengo que levantarme bastante temprano.",
            exampleEn = "Tomorrow I have to wake up quite early."
        ),
        VocabItem(
            id = "v_2_8",
            spanish = "bastante",
            english = "quite / enough / fairly",
            levelId = 2,
            topic = "Modifiers",
            partOfSpeech = "adverb / adjective",
            exampleEs = "El examen fue bastante difícil.",
            exampleEn = "The exam was quite difficult."
        ),
        VocabItem(
            id = "v_2_9",
            spanish = "la ciudad",
            english = "city",
            levelId = 2,
            topic = "Travel & Places",
            partOfSpeech = "noun (f)",
            gender = "feminine",
            exampleEs = "Valencia es una ciudad muy hermosa.",
            exampleEn = "Valencia is a very beautiful city."
        ),
        VocabItem(
            id = "v_2_10",
            spanish = "tranquilo / tranquila",
            english = "quiet / calm / peaceful",
            levelId = 2,
            topic = "Adjectives",
            partOfSpeech = "adjective",
            gender = "masculine / feminine",
            exampleEs = "Vivimos en un barrio muy tranquilo.",
            exampleEn = "We live in a very quiet neighborhood."
        ),

        // LEVEL 3: TALKING ABOUT THE PAST - Preterite, Imperfect, Time
        VocabItem(
            id = "v_3_1",
            spanish = "ayer",
            english = "yesterday",
            levelId = 3,
            topic = "Time & Dates",
            partOfSpeech = "adverb",
            exampleEs = "Ayer hablé con mi familia por teléfono.",
            exampleEn = "Yesterday I spoke with my family on the phone."
        ),
        VocabItem(
            id = "v_3_2",
            spanish = "anoche",
            english = "last night",
            levelId = 3,
            topic = "Time & Dates",
            partOfSpeech = "adverb",
            exampleEs = "Anoche cenamos en un restaurante cerca de la playa.",
            exampleEn = "Last night we had dinner at a restaurant near the beach."
        ),
        VocabItem(
            id = "v_3_3",
            spanish = "la semana pasada",
            english = "last week",
            levelId = 3,
            topic = "Time & Dates",
            partOfSpeech = "phrase",
            exampleEs = "La semana pasada compré un ordenador nuevo.",
            exampleEn = "Last week I bought a new computer."
        ),
        VocabItem(
            id = "v_3_4",
            spanish = "viajar",
            english = "to travel",
            levelId = 3,
            topic = "Travel & Places",
            partOfSpeech = "verb (regular -ar)",
            exampleEs = "El verano pasado viajé por el sur de España.",
            exampleEn = "Last summer I traveled through the south of Spain.",
            conjugations = mapOf("yo (pret)" to "viajé", "tú (pret)" to "viajaste", "él (pret)" to "viajó", "nosotros" to "viajamos")
        ),
        VocabItem(
            id = "v_3_5",
            spanish = "llegar",
            english = "to arrive",
            levelId = 3,
            topic = "Travel & Places",
            partOfSpeech = "verb",
            exampleEs = "El vuelo llegó con una hora de retraso.",
            exampleEn = "The flight arrived with a one-hour delay.",
            conjugations = mapOf("yo (pret)" to "llegué", "tú (pret)" to "llegaste", "él (pret)" to "llegó", "nosotros" to "llegamos")
        ),
        VocabItem(
            id = "v_3_6",
            spanish = "mientras",
            english = "while",
            levelId = 3,
            topic = "Connectors",
            partOfSpeech = "conjunction",
            exampleEs = "Mientras preparaba el café, sonó el teléfono.",
            exampleEn = "While I was preparing the coffee, the phone rang."
        ),
        VocabItem(
            id = "v_3_7",
            spanish = "de repente",
            english = "suddenly",
            levelId = 3,
            topic = "Connectors",
            partOfSpeech = "phrase",
            exampleEs = "Caminábamos por el parque y de repente empezó a llover.",
            exampleEn = "We were walking through the park and suddenly it started to rain."
        ),
        VocabItem(
            id = "v_3_8",
            spanish = "la reunión",
            english = "meeting",
            levelId = 3,
            topic = "Work & Career",
            partOfSpeech = "noun (f)",
            gender = "feminine",
            exampleEs = "Tuvimos una reunión importante con el cliente.",
            exampleEn = "We had an important meeting with the client."
        ),

        // LEVEL 4: NATURAL CONVERSATION - Pronouns, Reflexives, Discourse
        VocabItem(
            id = "v_4_1",
            spanish = "gustar",
            english = "to please / to like",
            levelId = 4,
            topic = "Feelings & Opinions",
            partOfSpeech = "verb (uses indirect pronouns)",
            exampleEs = "Me gustan las ciudades con historia.",
            exampleEn = "I like cities with history."
        ),
        VocabItem(
            id = "v_4_2",
            spanish = "encantar",
            english = "to love / to enchant",
            levelId = 4,
            topic = "Feelings & Opinions",
            partOfSpeech = "verb (uses indirect pronouns)",
            exampleEs = "Me encanta la comida mediterránea.",
            exampleEn = "I love Mediterranean food."
        ),
        VocabItem(
            id = "v_4_3",
            spanish = "levantarse",
            english = "to get up",
            levelId = 4,
            topic = "Daily Activities",
            partOfSpeech = "reflexive verb",
            exampleEs = "Me levanto a las siete todos los días laborales.",
            exampleEn = "I get up at seven every workday.",
            conjugations = mapOf("yo" to "me levanto", "tú" to "te levantas", "él/ella" to "se levanta", "nosotros" to "nos levantamos")
        ),
        VocabItem(
            id = "v_4_4",
            spanish = "sentirse",
            english = "to feel",
            levelId = 4,
            topic = "Feelings & Opinions",
            partOfSpeech = "reflexive verb (e->ie)",
            exampleEs = "Hoy me siento con mucha energía.",
            exampleEn = "Today I feel with a lot of energy.",
            conjugations = mapOf("yo" to "me siento", "tú" to "te sientes", "él/ella" to "se siente", "nosotros" to "nos sentimos")
        ),
        VocabItem(
            id = "v_4_5",
            spanish = "en mi opinión",
            english = "in my opinion",
            levelId = 4,
            topic = "Conversational Markers",
            partOfSpeech = "phrase",
            exampleEs = "En mi opinión, es una excelente oportunidad.",
            exampleEn = "In my opinion, it is an excellent opportunity."
        ),
        VocabItem(
            id = "v_4_6",
            spanish = "por eso",
            english = "that is why / therefore",
            levelId = 4,
            topic = "Connectors",
            partOfSpeech = "phrase",
            exampleEs = "Estudió mucho y por eso aprobó el examen.",
            exampleEn = "She studied a lot and therefore she passed the exam."
        ),
        VocabItem(
            id = "v_4_7",
            spanish = "o sea",
            english = "I mean / in other words",
            levelId = 4,
            topic = "Conversational Markers",
            partOfSpeech = "filler phrase",
            exampleEs = "O sea, no podemos llegar tarde mañana.",
            exampleEn = "I mean, we cannot arrive late tomorrow."
        ),
        VocabItem(
            id = "v_4_8",
            spanish = "vale la pena",
            english = "it is worth it",
            levelId = 4,
            topic = "Idioms & Expressions",
            partOfSpeech = "idiom",
            exampleEs = "Aprender español requiere tiempo pero vale la pena.",
            exampleEn = "Learning Spanish takes time, but it is worth it."
        )
    )
}
