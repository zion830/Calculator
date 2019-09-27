package com.boostcourse.calculator.util

object NumberFormat {
    fun stringToDouble(num: String) =
        if (num.indexOf(".") == num.length - 1) {
            num.substring(0, num.length - 1).toDouble()
        } else {
            num.toDouble()
        }

    fun doubleToString(num: Double): String {
        val value = num.toString()
        return if (value.indexOf(".0") == value.length - 2) {
            value.substring(0, value.length - 2)
        } else {
            value
        }
    }

    fun checkValue(num: String): String =
        if (num == ".") {
            "0."
        } else if (num.length > 1 && num[0] == '0' && num[1] != '.') {
            num.substring(1)
        } else {
            num
        }

    fun checkPoint(num: String) = num.length - num.replace(".", "").length > 1

    fun checkLength(num: String) = num.replace(".", "").length > 15
}