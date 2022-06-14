package com.paddy.mindvalley.channel.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.paddy.mindvalley.channel.data.model.Category
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.Media

@Dao
interface ChannelScreenSessionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: Media)

    @Transaction
    suspend fun insertMedia(objects: MutableList<Media>) = objects.forEach {insert(it)}

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: Channel)

    @Transaction
    suspend fun insertChannel(objects: MutableList<Channel>) = objects.forEach {insert(it)}

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: Category)

    @Transaction
    suspend fun insertCategory(objects: MutableList<Category>) = objects.forEach {insert(it)}

    @Query("SELECT * FROM media")
    fun getAllMediaItems(): MutableList<Media>

    @Query("SELECT * FROM channel")
    fun getAllChannelItems(): MutableList<Channel>

    @Query("SELECT * FROM category")
    fun getAllCategoryItems(): MutableList<Category>
}