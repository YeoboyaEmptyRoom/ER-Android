package com.yeoboya.presentation.view.sign_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.presentation.databinding.ActivitySignInBinding
import com.yeoboya.presentation.view.main.MainActivity
import com.yeoboya.presentation.view.sign_up.SignUpActivity
import com.yeoboya.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val signInBody = SignInRequestModel(
                email = binding.idEditText.text.toString(),
                password = binding.pwEditText.text.toString()
            )
            userViewModel.signIn(signInBody) {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }
        }

        binding.signupText.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            finish()
        }
    }
}