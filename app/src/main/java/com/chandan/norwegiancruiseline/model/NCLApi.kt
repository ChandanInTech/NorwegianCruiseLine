package com.chandan.norwegiancruiseline.model

import retrofit2.http.GET

interface NCLApi {

    @GET("SKY")
    suspend fun getSkyDetails(): CruiseDetailsResponse

    @GET("BLISS")
    suspend fun getBlissDetails(): CruiseDetailsResponse

    @GET("ESCAPE")
    suspend fun getEscapeDetails(): CruiseDetailsResponse
}
