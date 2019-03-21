package com.example.findus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    // override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    override fun onStart() {
        super.onStart()

        if (getFirebaseUser() != null) {
            updateUI()
        }
    }

    // sign up
    fun onSignUpClick(view: View) {
        if (!checkPasswordLength()) {
            showToast("Password must have 6 characters at least")
        } else {
            signUp()
        }
    }

    private fun signUp() {
        getFirebaseAuth().createUserWithEmailAndPassword(email(), password()).addOnCompleteListener(this) {
            task -> if (task.isSuccessful) {
                updateUI()
            } else {
                showToast(task.exception?.message ?: "Unknown error")
            }
        }
    }

    // sign in
    fun onSignInClick(view: View) {
        if (!checkPasswordLength()) {
            showToast("Password must have 6 characters at least")
        } else {
            signIn()
        }
    }

    private fun signIn() {
        getFirebaseAuth().signInWithEmailAndPassword(email(), password()).addOnCompleteListener(this) {
            task ->
                if (task.isSuccessful) {
                    updateUI()
                } else {
                    showToast(task.exception?.message ?: "Unknown error")
                }
        }
    }

    // helpers
    private fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    private fun email() = editTextEmail.text.toString()
    private fun password() = editTextPassword.text.toString()
    private fun checkPasswordLength() = password().length > 6
}
