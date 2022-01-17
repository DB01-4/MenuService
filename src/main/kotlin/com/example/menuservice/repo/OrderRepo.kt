package com.example.menuservice.repo

import com.example.menuservice.model.Order
import com.example.menuservice.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface OrderRepo : JpaRepository<Order, Int> {

    @Query("SELECT o from Order o WHERE o.tableId = :id")
    fun findByTableId(@Param("id") id: Int): List<Order>
}