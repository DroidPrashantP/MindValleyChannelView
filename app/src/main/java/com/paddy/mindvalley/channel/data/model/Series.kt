package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.Embedded
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@TypeConverters(Converters::class)
data class Series(var title: String, @Embedded var coverAsset: CoverAsset?)

