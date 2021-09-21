package com.example.menuservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null
    var description: String? = null
    var allergies: String? = null
    var price: Int? = null

    constructor(id: Int?, name: String?, description: String?, allergies: String?, price: Int?) {
        this.id = id
        this.name = name
        this.description = description
        this.allergies = allergies
        this.price = price
    }
}