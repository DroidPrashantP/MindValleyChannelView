package com.paddy.mindvalley.channel.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.ui.fragment.ChannelScreenFragment

class MainActivity : AppCompatActivity() {
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        mContext = this
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