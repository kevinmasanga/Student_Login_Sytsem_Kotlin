package com.example.studentloginsystem

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etRegNumber = findViewById<TextInputEditText>(R.id.etRegNumber)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val regNumber = etRegNumber.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            if (username.isEmpty() || regNumber.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Successful submission! Welcome, $username", Toast.LENGTH_LONG).show()
            }
        }
    }
}