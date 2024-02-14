package com.example.yesitlabq1

object IconPicker {
    val btn1: Int = R.drawable.btn_1
    val btn2: Int = R.drawable.btn_2
    val btn3: Int = R.drawable.btn_3
    val btn4: Int = R.drawable.btn_4
    val btn5: Int = R.drawable.btn_5
    val btn6: Int = R.drawable.btn_6
    val btn7: Int = R.drawable.btn_7
    val btn8: Int = R.drawable.btn_8
    val btn9: Int=   R.drawable.btn_9

    fun getIcon(iconNumber: Int): Int {
        return when (iconNumber) {
            1 -> btn1
            2 -> btn2
            3 -> btn3
            4 -> btn4
            5 -> btn5
            6 -> btn6
            7 -> btn7
            8 -> btn8
            9-> btn9
            else -> btn1 // Default to btn1 if an invalid number is passed
        }
    }
}
