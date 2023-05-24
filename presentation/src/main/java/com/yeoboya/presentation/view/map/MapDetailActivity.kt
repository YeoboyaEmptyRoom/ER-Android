package com.yeoboya.presentation.view.map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.domain.model.main.CurrentRoomModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.adapter.current_room_recyclerview.CurrentRoomRecyclerViewAdapter
import com.yeoboya.presentation.databinding.ActivityMapDetailBinding
import com.yeoboya.presentation.view.current.CurrentListDetailActivity

class MapDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapDetailBinding
    val list = mutableListOf<CurrentRoomModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapDetailBinding.inflate(layoutInflater)
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

        binding.mapDetailBackArrow.setOnClickListener {
            startActivity(Intent(this@MapDetailActivity, MapActivity::class.java))
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = CurrentRoomRecyclerViewAdapter(list)
        binding.mapCurrentRoomList.adapter = adapter
        adapter.itemList = list
        adapter.notifyDataSetChanged()

        adapter.itemClickListener = object : CurrentRoomRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                super.onItemClick(position)
                val item = list[position]
                val intent = Intent(this@MapDetailActivity, CurrentListDetailActivity::class.java)
                intent.putExtra("roomImage", item.roomImage)
                intent.putExtra("roomPrice", item.roomPrice)
                intent.putExtra("roomWidthHeight", item.roomWidthHeight)
                intent.putExtra("roomLocation", item.roomLocation)
                intent.putExtra("roomType", item.roomType)
                startActivity(intent)
            }
        }
    }
}