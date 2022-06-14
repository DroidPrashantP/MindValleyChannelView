package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@TypeConverters(Converters::class)
data class LatestMedia(val title: String,
                       val coverAsset: CoverAsset?,
                       val type: String)
