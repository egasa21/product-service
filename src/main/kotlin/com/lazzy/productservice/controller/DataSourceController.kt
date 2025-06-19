package com.lazzy.productservice.controller

import com.lazzy.productservice.domain.dto.response.BaseResponse
import com.lazzy.productservice.domain.dto.response.ResProductDto
import com.lazzy.productservice.service.MasterProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/datasource")
class DataSourceController(
    private val masterProductService: MasterProductService
) {
    @GetMapping("/products")
    fun getProductsByIds(
        @RequestParam("ids") ids: List<Int>
    ): ResponseEntity<BaseResponse<List<ResProductDto>>> {
        val products = masterProductService.getProductsByIds(ids)
        return ResponseEntity.ok(
            BaseResponse(data = products)
        )
    }
}