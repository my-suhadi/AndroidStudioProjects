package id.go.dephub.itjen.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {

    val questions = arrayOf("web development", "game development", "web design", "networking", "video editing")
    lateinit var tvRightAnswer: TextView
    lateinit var tvQuestion: TextView
    lateinit var etUserAnswer: EditText
    lateinit var currentQuestion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        tvRightAnswer = findViewById(R.id.tView_rightAnswer)
        tvQuestion = findViewById(R.id.tView_question)
        etUserAnswer = findViewById(R.id.edText_user_answer)

        startQuiz()
    }

    private fun startQuiz() {
        tvRightAnswer.text = ""
        tvRightAnswer.visibility = View.INVISIBLE
        
        currentQuestion = questions[Random.nextInt(questions.size)]
        tvQuestion.text = shuffleString(currentQuestion)
    }

    fun showAnswer(v: View) {
        tvRightAnswer.visibility = View.VISIBLE
        tvRightAnswer.text = currentQuestion
        val handler = Handler()
        handler.postDelayed({
            tvRightAnswer.visibility = View.INVISIBLE
        }, 2000)
    }

    fun checkAnswer(v: View) {
        if (etUserAnswer.text.toString().equals(currentQuestion, ignoreCase = true)) {
            rightAnswer()
            Toast.makeText(this, "Good Job!",Toast.LENGTH_LONG).show()
        } else {
            wrongAnswer()
            Toast.makeText(this, "Bad Job!",Toast.LENGTH_LONG).show()
        }
    }

    fun changeQuestion(v: View) {
        startQuiz()
    }

    fun rightAnswer() {
        tvRightAnswer.visibility = View.VISIBLE
        tvRightAnswer.setBackgroundColor(Color.GREEN)
        tvRightAnswer.text = currentQuestion

        val handler = Handler()
        handler.postDelayed({
            etUserAnswer.text.clear()
            startQuiz()
        }, 3000)
    }

    fun wrongAnswer() {
        tvRightAnswer.visibility = View.VISIBLE
        tvRightAnswer.setBackgroundColor(Color.RED)
        tvRightAnswer.text = etUserAnswer.text
        etUserAnswer.text.clear()
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

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}
