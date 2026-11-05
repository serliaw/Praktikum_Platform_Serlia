package com.serlia.praktikum_pbp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etInputMessage = findViewById<EditText>(R.id.etInputMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)

        val nameSender = intent.getStringExtra("EXTRA_SENDER")

        tvWelcome.text = getString(R.string.Welcome, nameSender)

        btnSend.setOnClickListener {
            val message = etInputMessage.text.toString().trim()
            if (message.isNotEmpty()) {
                Toast.makeText(this, "Message save: $message", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                etInputMessage.error = "Message cannot be empty!"
            }
        }
    }
}