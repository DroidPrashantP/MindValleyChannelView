package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding
import com.paddy.mindvalley.channel.utils.ImageLoadingUtils

class NewEpisodeAdapterViewHolder(var binding : LayoutNewEpisodeSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, media: Media?){
        binding.tbNewEpisodeSectionLabel.text = media?.title
        binding.tbNewEpisodeSectionDescription.text = media?.channel?.title

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.tbNewEpisodeSectionImage.clipToOutline = true

            binding.tbNewEpisodeSectionImage.shapeAppearanceModel = binding.tbNewEpisodeSectionImage.getShapeAppearanceModel()
                .toBuilder()
                .setAllCorners(CornerFamily.ROUNDED, 16.0f)
                .build()
        }

        context?.let {
            ImageLoadingUtils.loadImage(it, media?.coverAsset?.url, binding.tbNewEpisodeSectionImage, false)
            binding.tbNewEpisodeSectionImage.scaleType = ImageView.ScaleType.FIT_XY
        }
    }
}