package com.agc.challengedojo.data.remote.api.networkresponsehandler



class NetworkResponseHandler {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return try {
            Result.Success(apiCall())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}