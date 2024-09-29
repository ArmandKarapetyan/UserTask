package com.task.data.mapper

import com.task.domain.model.UiUsersInfo
import com.task.entities.responce.UserInfoResponse
import org.koin.core.annotation.Single

@Single
class UserInfoMapper : Mapper<UserInfoResponse, UiUsersInfo> {
    override fun transform(data: UserInfoResponse): UiUsersInfo =
        with(data) {
            return UiUsersInfo(
                id ?: 0,
                name.orEmpty(),
                avatarUrl.orEmpty(),
                location.orEmpty(),
                followers ?: 0,
                following ?: 0,
                bio.orEmpty(),
                publicRepos ?: 0,
                publicGists ?: 0,
                updatedAt.orEmpty(),
            )
        }
}
