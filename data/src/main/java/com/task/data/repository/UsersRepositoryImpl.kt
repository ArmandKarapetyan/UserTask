package com.task.data.repository

import com.task.data.dataservice.apiservice.UserService
import com.task.data.mapper.UserInfoMapper
import com.task.data.mapper.UserMapper
import com.task.data.util.emitFlow
import com.task.domain.model.UiUsers
import com.task.domain.model.UiUsersInfo
import com.task.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single
class UsersRepositoryImpl(
    private val userService: UserService,
    private val infoMapper: UserInfoMapper,
    private val mapper: UserMapper
) : UsersRepository {

    override fun getUsers(): Flow<List<UiUsers>> = emitFlow {
        userService.getUserList().map {
            mapper.transform(it)
        }
    }

    override fun getInfo(userLogin: String): Flow<UiUsersInfo> = emitFlow {
        val userInfo = userService.getUserInfo(userLogin)
        infoMapper.transform(userInfo)
    }
}