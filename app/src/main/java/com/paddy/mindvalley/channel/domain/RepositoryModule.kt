package com.paddy.mindvalley.channel.domain

import org.koin.dsl.module

val repModule = module {
    single {
        ChannelRepository(get())
    }
}
