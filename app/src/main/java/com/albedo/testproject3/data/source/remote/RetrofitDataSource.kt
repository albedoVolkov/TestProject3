package com.albedo.testproject3.data.source.remote

import com.albedo.testproject3.data.source.remote.api.DataAPI
import com.albedo.testproject3.services.ConstantsSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitDataSource @Inject constructor() {

    private val TAG = "RetrofitDataSource"

    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(ConstantsSource.START_USERS_URL_LINK)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val dataAPI : DataAPI by lazy {
        retrofit.create(DataAPI::class.java)
    }


}