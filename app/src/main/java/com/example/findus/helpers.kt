package com.example.findus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


fun getFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()
fun getFirebaseUser(): FirebaseUser? = getFirebaseAuth().currentUser

fun AppCompatActivity.updateUI() {
    when (getFirebaseUser()) {
        null -> startActivity(Intent(this, SignInActivity::class.java))
        else -> startActivity(Intent(this, MainActivity::class.java))
    }
}
