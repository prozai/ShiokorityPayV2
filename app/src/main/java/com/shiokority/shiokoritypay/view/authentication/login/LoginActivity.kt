package com.shiokority.shiokoritypay.view.authentication.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shiokority.shiokoritypay.R
import com.shiokority.shiokoritypay.view.dashboard.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonTogglePassword: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonTogglePassword = findViewById(R.id.buttonTogglePassword)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Here you would typically validate the credentials against a database or API
                // For this example, we'll just check if they're not empty
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }

        buttonTogglePassword.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    private fun togglePasswordVisibility() {
        val isPasswordVisible = editTextPassword.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

        editTextPassword.inputType = if (isPasswordVisible) {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        } else {
            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        buttonTogglePassword.setImageResource(
            if (isPasswordVisible) R.drawable.ic_visibility_off else R.drawable.ic_visibility_on
        )

        editTextPassword.setSelection(editTextPassword.text.length)
    }
}