package com.example.quiz

object QuestionRepository {

    val questions = listOf(

        Question(
            "Jakie urządzenie służy do rejestracji aktywności elektrycznej serca?",
            listOf("EEG", "EMG", "EKG", "USG"),
            2,
            "Biosygnały"
        ),

        Question(
            "Jak nazywa się sygnał elektryczny mózgu?",
            listOf("EKG", "EEG", "EMG", "RTG"),
            1,
            "Biosygnały"
        ),

        Question(
            "Co oznacza skrót EMG?",
            answers=listOf("Badanie wzroku", "Pomiar temperatury", "Analizę składu krwi", "Rejestrację pracy mięśni"),
            correctAnswer = 3,
            "Biosygnały"
        ),

        Question(
            "Co jest najważniejszą cechą biomateriału używanego w implantach?",
            answers=listOf("Toksyczność", "Wysoka masa", "Biokompatybilność", "Przewodnictwo elektryczne"),
            correctAnswer = 2,
            "Biomateriały"
        ),

        Question(
            "Jaką jednostkę mierzy pulsoksymetr?",
            answers=listOf("Saturację krwi", "Poziom cukru", "Ciśnienie tętnicze", "Temperaturę"),
            correctAnswer = 0,
            "Aparatura medyczna",
            R.drawable.pulsoksymetr
        ),

        Question(
            "Jaki materiał często stosuje się do produkcji implantów?",
            answers=listOf("Miedź", "Tytan", "Drewno", "Polimer syntetyczny"),
            correctAnswer = 1,
            "Biomateriały"
        ),

        Question(
            "Jaki sygnał rejestrowany jest podczas badania EEG?",
            answers=listOf("Aktywność serca", "Aktywność mięśni", "Aktywność mózgu", "Ciśnienie krwi"),
            correctAnswer = 2,
            "Biosygnały"
        ),

        Question(
            "Która komora serca ma najgrubszą ścianę mięśniową?",
            answers=listOf("Prawa komora", "Lewa komora", "Prawy przedsionek", "Lewy przedsionek"),
            correctAnswer = 1,
            "Anatomia i fizjologia",
        ),

        Question(
            "Gdzie zachodzi główne i ostateczne trawienie oraz wchłanianie składników odżywczych w układzie pokarmowym?",
            answers=listOf("W żołądku", "W jelicie cienkim", "W jelicie grubym", "W jamie ustnej"),
            correctAnswer = 1,
            "Anatomia i fizjologia",
        ),

        Question(
            "Jaki hormon odpowiedzialny jest za obniżanie poziomu glukozy we krwi?",
            answers=listOf("Adrenalina", "Glukagon", "Kortyzol", "Insulina"),
            correctAnswer = 3,
            "Anatomia i fizjologia",
        ),

        Question(
            "Który element neuronu odpowiada za przewodzenie impulsów nerwowych od ciała komórki do innych komórek?",
            answers=listOf("Synapsa", "Osłonka mielinowa", "Dendryt", "Akson (neuryt)"),
            correctAnswer = 3,
            "Anatomia i fizjologia",
        ),

        Question(
            "Jak nazywa się podstawowa jednostka strukturalna i funkcjonalna nerki, odpowiedzialna za filtrowanie krwi?",
            answers=listOf("Nefron", "Neuron", "Hepatocyt", "Pęcherzyk płucny"),
            correctAnswer = 0,
            "Anatomia i fizjologia",
        ),

        Question(
            "Który z poniższych procesów zachodzi podczas wdechu w warunkach spoczynkowych?",
            answers=listOf("Przepona kurczy się i obniża, a mięśnie międzyżebrowe zewnętrzne się kurczą",
                "Przepona rozluźnia się i unosi, zmniejszając objętość klatki piersiowej",
                "Ciśnienie w pęcherzykach płucnych staje się wyższe niż ciśnienie atmosferyczne",
                "Mięśnie brzucha kurczą się gwałtownie, wypychając powietrze z płuc"),
            correctAnswer = 0,
            "Anatomia i fizjologia",
        ),

        Question(
            "Które naczynia krwionośne jako jedyne posiadają zastawki zapobiegające cofaniu się krwi pod wpływem grawitacji?",
            answers=listOf("Wszystkie tętnice i żyły", "Aorta", "Żyły oraz naczynia limfatyczne", "Kapilary (naczynia włosowate)"),
            correctAnswer = 2,
            "Anatomia i fizjologia",
        ),

        Question(
            "Jaka jest główna rola żółci produkowanej przez wątrobę w procesie trawienia?",
            answers=listOf("Rozkład białek", "Emulgacja tłuszczów", "Trawienie", "Aktywacja enzymów żołądkowych"),
            correctAnswer = 1,
            "Anatomia i fizjologia",
        ),

        Question(
            "Gdzie w oku znajdują się fotoreceptory (czopki i pręciki) odpowiedzialne za odbiór bodźców wzrokowych?",
            answers=listOf("W rogówce", "W twardówce", "W tęczówce", "W siatkówce"),
            correctAnswer = 3,
            "Anatomia i fizjologia",
        ),

        Question(
            "Która część mózgowia odpowiada za utrzymanie równowagi, postawy ciała oraz precyzyjną koordynację ruchów?",
            answers=listOf("Rdzień przedłużony", "Podwzgórze", "Móżdżek", "Kora czuciowa"),
            correctAnswer = 2,
            "Anatomia i fizjologia",
        ),

        Question(
            "Który organ odpowiada za pompowanie krwi w organizmie człowieka?",
            listOf("Płuco", "Wątroba", "Serce", "Nerka"),
            2,
            "Anatomia i fizjologia"
        ),

        Question(
            "Ile komór ma serce?",
            listOf("2", "3", "4", "5"),
            0,
            "Anatomia i fizjologia"
        ),

        Question(
            "Który organ odpowiada za filtrowanie krwi i produkcję moczu?",
            answers=listOf("Wątroba", "Nerka", "Serce", "Trzustka"),
            correctAnswer = 1,
            "Anatomia i fizjologia"
        ),

        Question(
            "Jaki układ odpowiada za transport tlenu w organizmie?",
            answers=listOf("Układ kostny", "Układ pokarmowy", "Układ oddechowy", "Układ krwionośny"),
            correctAnswer = 3,
            "Anatomia i fizjologia"
        ),

        Question(
            "Co jest głównym celem inżynierii tkankowej?",
            answers=listOf("Leczenie chorób wirusowych", "Odtwarzanie tkanek", "Tworzenie nowych narządów", "Badanie struktury DNA"),
            correctAnswer = 1,
            "Anatomia i fizjologia"
        ),

        Question(
            "Co przedstawia rysunek?",
            answers=listOf("Aparat Golgiego", "Tkankę mięśniową", "Neuron", "Dendryty"),
            correctAnswer = 2,
            "Anatomia i fizjologia",
            imageResId = R.drawable.neuron
        ),


















    )
}