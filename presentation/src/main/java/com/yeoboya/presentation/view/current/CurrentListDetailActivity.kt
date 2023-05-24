package com.yeoboya.presentation.view.current

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.presentation.databinding.ActivityCurrentListDetailBinding
import com.yeoboya.presentation.view.main.MainActivity
import com.yeoboya.presentation.view.map.MapDetailActivity

class CurrentListDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCurrentListDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentListDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLoading()

        binding.currentListDetailBackArrow.setOnClickListener {
            when (intent.getStringExtra("beforePage")) {
                "Main" -> startActivity(Intent(this@CurrentListDetailActivity, MainActivity::class.java))
                "MapDetail" -> startActivity(Intent(this@CurrentListDetailActivity, MapDetailActivity::class.java))
            }
        }
    }

    fun initLoading() {
        binding.moneyText.text = intent.getStringExtra("roomPrice")
        binding.priceText.text = intent.getStringExtra("roomPrice")
        binding.rulerText.text = intent.getStringExtra("roomWidthHeight")
        binding.roomText.text = intent.getStringExtra("roomType")
        binding.floorText.text = intent.getStringExtra("roomWidthHeight")
        binding.locationText.text = intent.getStringExtra("roomLocation")
    }
}