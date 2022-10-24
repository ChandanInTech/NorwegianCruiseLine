package com.chandan.norwegiancruiseline.model


sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    data class Success<T>(val successData: T) : NetworkResult<T>(data = successData)
    data class Error<T>(val errorMessage: String) : NetworkResult<T>(message = errorMessage)
    class Loading<T> : NetworkResult<T>()
}
