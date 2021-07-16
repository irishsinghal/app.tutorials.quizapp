package com.tutorials.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        setQuestion()

        val btnSol = findViewById<Button>(R.id.btn_sol)

        val option1 = findViewById<TextView>(R.id.tv_op1)
        val option2 = findViewById<TextView>(R.id.tv_op2)
        val option3 = findViewById<TextView>(R.id.tv_op3)
        val option4 = findViewById<TextView>(R.id.tv_op4)


        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)

        btnSol.setOnClickListener(this)

    }

    private var qno = 0
    private var correctAns = 0
    private var selectedAns = 0
    private var marks = 0

    @SuppressLint("SetTextI18n")
    private fun setQuestion(qno:Int = 0) {

        val questionsList = Constants.getQuestions()
        val questionDisplay : Question = questionsList[qno]

        correctAns = questionDisplay.correctAnswer

        val tvQuestionNo = findViewById<TextView>(R.id.tv_QuestionNo)
        val pbProgress = findViewById<ProgressBar>(R.id.pb_progress)
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        val btnSol = findViewById<Button>(R.id.btn_sol)

        val ivImage = findViewById<ImageView>(R.id.iv_img)

        val option1 = findViewById<TextView>(R.id.tv_op1)
        val option2 = findViewById<TextView>(R.id.tv_op2)
        val option3 = findViewById<TextView>(R.id.tv_op3)
        val option4 = findViewById<TextView>(R.id.tv_op4)

        setOptToDefault()

        tvQuestionNo.text = questionDisplay.question
        option1.text = questionDisplay.option1
        option2.text = questionDisplay.option2
        option3.text = questionDisplay.option3
        option4.text = questionDisplay.option4
        btnSol.text = "Check Answer"
        pbProgress.max = 10
        pbProgress.progress = qno+1
        tvProgress.text = "${qno+1}" + " /  " + "${pbProgress.max}"
        ivImage.setImageResource(questionDisplay.image)

    }

    private fun setOptToDefault ()
    {
        val options = arrayListOf<TextView>()

        options.add(findViewById(R.id.tv_op1))
        options.add(findViewById(R.id.tv_op2))
        options.add(findViewById(R.id.tv_op3))
        options.add(findViewById(R.id.tv_op4))

        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    private fun selectOption (option:TextView) {
        setOptToDefault()
        option.setTextColor(Color.parseColor("#FFFFFF"))
        option.setBackgroundColor(Color.parseColor("#000000"))
    }

    private fun correctOption () {
        setOptToDefault()

        val options = arrayListOf<TextView>()


        options.add(findViewById(R.id.tv_op1))
        options.add(findViewById(R.id.tv_op2))
        options.add(findViewById(R.id.tv_op3))
        options.add(findViewById(R.id.tv_op4))

        when (selectedAns) {
            1 -> {
                options[0].setTextColor(Color.parseColor("#FFFFFF"))
                options[0].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            2 -> {
                options[1].setTextColor(Color.parseColor("#FFFFFF"))
                options[1].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            3 -> {
                options[2].setTextColor(Color.parseColor("#FFFFFF"))
                options[2].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            4 -> {
                options[3].setTextColor(Color.parseColor("#FFFFFF"))
                options[3].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
        }
        correctAns = 1
        marks++
    }

    private fun wrongOption () {
        setOptToDefault()

        val options = arrayListOf<TextView>()



        options.add(findViewById(R.id.tv_op1))
        options.add(findViewById(R.id.tv_op2))
        options.add(findViewById(R.id.tv_op3))
        options.add(findViewById(R.id.tv_op4))

        when (selectedAns) {
            1 -> {
                options[0].setTextColor(Color.parseColor("#FFFFFF"))
                options[0].setBackgroundColor(Color.parseColor("#EE5253"))
            }
            2 -> {
                options[1].setTextColor(Color.parseColor("#FFFFFF"))
                options[1].setBackgroundColor(Color.parseColor("#EE5253"))
            }
            3 -> {
                options[2].setTextColor(Color.parseColor("#FFFFFF"))
                options[2].setBackgroundColor(Color.parseColor("#EE5253"))
            }
            4 -> {
                options[3].setTextColor(Color.parseColor("#FFFFFF"))
                options[3].setBackgroundColor(Color.parseColor("#EE5253"))
            }
        }

        when (correctAns) {
            1 -> {
                options[0].setTextColor(Color.parseColor("#FFFFFF"))
                options[0].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            2 -> {
                options[1].setTextColor(Color.parseColor("#FFFFFF"))
                options[1].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            3 -> {
                options[2].setTextColor(Color.parseColor("#FFFFFF"))
                options[2].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
            4 -> {
                options[3].setTextColor(Color.parseColor("#FFFFFF"))
                options[3].setBackgroundColor(Color.parseColor("#0F9F89"))
            }
        }
        correctAns = 0
        selectedAns = 0
    }

    @SuppressLint("SetTextI18n")
    private fun checkAns()
    {
        setOptToDefault()


        val btnSol = findViewById<Button>(R.id.btn_sol)

        if (selectedAns == correctAns)
            correctOption()
        else
            wrongOption()
        if (qno<9)
            btnSol.text = "Next Question"
        else
            btnSol.text = "Finish Quiz"
    }

    private fun nextQuestion()
    {
        qno++
        setQuestion(qno)
    }

    override fun onClick (v: View?)
    {
        val option1 = findViewById<TextView>(R.id.tv_op1)
        val option2 = findViewById<TextView>(R.id.tv_op2)
        val option3 = findViewById<TextView>(R.id.tv_op3)
        val option4 = findViewById<TextView>(R.id.tv_op4)

        val btnSol = findViewById<Button>(R.id.btn_sol)


        when (v?.id){
            R.id.tv_op1 -> {
                selectOption(option1)
                selectedAns = 1
            }
            R.id.tv_op2 -> {
                selectOption(option2)
                selectedAns = 2
            }
            R.id.tv_op3 -> {
                selectOption(option3)
                selectedAns = 3
            }
            R.id.tv_op4 -> {
                selectOption(option4)
                selectedAns = 4
            }
            R.id.btn_sol -> {
                when(btnSol.text.toString().lowercase())
                {
                    "check answer" -> checkAns()
                    "next question" -> nextQuestion()
                    else -> {
                        val intent = Intent(this, Results::class.java)
                        startActivity(intent)
                        intent.putExtra("marks",marks)
                        finish()
                    }
                }
            }
        }
    }
    
}