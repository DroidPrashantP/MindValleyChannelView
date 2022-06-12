package com.paddy.mindvalley.channel.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.SectionData
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionItemBinding
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding

class ChannelSectionAdapterViewHolder(var binding : LayoutChannelSectionItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(channel: Channel?){
        binding.tvChannelScreenChannelTitle.text = channel?.title
        binding.tvChannelScreenEpisodesCount.text = (channel?.mediaCount ?: 0).toString()
    }
}