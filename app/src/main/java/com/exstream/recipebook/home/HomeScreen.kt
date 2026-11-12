package com.exstream.recipebook.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.exstream.recipebook.R
import com.exstream.recipebook.ui.components.DsIcon
import com.exstream.recipebook.ui.components.IconContent
import com.exstream.recipebook.ui.theme.PreviewTheme

@Composable
fun HomeScreen(
//    homeViewModel: HomeViewModel
) {

}




@Composable
fun RecipeRow(

) {
    Row {
        // leading icon
        DsIcon(
            icon = IconContent(
                icon = R.drawable.close,
                contentDescription = "food item" // TODO include this in list of details needed
            )
        )

        Column {
            // recipe name
            // recipe time
            // recipe servings
        }
        // trailing picker icon
        DsIcon(
            icon = IconContent(
                icon = R.drawable.chevron_right,
                contentDescription = "enter item" // TODO include this in list of details needed
            )
        )
    }
}


@PreviewTheme
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}