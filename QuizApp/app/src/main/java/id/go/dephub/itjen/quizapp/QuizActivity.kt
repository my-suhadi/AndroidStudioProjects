package id.go.dephub.itjen.quizapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {

    val questions = arrayOf("web development", "game development", "web design", "networking", "video editing")
    lateinit var rightAnswer: TextView
    lateinit var question: TextView
    lateinit var userAnswer: EditText
    lateinit var randomNumber: Random
    lateinit var currentQuestion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        rightAnswer = findViewById(R.id.tView_rightAnswer)
        question = findViewById(R.id.tView_question)
        userAnswer = findViewById(R.id.edText_user_answer)

        startQuiz()
    }

    private fun startQuiz() {
        currentQuestion = questions[Random.nextInt(questions.size)]
        question.text = shuffleString(currentQuestion)
    }

    fun showAnswer(v: View) {

    }

    fun checkAnswer(v: View) {

    }

    fun changeQuestion(v: View) {

    }

    fun rightAnswer() {

    }

    fun wrongAnswer() {

    }

    fun shuffleString(word: String): String {
        val characters: CharArray = word.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }
}
