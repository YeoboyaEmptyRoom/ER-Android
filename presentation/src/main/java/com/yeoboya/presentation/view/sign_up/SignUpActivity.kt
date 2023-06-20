package com.yeoboya.presentation.view.sign_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.presentation.databinding.ActivitySignUpBinding
import com.yeoboya.presentation.view.sign_in.SignInActivity
import com.yeoboya.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            finish()
        }

        binding.signupButton.setOnClickListener {
            val signUpRequestModel = SignUpRequestModel(
                email = binding.emailEditText.text.toString(),
                username = binding.idEditText.text.toString(),
                password = binding.passwordEditText.text.toString(),
                password_confirm = binding.passwordCheckEditText.text.toString()
            )
            userViewModel.signUp(signUpRequestModel) {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                finish()
            }
        }

    }
}