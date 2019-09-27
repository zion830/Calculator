package com.boostcourse.calculator.util

import java.lang.Math.pow

object Operation {

    fun add(baseValue: Double, secondValue: Double) = baseValue + secondValue

    fun sub(baseValue: Double, secondValue: Double) = baseValue - secondValue

    fun multi(baseValue: Double, secondValue: Double) = baseValue * secondValue

    fun divide(baseValue: Double, secondValue: Double): Double? =
        if (secondValue != 0.0) {
            baseValue / secondValue
        } else {
            null
        }

    fun power(baseValue: Double, secondValue: Double) = pow(baseValue, secondValue)
}