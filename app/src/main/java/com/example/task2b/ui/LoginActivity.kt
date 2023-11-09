package com.example.task2b.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.task2b.R
import com.example.task2b.sharedpreference

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    private lateinit var sharedPreferences: sharedpreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.login)

        sharedPreferences = sharedpreference(this)

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
            sharedPreferences.saveString("email", email)
            sharedPreferences.saveString("password", password)

            val intent = Intent(this, PutproductActivity::class.java)
            startActivity(intent)
            finish()
        }
    }




}