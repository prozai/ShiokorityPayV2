package com.shiokority.shiokoritypay.view.authentication.login

import com.shiokority.shiokoritypay.model.LoginResponse
import com.shiokority.shiokoritypay.model.LoginRequest
import com.shiokority.shiokoritypay.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ConsumerAuthentication {
    private val apiService = RetrofitClient.consumerApiService

    suspend fun authenticateConsumer(email: String, password: String): LoginResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.loginConsumer(LoginRequest(email, password))
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse?.success == true) {
                        // Save user data
                        loginResponse.email?.let { saveUserEmail(it) }
                        loginResponse.token?.let { saveUserToken(it) }
                    }
                    loginResponse
                } else {
                    LoginResponse(false, "Authentication failed: ${response.code()}", null, null)
                }
            } catch (e: Exception) {
                LoginResponse(false, "Network error: ${e.message}", null, null)
            }
        }
    }

    private fun saveUserEmail(email: String) {
        // TODO: Implement this to save the user's email
        // For example, using SharedPreferences:
        // PreferenceManager.getDefaultSharedPreferences(context).edit().putString("user_email", email).apply()
    }

    private fun saveUserToken(token: String) {
        // TODO: Implement this to save the user's token
        // For example, using SharedPreferences:
        // PreferenceManager.getDefaultSharedPreferences(context).edit().putString("user_token", token).apply()
    }
}