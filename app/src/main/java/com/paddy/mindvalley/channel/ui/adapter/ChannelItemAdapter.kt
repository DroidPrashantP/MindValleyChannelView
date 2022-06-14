package com.paddy.mindvalley.channel.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Channel
import com.paddy.mindvalley.channel.data.model.LatestMedia
import com.paddy.mindvalley.channel.data.model.Series
import com.paddy.mindvalley.channel.databinding.LayoutChannelCourseSectionIndividualItemBinding
import com.paddy.mindvalley.channel.ui.fragment.CourseSectionAdapterViewHolder
import com.paddy.mindvalley.channel.ui.fragment.SeriesItemViewHolder
import com.paddy.mindvalley.channel.utils.LayoutUtils
import com.paddy.mindvalley.channel.utils.isListNotEmpty
import com.paddy.mindvalley.channel.utils.isNotNullAndTrue

class ChannelItemAdapter(
    private var mContext: Context?,
    private var mChannel: Channel?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mMediaList: MutableList<LatestMedia>? = null
    private var mSeriesList: MutableList<Series>? = null
    private var mIsSeriesDataAvailable: Boolean? = null
    private var isMoreThanOneItem: Boolean = false

    init {
        mMediaList = mChannel?.latestMedia as MutableList<LatestMedia>?
        mSeriesList = if(mChannel?.series.isListNotEmpty()) mChannel?.series as MutableList<Series>? else mutableListOf()
        mIsSeriesDataAvailable = mChannel?.series.isListNotEmpty()
        isMoreThanOneItem = mChannel?.series?.size!! > 1
    }

    companion object {
        private const val VIEW_WIDTH_PERCENTAGE_SMALL = 45
        private const val VIEW_WIDTH_PERCENTAGE_LONG = 85
        private const val FULL_VIEW_WIDTH = 95
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = LayoutChannelCourseSectionIndividualItemBinding.inflate(inflater, parent, false)

        return  if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            LayoutUtils.setWidthAndHeightToSeriesView(view.root, mContext, if(isMoreThanOneItem)  VIEW_WIDTH_PERCENTAGE_LONG  else FULL_VIEW_WIDTH)
            SeriesItemViewHolder(view)
        } else {
            LayoutUtils.setWidthAndHeightToView(view.root, mContext, VIEW_WIDTH_PERCENTAGE_SMALL)
            CourseSectionAdapterViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            val series = mSeriesList?.get(position)
            val seriesItemViewHolder = holder as SeriesItemViewHolder
            seriesItemViewHolder.bindData(mContext, series)
        } else {
            val media = mMediaList?.get(position)
            val courseSectionAdapterViewHolder = holder as CourseSectionAdapterViewHolder
            courseSectionAdapterViewHolder.bindData(mContext, media)
        }
    }

    override fun getItemCount(): Int {
        return if (mIsSeriesDataAvailable.isNotNullAndTrue()) {
            mSeriesList?.size ?: 0
        } else {
            mMediaList?.size ?: 0
        }
    }
}