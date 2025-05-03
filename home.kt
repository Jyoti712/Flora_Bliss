package com.example.florabliss

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var countdownText: TextView
    private lateinit var birthdayButton: Button
    private lateinit var valentineSpecialButton: Button
    private lateinit var poojaEssentialsButton: Button
    private lateinit var personalizedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize UI elements
        countdownText = findViewById(R.id.countdownText)
        birthdayButton = findViewById(R.id.birthdayButton)
        valentineSpecialButton = findViewById(R.id.valentineSpecialButton)
        poojaEssentialsButton = findViewById(R.id.poojaEssentialsButton)
        personalizedButton = findViewById(R.id.personalizedButton)

        // Start countdown timer
        startCountdownTimer()

        // Set button listeners
        setButtonListeners()
    }

    private fun startCountdownTimer() {
        val timerDuration = 12 * 60 * 1000L // 12 minutes in milliseconds

        object : CountDownTimer(timerDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                countdownText.text = String.format("Sale Ends In: %02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                countdownText.text = "Sale Ended"
            }
        }.start()
    }

    private fun setButtonListeners() {
        // Navigate to Birthday Activity
        birthdayButton.setOnClickListener {
            val intent = Intent(this, BdayActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Valentine Special Activity
        valentineSpecialButton.setOnClickListener {
            val intent = Intent(this, ValentineSpecialActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Pooja Essentials Activity
        poojaEssentialsButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Personalized Activity
        personalizedButton.setOnClickListener {
            val intent = Intent(this, PersonalizedActivity::class.java)
            startActivity(intent)
        }
    }
}
