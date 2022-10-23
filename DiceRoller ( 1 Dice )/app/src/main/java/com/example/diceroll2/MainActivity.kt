package com.example.diceroll2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rollDice : Button = findViewById(R.id.button)
        // rollDice.text = "6"
        rollDice.setOnClickListener{
            var toast = Toast.makeText(this,"Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

//            var resultTextDisplay : TextView = findViewById(R.id.textView)
//            resultTextDisplay.text = "6"

            roll()
        }
        roll()
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun roll() {
        // Create new Dice object with 6 sides and roll the dice
        var myFirstDice = Dice(6)
        var resultedRolledNumber = myFirstDice.rolled()

//        var resultTextDisplay : TextView = findViewById(R.id.textView)
//        resultTextDisplay.text = resultedRolledNumber.toString()

        // Find the ImageView in the layout
        var diceImage : ImageView = findViewById(R.id.imageView)
//        diceImage.setImageResource(R.drawable.dice_2)

//        when(resultedRolledNumber) {
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3-> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }

        // Determine which drawable resource ID to use based on the dice roll
        val diceRolledResource = when(resultedRolledNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(diceRolledResource)
        // Update the content description
        diceImage.contentDescription = resultedRolledNumber.toString()

    }
}

class Dice(var numSides : Int) {
    fun rolled() : Int {
        return (1..numSides).random()
    }
}