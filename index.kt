package com.example.florabliss




import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.florabliss.LoginActivity
import com.example.florabliss.SigunUpActivity
import com.example.florabliss.R




class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)




       val loginButton: Button = findViewById(R.id.loginButton)
       val signupButton: Button = findViewById(R.id.signupButton)




       loginButton.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
           Toast.makeText(this, "Navigating to Login", Toast.LENGTH_SHORT).show()
       }




       signupButton.setOnClickListener {
           val intent = Intent(this, SigunUpActivity::class.java)
           startActivity(intent)
           Toast.makeText(this, "Navigating to Sign Up", Toast.LENGTH_SHORT).show()
       }
   }
}
