package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@Entity(tableName = "media")
@TypeConverters(Converters::class)
data class Media(
    @PrimaryKey var title: String = "",
    @Embedded(prefix = "med") var channel: MediaChannel?,
    @Embedded(prefix = "med") var coverAsset: CoverAsset?,
    var type: String
)

