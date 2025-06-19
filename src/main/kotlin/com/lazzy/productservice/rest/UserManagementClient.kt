package com.lazzy.productservice.rest

import com.lazzy.productservice.domain.dto.response.BaseResponse
import com.lazzy.productservice.domain.dto.response.ResGetUserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "user-service",
    path = "/user-service"
)
interface UserManagementClient {
    @GetMapping("/v1/users/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<ResGetUserDto>>

    @GetMapping("/users")
    fun getUsersByIds(
        @RequestParam("ids", required = true) ids: List<Int>
    ): ResponseEntity<BaseResponse<List<ResGetUserDto>>?>
}