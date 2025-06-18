package com.lazzy.productservice.repository

import com.lazzy.productservice.domain.entity.MasterProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterProductRepository: JpaRepository<MasterProductEntity, Int> {
}