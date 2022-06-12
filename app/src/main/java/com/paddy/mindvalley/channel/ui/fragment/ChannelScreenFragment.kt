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
import com.paddy.mindvalley.channel.databinding.ChannelScreenFragmentBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelPageMainAdapter
import com.paddy.mindvalley.channel.utils.isNotNullAndTrue
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChannelScreenFragment : Fragment(R.layout.channel_screen_fragment) {

    companion object {
        fun newInstance() = ChannelScreenFragment()
    }

    private var mContext: Context? = null
    private val mChannelScreenViewModel: ChannelScreenViewModel by sharedViewModel<ChannelScreenViewModel>()
    private var mDataBinding :  ChannelScreenFragmentBinding ? = null
    private var mChannelPageMainAdapter :  ChannelPageMainAdapter ? = null
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
                mDataBinding?.swipeToRefreshLayout?.isEnabled = mLinearLayoutManager?.findFirstCompletelyVisibleItemPosition() === 0
            }
        })
    }

    private fun loadData() {
        lifecycleScope.launchWhenResumed {
            mContext?.let { ctx ->
                mChannelScreenViewModel.fetchChannelScreenData().observe(viewLifecycleOwner) { result ->
                    mChannelPageMainAdapter?.addCollectionItems(result)
                }
            }
        }
    }

    private fun initializeTheRv(){
        mDataBinding?.rvChannelScreenMainList?.apply {
            mLinearLayoutManager = LinearLayoutManager(mContext)
            layoutManager = mLinearLayoutManager
            mChannelPageMainAdapter = ChannelPageMainAdapter(mContext, mutableListOf())
            adapter = mChannelPageMainAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}