package com.exstream.recipebook.recipe.data

import android.annotation.SuppressLint

data class Recipe(
    val name: String,
    val description: String = "",
    val servings: Int,
    val timeInMinutesToCook: Int,
    val timeInMinutesToPrep: Int,
    val totalTimeInMinutes: Int = timeInMinutesToCook + timeInMinutesToPrep
) {

    @SuppressLint("DefaultLocale")
    fun getTimeAsString() : String {
        val timeInHours: Int = totalTimeInMinutes / 60
        val timeRemaining: Int = totalTimeInMinutes % 60
        val formattedTimeRemaining: String = String.format("%02d", timeRemaining)
        return "$timeInHours:$formattedTimeRemaining"
    }
}