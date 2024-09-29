package com.task.domain.model

data class UiUsersInfo(
    val id: Int,
    val fullName: String,
    val avatarUrl : String,
    val location: String,
    val followers: Int,
    val following: Int,
    val bio : String,
    val publicRepo : Int,
    val publicGists : Int,
    val updateAt : String
)
