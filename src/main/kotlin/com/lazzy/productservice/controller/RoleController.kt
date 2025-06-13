package com.lazzy.productservice.controller

import com.lazzy.productservice.domain.dto.response.ResGetAllRoleDto
import com.lazzy.productservice.service.MasterRoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/role")
class RoleController(
    private val masterRoleService: MasterRoleService
) {

    @GetMapping("/all")
    fun getAllRoles(): ResponseEntity<List<ResGetAllRoleDto>> {
        return ResponseEntity.ok(
            masterRoleService.getAllRoles()
        )
    }
}