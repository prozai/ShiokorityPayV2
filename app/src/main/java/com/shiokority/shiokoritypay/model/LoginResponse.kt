package com.shiokority.shiokoritypay.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String?
)