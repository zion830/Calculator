package com.boostcourse.calculator.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.boostcourse.calculator.R
import com.boostcourse.calculator.util.Calculator
import com.boostcourse.calculator.util.NumberFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var currentValue = ""
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        tv_main_input.movementMethod = ScrollingMovementMethod()

        for (btn in getNumberBtns()) {
            btn.setOnClickListener {
                addInputValue(btn.text.toString())
            }
        }

        btn_plus_minus.setOnClickListener {

        }

        btn_power.setOnClickListener {
        }

        btn_clear.setOnClickListener {
            clearValue()
            calculator.reset()
        }

        btn_back.setOnClickListener {
            backspaceValue()
        }

        btn_back.setOnLongClickListener {
            clearValue()
            true
        }

        btn_add.setOnClickListener {
            tv_main_input.text = calculator.add(currentValue)
            currentValue = ""
        }

        btn_sub.setOnClickListener {

        }

        btn_multi.setOnClickListener {

        }

        btn_divide.setOnClickListener {

        }

        btn_point.setOnClickListener {
            addInputValue(".")
        }

        btn_result.setOnClickListener {
            tv_main_input.text = calculator.displayResult(currentValue)
            currentValue = ""
        }
    }

    private fun addInputValue(letter: String) {
        currentValue = NumberFormat.checkValue(currentValue + letter)
        tv_main_input.text = currentValue
    }

    private fun backspaceValue() {
        if (currentValue.isNotBlank()) {
            currentValue = currentValue.substring(0, currentValue.length - 1)
        }

        tv_main_input.text = currentValue
    }

    private fun clearValue() {
        tv_main_input.text = calculator.add(currentValue)
        currentValue = ""
    }

    private fun getNumberBtns() = arrayOf(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9)
}
