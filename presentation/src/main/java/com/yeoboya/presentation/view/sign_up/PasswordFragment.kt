package com.yeoboya.presentation.view.sign_up

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.FragmentPasswordBinding
import com.yeoboya.presentation.view.sign_in.SignInActivity

class PasswordFragment : Fragment() {

    private lateinit var binding: FragmentPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordBinding.inflate(layoutInflater)

        binding.signupButton.setOnClickListener {
            startActivity(Intent(context, SignInActivity::class.java))
        }

        return binding.root
    }

}