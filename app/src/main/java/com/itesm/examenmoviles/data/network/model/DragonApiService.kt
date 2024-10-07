package com.itesm.examenmoviles.data.network.model

import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonApiService {

    @GET("characters")
    suspend fun getCharacterList(
        @Query("limit") limit: Int
    ): CharacterObject

    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): DragonBallCharacter
}

