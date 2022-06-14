package com.paddy.mindvalley.channel.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.paddy.mindvalley.channel.data.model.Category
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.Media

@Database(entities = [Media::class, Channel::class, Category::class], version = 1)
abstract class ChannelScreenDatabase : RoomDatabase() {
    abstract fun channelScreenSessionDAO(): ChannelScreenSessionDAO
}