package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.databinding.ChannelScreenFragmentBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelPageMainAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChannelScreenFragment : Fragment(R.layout.channel_screen_fragment) {

    companion object {
        fun newInstance() = ChannelScreenFragment()
    }

    private var mContext: Context? = null
    private val mChannelScreenViewModel: ChannelScreenViewModel by sharedViewModel<ChannelScreenViewModel>()
    private var mDataBinding :  ChannelScreenFragmentBinding ? = null
    private var mChannelPageMainAdapter :  ChannelPageMainAdapter ? = null

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
            layoutManager = LinearLayoutManager(mContext)
            mChannelPageMainAdapter = ChannelPageMainAdapter(mContext, mutableListOf())
            adapter = mChannelPageMainAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}