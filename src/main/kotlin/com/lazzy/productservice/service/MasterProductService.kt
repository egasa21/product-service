package com.lazzy.productservice.service

import com.lazzy.productservice.domain.dto.request.ReqCreateProductDto
import com.lazzy.productservice.domain.dto.response.ResProductDto

interface MasterProductService {
    fun getAllProducts(): List<ResProductDto>
    fun getProductById(id: Int): ResProductDto?
    fun createProduct(req: ReqCreateProductDto): ResProductDto
}