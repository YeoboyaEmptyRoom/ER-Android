package com.yeoboya.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeoboya.domain.model.main.MainResponseModel
import com.yeoboya.domain.usecase.main.GetLeaseRoomsUseCase
import com.yeoboya.domain.usecase.main.GetMonthlyRoomsUseCase
import com.yeoboya.domain.usecase.main.GetRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase,
    private val getMonthlyRoomsUseCase: GetMonthlyRoomsUseCase,
    private val getLeaseRoomsUseCase: GetLeaseRoomsUseCase
): ViewModel() {
    fun getRooms(changeListData: (List<MainResponseModel>) -> Unit) {
        viewModelScope.launch {
            getRoomsUseCase()
                .onSuccess {
                    changeListData(it)
                    Log.d("TAG", "getRooms: $it")
                }
                .onFailure {
                    Log.d("TAG", "getRooms Failure ${it.message}")
                }
        }
    }

    fun getMonthlyRooms(changeListData: (List<MainResponseModel>) -> Unit) {
        viewModelScope.launch {
            getMonthlyRoomsUseCase()
                .onSuccess {
                    changeListData(it)
                    Log.d("TAG", "getMonthlyRooms: $it")
                }
                .onFailure {
                    Log.d("TAG", "getMonthlyRooms Failure ${it.message}")
                }
        }
    }

    fun getLeaseRooms(changeListData: (List<MainResponseModel>) -> Unit) {
        viewModelScope.launch {
            getLeaseRoomsUseCase()
                .onSuccess {
                    changeListData(it)
                    Log.d("TAG", "getLeaseRooms: $it")
                }
                .onFailure {
                    Log.d("TAG", "getLeaseRooms Failure ${it.message}")
                }
        }
    }
}