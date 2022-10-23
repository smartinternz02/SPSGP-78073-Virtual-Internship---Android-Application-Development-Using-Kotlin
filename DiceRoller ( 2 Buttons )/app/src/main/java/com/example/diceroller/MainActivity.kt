package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rollButton: Button = findViewById(R.id.button)
        var rollButton2 : Button =findViewById(R.id.button2)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            // ----- Adopt Good Code Practices --------
//            var resultTextView : TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            roll()
        }

        rollButton2.setOnClickListener {
            var toast2 = Toast.makeText(this , "Dice Rolled 2!" , Toast.LENGTH_SHORT)
            toast2.show()
            var resultDiceRoll2 : TextView = findViewById(R.id.textView2)
            resultDiceRoll2.text = "6"
            roll2()
        }


    }

    private fun roll2() {
        var mySecondDice = Dice2(6)
        var resultOfRoll2 = mySecondDice.Diceroll()

        var resultTextView : TextView = findViewById(R.id.textView2)
        resultTextView.text = resultOfRoll2.toString()
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun roll() {
        // Create new Dice object with 6 sides and roll it
        var myFirstDice = Dice(8)
        var diceRolled = myFirstDice.diceRoll()

        // Update the screen with the dice roll
        var resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRolled.toString()
    }

}

class Dice(var diceSides: Int) {
    fun diceRoll(): Int {
        return (1..diceSides).random()
    }
}

class Dice2(var numsSide : Int) {
    fun Diceroll() : Int {
        return (1..numsSide).random()
    }
}