package com.example.florabliss




import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class LoginActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.activity_login)




       val fname = findViewById<TextView>(R.id.editTextName)
       val email = findViewById<TextView>(R.id.editTextEmail)
       val pass = findViewById<TextView>(R.id.editTextPassword)




       val signUpButton = findViewById<Button>(R.id.loginButton)
       signUpButton.setOnClickListener {




           val fullname = fname.text.toString()
           val password = pass.text.toString()




           if (fullname.isNotEmpty() && password.isNotEmpty()) {
               Toast.makeText(this, "Login Successful",




                   Toast.LENGTH_SHORT).show()




               val intent = Intent(this, HomeActivity::class.java)
               startActivity(intent)
           } else {
               Toast.makeText(
                   this, "Please fill all fields",




                   Toast.LENGTH_SHORT
               ).show()




           }
       }
   }
}
