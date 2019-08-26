package com.example.architecturestudy.network.api

import com.example.architecturestudy.network.model.MarketResponse
import com.example.architecturestudy.network.model.TickerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/market/all")
    fun getMarketData(): Call<List<MarketResponse>>

    @GET("/v1/ticker")
    fun getTickerData(
        @Query("markets") markets: String
    ): Call<List<TickerResponse>>
}