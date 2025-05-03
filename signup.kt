package com.example.florabliss




import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class SigunUpActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.activity_sigun_up)




       val signUpButton = findViewById<Button>(R.id.signupButton)
       signUpButton.setOnClickListener {
           // Displaying a Toast message
           Toast.makeText(this, "Navigating to Login", Toast.LENGTH_SHORT).show()




           // Intent to navigate to LoginActivity
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
       }
   }
}

