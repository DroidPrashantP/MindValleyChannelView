package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.data.model.Series
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding

class SeriesItemViewHolder(var binding : LayoutNewEpisodeSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, series: Series?){
        binding.tbNewEpisodeSectionLabel.text = series?.title
        context?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                binding.tbNewEpisodeSectionImage.clipToOutline = true
            }
            Glide.with(context).load(series?.coverAsset?.url).into(binding.tbNewEpisodeSectionImage)
        }

    }
}