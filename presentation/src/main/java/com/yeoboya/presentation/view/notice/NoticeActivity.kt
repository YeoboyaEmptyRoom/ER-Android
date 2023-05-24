package com.yeoboya.presentation.view.notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeoboya.domain.model.notice.NoticeModel
import com.yeoboya.presentation.adapter.notice_recyclerview.NoticeRecyclerViewAdapter
import com.yeoboya.presentation.databinding.ActivityNoticeBinding

class NoticeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoticeBinding
    val list = mutableListOf<NoticeModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            NoticeModel(
                title = "제목1",
                writeDate = "2023.05.24",
                description = "공지사항 입니다. 공지사항입니다. 공지사항입니다"
            )
        )
        list.add(
            NoticeModel(
                title = "제목2",
                writeDate = "2023.05.21",
                description = "공지사항 입니다. 공지사항입니다. 공지사항입니다. 공지사항 입니다. 공지사항입니다. 공지사항입니다"
            )
        )
        list.add(
            NoticeModel(
                title = "제목3",
                writeDate = "2023.05.22",
                description = "제목3 내용입니다."
            )
        )
        list.add(
            NoticeModel(
                title = "제목4",
                writeDate = "2023.05.24",
                description = "공지사항을 개발하고있습니다. 공지사항을 개발하고있습니다. 공지사항을 개발하고있습니다. 공지사항을 개발하고있습니다. 공지사항을 개발하고있습니다."
            )
        )
        list.add(
            NoticeModel(
                title = "제목5",
                writeDate = "2023.05.23",
                description = "제목5 내용입니다 \n 제목5 내용입니다. 제목5 내용입니다."
            )
        )
        list.add(
            NoticeModel(
                title = "제목6",
                writeDate = "2023.05.20",
                description = ""
            )
        )
        list.add(
            NoticeModel(
                title = "제목7",
                writeDate = "2023.05.19",
                description = "빈 방 서비스입니다.\n 오래 기다려주셔서 감사합니다."
            )
        )
        list.add(
            NoticeModel(
                title = "제목8",
                writeDate = "2023.04.24",
                description = "안녕하세요 빈 방 서비스입니다."
            )
        )
        list.add(
            NoticeModel(
                title = "제목9",
                writeDate = "2023.05.21",
                description = "내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용"
            )
        )
        list.add(
            NoticeModel(
                title = "제목10",
                writeDate = "2023.03.10",
                description = "제목 10 입니다."
            )
        )

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = NoticeRecyclerViewAdapter(list)
        binding.noticeRecyclerview.adapter = adapter
        adapter.itemList = list
        adapter.notifyDataSetChanged()

        adapter.itemClickListener = object : NoticeRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                super.onItemClick(position)
                val item = list[position]
                val intent = Intent(this@NoticeActivity, NoticeDetailActivity::class.java)
                intent.putExtra("title", item.title)
                intent.putExtra("writeDate", item.writeDate)
                intent.putExtra("description", item.description)
                startActivity(intent)
            }
        }
    }
}