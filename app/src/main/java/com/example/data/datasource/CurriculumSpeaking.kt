package com.example.data.datasource

import com.example.data.model.SpeakingScenario

object CurriculumSpeaking {

    val allScenarios: List<SpeakingScenario> = listOf(
        SpeakingScenario(
            id = "spk_1",
            levelId = 1,
            title = "Introducing Yourself & Meeting Friends",
            description = "Practice meeting a Spanish speaker at a social gathering. Introduce your name, where you are from, and what you do.",
            tutorRole = "Mateo, a friendly local in Madrid who just joined your table",
            studentGoal = "Say your name, where you are from, and ask Mateo how he is doing.",
            initialTutorGreeting = "¡Hola! Mucho gusto, me llamo Mateo. ¿Cómo te llamas tú y de dónde eres?",
            initialTutorTranslation = "Hello! Nice to meet you, my name is Mateo. What is your name and where are you from?",
            samplePhrases = listOf(
                "Hola Mateo, me llamo...",
                "Soy de Estados Unidos / Inglaterra...",
                "Mucho gusto en conocerte.",
                "¿Cómo estás hoy?"
            )
        ),
        SpeakingScenario(
            id = "spk_2",
            levelId = 1,
            title = "Ordering Tapas & Drinks at a Bar",
            description = "You are sitting at a bustling tapas bar in Seville. Order food, drink, and ask for the bill.",
            tutorRole = "Camarero (Waiter) at Bar El Rincón",
            studentGoal = "Order a drink, two tapas, and ask how much it is or request the bill.",
            initialTutorGreeting = "¡Buenas tardes! Bienvenidos. ¿Qué les pongo para beber y comer?",
            initialTutorTranslation = "Good afternoon! Welcome. What can I get you to drink and eat?",
            samplePhrases = listOf(
                "Para mí, una cerveza / agua con gas, por favor.",
                "Quiero pedir tortilla de patatas y jamón.",
                "¿Qué me recomienda?",
                "La cuenta, por favor."
            )
        ),
        SpeakingScenario(
            id = "spk_3",
            levelId = 2,
            title = "Shopping at an Outdoor Market",
            description = "Ask for prices, quantities, and quality of fresh fruits and vegetables at a local Spanish market.",
            tutorRole = "Doña Carmen, the vendor at the fruit stall",
            studentGoal = "Ask for one kilo of apples, ask the price, and say whether you want anything else.",
            initialTutorGreeting = "¡Hola corazón! Mira qué fruta más fresca tengo hoy. ¿Qué te pongo?",
            initialTutorTranslation = "Hello sweetheart! Look what fresh fruit I have today. What can I get you?",
            samplePhrases = listOf(
                "Quisiera un kilo de manzanas, por favor.",
                "¿A cuánto están los tomates hoy?",
                "¿Están dulces las naranjas?",
                "Nada más, muchas gracias."
            )
        ),
        SpeakingScenario(
            id = "spk_4",
            levelId = 2,
            title = "Asking for Directions in the Historic Center",
            description = "You are lost in Granada. Stop a pedestrian to ask how to reach the Cathedral or nearest bank.",
            tutorRole = "Lucía, a helpful local resident walking down the street",
            studentGoal = "Politely excuse yourself, ask where the Cathedral is, and whether it is far or close.",
            initialTutorGreeting = "Hola, ¿te puedo ayudar en algo? Pareces un poco desorientado.",
            initialTutorTranslation = "Hello, can I help you with something? You seem a little disoriented.",
            samplePhrases = listOf(
                "Disculpe, ¿dónde está la Catedral?",
                "¿Está lejos de aquí o puedo ir a pie?",
                "¿Tengo que girar a la derecha o a la izquierda?",
                "Muchas gracias por su ayuda."
            )
        ),
        SpeakingScenario(
            id = "spk_5",
            levelId = 3,
            title = "Talking About Work & Daily Routine",
            description = "Discuss your profession, what your typical workday looks like, and what time you start and finish.",
            tutorRole = "Alejandro, a coworker chatting over coffee during break",
            studentGoal = "Explain what you do, what hours you work, and what you usually do after work.",
            initialTutorGreeting = "¿Qué tal el trabajo hoy? Yo he tenido muchas reuniones. ¿A qué hora sueles terminar tú?",
            initialTutorTranslation = "How is work today? I have had many meetings. What time do you usually finish?",
            samplePhrases = listOf(
                "Trabajo como ingeniero / diseñador...",
                "Normalmente empiezo a las nueve de la mañana.",
                "Después del trabajo me gusta hacer deporte.",
                "Hoy tengo bastante trabajo acumulado."
            )
        ),
        SpeakingScenario(
            id = "spk_6",
            levelId = 3,
            title = "Discussing Yesterday & Past Weekend",
            description = "Tell your tutor about what you did yesterday or last weekend using the preterite and imperfect.",
            tutorRole = "Sofía, your Spanish language exchange partner",
            studentGoal = "Describe at least two activities you did last weekend and how the weather was.",
            initialTutorGreeting = "¡Hola! Cuéntame, ¿qué tal tu fin de semana? ¿Hiciste algo divertido?",
            initialTutorTranslation = "Hello! Tell me, how was your weekend? Did you do anything fun?",
            samplePhrases = listOf(
                "El sábado fui al cine con unos amigos.",
                "El domingo descansé porque estaba muy cansado.",
                "Hacía muy buen tiempo, así que salí a pasear.",
                "Comí en un restaurante nuevo que me encantó."
            )
        ),
        SpeakingScenario(
            id = "spk_7",
            levelId = 4,
            title = "Making Plans with a Friend for Tomorrow",
            description = "Propose an activity, suggest meeting times and locations, and negotiate preferences with a friend.",
            tutorRole = "Javier, your close Spanish friend who wants to hang out",
            studentGoal = "Suggest an activity (dinner, concert, hike), ask when Javier is free, and confirm the plan.",
            initialTutorGreeting = "¡Oye! Mañana no tengo planes por la tarde. ¿Te apetece hacer algo juntos?",
            initialTutorTranslation = "Hey! Tomorrow I don't have plans in the afternoon. Do you fancy doing something together?",
            samplePhrases = listOf(
                "Podríamos ir a tomar un café o ver una exposición.",
                "¿A qué hora te viene bien?",
                "Prefiero quedar sobre las siete de la tarde.",
                "¡Perfecto! Nos vemos mañana allí."
            )
        ),
        SpeakingScenario(
            id = "spk_8",
            levelId = 4,
            title = "Debating Preferences & Expressing Opinions",
            description = "Discuss living in a big city versus the countryside, explaining pros and cons naturally.",
            tutorRole = "Elena, a thoughtful friend discussing future living plans",
            studentGoal = "State whether you prefer city or country life and give two distinct reasons using opinion phrases.",
            initialTutorGreeting = "Estaba pensando en mudarme a un pueblo tranquilo. En la ciudad hay demasiado ruido y estrés. ¿Tú qué opinas?",
            initialTutorTranslation = "I was thinking of moving to a quiet village. In the city there is too much noise and stress. What do you think?",
            samplePhrases = listOf(
                "En mi opinión, la ciudad ofrece más oportunidades culturales.",
                "Creo que vivir en el campo es más relajante, pero...",
                "Por un lado tienes tranquilidad, pero por otro lado faltan servicios.",
                "Estoy de acuerdo contigo en que el estrés es alto."
            )
        )
    )
}
