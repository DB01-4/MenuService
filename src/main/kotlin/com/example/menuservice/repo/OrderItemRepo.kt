package com.example.menuservice.repo

import com.example.menuservice.model.Order
import com.example.menuservice.model.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepo : JpaRepository<OrderItem, Int>