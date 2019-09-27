package com.boostcourse.calculator.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.boostcourse.calculator.*
import com.boostcourse.calculator.util.CalculatorCallback
import com.boostcourse.calculator.util.CalculatorImpl
import com.boostcourse.calculator.util.NumberFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculatorCallback {
    private lateinit var calculator: CalculatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = CalculatorImpl(this)
        initView()
    }

    private fun initView() {

        getNumberBtns().forEach {
            it.setOnClickListener { _ -> addInputValue(it.text.toString()) }
        }

        btn_plus_minus.setOnClickListener {
            val input = tv_main_input.text.toString()

            if (input.isEmpty()) {
                showMsg("값을 입력해주세요.")
            } else {
                val trans = NumberFormat.stringToDouble(input) * -1
                displayValue(NumberFormat.doubleToString(trans))
            }
        }

        btn_clear.setOnClickListener {
            calculator.reset()
        }

        btn_back.setOnClickListener {
            backspaceValue()
        }

        btn_back.setOnLongClickListener {
            displayValue("")
            true
        }

        btn_add.setOnClickListener {
            calculator.performOperation(ADD, tv_main_input.text.toString())
        }

        btn_sub.setOnClickListener {
            calculator.performOperation(SUB, tv_main_input.text.toString())
        }

        btn_multi.setOnClickListener {
            calculator.performOperation(MULTI, tv_main_input.text.toString())
        }

        btn_divide.setOnClickListener {
            calculator.performOperation(DIVIDE, tv_main_input.text.toString())
        }

        btn_power.setOnClickListener {
            calculator.performOperation(POWER, tv_main_input.text.toString())
        }

        btn_point.setOnClickListener {
            addInputValue(".")
        }

        btn_result.setOnClickListener {
            if (tv_main_input.text.isEmpty()) {
                showMsg("값을 입력해주세요.")
            } else {
                calculator.setValue(tv_main_input.text.toString())
                calculator.calculate()
            }
        }
    }

    private fun addInputValue(letter: String) {
        val current = tv_main_input.text.toString() + letter

        if (NumberFormat.checkPoint(current)) {
            showMsg("이미 . 연산자를 사용했습니다")
        } else if (NumberFormat.checkLength(current)) {
            showMsg("15자리까지 입력할 수 있습니다.")
        } else {
            displayValue(NumberFormat.checkValue(current))
        }
    }

    private fun backspaceValue() {
        val currentValue = tv_main_input.text

        if (currentValue.isNotBlank()) {
            tv_main_input.text = currentValue.substring(0, currentValue.length - 1)
        }
    }

    private fun getNumberBtns() = arrayOf(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9)

    override fun displayValue(result: String) {
        tv_main_input.text = result
    }

    override fun showMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
