package com.example.diceroll2

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generateNumber() {
        var diceInst = Dice(6)
        var res = diceInst.rolled()
        assertTrue("The Resulted Rolled Number Is Greater Than Specified Range",res in 1..6)
    }
}