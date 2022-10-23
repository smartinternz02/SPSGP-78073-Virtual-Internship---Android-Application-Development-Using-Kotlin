package com.example.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    // This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods in MainActivity class.
    // The lateinit keyword is something new. It's a promise that your code will initialize the variable before using it.
    // If you don't, your app will crash.

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This line initializes the binding object which you'll use to access Views in the activity_main.xml layout.

        binding= ActivityMainBinding.inflate(layoutInflater)

//      Set the content view of the activity.
//      Instead of passing the resource ID of the layout, R.layout.activity_main,
//      this specifies the root of the hierarchy of views in your app, binding.root.

        setContentView(binding.root)

        // Now when you need a reference to a View in your app, you can get it from the binding object instead of calling findViewById().
    // The binding object automatically defines references for every View in your app that has an ID.
    // Using view binding is so much more concise that often you won't even need to create a variable to hold the reference for a View, just use it directly from the binding object.

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
// keyboard enter key detect -> hide keyboard
        binding.costOfServiceEditText.setOnKeyListener {
                view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }

    }

    fun calculateTip() {

        //Notice the .text on the end. The first part, binding.costOfService, references the UI element for the cost of service.
        // Adding .text on the end says to take that result (an EditText object), and get the text property from it.
        // This is known as chaining, and is a very common pattern in Kotlin.

        val stringInTextField = binding.costOfServiceEditText.text.toString()

        // That doesn't work, though—toDouble() needs to be called on a String.
        // It turns out that the text attribute of an EditText is an Editable, because it represents text that can be changed.
        // Fortunately, you can convert an Editable to a String by calling toString() on it.

        val cost = stringInTextField.toDouble()

        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        var formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount,formattedTip)
    }


    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}

