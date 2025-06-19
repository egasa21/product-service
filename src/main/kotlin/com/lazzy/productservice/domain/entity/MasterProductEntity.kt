package com.lazzy.productservice.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.sql.Timestamp

@Entity
@Table(name = "mst_products")
data class MasterProductEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "mst_products_id_seq"
    )
    @SequenceGenerator(
        name = "mst_products_id_seq",
        sequenceName = "mst_products_id_seq",
        allocationSize = 1
    )
    @Column(name = "id", insertable = false, updatable = false)
    var id: Int = 0,

    @Column(name = "name", nullable = false)
    var name: String = "",

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "price", nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @Column(name = "sku", unique = true)
    var sku: String = "",

    @Column(name = "stock_quantity")
    var stockQuantity: Int = 0,

    @Column(name = "created_by")
    var createdBy: String? = null,

    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp
    var createdAt: Timestamp? = null,

    @Column(name = "updated_by")
    var updatedBy: String? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,

    @Column(name = "deleted_at")
    var deletedAt: Timestamp? = null,

    @Column(name = "deleted_by")
    var deletedBy: String? = null,

    @Column(name = "is_active")
    var isActive: Boolean = true,

    @Column(name = "is_delete")
    var isDelete: Boolean = false
)