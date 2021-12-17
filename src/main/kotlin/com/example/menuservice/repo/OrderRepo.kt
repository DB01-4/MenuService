package com.example.menuservice.repo

import com.example.menuservice.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface OrderRepo : JpaRepository<Order, Int>