package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.shape.CornerFamily
import com.paddy.mindvalley.channel.data.model.Series
import com.paddy.mindvalley.channel.databinding.LayoutChannelCourseSectionIndividualItemBinding
import com.paddy.mindvalley.channel.utils.ImageLoadingUtils

class SeriesItemViewHolder(var binding : LayoutChannelCourseSectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, series: Series?){
        binding.tbCourseSectionLabel.text = series?.title
        context?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                binding.tbCourseSectionImage.clipToOutline = true
                binding.tbCourseSectionImage.shapeAppearanceModel = binding.tbCourseSectionImage.shapeAppearanceModel
                    .toBuilder()
                    .setAllCorners(CornerFamily.ROUNDED, 16.0f)
                    .build()
            }

            ImageLoadingUtils.loadImage(it, series?.coverAsset?.url, binding.tbCourseSectionImage, false)
            binding.tbCourseSectionImage.scaleType = ImageView.ScaleType.FIT_XY
        }

    }
}