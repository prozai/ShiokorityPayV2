package com.shiokority.shiokoritypay.view.authentication.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.shiokority.shiokoritypay.R
import com.shiokority.shiokoritypay.view.signup.SignUpActivity
import com.shiokority.shiokoritypay.view.dashboard.MainActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonTogglePassword: ImageButton
    private lateinit var signUp: TextView
    private lateinit var consumerAuthentication: ConsumerAuthentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        consumerAuthentication = ConsumerAuthentication()

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonTogglePassword = findViewById(R.id.buttonTogglePassword)
        signUp = findViewById(R.id.signUp)

        buttonLogin.setOnClickListener {
            val email = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    val result = consumerAuthentication.authenticateConsumer(email, password)
                    if (result != null) {
                        if (result.success) {
                            Toast.makeText(this@LoginActivity, "Login successful: ${result.message}", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login failed: ${result.message}", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Login failed: Unknown error", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
        }

        buttonTogglePassword.setOnClickListener {
            togglePasswordVisibility()
        }

        signUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
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