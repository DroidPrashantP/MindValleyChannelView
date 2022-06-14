package com.paddy.mindvalley.channel.utils

import android.content.Context
import android.graphics.Point
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout


object LayoutUtils {

    fun setWidthToView(itemView: View, context: Context?, widthPercentage: Int) {
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = getWidth(wm, widthPercentage)
        val layoutParams = LinearLayout.LayoutParams(
            width,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        itemView.layoutParams = layoutParams
    }

    fun setWidthAndHeightToView(itemView: View, context: Context?, widthPercentage: Int) {
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = getWidth(wm, widthPercentage)
        val height = (width * 3) / 2  // 2/3 image ration
        val layoutParams = LinearLayout.LayoutParams(
            width,
            height
        )
        itemView.layoutParams = layoutParams
    }

    fun setWidthAndHeightToSeriesView(itemView: View, context: Context?, widthPercentage: Int) {
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = getWidth(wm, widthPercentage)
        val height = (width * 9) / 16  // 9/16 series image ration
        val layoutParams = LinearLayout.LayoutParams(
            width,
            height
        )
        itemView.layoutParams = layoutParams
    }


    private fun getWidth(wm: WindowManager, widthPercentage: Int): Int {
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x * widthPercentage / 100
    }

    private fun getHeight(wm: WindowManager, heightPercentage: Int): Int {
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y * heightPercentage / 100
    }
}