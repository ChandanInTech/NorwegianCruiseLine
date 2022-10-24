package com.chandan.norwegiancruiseline.model

class CruiseDetailsRepository(private val nclApi: NCLApi) {
    companion object {
        const val BASE_URL = "https://www.ncl.com/cms-service/cruise-ships/"
    }

    suspend fun getCruiseDetails(cruiseType: CruiseType): NetworkResult<CruiseDetailsResponse?> {
        val result = when (cruiseType) {
            CruiseType.ESCAPE -> nclApi.getEscapeDetails()
            CruiseType.BLISS -> nclApi.getBlissDetails()
            CruiseType.SKY -> nclApi.getSkyDetails()
        }

        return if (result != null) {
            NetworkResult.Success(result)
        } else {
            NetworkResult.Error(result.code)
        }
    }
}
