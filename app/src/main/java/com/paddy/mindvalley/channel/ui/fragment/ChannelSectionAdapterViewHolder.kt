package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionItemBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelItemAdapter
import com.paddy.mindvalley.channel.utils.ImageLoadingUtils

class ChannelSectionAdapterViewHolder(var binding : LayoutChannelSectionItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(context: Context?, channel: Channel?){
        binding.tvChannelScreenChannelTitle.text = channel?.title
        binding.tvChannelScreenEpisodesCount.text = (channel?.mediaCount ?: 0).toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.tvChannelScreenChannelImage.clipToOutline = true
        }

        context?.let {
            ImageLoadingUtils.loadImage(it, channel?.iconAsset?.thumbnailUrl, binding.tvChannelScreenChannelImage, true)
        }

        binding.rvChannelScreenChannelSection.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter =  ChannelItemAdapter(context, channel)
        }
    }
}