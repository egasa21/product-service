package com.lazzy.productservice.domain.dto.request

import jakarta.validation.constraints.*
import java.math.BigDecimal

data class ReqCreateProductDto(
    @field:NotBlank(message = "Product name is required")
    @field:Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    val name: String,

    @field:Size(max = 500, message = "Description cannot exceed 500 characters")
    val description: String? = null,

    @field:NotNull(message = "Price is required")
    @field:DecimalMin(value = "0.01", message = "Price must be greater than zero")
    val price: BigDecimal,

    @field:NotBlank(message = "SKU is required")
    @field:Pattern(
        regexp = "^[A-Za-z0-9-]+$",
        message = "SKU must contain only letters, numbers, and hyphens"
    )
    val sku: String,

    @field:Min(value = 0, message = "Stock quantity cannot be negative")
    val stockQuantity: Int,

    val isActive: Boolean = true,
)