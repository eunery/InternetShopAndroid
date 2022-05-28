package com.example.internetshopandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internetshopandroid.ui.fragments.LoginFragment
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}