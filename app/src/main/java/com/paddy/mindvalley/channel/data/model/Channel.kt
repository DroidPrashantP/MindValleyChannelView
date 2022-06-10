package com.paddy.mindvalley.channel.data.model

data class Channel(
    val title: String,
    val coverAsset: CoverAsset,
    val iconAsset: IconAsset,
    val id: String,
    val latestMedia: List<Media>,
    val mediaCount: Int,
    val series: List<Series>,
)

