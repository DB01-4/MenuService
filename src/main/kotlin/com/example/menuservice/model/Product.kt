package com.example.menuservice.model

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
    var price: Int? = null
    var image: String? = null

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = true, updatable = true)
    var category: Category? = null

}