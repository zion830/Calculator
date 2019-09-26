package com.boostcourse.calculator.util

import com.boostcourse.calculator.ADD
import com.boostcourse.calculator.NONE

class Calculator {
    var firstValue: Double = 0.0
    var secondValue: Double = 0.0
    var displayedNumber = ""
    var lastOperation: String = NONE
    var duplicateClick = false

    fun reset() {
        firstValue = 0.0
        secondValue = 0.0
        displayedNumber = ""
        lastOperation = NONE
    }

    fun add(input: String): String {
        var value = input
        /*if (input[input.length - 1] == '.') {
            value = input.substring(0, input.length - 1)
        }*/

        if (lastOperation == NONE) {
            lastOperation = ADD
            firstValue = value.toDouble()
            return ""
        } else {
            lastOperation = NONE
            secondValue = value.toDouble()
            return Operation.add(firstValue, secondValue).toString()
        }
    }

    fun displayResult(input: String): String =
        when (lastOperation) {
            ADD -> add(input)
            else -> input
        }

    fun isDouble(input: String): Boolean {
        val pointerIndex = input.indexOf(".")
        return pointerIndex in 0 until input.length
    }
}
