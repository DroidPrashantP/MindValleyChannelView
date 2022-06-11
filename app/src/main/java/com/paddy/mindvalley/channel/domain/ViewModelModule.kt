package com.paddy.mindvalley.channel.domain

import com.paddy.mindvalley.channel.ui.fragment.ChannelScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        ChannelScreenViewModel(get(), get())
    }
}
