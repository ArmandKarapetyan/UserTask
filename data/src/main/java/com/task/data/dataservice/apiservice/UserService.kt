package com.task.data.dataservice.apiservice

import com.task.entities.responce.UserInfoResponse
import com.task.entities.responce.UserResponse
import retrofit2.http.*

interface UserService {

    @GET("users")
    suspend fun getUserList(): List<UserResponse>

    @GET("users/{id}")
    suspend fun getUserInfo(
        @Path("id") userLogin: String
    ): UserInfoResponse
}
