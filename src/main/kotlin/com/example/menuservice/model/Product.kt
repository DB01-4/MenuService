package com.example.menuservice.model

import java.text.DecimalFormat
import javax.persistence.*


@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null
    var description: String? = null
    var allergies: String? = null
    var nutrition: String? = null
    @Column(precision=10, scale=2)
    var price: Double? = null
    var image: String? = null
    var inStock: Boolean? = false

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = true, updatable = true)
    var category: Category? = null

}