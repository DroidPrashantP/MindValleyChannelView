package com.paddy.mindvalley.channel.domain

import android.content.Context
import com.paddy.mindvalley.channel.BuildConfig
import com.paddy.mindvalley.channel.data.api.ApiHelper
import com.paddy.mindvalley.channel.data.api.ApiHelperImpl
import com.paddy.mindvalley.channel.data.api.ApiService
import com.paddy.mindvalley.channel.utils.NetworkUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    val appModule = module {
        single { provideOkHttpClient() }
        single { provideRetrofit(get(), BuildConfig.BASE_URL) }
        single { provideApiService(get()) }
        single { provideNetworkHelper(androidContext()) }

        single<ApiHelper> {
            return@single ApiHelperImpl(get())
        }
    }

    private fun provideNetworkHelper(context: Context) = NetworkUtils(context)

    private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    private fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)