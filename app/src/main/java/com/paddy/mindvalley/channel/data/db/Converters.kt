package com.paddy.mindvalley.channel.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.paddy.mindvalley.channel.data.model.LatestMedia
import com.paddy.mindvalley.channel.data.model.Series

class Converters {
    @TypeConverter
    fun mediaListToJson(value: MutableList<LatestMedia>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMediaList(value: String?) = Gson().fromJson(value, Array<LatestMedia>::class.java).toList()

    @TypeConverter
    fun seriesListToJson(value: MutableList<Series>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSeries(value: String?) = Gson().fromJson(value, Array<Series>::class.java).toList()
}