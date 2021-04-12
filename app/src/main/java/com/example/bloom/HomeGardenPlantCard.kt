package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeGardenPlantCard(plant: Plant) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HomeGardenPlantImage(plant)

        Column {

            TitleDescriptionCheckboxRow(plant)

            Divider()
        }

    }

}

@Composable
private fun HomeGardenPlantImage(plant: Plant) {
    Image(
        painter = painterResource(plant.imagesRes),
        contentDescription = plant.name.plus("Image"),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
private fun RowScope.TitleAndDescription(plant: Plant) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.weight(1F)
    ) {
        Text(
            text = plant.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
        Text(
            "This is a description",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
        )
    }
}

@Composable
private fun TitleDescriptionCheckboxRow(plant: Plant) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TitleAndDescription(plant)

        PlantCheckbox()
    }
}

@Composable
private fun PlantCheckbox() {
    val checkedState = remember {
        mutableStateOf(false)
    }

    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { isChecked ->
            checkedState.value = isChecked
        },
        colors = CheckboxDefaults.colors(
            checkmarkColor = MaterialTheme.colors.background,
        ),
        modifier = Modifier
            .size(24.dp)
    )
}

