package com.example.findus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    // override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // sign out
    fun onSignOutClick(view: View) {
        getFirebaseAuth().signOut()
        updateUI()
    }
}
