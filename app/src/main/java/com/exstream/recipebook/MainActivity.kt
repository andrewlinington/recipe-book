package com.exstream.recipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.exstream.recipebook.home.HomeScreen
import com.exstream.recipebook.recipe.data.Recipe
import com.exstream.recipebook.ui.components.IconContent
import com.exstream.recipebook.ui.theme.PreviewTheme
import com.exstream.recipebook.ui.theme.RecipeBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeBookTheme {
                RecipeBookApp()
            }
        }
    }
}

@Composable
fun RecipeBookApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            if(currentDestination == AppDestinations.HOME) {
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
        }
    }
}

@PreviewScreenSizes
@PreviewTheme
@Composable
fun PreviewRecipeBookApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            if(currentDestination == AppDestinations.HOME) {
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
                    ),
                    country = "Canada"
                )
            }
        }
    }
}


enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FAVORITES("Favorites", R.drawable.ic_favorite),
    PROFILE("Profile", R.drawable.ic_account_box),
}