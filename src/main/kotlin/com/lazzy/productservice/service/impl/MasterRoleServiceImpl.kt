package com.lazzy.productservice.service.impl

import com.lazzy.productservice.domain.dto.response.ResGetAllRoleDto
import com.lazzy.productservice.repository.MasterRoleRepository
import com.lazzy.productservice.service.MasterRoleService
import org.springframework.stereotype.Service

@Service
class MasterRoleServiceImpl(
    private val masterRoleRepository: MasterRoleRepository
) : MasterRoleService {
    override fun getAllRoles(): List<ResGetAllRoleDto> {
        val rawRole = masterRoleRepository.findAll()
        val result = mutableListOf<ResGetAllRoleDto>()
        rawRole.forEach {
            result.add(
                ResGetAllRoleDto(
                    id = it.id,
                    name = it.name
                )
            )
        }
        return result
    }
}