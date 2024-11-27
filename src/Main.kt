enum class Diffuculty{
    EASY, MEDIUM, HARD
}

data class Test<T> (val questionText: String,
                    val answer: T,
                    val difficulty: Diffuculty)

interface ProgressPintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPintable {
    val question1 = Test<String>("Quoth the raven ___", "nevermore", difficulty = Diffuculty.EASY)
    val question2 = Test<Boolean>("The sky is green. True or false", false, difficulty = Diffuculty.HARD)
    val question3 = Test<Int>("How many days are there between full moons?", 28, difficulty = Diffuculty.MEDIUM)


    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.difficulty)
            println(it.answer)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.difficulty)
            println(it.answer)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.difficulty)
            println(it.answer)
        }
        println()
    }
}


fun main() {
    Quiz().apply{
        printQuiz()
    }
}