package com.yeoboya.presentation.view.map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.yeoboya.domain.model.main.CurrentRoomModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.adapter.current_room_recyclerview.CurrentRoomRecyclerViewAdapter
import com.yeoboya.presentation.databinding.ActivityMapDetailBinding
import com.yeoboya.presentation.view.current.CurrentListDetailActivity
import com.yeoboya.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapDetailBinding
    private val mainViewModel by viewModels<MainViewModel>()
    private var check = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getRooms { rooms ->
            val roomsList = rooms.map {
                CurrentRoomModel(
                    roomImage = R.drawable.room,
                    roomPrice = "${it.rent_type} ${it.price}",
                    roomWidthHeight = "${it.area}m^2",
                    roomLocation = it.location,
                    roomType = it.room_type
                )
            }
            initRecyclerView(roomsList)
        }

        binding.mapDetailBackArrow.setOnClickListener {
            startActivity(Intent(this@MapDetailActivity, MapActivity::class.java))
        }

        binding.filter.setOnClickListener {
            binding.monthlyText.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.charterText.setTextColor(ContextCompat.getColor(this, R.color.black))

            val layoutParams = binding.mapCurrentRoomList.layoutParams as ConstraintLayout.LayoutParams
            if (check) {
                binding.mapCurrentIntroText.visibility = View.GONE
                binding.filterContent.visibility = View.VISIBLE
                layoutParams.topToBottom = R.id.filterContent
                check = false
            } else {
                binding.mapCurrentIntroText.visibility = View.VISIBLE
                binding.filterContent.visibility = View.GONE
                layoutParams.topToBottom = R.id.map_current_intro_text
                check = true
            }

            mainViewModel.getRooms { rooms ->
                val roomsList = rooms.map {
                    CurrentRoomModel(
                        roomImage = R.drawable.room,
                        roomPrice = "${it.rent_type} ${it.price}",
                        roomWidthHeight = "${it.area}m^2",
                        roomLocation = it.location,
                        roomType = it.room_type
                    )
                }
                initRecyclerView(roomsList)
            }
        }

        binding.monthlyText.setOnClickListener {
            binding.monthlyText.setTextColor(ContextCompat.getColor(this, R.color.P1))
            binding.charterText.setTextColor(ContextCompat.getColor(this, R.color.black))

            mainViewModel.getMonthlyRooms { rooms ->
                val roomsList = rooms.map {
                    CurrentRoomModel(
                        roomImage = R.drawable.room,
                        roomPrice = "${it.rent_type} ${it.price}",
                        roomWidthHeight = "${it.area}m^2",
                        roomLocation = it.location,
                        roomType = it.room_type
                    )
                }
                initRecyclerView(roomsList)
            }
        }

        binding.charterText.setOnClickListener {
            binding.monthlyText.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.charterText.setTextColor(ContextCompat.getColor(this, R.color.P1))

            mainViewModel.getLeaseRooms { rooms ->
                val roomsList = rooms.map {
                    CurrentRoomModel(
                        roomImage = R.drawable.room,
                        roomPrice = "${it.rent_type} ${it.price}",
                        roomWidthHeight = "${it.area}m^2",
                        roomLocation = it.location,
                        roomType = it.room_type
                    )
                }
                initRecyclerView(roomsList)
            }
        }

    }

    private fun initRecyclerView(list: List<CurrentRoomModel>) {
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
                intent.putExtra("beforePage", "MapDetail")
                intent.putExtra("id", position + 1)
                startActivity(intent)
            }
        }
    }
}