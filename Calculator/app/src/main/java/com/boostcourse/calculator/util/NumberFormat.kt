package com.boostcourse.calculator.util

import java.text.DecimalFormat

object NumberFormat {
    private val insertCommaFormat = DecimalFormat("#,###")

    // 세자리 단위로 끊어 콤마 삽입
    fun insertComma(num: String): String =
        if (num.contains(".")) { // 소수일 경우
            val rest = num.substringAfter(".")
            "${insertCommaFormat.format(num.toDouble())}.$rest"
        } else {
            insertCommaFormat.format(num.toLong())
        }
}