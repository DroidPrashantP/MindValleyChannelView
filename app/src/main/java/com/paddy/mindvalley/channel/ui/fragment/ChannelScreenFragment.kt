package com.paddy.mindvalley.channel.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paddy.mindvalley.channel.R

class ChannelScreenFragment : Fragment(R.layout.channel_screen_fragment) {

    companion object {
        fun newInstance() = ChannelScreenFragment()
    }

    private var mContext: Context? = null
    private val mChannelScreenViewModel: ChannelScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}