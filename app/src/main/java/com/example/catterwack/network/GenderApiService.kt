package com.example.catterwack.network

import com.example.catterwack.AgeObject
import com.example.catterwack.GenderObject
import com.example.catterwack.R
import retrofit2.Retrofit;
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


interface GenderApi {
    @GET("https://api.genderize.io/")
    suspend fun getGender(@Query("name") name: String): Response<GenderObject> //This was tough to figure out.
}

object GenderApiretrofitHelper {
    private const val BASE_URL = "https://api.genderize.io/";

    fun getGender(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

class GenderApiService {

}