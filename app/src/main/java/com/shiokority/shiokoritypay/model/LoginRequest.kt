package com.shiokority.shiokoritypay.model

import com.google.gson.annotations.SerializedName
import android.util.Patterns

data class LoginRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
) {
    fun isValid(): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches() //&& password.length >= 8
    }
}