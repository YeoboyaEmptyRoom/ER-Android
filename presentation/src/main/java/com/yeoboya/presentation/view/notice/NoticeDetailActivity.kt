package com.yeoboya.presentation.view.notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.ActivityNoticeDetailBinding

class NoticeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailBackArrow.setOnClickListener {
            startActivity(Intent(this@NoticeDetailActivity, NoticeActivity::class.java))
            finish()
        }

        initLoading()
    }

    fun initLoading() {
        binding.detailTitle.text = intent.getStringExtra("title")
        binding.detailWriteDate.text = intent.getStringExtra("writeDate")
        binding.detailDescription.text = intent.getStringExtra("description")
    }
}