package com.yeoboya.presentation.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.usecase.user.LogoutUseCase
import com.yeoboya.domain.usecase.user.SignInUseCase
import com.yeoboya.domain.usecase.user.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val application: Application
): AndroidViewModel(application) {
    fun signIn(
        body: SignInRequestModel,
        moveToMain: () -> Unit
    ) {
        viewModelScope.launch {
            signInUseCase(body)
                .onSuccess {
                    Log.d("TAG", "signIn Success: $it")
                    moveToMain()
                }
                .onFailure {
                    Log.d("TAG", "signIn Failure: ${it.message}")
                    Toast.makeText(application, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    fun signUp(
        body: SignUpRequestModel,
        moveToSignIn: () -> Unit
    ) {
        viewModelScope.launch {
            signUpUseCase(body)
                .onSuccess {
                    Log.d("TAG", "signUp Success: $it")
                    moveToSignIn
                }
                .onFailure {
                    Log.d("TAG", "signUp Failure: ${it.message}")
                    Toast.makeText(application, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            logoutUseCase()
                .onSuccess {
                    Log.d("TAG", "logout: $it")
                }
                .onFailure {
                    Log.d("TAG", "logout: ${it.message}")
                }
        }
    }
}