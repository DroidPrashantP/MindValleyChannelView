package com.paddy.mindvalley.channel.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.paddy.mindvalley.channel.data.model.Category
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.CoverAsset
import com.paddy.mindvalley.channel.data.model.IconAsset
import com.paddy.mindvalley.channel.data.model.LatestMedia
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.data.model.Series

class Converters {

    val gson = Gson()

    @TypeConverter
    fun channelToString(channel: Channel): String {
        return gson.toJson(channel)
    }

    @TypeConverter
    fun stringToChannel(recipeString: String): Channel {
        val objectType = object : TypeToken<Channel>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

    @TypeConverter
    fun mediaToString(media: Media): String {
        return gson.toJson(media)
    }

    @TypeConverter
    fun stringToMedia(recipeString: String): Media {
        val objectType = object : TypeToken<Media>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

    @TypeConverter
    fun coverAssetToString(coverAsset: CoverAsset): String {
        return gson.toJson(coverAsset)
    }

    @TypeConverter
    fun stringToCoverAsset(recipeString: String): CoverAsset {
        val objectType = object : TypeToken<Media>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

    @TypeConverter
    fun seriesToString(series: Series): String {
        return gson.toJson(series)
    }

    @TypeConverter
    fun stringToSeries(recipeString: String): Series {
        val objectType = object : TypeToken<Series>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

    @TypeConverter
    fun iconAssetToString(iconAsset: IconAsset): String {
        return gson.toJson(iconAsset)
    }

    @TypeConverter
    fun stringToIconAsset(recipeString: String): IconAsset {
        val objectType = object : TypeToken<IconAsset>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

    @TypeConverter
    fun mediaListToJson(value: MutableList<LatestMedia>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMediaList(value: String?) = Gson().fromJson(value, Array<LatestMedia>::class.java).toList()

    @TypeConverter
    fun channelListToJson(value: MutableList<Channel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToChannelList(value: String?) = Gson().fromJson(value, Array<Channel>::class.java).toList()

    @TypeConverter
    fun categoryListToJson(value: MutableList<Category>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCategory(value: String?) = Gson().fromJson(value, Array<Category>::class.java).toList()

    @TypeConverter
    fun seriesListToJson(value: MutableList<Series>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSeries(value: String?) = Gson().fromJson(value, Array<Series>::class.java).toList()
}