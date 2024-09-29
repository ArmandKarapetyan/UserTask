package com.task.domain.repository

import com.task.domain.model.UiUsers
import com.task.domain.model.UiUsersInfo
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsers(): Flow<List<UiUsers>>
    fun getInfo(userLogin:String): Flow<UiUsersInfo>
}
