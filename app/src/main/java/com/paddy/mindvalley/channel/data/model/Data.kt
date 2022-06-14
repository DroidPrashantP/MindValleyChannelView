package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep

@Keep
data class Data(
    var media: MutableList<Media>?,
    var channels: MutableList<Channel>?,
    var categories: MutableList<Category>?,

)