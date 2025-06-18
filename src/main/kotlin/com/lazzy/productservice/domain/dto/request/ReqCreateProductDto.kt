package com.lazzy.productservice.domain.dto.request

import java.math.BigDecimal

data class ReqCreateProductDto(
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val sku: String,
    val stockQuantity: Int,
    val isActive: Boolean = true,
)
