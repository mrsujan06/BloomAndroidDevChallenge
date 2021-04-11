package com.example.bloom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen() {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize(),
    ) {

        var searchQuery: String by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.padding(40.dp))

            SearchBarOutlineTextField(search = searchQuery, onSearchQueryChange = { searchQuery = it })

            BrowseThemeSection()

            HomeGardenSection()
        }
    }
}


@Composable
private fun SearchBarOutlineTextField(search: String, onSearchQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = search,
        onValueChange = onSearchQueryChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            focusedBorderColor = MaterialTheme.colors.onPrimary,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        label = {
            Text(
                text = stringResource(R.string.search_label),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
        },

        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
private fun BrowseThemeSection() {

    val browsePlant = getBrowseThemePlantList()

    Text(
        text = "Browse themes",
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )

    Spacer(Modifier.height(16.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(browsePlant) {
            PlantThemeCard(plant = it)
        }

    }

}

@Composable
fun HomeGardenSection() {

    val homeGardenPlant = getDesignHomePlantList()

    Row(modifier = Modifier
        .paddingFromBaseline(40.dp)
        .fillMaxWidth()) {
        Text(
            stringResource(R.string.design_your_home_garden),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .weight(1f)
        )
        Icon(
            Icons.Filled.FilterList, contentDescription = null, modifier = Modifier
        )
    }

    Spacer(modifier = Modifier.padding(16.dp))

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp) , modifier = Modifier.fillMaxSize()) {
        items(homeGardenPlant) {
            HomeGardenPlantCard(plant = it)
        }
    }

}

@Preview
@Composable
fun PreviewPlantCard() {
    BloomTheme(darkTheme = true) {
        PlantThemeCard(plant = Plant(R.drawable.fiddle_leaf, "Fiddle leaf"))
    }
}

@Preview
@Composable
fun PreviewHomeScreenDark() {
    BloomTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview
@Composable
fun PreviewHomeScreenLight() {
    BloomTheme(darkTheme = false) {
        HomeScreen()
    }
}



