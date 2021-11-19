package com.example.xoactivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var resetBt : Button
    private lateinit var firstPlayerCounter : TextView
    private lateinit var secondPlayerCounter : TextView
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var firstPlayerWinCounter = 0
    private var secondPlayerWinCounter = 0
    private lateinit var  buttonNewGame : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button1= findViewById(R.id.Bt1)
        button2= findViewById(R.id.Bt2)
        button3= findViewById(R.id.Bt3)
        button4= findViewById(R.id.Bt4)
        button5= findViewById(R.id.Bt5)
        button6= findViewById(R.id.Bt6)
        button7= findViewById(R.id.Bt7)
        button8= findViewById(R.id.Bt8)
        button9= findViewById(R.id.Bt9)
        resetBt = findViewById(R.id.btReset)
        buttonNewGame = findViewById(R.id.btNG)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resetBt.setOnClickListener(this)
        buttonNewGame.setOnClickListener(this)
        firstPlayerCounter = findViewById(R.id.tV1)
        secondPlayerCounter = findViewById(R.id.tV2)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is View){
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.Bt1 -> buttonNumber = 1
                R.id.Bt2 -> buttonNumber = 2
                R.id.Bt3 -> buttonNumber = 3
                R.id.Bt4 -> buttonNumber = 4
                R.id.Bt5 -> buttonNumber = 5
                R.id.Bt6 -> buttonNumber = 6
                R.id.Bt7 -> buttonNumber = 7
                R.id.Bt8 -> buttonNumber = 8
                R.id.Bt9 -> buttonNumber = 9
                R.id.btReset -> buttonNumber = 0
                R.id.btNG -> buttonNumber = 10
            }
            if (buttonNumber!=0 && buttonNumber!= 10){
                playGame(clickedView as Button, buttonNumber)
            }else if(buttonNumber == 0) {
                resetGame()
            }else {
                newGame()
            }
        }
    }

    private fun newGame() {
        if (activePlayer == 1 || activePlayer == 2) {
            firstPlayer.clear()
            secondPlayer.clear()
            button1.setBackgroundColor(Color.WHITE)
            button2.setBackgroundColor(Color.WHITE)
            button3.setBackgroundColor(Color.WHITE)
            button4.setBackgroundColor(Color.WHITE)
            button5.setBackgroundColor(Color.WHITE)
            button6.setBackgroundColor(Color.WHITE)
            button7.setBackgroundColor(Color.WHITE)
            button8.setBackgroundColor(Color.WHITE)
            button9.setBackgroundColor(Color.WHITE)
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            activePlayer = 1
            firstPlayerWinCounter = 0
            secondPlayerWinCounter = 0
            firstPlayerCounter.text = firstPlayerWinCounter.toString()
            secondPlayerCounter.text = secondPlayerWinCounter.toString()
        }
    }

    private fun resetGame() {
        if (activePlayer == 1 || activePlayer == 2) {
            firstPlayer.clear()
            secondPlayer.clear()
            button1.setBackgroundColor(Color.WHITE)
            button2.setBackgroundColor(Color.WHITE)
            button3.setBackgroundColor(Color.WHITE)
            button4.setBackgroundColor(Color.WHITE)
            button5.setBackgroundColor(Color.WHITE)
            button6.setBackgroundColor(Color.WHITE)
            button7.setBackgroundColor(Color.WHITE)
            button8.setBackgroundColor(Color.WHITE)
            button9.setBackgroundColor(Color.WHITE)
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            activePlayer = 1
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer==1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }else {
            secondPlayer.add(buttonNumber)
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            activePlayer=1
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check(){
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (!button1.isEnabled && !button2.isEnabled && !button3.isEnabled && !button4.isEnabled && !button5.isEnabled && !button6.isEnabled && !button7.isEnabled && !button8.isEnabled && !button9.isEnabled && winnerPlayer == 0){
            winnerPlayer = 3
        }
        if (winnerPlayer == 1){
            Toast.makeText(this , "first player won" , Toast.LENGTH_LONG).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        else if (winnerPlayer == 2){
            Toast.makeText(this , "second player won" , Toast.LENGTH_LONG).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        when (winnerPlayer){
            1-> {firstPlayerWinCounter += 1
                firstPlayerCounter.text = firstPlayerWinCounter.toString()
            }
            2->{secondPlayerWinCounter += 1
                secondPlayerCounter.text = secondPlayerWinCounter.toString()
            }
            3-> Toast.makeText(this , "its Tie" , Toast.LENGTH_LONG).show()
        }
    }
}