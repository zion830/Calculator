package com.boostcourse.calculator.util

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
}