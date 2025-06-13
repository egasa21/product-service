package com.lazzy.productservice.domain.dto.response

data class ResGetUserDto(
    val id: Int,
    val email: String,
    val username: String,
    var roleId: Int? = null,
    var roleName: String? = null,
)