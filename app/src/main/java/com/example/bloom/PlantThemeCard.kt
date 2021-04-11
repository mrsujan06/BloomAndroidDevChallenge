package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PlantThemeCard(plant: Plant) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(136.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = plant.imagesRes),
                contentDescription = plant.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(138.dp)
                    .height(96.dp)
            )
            Text(
                text = plant.name,
                style = MaterialTheme.typography.h2.merge(TextStyle(textAlign = TextAlign.Justify)),
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 8.dp)
                    .wrapContentSize()
            )
        }
    }
}
