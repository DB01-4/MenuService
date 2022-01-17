package com.example.menuservice.service

import com.example.menuservice.model.Category
import com.example.menuservice.model.Order
import com.example.menuservice.model.OrderItem
import com.example.menuservice.model.Product
import com.example.menuservice.repo.OrderRepo
import org.springframework.stereotype.Service


@Service
class OrderService(private val orderRepo: OrderRepo) {

    val orderItemService: OrderItemService? = null;


    //post empty order
    fun saveEmptyOrder(order: Order): Order {
        return orderRepo.save(order);
    }

    //post empty order
    fun saveOrder(order: Order): Order {
        return orderRepo.save(order);
    }

    //get orders
    val orders: List<Order>
        get() = orderRepo.findAll()

    //get order by id
    fun getOrderById(id: Int): Order? {
        return orderRepo.findById(id).orElse(null)
    }

    //delete product
    fun deleteOrder(id: Int): String {
        orderRepo.deleteById(id)
        return "Order deleted$id"
    }

    //update order status
    fun updateOrderStatus(order: Order, id: Int): Order {
        val existingOrder = orderRepo.findById(id!!).orElse(null)
        existingOrder.status = order.status;
        return orderRepo.save(existingOrder);
    }


    //find orders by table id
    fun findByTableId(id: Int): List<Order> {
        return orderRepo.findByTableId(id)
    }

}