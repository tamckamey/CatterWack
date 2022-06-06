package com.example.catterwack.network

import com.example.catterwack.AgeObject
import com.example.catterwack.R
import retrofit2.Retrofit;
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


interface AgeApi {
    @GET("https://api.agify.io/")
    suspend fun getAge(@Query("name") name: String): Response<AgeObject> //This was tough to figure out.
}

object AgeApiretrofitHelper {
    private const val BASE_URL = "https://api.agify.io/";

    fun getAge(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

class AgeApiService {

}