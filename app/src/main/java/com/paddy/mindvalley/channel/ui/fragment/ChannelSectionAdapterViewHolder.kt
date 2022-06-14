package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionItemBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelItemAdapter
import com.paddy.mindvalley.channel.utils.ImageLoadingUtils
import com.paddy.mindvalley.channel.utils.isListNotEmpty

class ChannelSectionAdapterViewHolder(var binding: LayoutChannelSectionItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(context: Context?, channel: Channel?) {
        context?.let { ctx ->
            binding.tvChannelScreenChannelTitle.text = channel?.title
            if (channel?.series.isListNotEmpty()) {
                binding.tvChannelScreenEpisodesCount.text = String.format(ctx.getString(R.string.append_series, (channel?.mediaCount ?: 0).toString()))
            } else {
                binding.tvChannelScreenEpisodesCount.text = String.format(ctx.getString(R.string.append_episodes, (channel?.mediaCount ?: 0).toString()))
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                binding.tvChannelScreenChannelImage.clipToOutline = true
            }

            ImageLoadingUtils.loadImage(ctx, channel?.iconAsset?.thumbnailUrl, binding.tvChannelScreenChannelImage, true)

            binding.rvChannelScreenChannelSection.apply {
                layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
                adapter = ChannelItemAdapter(context, channel)
            }
        }

    }
}