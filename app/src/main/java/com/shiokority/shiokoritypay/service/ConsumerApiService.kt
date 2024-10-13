package com.shiokority.shiokoritypay.service

import com.shiokority.shiokoritypay.model.LoginRequest
import com.shiokority.shiokoritypay.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ConsumerApiService {
    @POST("consumer/login")
    suspend fun loginConsumer(@Body loginRequest: LoginRequest): Response<LoginResponse>

    // You can add more API endpoints here as needed. For example:

    // @POST("consumer/register")
    // suspend fun registerConsumer(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    // @GET("consumer/profile")
    // suspend fun getConsumerProfile(@Header("Authorization") token: String): Response<ConsumerProfile>

    // @POST("consumer/logout")
    // suspend fun logoutConsumer(@Header("Authorization") token: String): Response<LogoutResponse>
}