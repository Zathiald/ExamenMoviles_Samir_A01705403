package com.itesm.examenmoviles.data.network.model

import com.itesm.examenmoviles.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    operator fun invoke(): DragonApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // Asegúrate de que esta URL sea correcta
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(DragonApiService::class.java)
    }
}

