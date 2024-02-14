package com.example.yesitlabq1

object ColorPicker {
    val color1: Int = android.graphics.Color.parseColor("#FF5733") // Bright Orange
    val color2: Int = android.graphics.Color.parseColor("#33FF57") // Bright Green
    val color3: Int = android.graphics.Color.parseColor("#5733FF") // Bright Purple
    val color4: Int = android.graphics.Color.parseColor("#FFFF00") // Bright Yellow
    val color5: Int = android.graphics.Color.parseColor("#FF69B4") // Bright Pink
    val color6: Int = android.graphics.Color.parseColor("#00FF00") // Bright Lime
    val color7: Int = android.graphics.Color.parseColor("#00FFFF") // Bright Cyan
    val color8: Int = android.graphics.Color.parseColor("#FF1493") // Bright Deep Pink
    val color9: Int = android.graphics.Color.parseColor("#547EEB") // Bright Deep Pink
    // Add more bright colors as needed

    fun getColor(colorNumber: Int): Int {
        return when (colorNumber) {
            1 -> color1
            2 -> color2
            3 -> color3
            4 -> color4
            5 -> color5
            6 -> color6
            7 -> color7
            8 -> color8
            9 -> color9
            // Add more cases as needed
            else -> color1 // Default to color1 if an invalid number is passed
        }
    }
}
