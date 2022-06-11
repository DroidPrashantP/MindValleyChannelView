package com.paddy.mindvalley.channel

import android.app.Application
import com.paddy.mindvalley.channel.domain.appModule
import com.paddy.mindvalley.channel.domain.repModule
import com.paddy.mindvalley.channel.domain.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MindValleyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MindValleyApplication)
            modules(listOf(appModule, repModule, viewModelModule))
        }
    }

}