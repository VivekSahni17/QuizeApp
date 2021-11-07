package com.viveksahani.quizeappeee.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.viveksahani.quizeappeee.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.editTextTextEmailAddress
import kotlinx.android.synthetic.main.activity_login.editTextTextPassword
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        firebaseAuth = FirebaseAuth.getInstance()

        btnsignup.setOnClickListener {
            viveksignup()
        }
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun viveksignup() {
        val email: String = editTextTextEmailAddress.text.toString()
        val passwordAuthentication: String = editTextTextPassword.text.toString()
        val confirmPasswordAuthentication: String = editTextconfirmPassword.text.toString()

        if (email.isBlank() || passwordAuthentication.isBlank() || confirmPasswordAuthentication.isBlank()) {
            Toast.makeText(this, "Email And Password Can't be Blank", Toast.LENGTH_SHORT).show()
        }

        firebaseAuth.createUserWithEmailAndPassword(email, passwordAuthentication)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error creating user.", Toast.LENGTH_SHORT).show()


                }


            }


    }
}