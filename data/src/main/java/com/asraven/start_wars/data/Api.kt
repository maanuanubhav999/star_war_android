package com.asraven.start_wars.data

import com.asraven.start_wars.data.remote.response.AllCharactersResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET(Endpoints.GET_ALL_USER)
    suspend fun getAllCharacters(
        @Query("page") page: Int,
    ): AllCharactersResponse

}