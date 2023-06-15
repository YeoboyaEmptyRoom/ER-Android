package com.yeoboya.presentation.view.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.FragmentIdBinding

class IdFragment : Fragment() {

    private lateinit var binding: FragmentIdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIdBinding.inflate(layoutInflater)

        binding.nextButton.setOnClickListener {
            val signUpActivity = activity as SignUpActivity
        }

        return binding.root
    }
}