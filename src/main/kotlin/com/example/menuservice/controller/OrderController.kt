package com.example.menuservice.controller

import com.example.menuservice.model.Category
import com.example.menuservice.model.Order
import com.example.menuservice.model.OrderItem
import com.example.menuservice.model.Product
import com.example.menuservice.service.OrderService
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["/api"])
@CrossOrigin(origins = ["*"])
@RestController
internal class OrderController(service: OrderService) {

    private val service: OrderService


    @GetMapping("/private/orders/{id}")
    fun one(@PathVariable id: Int): Order? {
        return service.getOrderById(id)
    }

    @GetMapping("/private/orders")
    fun all(): List<Order> {
        return service.orders
    }

    @PostMapping("/public/orders")
    fun newEmptyOrder(@RequestBody newOrder: Order): Order {
        return service.saveEmptyOrder(newOrder);
    }

    @PutMapping("/private/orders/{id}")
    fun updateOrderStatus(@RequestBody order: Order, @PathVariable id: Int): Order {
        return service.updateOrderStatus(order, id)
    }



    init {
        this.service = service
    }
}