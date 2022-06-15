package com.paddy.mindvalley.channel.data.model

import androidx.annotation.Keep

@Keep
data class ChannelListItem(var sectionTitle: String, var channelSectionViewType : ChannelSectionViewType, var sectionData: SectionData)
