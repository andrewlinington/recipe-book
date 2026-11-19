package com.exstream.recipebook.recipe.data

import com.exstream.recipebook.R
import com.exstream.recipebook.ui.components.IconContent
import org.junit.Test

import org.junit.Assert.*

class RecipeTest {

    @Test
    fun getTimeAsString_with_no_time() {
        val recipe = testRecipe(
            timeInMinutesToCook = 0,
            timeInMinutesToPrep = 0
        )

        assertEquals(recipe.getTimeAsString(), "0:00")
    }

    @Test
    fun getTimeAsString_with_no_hours_time() {
        val recipe = testRecipe(
            timeInMinutesToCook = 10,
            timeInMinutesToPrep = 0
        )

        assertEquals(recipe.getTimeAsString(), "0:10")
    }

    @Test
    fun getTimeAsString_with_under_10_minutes() {
        val recipe = testRecipe(
            timeInMinutesToCook = 0,
            timeInMinutesToPrep = 0
        )

        assertEquals(recipe.getTimeAsString(), "0:06")
    }

    @Test
    fun getTimeAsString_with_hours_and_minutes() {
        val recipe = testRecipe(
            timeInMinutesToCook = 65,
            timeInMinutesToPrep = 10
        )

        assertEquals(recipe.getTimeAsString(), "1:15")
    }
}

private fun testRecipe(
    timeInMinutesToCook: Int,
    timeInMinutesToPrep: Int,
) = Recipe(
    name = "sample",
    servings = 1,
    timeInMinutesToCook = timeInMinutesToCook,
    timeInMinutesToPrep = timeInMinutesToPrep,
    icon =  IconContent(
        icon = R.drawable.lunch_dining,
        contentDescription = "burger dish"
    ),
)
