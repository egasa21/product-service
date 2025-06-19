package com.lazzy.productservice.service.impl

import com.lazzy.productservice.domain.dto.request.ReqCreateProductDto
import com.lazzy.productservice.domain.dto.response.ResProductDto
import com.lazzy.productservice.domain.entity.MasterProductEntity
import com.lazzy.productservice.exception.CustomException
import com.lazzy.productservice.repository.MasterProductRepository
import com.lazzy.productservice.rest.UserManagementClient
import com.lazzy.productservice.service.MasterProductService
import jakarta.ws.rs.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import kotlin.text.toInt

@Service
class MasterProductServiceImpl(
    private val masterProductRepository: MasterProductRepository,
    private val userManagementClient: UserManagementClient
) : MasterProductService {

    override fun getAllProducts(): List<ResProductDto> {
        val rawData = masterProductRepository.findAll()
        val result = mutableListOf<ResProductDto>()
        rawData.forEach { product ->
            var createdBy = product.createdBy
            if (createdBy != null) {
                val user = userManagementClient.getUserById(
                    createdBy.toInt()
                ).body!!.data!!
                createdBy = user.username
            }
            result.add(
                ResProductDto(
                    id = product.id,
                    name = product.name,
                    description = product.description,
                    price = product.price,
                    sku = product.sku,
                    stockQuantity = product.stockQuantity,
                    isActive = product.isActive,
                    createdAt = product.createdAt,
                    createdBy = createdBy,
                    updatedAt = product.updatedAt
                )
            )
        }
        return result
    }

    override fun getProductById(id: Int): ResProductDto? {
        val productEntity = masterProductRepository.findById(id).orElseThrow {
            BadRequestException("Product with id $id not found")
        }

        var createdBy = productEntity.createdBy
        if (createdBy != null) {
            val user = userManagementClient.getUserById(
                createdBy.toInt()
            ).body!!.data!!
            createdBy = user.username
        }

        return ResProductDto(
            id = productEntity.id,
            name = productEntity.name,
            description = productEntity.description,
            price = productEntity.price,
            sku = productEntity.sku,
            stockQuantity = productEntity.stockQuantity,
            isActive = productEntity.isActive,
            createdBy = createdBy,
            createdAt = productEntity.createdAt,
            updatedAt = productEntity.updatedAt,
        )
    }

    override fun createProduct(req: ReqCreateProductDto, performerId: Int): ResProductDto {
        val performer = userManagementClient.getUserById(performerId).body!!.data!!
        if (performer.roleName != "admin") {
            throw CustomException(
                "Only administrators can create a products",
                HttpStatus.FORBIDDEN.value()
            )
        }


        val productRow = MasterProductEntity(
            name = req.name,
            description = req.description,
            price = req.price,
            sku = req.sku,
            stockQuantity = req.stockQuantity,
            isActive = req.isActive
        )

        val savedProduct = masterProductRepository.save(productRow)
        return ResProductDto(
            id = savedProduct.id,
            name = savedProduct.name,
            description = savedProduct.description,
            price = savedProduct.price,
            sku = savedProduct.sku,
            stockQuantity = savedProduct.stockQuantity,
            isActive = savedProduct.isActive,
            createdAt = savedProduct.createdAt,
            updatedAt = savedProduct.updatedAt
        )
    }

    override fun getProductsByIds(ids: List<Int>): List<ResProductDto> {
        val products = masterProductRepository.findAllByIds(ids)

        return products.map { product ->
            val username = product.createdBy?.let {
                userManagementClient.getUserById(it.toInt()).body?.data?.username
            }

            ResProductDto(
                id = product.id,
                name = product.name,
                description = product.description,
                price = product.price,
                sku = product.sku,
                stockQuantity = product.stockQuantity,
                isActive = product.isActive,
                createdAt = product.createdAt,
                createdBy = username,
                updatedAt = product.updatedAt
            )
        }
    }


}