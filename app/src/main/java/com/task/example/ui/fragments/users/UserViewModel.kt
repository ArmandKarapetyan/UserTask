package com.task.example.ui.fragments.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.domain.model.UiUsers
import com.task.domain.usecases.UsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserViewModel(
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<UiUsers>?>(null)
    val users: StateFlow<List<UiUsers>?> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        usersUseCase().onEach {
            _users.value = it
        }.catch {

        }.launchIn(viewModelScope)
    }

}
