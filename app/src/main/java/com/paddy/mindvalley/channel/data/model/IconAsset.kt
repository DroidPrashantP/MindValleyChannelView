package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@TypeConverters(Converters::class)
data class IconAsset(
    @ColumnInfo(name = "thumbnailUrl", defaultValue = "") var thumbnailUrl: String
)