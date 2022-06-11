package com.paddy.mindvalley.channel.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.ui.fragment.ChannelScreenFragment
import com.paddy.mindvalley.channel.ui.fragment.ChannelScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mChannelScreenViewModel: ChannelScreenViewModel  by viewModel<ChannelScreenViewModel>()
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        mContext = this

        mContext?.let { ctx ->
            mChannelScreenViewModel.fetchChannelScreenData()
        }
    }

    private fun initFragment() {
        addFragment(R.id.fm_mainActivityContainer, ChannelScreenFragment.newInstance())
    }

    private fun addFragment(containerViewId : Int, fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(containerViewId, fragment)
            commitAllowingStateLoss()
        }
    }
}