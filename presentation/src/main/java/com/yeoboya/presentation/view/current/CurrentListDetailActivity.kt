package com.yeoboya.presentation.view.current

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.ActivityCurrentListDetailBinding
import com.yeoboya.presentation.view.main.MainActivity
import com.yeoboya.presentation.view.map.MapDetailActivity
import com.yeoboya.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentListDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCurrentListDetailBinding
    private val mainViewModel by viewModels<MainViewModel>()

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
        mainViewModel.getDetail(intent.getIntExtra("id", 0)) {
            Glide.with(this).load(intent.getIntExtra("roomImage", R.drawable.home)).into(binding.horizontalCurrentImage1)
            binding.moneyText.text = "${it.rent_type} ${it.price}"
            binding.priceText.text = "${it.rent_type} ${it.price}"
            binding.rulerText.text = "${it.size.toInt()}평"
            binding.roomText.text = it.room_type
            binding.floorText.text = "${it.floor}층"
            binding.locationText.text = it.location
            binding.managementText.text = "관리비 ${it.maintenance_fee}원"
            binding.packingText.text = "주차비 ${it.parking_fee}원"
            binding.detailText.text = it.description
        }
    }
}