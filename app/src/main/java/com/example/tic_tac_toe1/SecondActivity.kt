package com.example.tic_tac_toe1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.table
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    private var activePlayer = 1
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var winner = 0
    private var checked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        table.setBackgroundResource(android.R.color.white)
        bt_restart.setBackgroundResource(android.R.color.holo_green_dark)

        bt_1.setOnClickListener { game(it, 1) }
        bt_2.setOnClickListener { game(it, 2) }
        bt_3.setOnClickListener { game(it, 3) }
        bt_4.setOnClickListener { game(it, 4) }
        bt_5.setOnClickListener { game(it, 5) }
        bt_6.setOnClickListener { game(it, 6) }
        bt_7.setOnClickListener { game(it, 7) }
        bt_8.setOnClickListener { game(it, 8) }
        bt_9.setOnClickListener { game(it, 9) }

        bt_restart.setOnClickListener { recreate() }
    }

    private fun game(v: View, id: Int) {


        val selectBt = v as Button
        if (activePlayer == 1) {
            selectBt.setBackgroundResource(R.color.colorPrimary)
            selectBt.text = "X"
            player1.add(id)
            checkWinner()
            if (winner == 0) {
                activePlayer = 2
                if (activePlayer == 2 && checked != 9)
                    Toast.makeText(this, "Player 2 Turn", Toast.LENGTH_SHORT).show()
                if (checked == 9) {
                    Toast.makeText(this, "MATCH DRAWN", Toast.LENGTH_SHORT).show()
                    return
                }
                //autoPlay()
            } else {
                return
            }

        } else {
            selectBt.setBackgroundResource(R.color.colorAccent)
            selectBt.text = "O"
            player2.add(id)
            checkWinner()
            if (winner == 0) {
                activePlayer = 1
                if (activePlayer == 1 && checked != 9)
                    Toast.makeText(this, "Player 1 Turn", Toast.LENGTH_SHORT).show()
                if (checked == 9) {
                    Toast.makeText(this, "MATCH DRAWN", Toast.LENGTH_SHORT).show()
                    return
                }
            } else {
                return
            }

        }
        v.isEnabled = false
    }


    private fun checkWinner() {

        checked++

        if (winner == 0) {
            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winner = 1
            }
            if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winner = 1
            }
            if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winner = 1
            }
            if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
                winner = 1
            }
        }
        if (winner == 0) {
            if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
                winner = 2
            }
            if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
                winner = 2
            }
            if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
                winner = 2
            }

            if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
                winner = 2
            }
            if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
                winner = 2
            }
            if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
                winner = 2
            }

            if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
                winner = 2
            }
            if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
                winner = 2
            }
        }

        if (winner != 0) {
            Toast.makeText(this, "The Winner is Player $winner", Toast.LENGTH_SHORT).show()
            disableAll()
        }

    }


    private fun disableAll() {
        bt_1.isEnabled = false
        bt_2.isEnabled = false
        bt_3.isEnabled = false
        bt_4.isEnabled = false
        bt_5.isEnabled = false
        bt_6.isEnabled = false
        bt_7.isEnabled = false
        bt_8.isEnabled = false
        bt_9.isEnabled = false
    }
}