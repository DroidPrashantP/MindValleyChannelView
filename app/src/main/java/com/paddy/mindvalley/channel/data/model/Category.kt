package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.db.Converters

@Keep
@Entity(tableName = "category")
@TypeConverters(Converters::class)
data class Category(@PrimaryKey var name: String)

