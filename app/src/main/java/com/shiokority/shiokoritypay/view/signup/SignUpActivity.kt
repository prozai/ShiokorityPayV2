package com.shiokority.shiokoritypay.view.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.shiokority.shiokoritypay.R
import com.shiokority.shiokoritypay.view.authentication.login.LoginActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var tilUsername: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etUsername: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        tilUsername = findViewById(R.id.tilUsername)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvLogin = findViewById(R.id.tvLogin)
    }

    private fun setupListeners() {
        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            if (validateInput()) {
                // Perform sign up logic here
                // For now, we'll just show a toast
                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            }
        }

        tvLogin.setOnClickListener {
            // Navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun validateInput(): Boolean {
        var isValid = true

        if (etUsername.text.toString().trim().isEmpty()) {
            tilUsername.error = "Username cannot be empty"
            isValid = false
        } else {
            tilUsername.error = null
        }

        if (etEmail.text.toString().trim().isEmpty()) {
            tilEmail.error = "Email cannot be empty"
            isValid = false
        } else {
            tilEmail.error = null
        }

        if (etPassword.text.toString().trim().isEmpty()) {
            tilPassword.error = "Password cannot be empty"
            isValid = false
        } else {
            tilPassword.error = null
        }

        return isValid
    }
}