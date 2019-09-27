package com.boostcourse.calculator.util

import com.boostcourse.calculator.*

class CalculatorImpl(private val callback: CalculatorCallback) : Calculator {
    private var firstValue = 0.0
    private var secondValue = 0.0
    private var firstIsExist = false
    private var secondIsExist = false
    private var lastOperation = NONE

    override fun reset() {
        firstValue = 0.0
        secondValue = 0.0
        firstIsExist = false
        secondIsExist = false
        lastOperation = NONE

        callback.displayValue("")
    }

    override fun setValue(value: String) {
        val input = NumberFormat.stringToDouble(value)

        if (!firstIsExist) {
            firstValue = input
            firstIsExist = true
        } else if (!secondIsExist) {
            secondValue = input
            secondIsExist = true
        }

        displayResult("")
    }

    override fun performOperation(op: String, value: String) {
        if (value.isEmpty()) {
            callback.showMsg("값을 입력해주세요.")
        } else {
            setValue(value)
            lastOperation = op

            if (firstIsExist && !secondIsExist) {
                displayResult("")
            } else if (firstIsExist && secondIsExist) {
                calculate()
            }
        }
    }

    override fun calculate() {
        when (lastOperation) {
            ADD -> firstValue = Operation.add(firstValue, secondValue)
            SUB -> firstValue = Operation.sub(firstValue, secondValue)
            MULTI -> firstValue = Operation.multi(firstValue, secondValue)
            POWER -> firstValue = Operation.power(firstValue, secondValue)
            DIVIDE -> {
                val result = Operation.divide(firstValue, secondValue)
                if (result == null) {
                    callback.showMsg("0으로 나눌 수 없습니다.")
                    firstValue
                } else {
                    firstValue = result
                }
            }
            else -> {
                callback.showMsg("계산할 수식이 없습니다.")
            }
        }

        displayResult(NumberFormat.doubleToString(firstValue))
        firstIsExist = false
        secondIsExist = false
    }

    override fun displayResult(value: String) {
        callback.displayValue(value)
    }

    fun converseSign(value: String) {
        if (value.isEmpty()) {
            callback.showMsg("값을 입력해주세요.")
        } else {
            val trans = NumberFormat.stringToDouble(value) * -1
            displayResult(NumberFormat.doubleToString(trans))
        }
    }
}
