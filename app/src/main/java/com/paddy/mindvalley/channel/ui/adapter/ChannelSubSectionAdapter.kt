package com.paddy.mindvalley.channel.ui.adapter

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.data.model.ChannelViewType
import com.paddy.mindvalley.channel.data.model.SubSectionItem
import com.paddy.mindvalley.channel.databinding.LayoutCategorySectionIndividualItemBinding
import com.paddy.mindvalley.channel.databinding.LayoutChannelPageTypeItemBinding
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionItemBinding
import com.paddy.mindvalley.channel.databinding.LayoutNewEpisodeSectionIndividualItemBinding
import com.paddy.mindvalley.channel.ui.ChannelPageTypeAdapterViewHolder
import com.paddy.mindvalley.channel.ui.fragment.CategoriesSectionAdapterViewHolder
import com.paddy.mindvalley.channel.ui.fragment.ChannelSectionAdapterViewHolder
import com.paddy.mindvalley.channel.ui.fragment.NewEpisodeAdapterViewHolder

class ChannelSubSectionAdapter(
    private var mContext: Context?,
    private var channelItem: ChannelListItem?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val MAX_WIDTH_PERCENTAGE = 45
        private const val NEW_EPISODE_TYPE = 1
        private const val CHANNEL_VIEW_TYPE = 2
        private const val CATEGORY_VIEW_TYPE = 3
        private const val EMPTY_VIEW = 4
    }


    override fun getItemViewType(position: Int): Int {
        return when (channelItem?.channelViewType) {
            ChannelViewType.NEW_EPISODE -> {
                NEW_EPISODE_TYPE
            }
            ChannelViewType.CHANNEL_SECTION -> {
                CHANNEL_VIEW_TYPE
            }
            ChannelViewType.CATEGORY_SECTION -> {
                CATEGORY_VIEW_TYPE
            }
            else -> {
                EMPTY_VIEW
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            NEW_EPISODE_TYPE -> {
                var view  = LayoutNewEpisodeSectionIndividualItemBinding.inflate(inflater, parent, false)
                setWidthToView(view.root, mContext, MAX_WIDTH_PERCENTAGE)
                viewHolder = NewEpisodeAdapterViewHolder(view)

            }
            CHANNEL_VIEW_TYPE -> {
                viewHolder = ChannelSectionAdapterViewHolder(LayoutChannelSectionItemBinding.inflate(inflater, parent, false))
            }
            CATEGORY_VIEW_TYPE -> {
                viewHolder = CategoriesSectionAdapterViewHolder(LayoutCategorySectionIndividualItemBinding.inflate(inflater, parent, false))
            }
        }
        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            NEW_EPISODE_TYPE -> {
                val newEpisodeAdapterViewHolder = holder as NewEpisodeAdapterViewHolder
                var media  = channelItem?.sectionData?.data?.media?.get(position)
                newEpisodeAdapterViewHolder.bindData(media)
            }
            CHANNEL_VIEW_TYPE -> {
                val channelSectionAdapterViewHolder = holder as ChannelSectionAdapterViewHolder
                val channel  = channelItem?.sectionData?.data?.channels?.get(position)
                channelSectionAdapterViewHolder.bindData(channel)
            }
            CATEGORY_VIEW_TYPE -> {
                val categoriesSectionAdapterViewHolder = holder as CategoriesSectionAdapterViewHolder
                val categories  = channelItem?.sectionData?.data?.categories?.get(position)
                categoriesSectionAdapterViewHolder.bindData(categories)
            }
        }
    }

    override fun getItemCount(): Int {
        return when (channelItem?.channelViewType) {
            ChannelViewType.NEW_EPISODE -> {
                channelItem?.sectionData?.data?.media?.size ?: 0
            }
            ChannelViewType.CHANNEL_SECTION -> {
                channelItem?.sectionData?.data?.channels?.size ?: 0
            }
            ChannelViewType.CATEGORY_SECTION -> {
                channelItem?.sectionData?.data?.categories?.size ?: 0
            }
            else -> {
               0
            }
        }
    }

    private fun setWidthToView(itemView: View, context: Context?, widthPercentage: Int) {
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = getWidth(wm, widthPercentage)
        val layoutParams = LinearLayout.LayoutParams(width,
            ViewGroup.LayoutParams.MATCH_PARENT)
        itemView.layoutParams = layoutParams
    }

    private fun getWidth(wm: WindowManager, widthPercentage: Int): Int {
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x * widthPercentage / 100
    }

}