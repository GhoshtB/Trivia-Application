package com.example.triviaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.triviaapplication.database.UserDatabase
import com.example.triviaapplication.fragments.SplashFragment
import com.example.triviaapplication.viemodel.UserViewmodel

class MainActivity : AppCompatActivity() {

    lateinit var userViewmodel: UserViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewmodel= ViewModelProvider(this)[UserViewmodel::class.java]

        userViewmodel.initializeViewModel(this.application)
        launchFragment(SplashFragment(),R.id.flContainer)

    }
}