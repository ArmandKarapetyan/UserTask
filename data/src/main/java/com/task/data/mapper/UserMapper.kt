package com.task.data.mapper

import com.task.domain.model.UiUsers
import com.task.entities.responce.UserResponse
import org.koin.core.annotation.Single

@Single
class UserMapper : Mapper<UserResponse, UiUsers> {
    override fun transform(data: UserResponse): UiUsers =
        with(data) {
            return UiUsers(
                id ?: 0,
                login.orEmpty(),
                avatarUrl.orEmpty()
            )
        }
}
