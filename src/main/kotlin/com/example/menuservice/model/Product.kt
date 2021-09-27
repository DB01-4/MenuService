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
    var price: Int? = null

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private val categoryId: Category? = null


    constructor(id: Int?, name: String?, description: String?, allergies: String?, price: Int?) {
        this.id = id
        this.name = name
        this.description = description
        this.allergies = allergies
        this.price = price
    }
}