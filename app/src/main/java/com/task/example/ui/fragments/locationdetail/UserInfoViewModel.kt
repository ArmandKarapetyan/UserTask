package com.task.example.ui.fragments.locationdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.domain.model.UiUsersInfo
import com.task.domain.usecases.UserInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserInfoViewModel(
    private val userLogin:String,
    private val userInfoUseCase: UserInfoUseCase
) : ViewModel() {

    private val _locationDetail = MutableStateFlow<UiUsersInfo?>(null)
    val locationDetail = _locationDetail.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        userInfoUseCase(userLogin).
        onEach {
            _locationDetail.value = it
        }.catch {

        }.launchIn(viewModelScope)
    }
}
