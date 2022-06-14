package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@Entity(tableName = "channel")
@TypeConverters(Converters::class)
data class Channel(
    @PrimaryKey
    val title: String,
    @Embedded(prefix = "ch") val coverAsset: CoverAsset,
    @Embedded(prefix = "ch") val iconAsset: IconAsset,
    @ColumnInfo(name = "id", defaultValue = "0") val id: String,
    @ColumnInfo(name = "ch_latestMedia") var latestMedia: List<LatestMedia>,
    val mediaCount: Int,
    @ColumnInfo(name = "ch_series") val series: List<Series>,
)

