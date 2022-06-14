package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class CoverAsset( @ColumnInfo(name = "url", defaultValue = "") var url: String)