package com.lazzy.productservice.controller

import com.lazzy.productservice.domain.dto.request.ReqCreateProductDto
import com.lazzy.productservice.domain.dto.response.BaseResponse
import com.lazzy.productservice.domain.dto.response.ResProductDto
import com.lazzy.productservice.service.MasterProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val productService: MasterProductService,
    private val masterProductService: MasterProductService
) {
    @GetMapping()
    fun getAllProducts(): ResponseEntity<BaseResponse<List<ResProductDto>>?> {
        return ResponseEntity.ok(
            BaseResponse(
                data = productService.getAllProducts()
            )
        )
    }

    @GetMapping("/{id}")
    fun getProductById(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<ResProductDto?>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = productService.getProductById(id)
            )
        )
    }

    @PostMapping()
    fun createProduct(
        @Valid @RequestBody req: ReqCreateProductDto
    ): ResponseEntity<BaseResponse<ResProductDto>> {
        return ResponseEntity(
            BaseResponse(
                data = masterProductService.createProduct(req)
            ),
            HttpStatus.CREATED
        )
    }
}