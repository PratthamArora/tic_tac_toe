package com.example.tic_tac_toe1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("data", 1)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", 2)
            startActivity(intent)
        }
    }
}