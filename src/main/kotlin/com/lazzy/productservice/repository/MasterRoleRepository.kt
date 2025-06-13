package com.lazzy.productservice.repository

import com.lazzy.productservice.domain.entity.MasterRoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterRoleRepository : JpaRepository<MasterRoleEntity, Int> {

}