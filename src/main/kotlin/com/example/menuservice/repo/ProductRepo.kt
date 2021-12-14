package com.example.menuservice.repo

import com.example.menuservice.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ProductRepo : JpaRepository<Product, Int> {

    @Query("from Product p inner join fetch p.category where p.category.id = :id")
    fun findByCategoryId(@Param("id") id: Int): List<Product>
}