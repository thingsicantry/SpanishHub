package com.example.data.datasource

import com.example.data.model.ExerciseType
import com.example.data.model.QuizQuestion
import com.example.data.model.ReadingPassage

object CurriculumReading {

    val allPassages: List<ReadingPassage> = listOf(
        ReadingPassage(
            id = "read_1",
            levelId = 1,
            title = "Un día en la vida de Elena",
            spanishText = "Elena vive en Madrid. Es española y trabaja en una librería en el centro. Todas las mañanas se levanta a las siete, toma un café con leche y lee las noticias. A las ocho y media sale de casa y toma el metro. En la librería habla con muchos clientes y recomienda libros interesantes. Por la tarde, Elena vuelve a casa, cocina la cena y practica guitarra.",
            englishTranslation = "Elena lives in Madrid. She is Spanish and works at a bookstore downtown. Every morning she gets up at seven, drinks a coffee with milk, and reads the news. At eight-thirty she leaves home and takes the subway. At the bookstore she talks with many customers and recommends interesting books. In the afternoon, Elena returns home, cooks dinner, and practices guitar.",
            topic = "Daily Life & Routines",
            questions = listOf(
                QuizQuestion(
                    id = "read_1_q1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Dónde trabaja Elena?",
                    options = listOf("En una librería en el centro", "En un banco en Barcelona", "En un restaurante mexicano", "En una escuela de idiomas"),
                    expectedAnswers = listOf("En una librería en el centro"),
                    hint = "Look at the second sentence.",
                    explanation = "Elena trabaja en una librería en el centro."
                ),
                QuizQuestion(
                    id = "read_1_q2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué hace Elena por la tarde?",
                    options = listOf("Vuelve a casa, cocina y toca la guitarra", "Va al gimnasio con amigos", "Trabaja hasta la noche", "Toma el autobús al supermercado"),
                    expectedAnswers = listOf("Vuelve a casa, cocina y toca la guitarra"),
                    hint = "Check the last sentence.",
                    explanation = "Vuelve a casa, cocina la cena y practica guitarra."
                )
            )
        ),

        ReadingPassage(
            id = "read_2",
            levelId = 2,
            title = "El mercado de San Miguel",
            spanishText = "El Mercado de San Miguel es uno de los lugares gastronómicos más conocidos de Madrid. Aunque suele haber muchos turistas, el ambiente es bastante agradable y animado. Los puestos ofrecen una gran variedad de tapas tradicionales: jamón ibérico, quesos curados, aceitunas y mariscos frescos. Nadie sale de allí con hambre porque la comida es exquisita.",
            englishTranslation = "The San Miguel Market is one of the best-known gastronomic places in Madrid. Although there are usually many tourists, the atmosphere is quite pleasant and lively. The stalls offer a wide variety of traditional tapas: Iberian ham, cured cheeses, olives, and fresh seafood. Nobody leaves there hungry because the food is exquisite.",
            topic = "Food & Travel",
            questions = listOf(
                QuizQuestion(
                    id = "read_2_q1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Cómo es el ambiente en el mercado?",
                    options = listOf("Bastante agradable y animado", "Muy silencioso y aburrido", "Peligroso y solitario", "Cerrado y oscuro"),
                    expectedAnswers = listOf("Bastante agradable y animado"),
                    hint = "Notice the modifier 'bastante'.",
                    explanation = "El texto indica que el ambiente es bastante agradable y animado."
                ),
                QuizQuestion(
                    id = "read_2_q2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Por qué nadie sale con hambre?",
                    options = listOf("Porque la comida es exquisita y variada", "Porque cierran temprano", "Porque solo venden café", "Porque es muy barato"),
                    expectedAnswers = listOf("Porque la comida es exquisita y variada"),
                    hint = "Look at the negative sentence 'Nadie sale...' and the connector 'porque'.",
                    explanation = "Nadie sale con hambre porque la comida es exquisita."
                )
            )
        ),

        ReadingPassage(
            id = "read_3",
            levelId = 3,
            title = "Un viaje inolvidable a Granada",
            spanishText = "El verano pasado decidí viajar solo a Granada por primera vez. Cuando llegué a la estación de trenes, hacía mucho calor pero la vista de Sierra Nevada al fondo era impresionante. Mientras caminaba por las estrechas calles del Albaicín, escuché música flamenca que salía de una pequeña casa blanca. Entré y conocí a unos músicos maravillosos que me invitaron a compartir un té con ellos. Fue una experiencia que nunca olvidaré.",
            englishTranslation = "Last summer I decided to travel alone to Granada for the first time. When I arrived at the train station, it was very hot, but the view of Sierra Nevada in the background was stunning. While I was walking through the narrow streets of Albaicín, I heard flamenco music coming out of a small white house. I went in and met some wonderful musicians who invited me to share tea with them. It was an experience I will never forget.",
            topic = "Travel & Memories",
            questions = listOf(
                QuizQuestion(
                    id = "read_3_q1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué hacía el protagonista cuando escuchó música flamenca?",
                    options = listOf("Caminaba por las calles del Albaicín", "Comía en un restaurante", "Dormía en el hotel", "Esperaba el autobús"),
                    expectedAnswers = listOf("Caminaba por las calles del Albaicín"),
                    hint = "Look for the connector 'Mientras'.",
                    explanation = "Mientras caminaba por las estrechas calles del Albaicín, escuchó música flamenca."
                ),
                QuizQuestion(
                    id = "read_3_q2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Cómo era el clima cuando llegó a la estación?",
                    options = listOf("Hacía mucho calor", "Estaba lloviendo", "Hacía mucho frío y viento", "Nevaba sobre la ciudad"),
                    expectedAnswers = listOf("Hacía mucho calor"),
                    hint = "Notice the imperfect expression: hacía mucho calor.",
                    explanation = "Hacía mucho calor pero la vista era impresionante."
                )
            )
        ),

        ReadingPassage(
            id = "read_4",
            levelId = 4,
            title = "El arte de la sobremesa española",
            spanishText = "Para los españoles, la comida no termina cuando se acaba el último bocado del plato. La sobremesa es esa costumbre tan arraigada de quedarse sentado a la mesa después de comer, charlando tranquilamente con amigos o familiares durante horas. Se comparten anécdotas, se debaten temas de actualidad o simplemente se disfruta de la compañía acompañada de un café. En mi opinión, la sobremesa refleja perfectamente la filosofía de vida mediterránea: el tiempo no se pierde cuando se comparte con las personas que te importan.",
            englishTranslation = "For Spanish people, the meal does not end when the last bite on the plate is finished. La sobremesa is that deeply rooted custom of staying seated at the table after eating, chatting leisurely with friends or family for hours. Anecdotes are shared, current topics are debated, or people simply enjoy company over coffee. In my opinion, la sobremesa perfectly reflects the Mediterranean life philosophy: time is not lost when shared with people you care about.",
            topic = "Culture & Philosophy",
            questions = listOf(
                QuizQuestion(
                    id = "read_4_q1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué es exactamente 'la sobremesa'?",
                    options = listOf(
                        "Quedarse charlando en la mesa después de comer",
                        "El postre que se sirve antes del café",
                        "Limpiar la mesa rápidamente",
                        "Pedir la cuenta al camarero"
                    ),
                    expectedAnswers = listOf("Quedarse charlando en la mesa después de comer"),
                    hint = "Look at the definition in the second sentence.",
                    explanation = "Es la costumbre de quedarse sentado a la mesa charlando después de comer."
                ),
                QuizQuestion(
                    id = "read_4_q2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Según el autor, ¿qué refleja esta costumbre?",
                    options = listOf(
                        "La filosofía de vida mediterránea sobre valorar el tiempo compartido",
                        "La necesidad de comer más rápido",
                        "El costo elevado de los restaurantes",
                        "La falta de trabajo por las tardes"
                    ),
                    expectedAnswers = listOf("La filosofía de vida mediterránea sobre valorar el tiempo compartido"),
                    hint = "Check the final sentence introduced by 'En mi opinión'.",
                    explanation = "Refleja que el tiempo no se pierde cuando se comparte con las personas que te importan."
                )
            )
        )
    )

    val diagnosticTests: Map<Int, List<QuizQuestion>> = mapOf(
        1 to listOf(
            QuizQuestion(
                id = "diag_1_1",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "¿Cuál es la forma correcta? 'Yo ___ estudiar español.' (querer)",
                options = listOf("quiero", "quiere", "queremos", "quieres"),
                expectedAnswers = listOf("quiero"),
                hint = "Yo form of querer.",
                explanation = "Yo quiero."
            ),
            QuizQuestion(
                id = "diag_1_2",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "María ___ en Barcelona esta semana.",
                options = listOf("está", "es", "son", "estamos"),
                expectedAnswers = listOf("está"),
                hint = "Temporary location uses estar.",
                explanation = "Estar is used for location: María está en Barcelona."
            ),
            QuizQuestion(
                id = "diag_1_3",
                type = ExerciseType.TRANSLATE_EN_TO_ES,
                prompt = "Translate: 'We are going to eat now.'",
                expectedAnswers = listOf("Vamos a comer ahora", "Nosotros vamos a comer ahora"),
                hint = "Vamos a + comer + ahora",
                explanation = "Ir a + infinitive: Vamos a comer ahora."
            )
        ),
        2 to listOf(
            QuizQuestion(
                id = "diag_2_1",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "¿___ a la nueva profesora de historia? (conocer vs saber)",
                options = listOf("Conoces", "Sabes", "Conozco", "Sabe"),
                expectedAnswers = listOf("Conoces"),
                hint = "Familiarity with a person takes conocer.",
                explanation = "Conocer is used for people: ¿Conoces a la nueva profesora?"
            ),
            QuizQuestion(
                id = "diag_2_2",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "Yo no sé ___ sobre ese tema.",
                options = listOf("nada", "nadie", "nunca", "tampoco"),
                expectedAnswers = listOf("nada"),
                hint = "Nothing = nada.",
                explanation = "No sé nada sobre ese tema."
            ),
            QuizQuestion(
                id = "diag_2_3",
                type = ExerciseType.TRANSLATE_EN_TO_ES,
                prompt = "Translate: 'Tomorrow I want to arrive earlier.'",
                expectedAnswers = listOf("Mañana quiero llegar más temprano", "Manana quiero llegar mas temprano"),
                hint = "Mañana + quiero llegar + más temprano.",
                explanation = "Mañana quiero llegar más temprano."
            )
        ),
        3 to listOf(
            QuizQuestion(
                id = "diag_3_1",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "Ayer nosotros ___ en un restaurante fantástico. (cenar - preterite)",
                options = listOf("cenamos", "cenábamos", "cenaron", "cené"),
                expectedAnswers = listOf("cenamos"),
                hint = "Preterite of cenar for nosotros.",
                explanation = "Ayer cenamos."
            ),
            QuizQuestion(
                id = "diag_3_2",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "Cuando era pequeño, siempre ___ con mi hermano. (jugar - habitual past)",
                options = listOf("jugaba", "jugué", "jugaron", "juego"),
                expectedAnswers = listOf("jugaba"),
                hint = "Habitual past actions use the imperfect.",
                explanation = "Imperfect for childhood habits: siempre jugaba."
            ),
            QuizQuestion(
                id = "diag_3_3",
                type = ExerciseType.TRANSLATE_EN_TO_ES,
                prompt = "Translate: 'Have you visited Madrid?'",
                expectedAnswers = listOf("¿Has visitado Madrid?", "Has visitado Madrid"),
                hint = "¿Has + visitado + Madrid?",
                explanation = "Present perfect: ¿Has visitado Madrid?"
            )
        ),
        4 to listOf(
            QuizQuestion(
                id = "diag_4_1",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "¿Tienes el pasaporte? Sí, ___ tengo en la mochila.",
                options = listOf("lo", "la", "le", "el"),
                expectedAnswers = listOf("lo"),
                hint = "Pasaporte is masculine singular -> lo.",
                explanation = "Direct object pronoun: Sí, lo tengo."
            ),
            QuizQuestion(
                id = "diag_4_2",
                type = ExerciseType.CHOOSE_VERB,
                prompt = "A mí me ___ mucho las películas extranjeras. (gustar)",
                options = listOf("gustan", "gusta", "gusto", "gustamos"),
                expectedAnswers = listOf("gustan"),
                hint = "Películas is plural, so use gustan.",
                explanation = "Me gustan las películas."
            ),
            QuizQuestion(
                id = "diag_4_3",
                type = ExerciseType.TRANSLATE_EN_TO_ES,
                prompt = "Translate: 'In my opinion, it is worth the effort.'",
                expectedAnswers = listOf(
                    "En mi opinión, vale la pena",
                    "En mi opinion vale la pena",
                    "En mi opinión vale la pena"
                ),
                hint = "En mi opinión, vale la pena.",
                explanation = "En mi opinión, vale la pena."
            )
        )
    )
}
