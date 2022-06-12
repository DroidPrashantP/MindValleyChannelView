package com.paddy.mindvalley.channel.ui.adapter

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.Media
import com.paddy.mindvalley.channel.data.model.Series
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding
import com.paddy.mindvalley.channel.ui.fragment.NewEpisodeAdapterViewHolder
import com.paddy.mindvalley.channel.ui.fragment.SeriesItemViewHolder
import com.paddy.mindvalley.channel.utils.isListNotEmpty
import com.paddy.mindvalley.channel.utils.isNotNullAndTrue

class ChannelItemAdapter(
    private var mContext: Context?,
    private var mChannel: Channel?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mMediaList: MutableList<Media>? = null
    private var mSeriesList: MutableList<Series>? = null
    private var mIsSeriesDataAvailable: Boolean? = null

    init {
        mMediaList = mChannel?.latestMedia as MutableList<Media>?
        mSeriesList = mChannel?.series as MutableList<Series>?
        mIsSeriesDataAvailable = mChannel?.series.isListNotEmpty()
    }

    companion object {
        private const val MAX_WIDTH_PERCENTAGE_SMALL = 45
        private const val MAX_WIDTH_PERCENTAGE_LONG = 85
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = LayoutNewEpisodeSectionIndividualItemBinding.inflate(inflater, parent, false)

        return  if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            setWidthToView(view.root, mContext, MAX_WIDTH_PERCENTAGE_LONG)
            SeriesItemViewHolder(view)
        } else {
            setWidthToView(view.root, mContext, MAX_WIDTH_PERCENTAGE_SMALL)
            NewEpisodeAdapterViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            val series = mSeriesList?.get(position)
            val seriesItemViewHolder = holder as SeriesItemViewHolder
            seriesItemViewHolder.bindData(mContext, series)
        } else {
            val media = mMediaList?.get(position)
            val newEpisodeAdapterViewHolder = holder as NewEpisodeAdapterViewHolder
            newEpisodeAdapterViewHolder.bindData(mContext, media)
        }
    }

    override fun getItemCount(): Int {
        return if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            mSeriesList?.size ?: 0
        } else {
            mMediaList?.size ?: 0
        }
    }

    private fun setWidthToView(itemView: View, context: Context?, widthPercentage: Int) {
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = getWidth(wm, widthPercentage)
        val layoutParams = LinearLayout.LayoutParams(
            width,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        itemView.layoutParams = layoutParams
    }

    private fun getWidth(wm: WindowManager, widthPercentage: Int): Int {
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x * widthPercentage / 100
    }

}