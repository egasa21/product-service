package com.lazzy.productservice.controller

import com.lazzy.productservice.domain.dto.request.ReqRegisterDto
import com.lazzy.productservice.domain.dto.response.BaseResponse
import com.lazzy.productservice.domain.dto.response.ResGetUserDto
import com.lazzy.productservice.service.MasterUserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val masterUserService: MasterUserService
) {
    @GetMapping("/active")
    fun getAllActiveUsers(): ResponseEntity<BaseResponse<List<ResGetUserDto>>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterUserService.   findAllActiveUsers()
            )
        )
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<ResGetUserDto>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterUserService.findUserById(id)
            )
        )
    }

    @PostMapping("/register")
    fun registerUser(
        @Valid @RequestBody req: ReqRegisterDto
    ): ResponseEntity<BaseResponse<ResGetUserDto>> {
        return ResponseEntity(
            BaseResponse(
                data = masterUserService.register(req)
            ),
            HttpStatus.CREATED
        )
    }
}