package com.lazzy.productservice.domain.dto.response

import java.math.BigDecimal
import java.sql.Timestamp

data class ResProductDto(
    val id: Int,
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val sku: String,
    val stockQuantity: Int,
    val isActive: Boolean,
    val createdBy: String? = null,
    val createdAt: Timestamp? = null,
    val updatedAt: Timestamp? = null
)