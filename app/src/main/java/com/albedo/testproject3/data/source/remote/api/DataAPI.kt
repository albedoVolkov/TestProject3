package com.albedo.testproject3.data.source.remote.api

import com.albedo.testproject3.data.models.DataFromServer
import com.albedo.testproject3.services.ConstantsSource
import retrofit2.http.GET

interface DataAPI {

    @GET(ConstantsSource.END_USERS_URL_LINK)
    suspend fun getData(): DataFromServer?
}