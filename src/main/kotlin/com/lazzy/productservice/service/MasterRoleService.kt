package com.lazzy.productservice.service

import com.lazzy.productservice.domain.dto.response.ResGetAllRoleDto

interface MasterRoleService {
    fun getAllRoles(): List<ResGetAllRoleDto>
}