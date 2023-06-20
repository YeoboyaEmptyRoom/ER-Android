package com.yeoboya.presentation.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yeoboya.domain.model.main.CurrentRoomModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.adapter.current_room_recyclerview.CurrentRoomRecyclerViewAdapter
import com.yeoboya.presentation.databinding.ActivityMainBinding
import com.yeoboya.presentation.view.current.CurrentListDetailActivity
import com.yeoboya.presentation.view.map.MapActivity
import com.yeoboya.presentation.view.notice.NoticeActivity
import com.yeoboya.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CurrentRoomRecyclerViewAdapter
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getRooms { rooms ->
            val roomsList = rooms.map {
                CurrentRoomModel(
                    roomImage = R.drawable.room,
                    roomPrice = "${it.rent_type} ${it.price}",
                    roomWidthHeight = "${it.area}m^2",
                    roomLocation = it.location,
                    roomType = it.room_type,
                    id = it.id
                )
            }
            initRecyclerView(roomsList)
        }

        binding.announcement.setOnClickListener {
            startActivity(Intent(this@MainActivity, NoticeActivity::class.java))
        }

        binding.wantOneRoom.setOnClickListener {
            startActivity(Intent(this@MainActivity, MapActivity::class.java))
        }
        binding.wantTwoRoom.setOnClickListener {
            startActivity(Intent(this@MainActivity, MapActivity::class.java))
        }
        binding.wantOfficetels.setOnClickListener {
            startActivity(Intent(this@MainActivity, MapActivity::class.java))
        }
        binding.wantApartment.setOnClickListener {
            startActivity(Intent(this@MainActivity, MapActivity::class.java))
        }
    }

    private fun initRecyclerView(
        list: List<CurrentRoomModel>
    ) {
        adapter = CurrentRoomRecyclerViewAdapter(list)
        adapter.itemList = list
        binding.currentRoomList.adapter = adapter
        adapter.notifyDataSetChanged()

        adapter.itemClickListener = object : CurrentRoomRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                super.onItemClick(position)
                val item = list[position]
                val intent = Intent(this@MainActivity, CurrentListDetailActivity::class.java)
                intent.putExtra("roomImage", item.roomImage)
                intent.putExtra("beforePage", "Main")
                intent.putExtra("id", item.id)
                startActivity(intent)
            }
        }
    }
}
