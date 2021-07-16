package com.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Results : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val btnReplay = findViewById<Button>(R.id.btn_replay)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        btnReplay.setOnClickListener(this)
        btnExit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        val btnReplay = findViewById<Button>(R.id.btn_replay)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        when(v?:this)
        {
            btnReplay -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnExit -> {
                finish()
            }
        }
    }
}