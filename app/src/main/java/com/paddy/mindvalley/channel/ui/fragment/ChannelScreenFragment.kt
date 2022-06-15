package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.databinding.ChannelScreenFragmentBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelScreenSectionAdapter
import com.paddy.mindvalley.channel.utils.gone
import com.paddy.mindvalley.channel.utils.isListNotEmpty
import com.paddy.mindvalley.channel.utils.isNotNullAndTrue
import com.paddy.mindvalley.channel.utils.show
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChannelScreenFragment : Fragment(R.layout.channel_screen_fragment) {

    companion object {
        fun newInstance() = ChannelScreenFragment()
    }

    private var mContext: Context? = null
    private val mChannelScreenViewModel: ChannelScreenViewModel by sharedViewModel<ChannelScreenViewModel>()
    private var mDataBinding :  ChannelScreenFragmentBinding ? = null
    private var mChannelScreenSectionAdapter :  ChannelScreenSectionAdapter ? = null
    private var mLinearLayoutManager:  LinearLayoutManager ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mDataBinding = ChannelScreenFragmentBinding.inflate(inflater, container, false);
        return mDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTheRv()
        swipeToRefreshLayoutBinding()
        loadData()
    }

    private fun swipeToRefreshLayoutBinding() {
        mDataBinding?.swipeToRefreshLayout?.setOnRefreshListener {
            if (mDataBinding?.swipeToRefreshLayout?.isRefreshing.isNotNullAndTrue()) {
                mDataBinding?.swipeToRefreshLayout?.isRefreshing = false
            }
            loadData()
        }

        mDataBinding?.rvChannelScreenMainList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {}
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                mDataBinding?.swipeToRefreshLayout?.isEnabled = mLinearLayoutManager?.findFirstCompletelyVisibleItemPosition() == 0
            }
        })
    }

    private fun loadData() {
        mDataBinding?.let { view ->
            showLoadingView(view)
            lifecycleScope.launchWhenResumed {
                mContext?.let {
                    mChannelScreenViewModel.fetchChannelScreenData().observe(viewLifecycleOwner) { result ->
                        hideLoadingView(view)
                        if(isDataAvailable(result)) {
                            showContentView(view)
                            mChannelScreenSectionAdapter?.addCollectionItems(result)
                        } else {
                            showEmptyView(view)
                        }
                    }
                }
            }
        }

    }

    private fun initializeTheRv(){
        mDataBinding?.rvChannelScreenMainList?.apply {
            mLinearLayoutManager = LinearLayoutManager(mContext)
            layoutManager = mLinearLayoutManager
            mChannelScreenSectionAdapter = ChannelScreenSectionAdapter(mContext, mutableListOf())
            adapter = mChannelScreenSectionAdapter
        }
    }


    private fun hideLoadingView(view: ChannelScreenFragmentBinding) {
        view.shimmerViewContainer.stopShimmer()
        view.shimmerViewContainer.gone()
        view.rvChannelScreenMainList.show()
        view.clEmptyScreenContainer.gone()
    }

    private fun showLoadingView(view: ChannelScreenFragmentBinding) {
        view.shimmerViewContainer.show()
        view.rvChannelScreenMainList.gone()
        view.shimmerViewContainer.startShimmer()
        view.clEmptyScreenContainer.gone()
    }

    private fun showEmptyView(view: ChannelScreenFragmentBinding) {
        view.shimmerViewContainer.gone()
        view.rvChannelScreenMainList.gone()
        view.clEmptyScreenContainer.show()
    }

    private fun showContentView(view: ChannelScreenFragmentBinding) {
        view.shimmerViewContainer.gone()
        view.rvChannelScreenMainList.show()
        view.clEmptyScreenContainer.gone()
    }


    private fun isDataAvailable(collection: MutableList<ChannelListItem>) : Boolean{
        var isDataAvailable : Boolean  = false
        collection.forEach {
            if(it.sectionData.data.media.isListNotEmpty() || it.sectionData.data.channels.isListNotEmpty() || it.sectionData.data.categories.isListNotEmpty() ){
                isDataAvailable = true
            }
        }
        return isDataAvailable
    }
}