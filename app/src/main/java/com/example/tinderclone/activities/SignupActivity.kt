package com.example.tinderclone.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tinderclone.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*
import android.widget.Toast
import com.example.tinderclone.Util.DATA_USERS
import com.example.tinderclone.Util.User
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private val firebaseDatabase = FirebaseDatabase.getInstance().reference
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseAuthListener = FirebaseAuth.AuthStateListener {
        val user = firebaseAuth.currentUser
        if (user != null) {
            startActivity(MainActivity.newIntent(this))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }

    fun onSignup(v: View) {
        if (!emailET.text.toString().isNullOrEmpty() && !passwordET.text.toString().isNullOrEmpty()) {
            firebaseAuth.createUserWithEmailAndPassword(
                emailET.text.toString(),
                passwordET.text.toString()
            )
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Signup Error! ${task.exception?.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val email = emailET.text.toString()
                        val userId = firebaseAuth.currentUser?.uid ?: ""
                        val user = User(userId, "", "", email, "", "", "")
                        firebaseDatabase.child(DATA_USERS).child(userId).setValue(user)
                    }
                }
        }
    }

    //Static function in Kotlin
    companion object {
        fun newIntent(context: Context?) = Intent(context, SignupActivity::class.java)
    }
}
