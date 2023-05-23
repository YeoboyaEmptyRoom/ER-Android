package com.yeoboya.presentation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.domain.model.CurrentRoomModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.adapter.current_room_recyclerview.CurrentRoomRecyclerViewAdapter
import com.yeoboya.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val list = mutableListOf<CurrentRoomModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            CurrentRoomModel(
                roomImage = R.drawable.apartment,
                roomPrice = "전세 3억 4000",
                roomWidthHeight = "42.14m^2, 8층",
                roomLocation = "구리구 구리동",
                roomType = "아파트"
            )
        )
        list.add(
            CurrentRoomModel(
                roomImage = R.drawable.home,
                roomPrice = "전세 1억 4000",
                roomWidthHeight = "22.14m^2, 3층",
                roomLocation = "구리구 구리동",
                roomType = "원룸"
            )
        )
        list.add(
            CurrentRoomModel(
                roomImage = R.drawable.two_home,
                roomPrice = "월세 100/4000",
                roomWidthHeight = "42.14m^2, 8층",
                roomLocation = "광산구 송정동",
                roomType = "투룸+"
            )
        )
        list.add(
            CurrentRoomModel(
                roomImage = R.drawable.officetels,
                roomPrice = "전세 2억 5000",
                roomWidthHeight = "35.22m^2, 10층",
                roomLocation = "남구 대촌동",
                roomType = "오피스텔"
            )
        )
        list.add(
            CurrentRoomModel(
                roomImage = R.drawable.apartment,
                roomPrice = "전세 3억 4000",
                roomWidthHeight = "42.14m^2, 8층",
                roomLocation = "구리구 구리동",
                roomType = "아파트"
            )
        )

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = CurrentRoomRecyclerViewAdapter(list)
        binding.currentRoomList.adapter = adapter
        adapter.itemList = list
        adapter.notifyDataSetChanged()
    }

}
