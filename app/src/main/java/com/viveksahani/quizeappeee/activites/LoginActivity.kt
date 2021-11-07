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

class LoginActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        buttonLogin.setOnClickListener{
            viveklogin()
        }
        btnsignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

    private fun  viveklogin(){
        val email:String = editTextTextEmailAddress.text.toString()
        val passwordAuthentication:String = editTextTextPassword.text.toString()

        if (email.isBlank() || passwordAuthentication.isBlank()){
            Toast.makeText(this,"Email/Password Cannot Be Empty",Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,passwordAuthentication).addOnCompleteListener (this){
            if(it.isSuccessful){
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Authentication Failled",Toast.LENGTH_SHORT).show()
            }
        }

    }


}