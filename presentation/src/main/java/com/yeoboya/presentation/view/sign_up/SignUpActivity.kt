package com.yeoboya.presentation.view.sign_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.ActivitySignUpBinding
import com.yeoboya.presentation.view.sign_in.SignInActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val idFragment = IdFragment()

        fragmentTransaction.replace(R.id.fragment_container, idFragment)
        fragmentTransaction.commit()

        binding.backArrow.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }
    }
}