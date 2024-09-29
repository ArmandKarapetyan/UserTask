package com.task.domain.usecases

import com.task.domain.dispatcher.CoroutineDispatcherProvider
import com.task.domain.model.UiUsers
import com.task.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

interface UsersUseCase {
    operator fun invoke(): Flow<List<UiUsers>>
}

@Factory
internal class UsersUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val dispatcher: CoroutineDispatcherProvider
) : UsersUseCase {

    override operator fun invoke(): Flow<List<UiUsers>> {
        return usersRepository.getUsers().flowOn(dispatcher.io)
    }
}
