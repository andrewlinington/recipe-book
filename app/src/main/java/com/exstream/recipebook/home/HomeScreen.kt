package com.exstream.recipebook.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exstream.recipebook.R
import com.exstream.recipebook.recipe.data.Recipe
import com.exstream.recipebook.ui.components.DsIcon
import com.exstream.recipebook.ui.components.IconContent
import com.exstream.recipebook.ui.theme.PreviewTheme

@Composable
fun HomeScreen(
    recipes: List<Recipe>
//    homeViewModel: HomeViewModel
) {
    Column(
        Modifier.fillMaxSize().padding(12.dp)
    ) {
        Column(
            Modifier.background(
                MaterialTheme.colorScheme.surfaceContainerHigh,
                shape = RoundedCornerShape(12.dp)
            )
        ) {
            recipes.forEachIndexed { index, recipe ->
                RecipeRow(
                    recipe = recipe,
                    hasDivider = recipes.lastIndex != index
                )
            }
        }
    }
}

@Composable
private fun RecipeRow(
    recipe: Recipe,
    hasDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // leading icon
            DsIcon(
                icon = recipe.icon,
                iconSize = { large }
            )

            Column(
                Modifier.weight(1f)
            ) {
                Text(text = recipe.name)
                RecipeInfo(recipe.getTimeAsString(), recipe.servings)
            }
            DsIcon(
                icon = IconContent(
                    icon = R.drawable.chevron_right,
                    contentDescription = "chevron to enter ${recipe.name}"
                ),
                iconSize = { large }
            )
        }
        if (hasDivider) {
            HorizontalDivider(
                Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceContainer
            )
        }
    }
}

@Composable
private fun RecipeInfo(
    time: String,
    servings: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        DsIcon(
            IconContent(
                R.drawable.hourglass_empty,
                "Time to cook"
            ),
            tint = MaterialTheme.colorScheme.primaryContainer
        )
        // time
        Text(text = time)
        // servings
        DsIcon(
            IconContent(
                R.drawable.restaurant,
                "Serving icon"
            ),
            modifier = Modifier.padding(start = 4.dp),
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(text = "$servings servings") // TODO add to string res
    }
}


@PreviewTheme
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        recipes = listOf(
            Recipe(
                name = "Spaghetti and Meatballs",
                icon = IconContent(
                    icon = R.drawable.dinner_dining,
                    contentDescription = "pasta dish"
                ),
                description = "",
                servings = 4,
                timeInMinutesToCook = 25,
                timeInMinutesToPrep = 15
            ),
            Recipe(
                name = "Spaghetti",
                icon = IconContent(
                    icon = R.drawable.dinner_dining,
                    contentDescription = "pasta dish"
                ),
                description = "",
                servings = 4,
                timeInMinutesToCook = 15,
                timeInMinutesToPrep = 5
            ),
            Recipe(
                name = "Burger",
                icon = IconContent(
                    icon = R.drawable.lunch_dining,
                    contentDescription = "burger dish"
                ),
                description = "",
                servings = 8,
                timeInMinutesToCook = 25,
                timeInMinutesToPrep = 25
            )
        )
    )
}