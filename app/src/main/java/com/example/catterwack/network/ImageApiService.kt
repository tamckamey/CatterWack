package com.example.catterwack.network

import com.example.catterwack.AgeObject
import com.example.catterwack.ImageObject
import com.example.catterwack.R
import retrofit2.Retrofit;
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


interface CatImageApi {
    @GET("https://api.thecatapi.com/v1/images/search/")
    suspend fun getImage(): Response<List<ImageObject>> //This was tough to figure out.
}

object CatImageApiretrofitHelper {
    private const val BASE_URL = "https://api.thecatapi.com/v1/images/search/";

    fun getCatImage(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

class CatImageApiService {

}