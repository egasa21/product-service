package com.lazzy.productservice.repository

import com.lazzy.productservice.domain.entity.MasterProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MasterProductRepository: JpaRepository<MasterProductEntity, Int> {
    @Query(
        """
    SELECT p FROM MasterProductEntity p
    WHERE p.id IN (:ids) AND p.isActive = true
    """
    )
    fun findAllByIds(ids: List<Int>): List<MasterProductEntity>

}