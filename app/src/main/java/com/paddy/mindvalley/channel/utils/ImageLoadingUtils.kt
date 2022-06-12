package com.paddy.mindvalley.channel.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.paddy.mindvalley.channel.R
import timber.log.Timber

object ImageLoadingUtils {

    fun loadImage(
        ctx: Context?,
        imageUrl: String?,
        appCompatImageView: AppCompatImageView?,
        circularTransformation: Boolean
    ) {
        try {

            if (appCompatImageView != null && ctx != null && imageUrl!= null) {
                Glide.with(ctx).load(imageUrl)
                    .apply(if (circularTransformation) circularOptions else options)
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any,
                            target: Target<Drawable?>,
                            isFirstResource: Boolean
                        ): Boolean {
                            if (e != null) {
                                val exceptionList = e.rootCauses
                                if (exceptionList.size > 0) {
                                    val errorMsg = exceptionList[0].message
                                }
                            }
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any,
                            target: Target<Drawable?>,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }
                    })
                    .into(appCompatImageView)
            }
        } catch (e: Throwable) {
            Timber.e("Exception caught while loading image ==>> " + e.message)
        }
    }

    private val circularOptions: RequestOptions = RequestOptions()
        .placeholder(R.drawable.channel_image_bg)
        .transform(CircleCrop())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.channel_image_bg)

    private val options: RequestOptions = RequestOptions()
        .placeholder(R.drawable.glide_rectangle_holder_bg)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.glide_rectangle_holder_bg)
}