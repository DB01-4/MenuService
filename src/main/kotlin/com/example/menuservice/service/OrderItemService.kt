package com.example.menuservice.service

import com.example.menuservice.model.Order
import com.example.menuservice.model.OrderItem
import com.example.menuservice.model.Product
import com.example.menuservice.repo.CategoryRepo
import com.example.menuservice.repo.OrderItemRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderItemService(private val orderItemRepo: OrderItemRepo) {

    //get order items
//    val orderItems: List<OrderItem>
//        get() = orderItemRepo.findAll()

    fun saveOrderItem(orderItem: OrderItem): OrderItem {
        return orderItemRepo.save(orderItem);
    }

    fun saveOrderItems(newOrderItems: List<OrderItem>): List<OrderItem> {
        var orderItems = ArrayList<OrderItem>();
        newOrderItems.forEach() {
            orderItems.add(saveOrderItem(it));
        }
        return orderItems;
    }


}