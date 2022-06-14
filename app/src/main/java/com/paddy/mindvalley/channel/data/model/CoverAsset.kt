package com.paddy.mindvalley.channel.data.model

import androidx.room.ColumnInfo

data class CoverAsset( @ColumnInfo(name = "url", defaultValue = "") var url: String)