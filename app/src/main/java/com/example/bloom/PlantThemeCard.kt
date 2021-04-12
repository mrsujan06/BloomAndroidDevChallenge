package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlantThemeCard(plant: Plant) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.onSecondary,
        elevation = 2.dp,
        modifier = Modifier
            .size(136.dp)
            .padding(2.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = plant.imagesRes),
                contentDescription = plant.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )

            Text(
                text = plant.name,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 8.dp)

            )
        }
    }
}

@Preview
@Composable
fun PreviewPlantThemeCard() {
    PlantThemeCard(plant = Plant(R.drawable.fiddle_leaf, "Fiddle Leaf"))
}

