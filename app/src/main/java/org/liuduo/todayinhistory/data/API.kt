package org.liuduo.todayinhistory.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("history/today")
    suspend fun getItems(
        @Query("type") type: Int,
        @Query("app_id") appId: String,
        @Query("app_secret") appSecret: String
    ): Response<Result>
}