package com.example.bloom

data class Plant(
    var imagesRes: Int,
    var name: String
)

fun getBrowseThemePlantList() = mutableListOf(

    Plant(R.drawable.desert_chic, "Desert Chic"),
    Plant(R.drawable.tiny_terrariums, "Tiny terrariums"),
    Plant(R.drawable.jungle_vibes, "Jungle Vibes"),
    Plant(R.drawable.monstera, "Monstera"),
    Plant(R.drawable.aglaonema, "Aglaonema"),
    Plant(R.drawable.peace_lily, "Peace Lily")
)


fun getDesignHomePlantList() = mutableListOf(
    Plant(R.drawable.monstera, "Monstera"),
    Plant(R.drawable.aglaonema, "Aglaonema"),
    Plant(R.drawable.peace_lily, "Peace Lily"),
    Plant(R.drawable.fiddle_leaf, "Fiddle leaf tree"),
    Plant(R.drawable.tiny_terrariums, "Tiny terrariums"),
    Plant(R.drawable.jungle_vibes, "Jungle Vibes"),
)