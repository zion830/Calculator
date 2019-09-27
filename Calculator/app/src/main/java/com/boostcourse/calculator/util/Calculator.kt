package com.boostcourse.calculator.util

interface Calculator {

    fun reset()

    fun setValue(value: String)

    fun performOperation(op: String, value: String)

    fun displayResult(value: String)

    fun calculate()
}