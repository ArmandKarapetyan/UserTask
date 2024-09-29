package com.task.domain.usecases

import com.task.domain.dispatcher.CoroutineDispatcherProvider
import com.task.domain.model.UiUsers
import com.task.domain.model.UiUsersInfo
import com.task.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

interface UserInfoUseCase {
    operator fun invoke(userLogin:String): Flow<UiUsersInfo>
}

@Factory
class UserInfoUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val dispatcher: CoroutineDispatcherProvider
) : UserInfoUseCase {

    override operator fun invoke(userLogin:String): Flow<UiUsersInfo> {
        return usersRepository.getInfo(userLogin).flowOn(dispatcher.io)
    }
}
