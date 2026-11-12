package com.example.data.datasource

import com.example.data.model.ExerciseType
import com.example.data.model.Lesson
import com.example.data.model.LessonExample
import com.example.data.model.QuizQuestion

object CurriculumLessons {

    val allLessons: List<Lesson> = listOf(
        // ================= LEVEL 1: BEGINNER A1 =================
        Lesson(
            id = "l1_1",
            levelId = 1,
            title = "Core Verbs: Querer, Poder & Necesitar",
            subtitle = "Expressing wants, ability & needs",
            durationMinutes = 10,
            objective = "Learn how to express what you want (querer), what you can do (poder), and what you need (necesitar or tener que) with other verbs.",
            plainEnglishRule = "In Spanish, when you combine two verbs, you conjugate only the first verb and leave the second verb in its original infinitive form (ending in -ar, -er, or -ir).",
            patternFormula = "[Conjugated Verb] + [Infinitive Verb]",
            patternFormulaExplanation = "Quiero (I want) + comer (to eat) = Quiero comer (I want to eat). No need to change 'comer'!",
            examples = listOf(
                LessonExample("Quiero aprender español.", "I want to learn Spanish.", "Quiero (I want) + aprender (to learn)"),
                LessonExample("Puedo hablar un poco.", "I can speak a little.", "Puedo (I can) + hablar (to speak)"),
                LessonExample("Necesito comprar agua.", "I need to buy water.", "Necesito (I need) + comprar (to buy)"),
                LessonExample("Tengo que trabajar hoy.", "I have to work today.", "Tengo que (I have to) + trabajar (to work)")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l1_1_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the correct form to say: 'I can pay now.'",
                    options = listOf("Puedo pagar ahora", "Poder pago ahora", "Pudo pagar ahora", "Puedo pago ahora"),
                    expectedAnswers = listOf("Puedo pagar ahora"),
                    hint = "Remember: conjugate the first verb (puedo), keep the second as an infinitive (pagar).",
                    explanation = "Only the first verb changes: 'Puedo' (I can). The action 'pagar' stays in the infinitive."
                ),
                QuizQuestion(
                    id = "l1_1_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with the correct word for 'I have to':",
                    blankSentence = "___ que estudiar esta tarde.",
                    options = listOf("Tengo", "Tienes", "Tiene", "Tenemos"),
                    expectedAnswers = listOf("Tengo", "tengo"),
                    hint = "Use the 'yo' (I) form of tener.",
                    explanation = "'Tengo que' means 'I have to'."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l1_1_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate to Spanish: 'I want to drink coffee.'",
                    expectedAnswers = listOf("Quiero beber café", "Quiero tomar café", "Yo quiero beber café", "Yo quiero tomar café"),
                    hint = "Querer (yo form) + beber/tomar + café",
                    explanation = "'Quiero' = I want, 'beber café' or 'tomar café' = to drink coffee."
                ),
                QuizQuestion(
                    id = "l1_1_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange the words to build: 'I need to call my friend.'",
                    wordsToArrange = listOf("Necesito", "llamar", "a", "mi", "amigo"),
                    expectedAnswers = listOf("Necesito llamar a mi amigo", "necesito llamar a mi amigo"),
                    hint = "Start with the conjugated verb Necesito.",
                    explanation = "Necesito + llamar (infinitive) + personal 'a' + mi amigo."
                )
            ),
            reviewSummary = listOf(
                "Quiero = I want; Puedo = I can; Necesito = I need; Tengo que = I have to.",
                "Always leave the second action in the infinitive: Quiero comer, Puedo ir.",
                "In Spanish, you don't need to say 'yo' every time because the verb ending reveals who is speaking."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l1_1_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I have to go to the supermarket.'",
                    expectedAnswers = listOf("Tengo que ir al supermercado", "Yo tengo que ir al supermercado"),
                    hint = "Tengo que + ir + al supermercado",
                    explanation = "'al' is a contraction of 'a + el' (to the)."
                ),
                QuizQuestion(
                    id = "l1_1_a2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Find and correct the error in: 'Quiero compro un libro.'",
                    expectedAnswers = listOf("Quiero comprar un libro", "Yo quiero comprar un libro"),
                    hint = "The second verb must be in infinitive form (-ar).",
                    explanation = "The second verb must be 'comprar', not 'compro'."
                )
            )
        ),

        Lesson(
            id = "l1_2",
            levelId = 1,
            title = "Ser vs Estar: The Two 'To Be's",
            subtitle = "Permanent traits vs states & locations",
            durationMinutes = 12,
            objective = "Understand when to use 'ser' (identity, origin, characteristics) versus 'estar' (location, temporary states, feelings).",
            plainEnglishRule = "Use SER for who or what someone is inherently (Doctor, Spanish, tall). Use ESTAR for where someone is located or how someone feels right now (tired, in Madrid).",
            patternFormula = "SER = Essence / Identity | ESTAR = State / Location",
            patternFormulaExplanation = "Remember: 'How you feel and where you are, always use the verb ESTAR!'",
            examples = listOf(
                LessonExample("Soy de España.", "I am from Spain.", "SER: Origin"),
                LessonExample("Soy estudiante.", "I am a student.", "SER: Profession / Identity"),
                LessonExample("Estoy cansado.", "I am tired.", "ESTAR: Temporary condition / Feeling"),
                LessonExample("Estoy en la oficina.", "I am in the office.", "ESTAR: Location")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l1_2_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the correct verb: 'Carlos ___ en casa hoy.' (Carlos is at home today)",
                    options = listOf("está", "es", "somos", "están"),
                    expectedAnswers = listOf("está"),
                    hint = "Location always takes ESTAR.",
                    explanation = "Being at home is a location, so we use 'está' (from estar)."
                ),
                QuizQuestion(
                    id = "l1_2_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the correct verb: 'Ella ___ médica.' (She is a doctor)",
                    options = listOf("es", "está", "son", "estamos"),
                    expectedAnswers = listOf("es"),
                    hint = "Professions always use SER.",
                    explanation = "Professions define who someone is, so we use 'es' (from ser)."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l1_2_i1",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Fill in the blank with the correct form of ser or estar:",
                    blankSentence = "Nosotros ___ muy felices hoy.",
                    options = listOf("estamos", "somos", "están", "son"),
                    expectedAnswers = listOf("estamos"),
                    hint = "Happiness today is a temporary emotional state.",
                    explanation = "Emotional states use estar: 'estamos felices'."
                ),
                QuizQuestion(
                    id = "l1_2_i2",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate to Spanish: 'Where are you?' (informal)",
                    expectedAnswers = listOf("¿Dónde estás?", "Donde estas", "Dónde estás", "¿Dónde estás tú?"),
                    hint = "Use ¿Dónde + estar (tú form)?",
                    explanation = "'¿Dónde estás?' uses estar because it asks for location."
                )
            ),
            reviewSummary = listOf(
                "SER: DOCTOR (Description, Occupation, Characteristic, Time, Origin, Relationship).",
                "ESTAR: PLACE (Position, Location, Action -ing, Condition, Emotion).",
                "Soy feliz = I am a naturally happy person; Estoy feliz = I feel happy right now."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l1_2_a1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Cómo ___? (How are you right now?)",
                    options = listOf("estás", "eres", "está", "es"),
                    expectedAnswers = listOf("estás"),
                    hint = "Asking how someone feels uses estar.",
                    explanation = "'¿Cómo estás?' asks about current condition."
                ),
                QuizQuestion(
                    id = "l1_2_a2",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Madrid is in Spain.'",
                    expectedAnswers = listOf("Madrid está en España", "Madrid esta en Espana"),
                    hint = "Geographical location takes está.",
                    explanation = "Location uses estar: 'Madrid está en España'."
                )
            )
        ),

        Lesson(
            id = "l1_3",
            levelId = 1,
            title = "Present Tense: -AR, -ER & -IR Verbs",
            subtitle = "Mastering regular verb conjugations",
            durationMinutes = 15,
            objective = "Learn how to conjugate regular Spanish verbs in the present tense for all subjects (yo, tú, él/ella, nosotros, ellos).",
            plainEnglishRule = "Remove the -ar, -er, or -ir ending to get the verb stem, then attach the person ending. For 'yo' (I), regular verbs almost always end in -o!",
            patternFormula = "Hablar -> habl- + o (yo hablo), as (tú hablas), a (él habla)",
            patternFormulaExplanation = "-AR: -o, -as, -a, -amos, -an | -ER: -o, -es, -e, -emos, -en | -IR: -o, -es, -e, -imos, -en",
            examples = listOf(
                LessonExample("Hablo inglés y español.", "I speak English and Spanish.", "Habl-ar -> hablo"),
                LessonExample("¿Dónde vives?", "Where do you live?", "Viv-ir -> vives (tú)"),
                LessonExample("Comemos juntos a las dos.", "We eat together at two.", "Com-er -> comemos (nosotros)"),
                LessonExample("Ellos trabajan en un banco.", "They work in a bank.", "Trabaj-ar -> trabajan (ellos)")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l1_3_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Select the correct form: 'Nosotros ___ café por la mañana.' (tomar)",
                    options = listOf("tomamos", "toman", "tomo", "tomas"),
                    expectedAnswers = listOf("tomamos"),
                    hint = "-AR ending for nosotros is -amos.",
                    explanation = "Nosotros + tomar = tomamos."
                ),
                QuizQuestion(
                    id = "l1_3_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Write the 'yo' form of comer (to eat):",
                    blankSentence = "Yo ___ una manzana todos los días.",
                    options = listOf("como", "comes", "come", "comemos"),
                    expectedAnswers = listOf("como"),
                    hint = "The yo form ends in -o.",
                    explanation = "Comer -> como."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l1_3_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Do you live here?' (informal tú)",
                    expectedAnswers = listOf("¿Vives aquí?", "¿Vives aqui?", "Vives aquí", "¿Tú vives aquí?"),
                    hint = "Vivir in tú form is vives + aquí.",
                    explanation = "'¿Vives aquí?' is the natural direct translation."
                ),
                QuizQuestion(
                    id = "l1_3_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'We write many emails.'",
                    wordsToArrange = listOf("Escribimos", "muchos", "correos", "electrónicos"),
                    expectedAnswers = listOf("Escribimos muchos correos electrónicos", "escribimos muchos correos electronicos"),
                    hint = "Escribir in nosotros form is Escribimos.",
                    explanation = "Escribimos muchos correos electrónicos."
                )
            ),
            reviewSummary = listOf(
                "All present tense regular verbs end in -o for 'yo' (hablo, como, vivo).",
                "Tú ends in -as (-ar) or -es (-er/-ir): hablas, comes, vives.",
                "Nosotros preserves the vowel: hablamos (-ar), comemos (-er), vivimos (-ir)."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l1_3_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'She speaks Spanish very well.'",
                    expectedAnswers = listOf("Ella habla español muy bien", "Habla español muy bien", "Ella habla espanol muy bien"),
                    hint = "Ella habla + español + muy bien",
                    explanation = "Ella habla español muy bien."
                ),
                QuizQuestion(
                    id = "l1_3_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué ___ ustedes? (aprender)",
                    options = listOf("aprenden", "aprende", "aprendemos", "aprendes"),
                    expectedAnswers = listOf("aprenden"),
                    hint = "Ustedes takes the same plural ending as ellos (-en for -er verbs).",
                    explanation = "Ustedes aprenden."
                )
            )
        ),

        Lesson(
            id = "l1_4",
            levelId = 1,
            title = "Ir a + Infinitive: The Instant Future",
            subtitle = "Talking about future plans with ease",
            durationMinutes = 10,
            objective = "Learn how to talk about the future in Spanish immediately without memorizing new future tense endings by using 'ir a + infinitive' (going to do).",
            plainEnglishRule = "Just conjugate the verb IR (voy, vas, va, vamos, van), add the letter 'a', and follow with any infinitive action verb. Exactly like English 'going to'!",
            patternFormula = "[voy / vas / va / vamos / van] + a + [Infinitive]",
            patternFormulaExplanation = "Voy a comer = I am going to eat. Vamos a viajar = We are going to travel.",
            examples = listOf(
                LessonExample("Voy a cocinar esta noche.", "I am going to cook tonight.", "Voy + a + cocinar"),
                LessonExample("¿Qué vas a hacer mañana?", "What are you going to do tomorrow?", "Vas + a + hacer"),
                LessonExample("Vamos a comprar un coche nuevo.", "We are going to buy a new car.", "Vamos + a + comprar"),
                LessonExample("Ellos van a llegar tarde.", "They are going to arrive late.", "Van + a + llegar")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l1_4_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the correct phrase: 'We are going to visit Madrid.'",
                    options = listOf("Vamos a visitar Madrid", "Van a visitar Madrid", "Voy a visitar Madrid", "Vamos visitar Madrid"),
                    expectedAnswers = listOf("Vamos a visitar Madrid"),
                    hint = "We = vamos. Don't forget the 'a'!",
                    explanation = "'Vamos a visitar' correctly includes the required preposition 'a'."
                ),
                QuizQuestion(
                    id = "l1_4_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'going to' connector:",
                    blankSentence = "Voy ___ llamar a María ahora.",
                    options = listOf("a", "de", "en", "por"),
                    expectedAnswers = listOf("a"),
                    hint = "Ir is always followed by 'a' before an action.",
                    explanation = "The construction is always: ir + a + infinitive."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l1_4_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I am going to study Spanish today.'",
                    expectedAnswers = listOf("Voy a estudiar español hoy", "Yo voy a estudiar español hoy", "Voy a estudiar espanol hoy"),
                    hint = "Voy a + estudiar + español + hoy",
                    explanation = "'Voy a estudiar español hoy' is the standard future construction."
                ),
                QuizQuestion(
                    id = "l1_4_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to build: 'What are you going to order?'",
                    wordsToArrange = listOf("¿Qué", "vas", "a", "pedir?"),
                    expectedAnswers = listOf("¿Qué vas a pedir?", "Que vas a pedir"),
                    hint = "¿Qué + vas a + pedir?",
                    explanation = "¿Qué vas a pedir? (Pedir = to order/request)."
                )
            ),
            reviewSummary = listOf(
                "Ir forms: voy (I), vas (you), va (he/she/it), vamos (we), van (they).",
                "Never omit 'a': 'Voy comer' is incorrect; 'Voy A comer' is required.",
                "This formula works for 90% of daily conversational future statements in Spanish."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l1_4_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'They are going to travel to Mexico.'",
                    expectedAnswers = listOf("Van a viajar a México", "Ellos van a viajar a México", "Van a viajar a Mexico"),
                    hint = "Ellos van a + viajar + a México",
                    explanation = "Van a viajar a México."
                ),
                QuizQuestion(
                    id = "l1_4_a2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Fix the error in: 'Nosotros vamos cenar en el restaurante.'",
                    expectedAnswers = listOf("Nosotros vamos a cenar en el restaurante", "Vamos a cenar en el restaurante"),
                    hint = "Add the missing connector 'a'.",
                    explanation = "Missing 'a' between vamos and cenar."
                )
            )
        ),

        Lesson(
            id = "l1_5",
            levelId = 1,
            title = "Question Words & Daily Conversations",
            subtitle = "Asking what, where, when, why, who & how",
            durationMinutes = 12,
            objective = "Ask and answer key everyday questions using Spanish interrogative words (qué, dónde, cuándo, por qué, quién, cómo) and connecting words (y, pero, porque).",
            plainEnglishRule = "In Spanish, all question words carry a written accent mark (tilde): ¿Qué?, ¿Dónde?, ¿Cuándo?, etc. Note that 'por qué' (two words, with accent) means 'why', while 'porque' (one word, no accent) means 'because'.",
            patternFormula = "¿[Question Word] + [Verb] + [Subject / Details]?",
            patternFormulaExplanation = "¿Por qué estudias español? (Why do you study Spanish?) -> Porque me gusta (Because I like it).",
            examples = listOf(
                LessonExample("¿Cómo te llamas?", "What is your name? (How do you call yourself?)", "Cómo = How"),
                LessonExample("¿De dónde eres?", "Where are you from?", "Dónde = Where"),
                LessonExample("¿Cuándo es la reunión?", "When is the meeting?", "Cuándo = When"),
                LessonExample("¿Por qué? Porque es importante.", "Why? Because it is important.", "Por qué vs porque")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l1_5_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the right question word: '¿___ cuesta esto?' (How much does this cost?)",
                    options = listOf("Cuánto", "Cuándo", "Dónde", "Quién"),
                    expectedAnswers = listOf("Cuánto", "Cuanto"),
                    hint = "Cuánto means how much.",
                    explanation = "¿Cuánto cuesta? is the universal way to ask price."
                ),
                QuizQuestion(
                    id = "l1_5_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'because':",
                    blankSentence = "Estudio español ___ quiero viajar.",
                    options = listOf("porque", "por qué", "pero", "así que"),
                    expectedAnswers = listOf("porque"),
                    hint = "One word, no accent for 'because'.",
                    explanation = "'porque' = because (explanation); 'por qué' = why (question)."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l1_5_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Where is the bathroom?'",
                    expectedAnswers = listOf("¿Dónde está el baño?", "Donde esta el bano", "Dónde está el baño"),
                    hint = "¿Dónde + está + el baño?",
                    explanation = "Use 'está' for location: ¿Dónde está el baño?"
                ),
                QuizQuestion(
                    id = "l1_5_i2",
                    type = ExerciseType.CONVERSATION_REPLY,
                    prompt = "Answer the question in Spanish: '¿Cómo te llamas?' (Say: Me llamo [Your Name])",
                    expectedAnswers = listOf("Me llamo", "Mi nombre es"),
                    hint = "Start with 'Me llamo...'",
                    explanation = "'Me llamo...' is the natural Spanish response."
                )
            ),
            reviewSummary = listOf(
                "¿Qué? = What?, ¿Dónde? = Where?, ¿Cuándo? = When?, ¿Quién? = Who?",
                "¿Por qué? = Why? vs Porque = Because.",
                "Y = and, Pero = but, Así que = so."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l1_5_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I want to go, but I have to work.'",
                    expectedAnswers = listOf("Quiero ir, pero tengo que trabajar", "Quiero ir pero tengo que trabajar"),
                    hint = "Quiero ir + pero + tengo que trabajar",
                    explanation = "Combines querer, connector 'pero', and 'tener que'."
                ),
                QuizQuestion(
                    id = "l1_5_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿___ es tu número de teléfono? (What is your phone number?)",
                    options = listOf("Cuál", "Qué", "Quién", "Dónde"),
                    expectedAnswers = listOf("Cuál", "Cual"),
                    hint = "In Spanish, asking for specific data or choices from many options uses 'Cuál', not 'Qué'.",
                    explanation = "Spanish uses '¿Cuál es...?' when asking for phone numbers, names, or addresses."
                )
            )
        ),

        // ================= LEVEL 2: DEVELOPING A1 =================
        Lesson(
            id = "l2_1",
            levelId = 2,
            title = "Saber vs Conocer: Two Ways to Know",
            subtitle = "Facts & skills vs people & places",
            durationMinutes = 12,
            objective = "Distinguish accurately between SABER (knowing facts, information, or how to do something) and CONOCER (being familiar with a person or place).",
            plainEnglishRule = "Use SABER for facts, data, or abilities (+ infinitive). Use CONOCER for people (with the personal 'a') and places you have visited or are familiar with.",
            patternFormula = "SABER = Facts / Skills | CONOCER = People / Places",
            patternFormulaExplanation = "Sé hablar español (I know how to speak). Conozco a Juan (I know Juan). Conozco Barcelona (I've been to/know Barcelona).",
            examples = listOf(
                LessonExample("Sé dónde está el hotel.", "I know where the hotel is.", "SABER: Information / Fact"),
                LessonExample("¿Sabes cocinar paella?", "Do you know how to cook paella?", "SABER: Skill / How to do"),
                LessonExample("Conozco a tu hermano.", "I know your brother.", "CONOCER: Familiar with a person (+ personal 'a')"),
                LessonExample("No conozco esa ciudad.", "I don't know (haven't visited) that city.", "CONOCER: Familiar with a place")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l2_1_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the verb: 'Yo ___ hablar tres idiomas.' (I know how to speak three languages)",
                    options = listOf("sé", "conozco", "sabes", "conoce"),
                    expectedAnswers = listOf("sé", "se"),
                    hint = "Knowing how to do a skill uses saber (yo form is sé).",
                    explanation = "'Sé' + infinitive expresses knowing how to do a skill."
                ),
                QuizQuestion(
                    id = "l2_1_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the verb: '¿___ a María?' (Do you know Maria?)",
                    options = listOf("Conoces", "Sabes", "Conozco", "Sabe"),
                    expectedAnswers = listOf("Conoces"),
                    hint = "Being acquainted with a person uses conocer.",
                    explanation = "People require conocer + personal 'a': ¿Conoces a María?"
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l2_1_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I don't know the answer.'",
                    expectedAnswers = listOf("No sé la respuesta", "No se la respuesta", "Yo no sé la respuesta"),
                    hint = "No sé + la respuesta",
                    explanation = "A factual answer is data, so we use saber: No sé la respuesta."
                ),
                QuizQuestion(
                    id = "l2_1_i2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Fill with the correct form of conocer (yo form):",
                    blankSentence = "Yo no ___ este restaurante.",
                    options = listOf("conozco", "sé", "conoce", "sabemos"),
                    expectedAnswers = listOf("conozco"),
                    hint = "Familiarity with a restaurant or place uses conocer.",
                    explanation = "Yo conozco / no conozco."
                )
            ),
            reviewSummary = listOf(
                "Saber: Sé, sabes, sabe, sabemos, saben. For facts and how-to skills.",
                "Conocer: Conozco, conoces, conoce, conocemos, conocen. For people and places.",
                "Always remember the personal 'a' when knowing a person: Conozco A Carlos."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l2_1_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Do you know where Carlos lives?'",
                    expectedAnswers = listOf("¿Sabes dónde vive Carlos?", "Sabes donde vive Carlos", "¿Tú sabes dónde vive Carlos?"),
                    hint = "¿Sabes + dónde vive Carlos?",
                    explanation = "This is asking for factual information (where he lives), so use saber."
                ),
                QuizQuestion(
                    id = "l2_1_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Nosotros ___ muy bien España. (We know Spain very well)",
                    options = listOf("conocemos", "sabemos", "conocen", "saben"),
                    expectedAnswers = listOf("conocemos"),
                    hint = "Familiarity with a country uses conocer.",
                    explanation = "Nosotros conocemos España."
                )
            )
        ),

        Lesson(
            id = "l2_2",
            levelId = 2,
            title = "Key Irregulars: Decir, Dar, Ver & Hacer",
            subtitle = "Saying, giving, seeing and making/doing",
            durationMinutes = 14,
            objective = "Master four of the most frequent irregular verbs in daily Spanish conversation: Decir (to say), Dar (to give), Ver (to see), and Hacer (to make/do).",
            plainEnglishRule = "Their 'yo' forms are special: Yo digo (I say), Yo doy (I give), Yo veo (I see), Yo hago (I do/make). The rest of the forms follow regular patterns with stem changes.",
            patternFormula = "Digo (decir) | Doy (dar) | Veo (ver) | Hago (hacer)",
            patternFormulaExplanation = "Hago ejercicio (I exercise); Digo la verdad (I tell the truth); Doy las gracias (I give thanks); Veo una película (I watch a movie).",
            examples = listOf(
                LessonExample("Hago la compra los sábados.", "I do the groceries on Saturdays.", "Hacer -> Hago"),
                LessonExample("Siempre digo la verdad.", "I always tell the truth.", "Decir -> Digo"),
                LessonExample("Te doy mi número.", "I give you my number.", "Dar -> Doy"),
                LessonExample("Veo a mis amigos los fines de semana.", "I see my friends on weekends.", "Ver -> Veo")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l2_2_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the 'yo' form of hacer: 'Yo ___ el desayuno.' (I make breakfast)",
                    options = listOf("hago", "haco", "hace", "hacen"),
                    expectedAnswers = listOf("hago"),
                    hint = "Hacer has an irregular 'yo' form ending in -go.",
                    explanation = "Yo hago el desayuno."
                ),
                QuizQuestion(
                    id = "l2_2_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the form of decir for 'él': 'Él ___ que sí.' (He says yes)",
                    options = listOf("dice", "digo", "dices", "decimos"),
                    expectedAnswers = listOf("dice"),
                    hint = "Decir has an e->i stem change: dice.",
                    explanation = "Él dice que sí."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l2_2_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'What are you doing?' (informal tú)",
                    expectedAnswers = listOf("¿Qué haces?", "Que haces", "¿Qué estás haciendo?", "¿Tú qué haces?"),
                    hint = "¿Qué + hacer (tú)?",
                    explanation = "¿Qué haces? is the most common way to ask what someone is doing."
                ),
                QuizQuestion(
                    id = "l2_2_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'I see a new problem.'",
                    wordsToArrange = listOf("Veo", "un", "problema", "nuevo"),
                    expectedAnswers = listOf("Veo un problema nuevo", "veo un problema nuevo"),
                    hint = "Ver in yo form is Veo.",
                    explanation = "Veo un problema nuevo."
                )
            ),
            reviewSummary = listOf(
                "Yo forms: Hago (hacer), Digo (decir), Doy (dar), Veo (ver).",
                "Hacer is used for both 'to make' and 'to do': hago café, hago mi tarea.",
                "Decir takes an e->i vowel change: digo, dices, dice, dicen (except decimos)."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l2_2_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I give you my word.'",
                    expectedAnswers = listOf("Te doy mi palabra", "Doy mi palabra"),
                    hint = "Te doy + mi palabra",
                    explanation = "Te doy mi palabra."
                ),
                QuizQuestion(
                    id = "l2_2_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué ___ ellos los domingos? (What do they do on Sundays?)",
                    options = listOf("hacen", "hace", "hacemos", "hago"),
                    expectedAnswers = listOf("hacen"),
                    hint = "Ellos form of hacer.",
                    explanation = "Ellos hacen."
                )
            )
        ),

        Lesson(
            id = "l2_3",
            levelId = 2,
            title = "Expanding Negatives: Nunca, Nadie, Nada & Tampoco",
            subtitle = "Never, nobody, nothing & neither",
            durationMinutes = 11,
            objective = "Learn Spanish negative words and master the Spanish double negative rule, which is required and completely natural.",
            plainEnglishRule = "In Spanish, double negatives are required. If the negative word comes AFTER the verb, you MUST still put 'no' BEFORE the verb. E.g., 'No sé nada' (I don't know nothing = I don't know anything).",
            patternFormula = "No + [Verb] + [Negative Word]  OR  [Negative Word] + [Verb]",
            patternFormulaExplanation = "'No tengo nada' = 'Nada tengo' (I have nothing / I don't have anything).",
            examples = listOf(
                LessonExample("No sé nada.", "I don't know anything / I know nothing.", "Double negative: No + verb + nada"),
                LessonExample("Nadie está aquí.", "Nobody is here.", "Negative word before verb: no 'no' needed"),
                LessonExample("No hablo con nadie.", "I don't speak with anybody.", "Negative word after verb: 'no' required"),
                LessonExample("Yo tampoco quiero ir.", "I don't want to go either / Me neither.", "Tampoco = neither / not either")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l2_3_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "How do you say 'Me neither' in Spanish?",
                    options = listOf("Yo tampoco", "Yo también", "Yo nunca", "Yo nada"),
                    expectedAnswers = listOf("Yo tampoco", "tampoco"),
                    hint = "Tampoco is the opposite of también.",
                    explanation = "'Yo tampoco' is the standard phrase for 'me neither'."
                ),
                QuizQuestion(
                    id = "l2_3_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete the double negative: 'No veo a ___.' (I don't see anyone)",
                    blankSentence = "No veo a ___.",
                    options = listOf("nadie", "alguien", "nada", "nunca"),
                    expectedAnswers = listOf("nadie"),
                    hint = "Nadie = nobody / anyone (for people).",
                    explanation = "No veo a nadie = I don't see anyone."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l2_3_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I never eat meat.'",
                    expectedAnswers = listOf("Nunca como carne", "No como carne nunca", "Yo nunca como carne"),
                    hint = "Nunca como carne OR No como carne nunca.",
                    explanation = "Both 'Nunca como carne' and 'No como carne nunca' are grammatically correct."
                ),
                QuizQuestion(
                    id = "l2_3_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'There is nothing here.'",
                    wordsToArrange = listOf("No", "hay", "nada", "aquí"),
                    expectedAnswers = listOf("No hay nada aquí", "no hay nada aqui"),
                    hint = "No + hay + nada + aquí",
                    explanation = "No hay nada aquí (Hay = there is/are)."
                )
            ),
            reviewSummary = listOf(
                "Nada = nothing/anything; Nadie = nobody/anybody; Nunca = never; Tampoco = neither.",
                "Rule: No + verb + negative word (No quiero nada).",
                "Or put the negative first without 'no': Nunca quiero eso."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l2_3_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Nobody knows the secret.'",
                    expectedAnswers = listOf("Nadie sabe el secreto", "Nadie conoce el secreto"),
                    hint = "Nadie + sabe + el secreto",
                    explanation = "Nadie sabe el secreto."
                ),
                QuizQuestion(
                    id = "l2_3_a2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Fix the English-influenced mistake: 'Hablo con nadie.'",
                    expectedAnswers = listOf("No hablo con nadie", "Con nadie hablo"),
                    hint = "Add 'no' before the verb hablo.",
                    explanation = "Spanish requires: 'No hablo con nadie'."
                )
            )
        ),

        Lesson(
            id = "l2_4",
            levelId = 2,
            title = "Modifiers & Time Expressions",
            subtitle = "Today, tomorrow, earlier, later & degrees",
            durationMinutes = 11,
            objective = "Add nuance and precision to sentences using modifiers (muy, bastante, más, menos, solo, también) and time words (hoy, mañana, ayer, más tarde, temprano, tarde).",
            plainEnglishRule = "Modifiers like 'muy' (very), 'bastante' (quite/fairly), 'más' (more), and 'menos' (less) come directly before adjectives or adverbs. Time expressions usually sit at the start or end of the clause.",
            patternFormula = "[Time Word], [Sentence] + [Modifier] + [Adjective]",
            patternFormulaExplanation = "Hoy tengo que trabajar bastante temprano (Today I have to work quite early).",
            examples = listOf(
                LessonExample("Hoy estoy muy ocupado.", "Today I am very busy.", "Hoy (today) + muy (very)"),
                LessonExample("Mañana voy a llegar más tarde.", "Tomorrow I am going to arrive later.", "Mañana (tomorrow) + más tarde (later)"),
                LessonExample("El examen es bastante fácil.", "The exam is quite easy.", "Bastante = quite / fairly"),
                LessonExample("Solo hablo un poco de español.", "I only speak a little Spanish.", "Solo = only / just")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l2_4_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "How do you say 'quite early'?",
                    options = listOf("bastante temprano", "muy tarde", "más tarde", "solo temprano"),
                    expectedAnswers = listOf("bastante temprano"),
                    hint = "Bastante = quite; temprano = early.",
                    explanation = "Bastante temprano."
                ),
                QuizQuestion(
                    id = "l2_4_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'more':",
                    blankSentence = "Quiero practicar ___ español.",
                    options = listOf("más", "muy", "menos", "tan"),
                    expectedAnswers = listOf("más", "mas"),
                    hint = "Más = more.",
                    explanation = "Quiero practicar más español."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l2_4_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Tomorrow I want to sleep more.'",
                    expectedAnswers = listOf("Mañana quiero dormir más", "Manana quiero dormir mas", "Yo quiero dormir más mañana"),
                    hint = "Mañana + quiero + dormir + más",
                    explanation = "Mañana quiero dormir más."
                ),
                QuizQuestion(
                    id = "l2_4_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'We can talk later today.'",
                    wordsToArrange = listOf("Podemos", "hablar", "más", "tarde", "hoy"),
                    expectedAnswers = listOf("Podemos hablar más tarde hoy", "Hoy podemos hablar más tarde"),
                    hint = "Podemos hablar + más tarde + hoy",
                    explanation = "Podemos hablar más tarde hoy."
                )
            ),
            reviewSummary = listOf(
                "Muy = very; Bastante = quite/fairly; Más = more; Menos = less; Solo = only.",
                "Hoy = today; Mañana = tomorrow; Ayer = yesterday.",
                "Temprano = early; Tarde = late; Más tarde = later."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l2_4_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Today is quite hot.'",
                    expectedAnswers = listOf("Hoy hace bastante calor", "Hoy está bastante caluroso"),
                    hint = "Weather uses 'hacer': Hoy hace bastante calor.",
                    explanation = "Hoy hace bastante calor."
                ),
                QuizQuestion(
                    id = "l2_4_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Puedes venir ___ temprano mañana? (more early)",
                    options = listOf("más", "muy", "bastante", "menos"),
                    expectedAnswers = listOf("más", "mas"),
                    hint = "More early = más temprano.",
                    explanation = "Más temprano."
                )
            )
        ),

        Lesson(
            id = "l2_5",
            levelId = 2,
            title = "Adjectives & Multi-Clause Sentences",
            subtitle = "Describing things & connecting thoughts",
            durationMinutes = 14,
            objective = "Master adjective gender/number agreement and connect multiple sentences smoothly with connectors (porque, pero, aunque, cuando).",
            plainEnglishRule = "In Spanish, adjectives must match the noun in gender (masculine/feminine) and number (singular/plural), and usually come AFTER the noun: 'un coche rojo', 'dos casas blancas'.",
            patternFormula = "[Noun] + [Matching Adjective] + [Connector] + [Second Clause]",
            patternFormulaExplanation = "Tengo una casa pequeña pero es muy cómoda (I have a small house but it is very comfortable).",
            examples = listOf(
                LessonExample("Tengo un coche nuevo y dos casas antiguas.", "I have a new car and two old houses.", "Agreement: coche nuevo (m.sg), casas antiguas (f.pl)"),
                LessonExample("La comida española es deliciosa.", "Spanish food is delicious.", "Comida (f) -> española deliciosa (f)"),
                LessonExample("Estudio mucho porque quiero hablar bien.", "I study a lot because I want to speak well.", "Connector: porque"),
                LessonExample("Aunque estoy cansado, voy a salir.", "Even though I am tired, I am going to go out.", "Connector: aunque (even though)")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l2_5_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Select the correct adjective form: 'Las manzanas son ___.' (rojo)",
                    options = listOf("rojas", "rojos", "roja", "rojo"),
                    expectedAnswers = listOf("rojas"),
                    hint = "Manzanas is feminine plural.",
                    explanation = "Las manzanas son rojas."
                ),
                QuizQuestion(
                    id = "l2_5_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'even though':",
                    blankSentence = "___ llueve, vamos al parque.",
                    options = listOf("Aunque", "Porque", "Pero", "Así que"),
                    expectedAnswers = listOf("Aunque", "aunque"),
                    hint = "Aunque = even though / although.",
                    explanation = "Aunque llueve, vamos al parque."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l2_5_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I have a big family and we live in a quiet city.'",
                    expectedAnswers = listOf(
                        "Tengo una familia grande y vivimos en una ciudad tranquila",
                        "Tengo una familia grande y nosotros vivimos en una ciudad tranquila"
                    ),
                    hint = "Familia grande + ciudad tranquila (adjectives match feminine nouns).",
                    explanation = "Tengo una familia grande y vivimos en una ciudad tranquila."
                ),
                QuizQuestion(
                    id = "l2_5_i2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Fix the adjective error: 'Compré dos camisas blanco.'",
                    expectedAnswers = listOf("Compré dos camisas blancas", "Compre dos camisas blancas"),
                    hint = "Camisas is feminine plural, so blanco must be blancas.",
                    explanation = "Dos camisas blancas."
                )
            ),
            reviewSummary = listOf(
                "Adjectives change: -o (m), -a (f), -os (m.pl), -as (f.pl).",
                "Adjectives ending in consonants add -es: azul -> azules.",
                "Connectors like 'aunque' (although), 'porque' (because), and 'pero' (but) let you construct rich compound sentences."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l2_5_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'The Spanish books are very interesting.'",
                    expectedAnswers = listOf(
                        "Los libros españoles son muy interesantes",
                        "Los libros espanoles son muy interesantes"
                    ),
                    hint = "Libros españoles + son muy interesantes",
                    explanation = "Los libros españoles son muy interesantes."
                ),
                QuizQuestion(
                    id = "l2_5_a2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'I want to travel when I have time.'",
                    wordsToArrange = listOf("Quiero", "viajar", "cuando", "tengo", "tiempo"),
                    expectedAnswers = listOf("Quiero viajar cuando tengo tiempo"),
                    hint = "Quiero viajar + cuando tengo tiempo",
                    explanation = "Quiero viajar cuando tengo tiempo."
                )
            )
        ),

        // ================= LEVEL 3: A1 TO A2 (TALKING ABOUT THE PAST) =================
        Lesson(
            id = "l3_1",
            levelId = 3,
            title = "Numbers, Time, Dates & Schedules",
            subtitle = "Telling time and ordering your schedule",
            durationMinutes = 12,
            objective = "Tell time in Spanish, understand numbers up to 1000, express dates, and talk about your daily routines and schedules.",
            plainEnglishRule = "To tell the time, use 'Es la una' (It is one o'clock, singular) and 'Son las...' for all other hours (plural). To say 'at' a certain time, use 'a la una' or 'a las...'.",
            patternFormula = "Son las [Hour] y [Minutes]  /  A las [Hour]",
            patternFormulaExplanation = "Son las tres y media (It's 3:30). Empiezo a trabajar a las nueve (I start work at 9).",
            examples = listOf(
                LessonExample("¿Qué hora es? Son las cinco y cuarto.", "What time is it? It's 5:15.", "Son las + hora"),
                LessonExample("Es la una y media.", "It is 1:30.", "Es la (only for one o'clock)"),
                LessonExample("La clase empieza a las ocho de la mañana.", "The class starts at 8:00 in the morning.", "A las + hora"),
                LessonExample("Hoy es el quince de mayo.", "Today is the fifteenth of May.", "Dates: el + number + de + month")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l3_1_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose how to say: 'It is two o'clock.'",
                    options = listOf("Son las dos", "Es la dos", "Está a las dos", "Son los dos"),
                    expectedAnswers = listOf("Son las dos"),
                    hint = "Plural hours use 'Son las'.",
                    explanation = "Son las dos."
                ),
                QuizQuestion(
                    id = "l3_1_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'at':",
                    blankSentence = "Almorzamos ___ las dos de la tarde.",
                    options = listOf("a", "en", "de", "por"),
                    expectedAnswers = listOf("a"),
                    hint = "Saying 'at' a specific hour uses 'a'.",
                    explanation = "'A las dos' = at two o'clock."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l3_1_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'What time do you have to leave?'",
                    expectedAnswers = listOf("¿A qué hora tienes que salir?", "A que hora tienes que salir", "¿A qué hora te tienes que ir?"),
                    hint = "¿A qué hora + tienes que salir?",
                    explanation = "¿A qué hora tienes que salir?"
                ),
                QuizQuestion(
                    id = "l3_1_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'The meeting is at four in the afternoon.'",
                    wordsToArrange = listOf("La", "reunión", "es", "a", "las", "cuatro", "de", "la", "tarde"),
                    expectedAnswers = listOf("La reunión es a las cuatro de la tarde", "La reunion es a las cuatro de la tarde"),
                    hint = "La reunión es a las cuatro de la tarde.",
                    explanation = "La reunión es a las cuatro de la tarde."
                )
            ),
            reviewSummary = listOf(
                "Es la una (1:00) vs Son las dos, tres, cuatro... (2:00, 3:00, 4:00).",
                "Y cuarto = quarter past; Y media = half past; Menos cuarto = quarter to.",
                "A las + hour = at that time: Salgo a las seis."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l3_1_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'It is one fifteen.'",
                    expectedAnswers = listOf("Es la una y cuarto", "Es la una y quince"),
                    hint = "Remember 1:00 is singular: Es la una.",
                    explanation = "Es la una y cuarto."
                ),
                QuizQuestion(
                    id = "l3_1_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Cuál es la fecha de hoy? Hoy es el diez ___ octubre.",
                    options = listOf("de", "en", "a", "por"),
                    expectedAnswers = listOf("de"),
                    hint = "Spanish dates use 'el [day] de [month]'.",
                    explanation = "El diez de octubre."
                )
            )
        ),

        Lesson(
            id = "l3_2",
            levelId = 3,
            title = "The Preterite Tense: Completed Past Actions",
            subtitle = "What happened yesterday and last week",
            durationMinutes = 15,
            objective = "Use the Preterite tense to talk about finished, completed actions that happened at a specific point in the past.",
            plainEnglishRule = "The preterite is like a single snapshot: you took a trip, you bought a coffee, you arrived. For regular -AR verbs: -é, -aste, -ó, -amos, -aron. For -ER/-IR verbs: -í, -iste, -ió, -imos, -ieron.",
            patternFormula = "AR: -é, -aste, -ó, -amos, -aron | ER/IR: -í, -iste, -ió, -imos, -ieron",
            patternFormulaExplanation = "Hablé (I spoke); Comí (I ate); Viví (I lived); Llegó (he/she arrived).",
            examples = listOf(
                LessonExample("Ayer trabajé todo el día.", "Yesterday I worked all day.", "Trabajar -> trabajé"),
                LessonExample("Comí en un restaurante mexicano anoche.", "I ate at a Mexican restaurant last night.", "Comer -> comí"),
                LessonExample("Llegamos a Madrid la semana pasada.", "We arrived in Madrid last week.", "Llegar -> llegamos"),
                LessonExample("Ella compró un vestido nuevo.", "She bought a new dress.", "Comprar -> compró")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l3_2_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the preterite form for 'I bought': 'Ayer yo ___ un café.' (comprar)",
                    options = listOf("compré", "compro", "compraba", "compró"),
                    expectedAnswers = listOf("compré", "compre"),
                    hint = "The 'yo' preterite for -AR verbs ends in -é.",
                    explanation = "Yo compré un café."
                ),
                QuizQuestion(
                    id = "l3_2_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the form for 'they lived': 'Ellos ___ en Valencia dos años.' (vivir)",
                    options = listOf("vivieron", "vivían", "vivimos", "vivió"),
                    expectedAnswers = listOf("vivieron"),
                    hint = "-IR preterite plural ending is -ieron.",
                    explanation = "Ellos vivieron."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l3_2_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Yesterday I talked with my boss.'",
                    expectedAnswers = listOf("Ayer hablé con mi jefe", "Ayer hable con mi jefe", "Yo hablé con mi jefe ayer"),
                    hint = "Ayer + hablé + con mi jefe",
                    explanation = "Ayer hablé con mi jefe."
                ),
                QuizQuestion(
                    id = "l3_2_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'What did you eat last night?'",
                    wordsToArrange = listOf("¿Qué", "comiste", "anoche?"),
                    expectedAnswers = listOf("¿Qué comiste anoche?", "Que comiste anoche"),
                    hint = "¿Qué + comiste + anoche?",
                    explanation = "¿Qué comiste anoche?"
                )
            ),
            reviewSummary = listOf(
                "Use preterite for completed past events: ayer (yesterday), anoche (last night), la semana pasada (last week).",
                "-AR preterite: hablé, hablaste, habló, hablamos, hablaron.",
                "-ER/-IR preterite: comí, comiste, comió, comimos, comieron."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l3_2_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'We decided to stay.'",
                    expectedAnswers = listOf("Decidimos quedarnos", "Decidimos quedar"),
                    hint = "Decidir in nosotros preterite is decidimos.",
                    explanation = "Decidimos quedarnos."
                ),
                QuizQuestion(
                    id = "l3_2_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "El tren ___ a tiempo. (llegar)",
                    options = listOf("llegó", "llega", "llegaba", "llegué"),
                    expectedAnswers = listOf("llegó", "llego"),
                    hint = "Third person preterite of llegar ends in -ó.",
                    explanation = "El tren llegó a tiempo."
                )
            )
        ),

        Lesson(
            id = "l3_3",
            levelId = 3,
            title = "The Imperfect Tense: Habits & Background",
            subtitle = "Used to, was doing & setting the scene",
            durationMinutes = 14,
            objective = "Learn the Imperfect tense to describe habits in the past ('used to'), ongoing background states ('was doing'), and descriptions (age, weather, scenery).",
            plainEnglishRule = "The imperfect is like a movie playing in the background with no set end time. For -AR verbs: -aba, -abas, -aba, -ábamos, -aban. For -ER/-IR verbs: -ía, -ías, -ía, -íamos, -ían.",
            patternFormula = "AR: -aba, -abas, -aba | ER/IR: -ía, -ías, -ía",
            patternFormulaExplanation = "Cuando era niño, jugaba en el parque (When I was a boy, I used to play in the park).",
            examples = listOf(
                LessonExample("Cuando vivía en Madrid, comía tapas todos los días.", "When I lived in Madrid, I used to eat tapas every day.", "Ongoing habit / repeated past"),
                LessonExample("Hacía mucho sol esa mañana.", "It was very sunny that morning.", "Weather / background setting"),
                LessonExample("Tenía veinte años.", "I was twenty years old.", "Age in the past (always imperfect)"),
                LessonExample("Estaba cansado.", "I was tired (for an ongoing period).", "Mental / physical state in background")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l3_3_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the imperfect form for 'I used to speak': 'De niño yo ___ poco.' (hablar)",
                    options = listOf("hablaba", "hablé", "hablo", "hablaría"),
                    expectedAnswers = listOf("hablaba"),
                    hint = "-AR imperfect ends in -aba.",
                    explanation = "Yo hablaba (I used to speak)."
                ),
                QuizQuestion(
                    id = "l3_3_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'era' (used to be/was):",
                    blankSentence = "Mi casa ___ grande y blanca.",
                    options = listOf("era", "fue", "es", "estaba"),
                    expectedAnswers = listOf("era"),
                    hint = "Description of an object in the past uses imperfect of ser: era.",
                    explanation = "Mi casa era grande y blanca."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l3_3_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'We used to live near the beach.'",
                    expectedAnswers = listOf(
                        "Vivíamos cerca de la playa",
                        "Viviamos cerca de la playa",
                        "Nosotros vivíamos cerca de la playa"
                    ),
                    hint = "Vivir in nosotros imperfect is vivíamos.",
                    explanation = "Vivíamos cerca de la playa."
                ),
                QuizQuestion(
                    id = "l3_3_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'It was five o'clock in the afternoon.'",
                    wordsToArrange = listOf("Eran", "las", "cinco", "de", "la", "tarde"),
                    expectedAnswers = listOf("Eran las cinco de la tarde"),
                    hint = "Time in the past always uses imperfect: Eran las cinco.",
                    explanation = "Eran las cinco de la tarde."
                )
            ),
            reviewSummary = listOf(
                "Use imperfect for: repeated habits (used to), background scenes, weather, age, time in past.",
                "-AR: cantaba, cantabas, cantaba, cantábamos, cantaban.",
                "-ER/-IR: comía, comías, comía, comíamos, comían.",
                "Only 3 irregular verbs in the imperfect: ser (era), ir (iba), ver (veía)."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l3_3_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I was very happy in that company.'",
                    expectedAnswers = listOf("Era muy feliz en esa empresa", "Estaba muy feliz en esa empresa"),
                    hint = "Era / Estaba muy feliz en esa empresa.",
                    explanation = "Era / Estaba muy feliz en esa empresa."
                ),
                QuizQuestion(
                    id = "l3_3_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Siempre ___ al fútbol los domingos. (We always used to play)",
                    options = listOf("jugábamos", "jugamos", "jugaron", "jugaban"),
                    expectedAnswers = listOf("jugábamos", "jugabamos"),
                    hint = "Habitual past action in nosotros form.",
                    explanation = "Siempre jugábamos al fútbol."
                )
            )
        ),

        Lesson(
            id = "l3_4",
            levelId = 3,
            title = "Preterite vs Imperfect in Action",
            subtitle = "Combining the two past tenses in stories",
            durationMinutes = 15,
            objective = "Combine preterite (interruption, specific event) and imperfect (ongoing background) to tell rich, natural stories about past experiences.",
            plainEnglishRule = "Think of a movie: the IMPERFECT sets the stage (it was raining, I was walking down the street) and the PRETERITE is the sudden action that interrupted it (suddenly, I saw an old friend).",
            patternFormula = "[Imperfect Background] + cuando + [Preterite Interruption]",
            patternFormulaExplanation = "Caminaba por la calle cuando vi a Juan (I was walking along the street when I saw Juan).",
            examples = listOf(
                LessonExample("Dormía cuando sonó el teléfono.", "I was sleeping when the phone rang.", "Dormía (imperfect background) + sonó (preterite action)"),
                LessonExample("Hacía frío cuando salimos.", "It was cold when we left.", "Hacía (imperfect weather) + salimos (completed action)"),
                LessonExample("Estudiaba en la biblioteca y encontré este libro.", "I was studying in the library and I found this book.", "Background + discovery"),
                LessonExample("Ayer tuve un día difícil.", "Yesterday I had a difficult day.", "Finished day = preterite")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l3_4_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Select the pair: 'Yo ___ (cocinar) cuando mi amigo ___ (llegar).'",
                    options = listOf(
                        "cocinaba / llegó",
                        "cociné / llegaba",
                        "cocinaba / llegaba",
                        "cociné / llegó"
                    ),
                    expectedAnswers = listOf("cocinaba / llegó", "cocinaba / llego"),
                    hint = "Cooking was the ongoing background; the friend arriving was the specific interrupting event.",
                    explanation = "Cocinaba (imperfect) cuando mi amigo llegó (preterite)."
                ),
                QuizQuestion(
                    id = "l3_4_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Which tense fits best: 'El año pasado ___ a Colombia.' (visitar - completed trip)",
                    options = listOf("visité", "visitaba", "visito", "visitaré"),
                    expectedAnswers = listOf("visité", "visite"),
                    hint = "A specific completed trip last year uses preterite.",
                    explanation = "El año pasado visité Colombia."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l3_4_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I was working when you called.'",
                    expectedAnswers = listOf(
                        "Trabajaba cuando llamaste",
                        "Yo trabajaba cuando tú llamaste",
                        "Estaba trabajando cuando llamaste"
                    ),
                    hint = "Trabajaba (imperfect) + cuando llamaste (preterite).",
                    explanation = "Trabajaba / Estaba trabajando cuando llamaste."
                ),
                QuizQuestion(
                    id = "l3_4_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'It was late when we arrived.'",
                    wordsToArrange = listOf("Era", "tarde", "cuando", "llegamos"),
                    expectedAnswers = listOf("Era tarde cuando llegamos"),
                    hint = "Era tarde (imperfect time) + cuando llegamos (preterite).",
                    explanation = "Era tarde cuando llegamos."
                )
            ),
            reviewSummary = listOf(
                "Imperfect = the backdrop (what was going on, time, feelings).",
                "Preterite = the foreground action (what happened next).",
                "Keyword 'cuando' frequently bridges an imperfect state and a preterite event."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l3_4_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'While I was reading, I fell asleep.'",
                    expectedAnswers = listOf("Mientras leía, me dormí", "Mientras leía me dormí", "Mientras leia me dormi"),
                    hint = "Mientras leía (imperfect) + me dormí (preterite).",
                    explanation = "Mientras leía, me dormí."
                ),
                QuizQuestion(
                    id = "l3_4_a2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Choose the natural sentence for: 'Yesterday at 3 PM it started to rain.'",
                    options = listOf("Ayer a las tres empezó a llover", "Ayer a las tres empezaba a llover"),
                    expectedAnswers = listOf("Ayer a las tres empezó a llover"),
                    hint = "Starting is a discrete moment = preterite.",
                    explanation = "Empezó a llover."
                )
            )
        ),

        Lesson(
            id = "l3_5",
            levelId = 3,
            title = "Present Perfect & Combining All Tenses",
            subtitle = "Have done, did, do, and will do",
            durationMinutes = 15,
            objective = "Recognize and use the Present Perfect (he comido, has viajado) for life experiences, and comfortably combine past, present, and future in a single conversation.",
            plainEnglishRule = "The Present Perfect connects the past to now (things you have done). Conjugate HABER (he, has, ha, hemos, han) + past participle (-ado for -ar, -ido for -er/-ir).",
            patternFormula = "[he / has / ha / hemos / han] + [Participle (-ado / -ido)]",
            patternFormulaExplanation = "He vivido en España (I have lived in Spain). ¿Has probado el ceviche? (Have you tried ceviche?).",
            examples = listOf(
                LessonExample("He aprendido mucho español este mes.", "I have learned a lot of Spanish this month.", "He + aprendido"),
                LessonExample("¿Has estado en Madrid alguna vez?", "Have you ever been to Madrid?", "Has + estado"),
                LessonExample("Ayer trabajé, hoy descanso y mañana viajaré.", "Yesterday I worked, today I rest, and tomorrow I will travel.", "Combining past, present, and future!"),
                LessonExample("Hemos terminado la lección.", "We have finished the lesson.", "Hemos + terminado")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l3_5_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the form: 'Yo ___ hablado con ella hoy.' (haber)",
                    options = listOf("he", "has", "ha", "hemos"),
                    expectedAnswers = listOf("he"),
                    hint = "Yo form of haber is 'he'.",
                    explanation = "Yo he hablado."
                ),
                QuizQuestion(
                    id = "l3_5_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with participle of comer (to eat):",
                    blankSentence = "¿Has ___ paella alguna vez?",
                    options = listOf("comido", "comiendo", "comió", "comado"),
                    expectedAnswers = listOf("comido"),
                    hint = "-ER verbs become -ido.",
                    explanation = "¿Has comido paella?"
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l3_5_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I have never visited Mexico.'",
                    expectedAnswers = listOf("Nunca he visitado México", "Nunca he visitado Mexico", "No he visitado México nunca"),
                    hint = "Nunca + he visitado + México",
                    explanation = "Nunca he visitado México."
                ),
                QuizQuestion(
                    id = "l3_5_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'We have decided to travel tomorrow.'",
                    wordsToArrange = listOf("Hemos", "decidido", "viajar", "mañana"),
                    expectedAnswers = listOf("Hemos decidido viajar mañana", "Hemos decidido viajar manana"),
                    hint = "Hemos decidido + viajar mañana",
                    explanation = "Hemos decidido viajar mañana."
                )
            ),
            reviewSummary = listOf(
                "Present Perfect = Haber + past participle (he, has, ha, hemos, han).",
                "-AR -> -ado (hablado, viajado); -ER/-IR -> -ido (comido, vivido).",
                "Now you can fluently express yesterday (trabajé), always (trabajaba), have done (he trabajado), today (trabajo), and tomorrow (voy a trabajar)!"
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l3_5_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Have you seen this movie?'",
                    expectedAnswers = listOf("¿Has visto esta película?", "Has visto esta pelicula", "¿Has visto esta película ya?"),
                    hint = "Ver has an irregular participle: visto. ¿Has visto...?",
                    explanation = "¿Has visto esta película?"
                ),
                QuizQuestion(
                    id = "l3_5_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Ellos ya ___ terminado el proyecto. (They have already finished)",
                    options = listOf("han", "ha", "hemos", "habían"),
                    expectedAnswers = listOf("han"),
                    hint = "Ellos form of haber.",
                    explanation = "Ellos han terminado."
                )
            )
        ),

        // ================= LEVEL 4: DEVELOPING A2 (NATURAL CONVERSATION) =================
        Lesson(
            id = "l4_1",
            levelId = 4,
            title = "Direct Object Pronouns: Lo, La, Los, Las",
            subtitle = "Replacing 'it' and 'them' cleanly",
            durationMinutes = 14,
            objective = "Use direct object pronouns (lo, la, los, las) to replace nouns smoothly without repeating words, placing them before the conjugated verb.",
            plainEnglishRule = "In Spanish, the object pronoun goes BEFORE the conjugated verb: 'I buy the book' = 'Compro el libro' -> 'I buy it' = 'LO compro' (literally: 'It I buy'). Match masculine/feminine and singular/plural.",
            patternFormula = "[Pronoun: lo / la / los / las] + [Conjugated Verb]",
            patternFormulaExplanation = "¿El café? Lo quiero caliente. ¿La llave? La tengo en el bolsillo.",
            examples = listOf(
                LessonExample("¿Tienes el libro? Sí, lo tengo.", "Do you have the book? Yes, I have it.", "El libro (m) -> lo"),
                LessonExample("¿Compraste la comida? Sí, la compré.", "Did you buy the food? Yes, I bought it.", "La comida (f) -> la"),
                LessonExample("No los conozco.", "I don't know them.", "Los = them (masculine/mixed)"),
                LessonExample("Voy a verla / La voy a ver mañana.", "I am going to see her tomorrow.", "With infinitive: can attach to the end or go before!")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l4_1_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Replace 'el café': 'Tomo el café todos los días.' -> '___ tomo todos los días.'",
                    options = listOf("Lo", "La", "Le", "El"),
                    expectedAnswers = listOf("Lo", "lo"),
                    hint = "El café is masculine singular, so use 'lo'.",
                    explanation = "'Lo tomo todos los días'."
                ),
                QuizQuestion(
                    id = "l4_1_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Replace 'las llaves': '¿Dónde están las llaves? No ___ encuentro.'",
                    options = listOf("las", "los", "la", "les"),
                    expectedAnswers = listOf("las"),
                    hint = "Las llaves is feminine plural.",
                    explanation = "No las encuentro (I can't find them)."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l4_1_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I need it (masculine).' (e.g. the passport)",
                    expectedAnswers = listOf("Lo necesito", "Yo lo necesito"),
                    hint = "Lo + necesito",
                    explanation = "Lo necesito."
                ),
                QuizQuestion(
                    id = "l4_1_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'I understand it (feminine, e.g. the lesson) perfectly.'",
                    wordsToArrange = listOf("La", "entiendo", "perfectamente"),
                    expectedAnswers = listOf("La entiendo perfectamente"),
                    hint = "La + entiendo + perfectamente",
                    explanation = "La entiendo perfectamente."
                )
            ),
            reviewSummary = listOf(
                "Direct Object Pronouns: me (me), te (you), lo/la (him/her/it), nos (us), los/las (them).",
                "Normal position: directly BEFORE the conjugated verb (Lo tengo).",
                "With an infinitive: attach to the end (Quiero comprarlo) OR place before (Lo quiero comprar)."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l4_1_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Do you see that house? I want to buy it.'",
                    expectedAnswers = listOf(
                        "¿Ves esa casa? Quiero comprarla",
                        "¿Ves esa casa? La quiero comprar",
                        "Ves esa casa La quiero comprar"
                    ),
                    hint = "Casa is feminine -> la. Quiero comprarla or La quiero comprar.",
                    explanation = "¿Ves esa casa? Quiero comprarla / La quiero comprar."
                ),
                QuizQuestion(
                    id = "l4_1_a2",
                    type = ExerciseType.CORRECT_SENTENCE,
                    prompt = "Fix the English word order: 'Veo lo todos los días.'",
                    expectedAnswers = listOf("Lo veo todos los días", "Lo veo todos los dias"),
                    hint = "Put 'lo' before 'veo'.",
                    explanation = "Pronoun goes before conjugated verb: Lo veo todos los días."
                )
            )
        ),

        Lesson(
            id = "l4_2",
            levelId = 4,
            title = "Indirect Objects & Gustar-like Verbs",
            subtitle = "To me, to you, pleasing, mattering & interesting",
            durationMinutes = 15,
            objective = "Master indirect object pronouns (me, te, le, nos, les) and verbs like gustar, encantar, importar, and parecer.",
            plainEnglishRule = "In Spanish, you don't say 'I like Spanish'; you say 'Spanish is pleasing TO ME' ('Me gusta el español'). If the thing you like is plural, use 'gustan': 'Me gustan las tapas'.",
            patternFormula = "[me / te / le / nos / les] + [gusta / gustan] + [Thing]",
            patternFormulaExplanation = "Me gusta la música. Me gustan los libros. Te importa esto. Nos parece bien.",
            examples = listOf(
                LessonExample("Me gusta mucho viajar.", "I like traveling a lot. (Traveling is pleasing to me)", "Me gusta + infinitive"),
                LessonExample("Me gustan estas canciones.", "I like these songs.", "Plural thing -> gustan"),
                LessonExample("¿Te interesa aprender más?", "Does learning more interest you?", "Interesar works just like gustar"),
                LessonExample("No me importa esperar.", "I don't mind waiting. (Waiting doesn't matter to me)", "Importar = to matter")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l4_2_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the correct form: 'A nosotros nos ___ las ciudades grandes.' (gustar)",
                    options = listOf("gustan", "gusta", "gustamos", "gusto"),
                    expectedAnswers = listOf("gustan"),
                    hint = "Ciudades grandes is plural, so use gustan.",
                    explanation = "Nos gustan las ciudades grandes."
                ),
                QuizQuestion(
                    id = "l4_2_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'to him/to her' pronoun:",
                    blankSentence = "A Carlos ___ encanta bailar salsa.",
                    options = listOf("le", "lo", "se", "el"),
                    expectedAnswers = listOf("le"),
                    hint = "Indirect object pronoun for él/ella is 'le'.",
                    explanation = "A Carlos le encanta bailar."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l4_2_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I love Spanish food.' (use encantar)",
                    expectedAnswers = listOf("Me encanta la comida española", "Me encanta la comida espanola"),
                    hint = "Me encanta + la comida española",
                    explanation = "Me encanta la comida española."
                ),
                QuizQuestion(
                    id = "l4_2_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'Does this seem good to you?'",
                    wordsToArrange = listOf("¿Te", "parece", "bien", "esto?"),
                    expectedAnswers = listOf("¿Te parece bien esto?", "Te parece bien esto"),
                    hint = "¿Te parece bien esto?",
                    explanation = "¿Te parece bien esto? (Parecer = to seem/appear)."
                )
            ),
            reviewSummary = listOf(
                "Indirect pronouns: me (to me), te (to you), le (to him/her), nos (to us), les (to them).",
                "Gusta (singular noun or infinitive action) vs Gustan (plural nouns).",
                "Other identical verbs: encantar (to love), importar (to matter), interesar (to interest), parecer (to seem)."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l4_2_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'We don't care about the price.' (use importar)",
                    expectedAnswers = listOf("No nos importa el precio", "A nosotros no nos importa el precio"),
                    hint = "No nos importa + el precio",
                    explanation = "No nos importa el precio."
                ),
                QuizQuestion(
                    id = "l4_2_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "A ellos les ___ los museos históricos.",
                    options = listOf("interesan", "interesa", "intereso", "interesamos"),
                    expectedAnswers = listOf("interesan"),
                    hint = "Museos is plural -> interesan.",
                    explanation = "Les interesan los museos."
                )
            )
        ),

        Lesson(
            id = "l4_3",
            levelId = 4,
            title = "Reflexive Verbs: Daily Routine & Changes",
            subtitle = "Waking up, feeling, calling oneself & routines",
            durationMinutes = 14,
            objective = "Master reflexive verbs (actions you do to yourself, or internal state changes like sentirse, levantarse, ducharse, llamarse).",
            plainEnglishRule = "Reflexive verbs show that the subject performs and receives the action. They require reflexive pronouns: me, te, se, nos, se.",
            patternFormula = "[me / te / se / nos / se] + [Conjugated Verb]",
            patternFormulaExplanation = "Me levanto (I get up); Te duchas (you shower); Se llama (he/she is called); Nos sentimos bien (we feel well).",
            examples = listOf(
                LessonExample("Me despierto a las siete de la mañana.", "I wake up at seven in the morning.", "Despertarse (e->ie)"),
                LessonExample("Me levanto y me ducho enseguida.", "I get up and shower right away.", "Levantarse & ducharse"),
                LessonExample("¿Cómo te sientes hoy?", "How are you feeling today?", "Sentirse (e->ie)"),
                LessonExample("Ellos se van a mudar a otra ciudad.", "They are going to move to another city.", "Mudarse")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l4_3_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "Choose the pronoun: 'Yo ___ acuesto tarde los viernes.' (acostarse)",
                    options = listOf("me", "te", "se", "mi"),
                    expectedAnswers = listOf("me"),
                    hint = "Yo takes 'me'.",
                    explanation = "Yo me acuesto."
                ),
                QuizQuestion(
                    id = "l4_3_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with the correct reflexive pronoun:",
                    blankSentence = "Nosotros ___ quedamos en casa hoy.",
                    options = listOf("nos", "se", "los", "les"),
                    expectedAnswers = listOf("nos"),
                    hint = "Nosotros takes 'nos'.",
                    explanation = "Nosotros nos quedamos (We stay)."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l4_3_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I feel very happy today.'",
                    expectedAnswers = listOf(
                        "Me siento muy feliz hoy",
                        "Hoy me siento muy feliz",
                        "Yo me siento muy feliz hoy"
                    ),
                    hint = "Sentirse in yo form: Me siento + muy feliz hoy.",
                    explanation = "Me siento muy feliz hoy."
                ),
                QuizQuestion(
                    id = "l4_3_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'What time do you wake up?'",
                    wordsToArrange = listOf("¿A", "qué", "hora", "te", "despiertas?"),
                    expectedAnswers = listOf("¿A qué hora te despiertas?", "A que hora te despiertas"),
                    hint = "¿A qué hora te despiertas?",
                    explanation = "¿A qué hora te despiertas?"
                )
            ),
            reviewSummary = listOf(
                "Reflexive pronouns: me, te, se, nos, se.",
                "Notice stem changes: despertarse (me despierto), acostarse (me acuesto), sentirse (me siento).",
                "Often used for emotions, body movements, and daily routines."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l4_3_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'She has to get up early tomorrow.'",
                    expectedAnswers = listOf(
                        "Ella tiene que levantarse temprano mañana",
                        "Ella se tiene que levantar temprano mañana",
                        "Tiene que levantarse temprano mañana"
                    ),
                    hint = "Tiene que levantarse or Se tiene que levantar.",
                    explanation = "Tiene que levantarse temprano mañana."
                ),
                QuizQuestion(
                    id = "l4_3_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿A qué hora ___ acuestan ustedes normalmente?",
                    options = listOf("se", "nos", "les", "os"),
                    expectedAnswers = listOf("se"),
                    hint = "Ustedes uses 'se'.",
                    explanation = "Ustedes se acuestan."
                )
            )
        ),

        Lesson(
            id = "l4_4",
            levelId = 4,
            title = "Expressing Opinions, Reasons & Nuance",
            subtitle = "Creo que, me parece, por eso & detailed explanations",
            durationMinutes = 14,
            objective = "Express thoughtful opinions, agree and disagree politely, and provide detailed explanations using phrases like 'en mi opinión', 'creo que', 'por un lado', and 'por eso'.",
            plainEnglishRule = "In conversational Spanish, sharing opinions smoothly relies on conversational framing phrases. Note: 'Creo que' (I think that) and 'Pienso que' (I believe that) take standard indicative verbs in positive statements.",
            patternFormula = "[Opinion Phrase] + que + [Clause] + porque / por eso + [Reason]",
            patternFormulaExplanation = "Creo que es una buena idea porque nos ahorra tiempo (I think it is a good idea because it saves us time).",
            examples = listOf(
                LessonExample("En mi opinión, es mejor empezar temprano.", "In my opinion, it is better to start early.", "En mi opinión..."),
                LessonExample("Creo que tienes razón.", "I think you are right.", "Tener razón = to be right"),
                LessonExample("No estoy de acuerdo con esa decisión.", "I don't agree with that decision.", "Estar de acuerdo = to agree"),
                LessonExample("Estaba cansado, por eso no fui a la fiesta.", "I was tired, that is why (therefore) I didn't go to the party.", "Por eso = that's why / therefore")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l4_4_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "How do you say 'I agree' in Spanish?",
                    options = listOf("Estoy de acuerdo", "Soy de acuerdo", "Tengo acuerdo", "Hago de acuerdo"),
                    expectedAnswers = listOf("Estoy de acuerdo"),
                    hint = "Uses the verb estar.",
                    explanation = "Estar de acuerdo = to agree."
                ),
                QuizQuestion(
                    id = "l4_4_g2",
                    type = ExerciseType.FILL_IN_BLANK,
                    prompt = "Complete with 'that is why':",
                    blankSentence = "Me encanta el arte, ___ visito muchos museos.",
                    options = listOf("por eso", "porque", "para que", "por qué"),
                    expectedAnswers = listOf("por eso"),
                    hint = "Por eso = for that reason / that is why.",
                    explanation = "Por eso visito muchos museos."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l4_4_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'I think that this restaurant is the best in the city.'",
                    expectedAnswers = listOf(
                        "Creo que este restaurante es el mejor de la ciudad",
                        "Pienso que este restaurante es el mejor de la ciudad"
                    ),
                    hint = "Creo que + este restaurante + es el mejor de la ciudad.",
                    explanation = "Creo que este restaurante es el mejor de la ciudad."
                ),
                QuizQuestion(
                    id = "l4_4_i2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'In my opinion, it is worth the effort.'",
                    wordsToArrange = listOf("En", "mi", "opinión,", "vale", "la", "pena"),
                    expectedAnswers = listOf(
                        "En mi opinión, vale la pena",
                        "En mi opinion vale la pena",
                        "En mi opinion, vale la pena"
                    ),
                    hint = "Vale la pena = it is worth the pain/effort.",
                    explanation = "En mi opinión, vale la pena."
                )
            ),
            reviewSummary = listOf(
                "Creo que / Pienso que = I think / believe that.",
                "En mi opinión = In my opinion; Me parece que = It seems to me that.",
                "Por eso = Therefore / that's why; Sin embargo = However.",
                "Tener razón = to be right: Tienes toda la razón."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l4_4_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'However, we have to consider other options.'",
                    expectedAnswers = listOf(
                        "Sin embargo, tenemos que considerar otras opciones",
                        "Sin embargo tenemos que considerar otras opciones"
                    ),
                    hint = "Sin embargo + tenemos que considerar + otras opciones.",
                    explanation = "Sin embargo, tenemos que considerar otras opciones."
                ),
                QuizQuestion(
                    id = "l4_4_a2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "¿Qué ___ tú de esta propuesta? (What do you think/opine?)",
                    options = listOf("opinas", "crees", "dices", "pareces"),
                    expectedAnswers = listOf("opinas"),
                    hint = "Opinar de = to think/opine about.",
                    explanation = "¿Qué opinas tú...?"
                )
            )
        ),

        Lesson(
            id = "l4_5",
            levelId = 4,
            title = "Conversational Fluency & Spontaneous Speech",
            subtitle = "Native fillers, idioms & speaking without translating",
            durationMinutes = 15,
            objective = "Speak Spanish spontaneously without translating every single word in your head, using natural discourse markers (pues, bueno, a ver, o sea, claro) and high-frequency idioms.",
            plainEnglishRule = "Native speakers never translate word-for-word. They use conversational bridges ('bueno', 'a ver', 'o sea', 'vale', 'claro') to give themselves thinking time and sound completely natural.",
            patternFormula = "[Conversational Marker] + [Spontaneous Response]",
            patternFormulaExplanation = "Bueno, a ver... la verdad es que prefiero salir mañana (Well, let's see... the truth is I prefer to go out tomorrow).",
            examples = listOf(
                LessonExample("A ver, ¿qué opciones tenemos?", "Let's see, what options do we have?", "A ver = Let's see / let's look"),
                LessonExample("O sea, no es fácil pero es posible.", "In other words / I mean, it's not easy but it's possible.", "O sea = I mean / in other words"),
                LessonExample("¡Claro que sí! Cuenta conmigo.", "Of course! Count on me.", "Claro que sí = of course"),
                LessonExample("La verdad es que no estoy seguro.", "To be honest / the truth is that I am not sure.", "La verdad es que...")
            ),
            guidedPractice = listOf(
                QuizQuestion(
                    id = "l4_5_g1",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "How do native Spanish speakers say 'I mean / in other words'?",
                    options = listOf("O sea", "Es decir", "Bueno", "A ver"),
                    expectedAnswers = listOf("O sea", "o sea"),
                    hint = "Two words: o sea.",
                    explanation = "'O sea' is the most ubiquitous conversational filler for 'I mean / in other words'."
                ),
                QuizQuestion(
                    id = "l4_5_g2",
                    type = ExerciseType.CHOOSE_VERB,
                    prompt = "How do you say 'Count on me'?",
                    options = listOf("Cuenta conmigo", "Cuenta con yo", "Cuenta para mí", "Cuenta me"),
                    expectedAnswers = listOf("Cuenta conmigo"),
                    hint = "Con + mí becomes 'conmigo'.",
                    explanation = "Cuenta conmigo."
                )
            ),
            independentPractice = listOf(
                QuizQuestion(
                    id = "l4_5_i1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'To be honest, I prefer to stay home.'",
                    expectedAnswers = listOf(
                        "La verdad es que prefiero quedarme en casa",
                        "La verdad, prefiero quedarme en casa",
                        "Para ser honesto, prefiero quedarme en casa"
                    ),
                    hint = "La verdad es que prefiero quedarme en casa.",
                    explanation = "La verdad es que prefiero quedarme en casa."
                ),
                QuizQuestion(
                    id = "l4_5_i2",
                    type = ExerciseType.CONVERSATION_REPLY,
                    prompt = "A friend asks: '¿Quieres venir a cenar esta noche?' (Answer enthusiastically: Of course! At what time?)",
                    expectedAnswers = listOf(
                        "¡Claro que sí! ¿A qué hora?",
                        "Claro que sí, ¿a qué hora?",
                        "Claro que si, a que hora"
                    ),
                    hint = "¡Claro que sí! ¿A qué hora?",
                    explanation = "¡Claro que sí! ¿A qué hora? is natural, spontaneous Spanish."
                )
            ),
            reviewSummary = listOf(
                "Use native discourse markers: A ver (let's see), Bueno (well), O sea (I mean), Claro (of course).",
                "Conmigo (with me), Contigo (with you).",
                "You have now mastered all four core levels of foundational Spanish! You can express yourself across the past, present, and future, convey emotions and opinions, and hold authentic everyday conversations."
            ),
            assessmentQuiz = listOf(
                QuizQuestion(
                    id = "l4_5_a1",
                    type = ExerciseType.TRANSLATE_EN_TO_ES,
                    prompt = "Translate: 'Let's see, what are we going to do now?'",
                    expectedAnswers = listOf(
                        "A ver, ¿qué vamos a hacer ahora?",
                        "A ver ¿qué vamos a hacer ahora?",
                        "A ver que vamos a hacer ahora"
                    ),
                    hint = "A ver + ¿qué vamos a hacer ahora?",
                    explanation = "A ver, ¿qué vamos a hacer ahora?"
                ),
                QuizQuestion(
                    id = "l4_5_a2",
                    type = ExerciseType.SENTENCE_BUILDER,
                    prompt = "Arrange to say: 'Of course you can count on me.'",
                    wordsToArrange = listOf("Claro", "que", "puedes", "contar", "conmigo"),
                    expectedAnswers = listOf("Claro que puedes contar conmigo"),
                    hint = "Claro que puedes contar conmigo.",
                    explanation = "Claro que puedes contar conmigo."
                )
            )
        )
    )
}
