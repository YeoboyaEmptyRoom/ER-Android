package com.yeoboya.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.presentation.R
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
}