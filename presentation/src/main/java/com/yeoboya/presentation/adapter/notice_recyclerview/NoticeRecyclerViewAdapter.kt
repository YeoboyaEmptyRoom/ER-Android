package com.yeoboya.presentation.adapter.notice_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeoboya.domain.model.notice.NoticeModel
import com.yeoboya.presentation.R
import com.yeoboya.presentation.databinding.NoticeListItemBinding

class NoticeRecyclerViewAdapter(var itemList: List<NoticeModel>): RecyclerView.Adapter<NoticeRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = NoticeListItemBinding.bind(itemView)

        val title = binding.title
        val writeDate = binding.writeDate
        val description = binding.description

        fun bind(item: NoticeModel) {
            title.text = item.title
            writeDate.text = item.writeDate
            description.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notice_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

}