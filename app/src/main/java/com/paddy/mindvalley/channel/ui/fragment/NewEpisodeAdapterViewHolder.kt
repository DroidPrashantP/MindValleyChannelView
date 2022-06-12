package com.paddy.mindvalley.channel.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding

class NewEpisodeAdapterViewHolder(var binding : LayoutNewEpisodeSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(media: Media?){
        binding.tbNewEpisodeSectionLabel.text = "New Episode"
        binding.tbNewEpisodeSectionDescription.text = media?.title


    }
}