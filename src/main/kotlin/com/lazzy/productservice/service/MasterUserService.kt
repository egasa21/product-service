package com.lazzy.productservice.service

import com.lazzy.productservice.domain.dto.request.ReqLoginDto
import com.lazzy.productservice.domain.dto.request.ReqRegisterDto
import com.lazzy.productservice.domain.dto.response.ResGetUserDto
import com.lazzy.productservice.domain.dto.response.ResLoginDto


//todo: get user by id
interface MasterUserService {
    fun findAllActiveUsers(): List<ResGetUserDto>
    fun findUserById(id: Int): ResGetUserDto?
    fun register(req: ReqRegisterDto): ResGetUserDto
    fun login(req: ReqLoginDto): ResLoginDto
}