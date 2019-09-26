package com.boostcourse.calculator.util

import java.text.DecimalFormat

object NumberFormat {

    fun checkValue(num: String): String =
        if (num == ".") {
            "0."
        } else {
            num
        }
}