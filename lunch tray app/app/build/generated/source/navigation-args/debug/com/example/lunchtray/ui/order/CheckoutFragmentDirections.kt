package com.example.lunchtray.ui.order

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.lunchtray.R

public class CheckoutFragmentDirections private constructor() {
  public companion object {
    public fun actionCheckoutFragmentToStartOrderFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_checkoutFragment_to_startOrderFragment2)
  }
}
