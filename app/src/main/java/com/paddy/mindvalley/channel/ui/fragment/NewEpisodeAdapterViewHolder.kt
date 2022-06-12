package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding

class NewEpisodeAdapterViewHolder(var binding : LayoutNewEpisodeSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, media: Media?){
        binding.tbNewEpisodeSectionLabel.text = media?.title
        binding.tbNewEpisodeSectionDescription.text = media?.channel?.title

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.tbNewEpisodeSectionImage.clipToOutline = true
        }

        context?.let {
            Glide.with(context).load(media?.coverAsset?.url).into(binding.tbNewEpisodeSectionImage)
        }

    }
}