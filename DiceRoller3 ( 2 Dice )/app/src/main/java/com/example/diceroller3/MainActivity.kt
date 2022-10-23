package com.example.diceroller3

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
        var rollbutton : Button = findViewById(R.id.button)
        rollbutton.setOnClickListener {
            var toast = Toast.makeText(this , "Rolled Dice", Toast.LENGTH_SHORT)
            toast.show()
            rollit()
        }
        rollit()
    }

    private fun rollit() {
        var myFirstDice = Dice(6)
        var mySecondDice = Dice(6)
        var result = myFirstDice.roll()
        var result2 = mySecondDice.roll()

        var imageField : ImageView = findViewById(R.id.imageView)
        var imageField2 : ImageView = findViewById(R.id.imageView2)
        var resultImage = when(result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        var resultImage2 = when(result2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageField.setImageResource(resultImage)
        imageField2.setImageResource(resultImage2)
        imageField.contentDescription = result.toString()
        imageField2.contentDescription = result2.toString()
    }
}

class Dice (var numSides : Int) {
    fun roll() : Int {
        return (1..numSides).random()
    }
}