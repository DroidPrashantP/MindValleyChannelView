package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import com.paddy.mindvalley.channel.data.model.LatestMedia
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.databinding.LayoutChannelCourseSectionIndividualItemBinding
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding
import com.paddy.mindvalley.channel.utils.ImageLoadingUtils

class CourseSectionAdapterViewHolder(var binding : LayoutChannelCourseSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, media: LatestMedia?){
        binding.tbCourseSectionLabel.text = media?.title

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.tbCourseSectionImage.clipToOutline = true
            binding.tbCourseSectionImage.shapeAppearanceModel = binding.tbCourseSectionImage.getShapeAppearanceModel()
                .toBuilder()
                .setAllCorners(CornerFamily.ROUNDED, 16.0f)
                .build()
        }

        context?.let {
            ImageLoadingUtils.loadImage(it, media?.coverAsset?.url, binding.tbCourseSectionImage, false)
            binding.tbCourseSectionImage.scaleType = ImageView.ScaleType.FIT_XY
        }
    }
}