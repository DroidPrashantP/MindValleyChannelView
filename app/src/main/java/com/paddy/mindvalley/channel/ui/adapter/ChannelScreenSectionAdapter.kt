package com.paddy.mindvalley.channel.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionTypeItemBinding
import com.paddy.mindvalley.channel.ui.ChannelScreenSectionAdapterVH

class ChannelScreenSectionAdapter(
    private var mContext: Context?,
    private var mCollection: MutableList<ChannelListItem>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChannelScreenSectionAdapterVH(LayoutChannelSectionTypeItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mCollection?.get(position)
        (holder as ChannelScreenSectionAdapterVH).bindData(mContext, item)
    }

    override fun getItemCount(): Int {
        return mCollection?.size ?: 0
    }

    fun addCollectionItems(collection: MutableList<ChannelListItem>) {
        mCollection = collection
        notifyItemRangeChanged(0, mCollection?.size ?: 0)
    }

}