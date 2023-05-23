package com.yeoboya.presentation.adapter.current_room_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeoboya.domain.model.CurrentRoomModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.ActivityMainBinding

class CurrentRoomRecyclerViewAdapter(var itemList: List<CurrentRoomModel>): RecyclerView.Adapter<CurrentRoomRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemVIew: View): RecyclerView.ViewHolder(itemVIew) {
        val roomImage = itemVIew.findViewById<ImageView>(R.id.room_image)
        val roomPrice = itemVIew.findViewById<TextView>(R.id.room_price)
        val roomWidthHeight = itemVIew.findViewById<TextView>(R.id.room_width_height)
        val roomLocation = itemVIew.findViewById<TextView>(R.id.room_location)
        val roomType = itemVIew.findViewById<TextView>(R.id.room_type)

        fun bind(item: CurrentRoomModel) {
            Glide.with(itemView).load(item.roomImage).into(roomImage)
            roomPrice.text = item.roomPrice
            roomWidthHeight.text = item.roomWidthHeight
            roomLocation.text = item.roomLocation
            roomType.text = item.roomType
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.current_room_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])
}