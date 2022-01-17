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


    @GetMapping("/public/orders/{id}")
    fun one(@PathVariable id: Int): Order? {
        return service.getOrderById(id)
    }

    @GetMapping("/public/orders")
    fun all(): List<Order> {
        return service.orders
    }

    @GetMapping("public/orders/table/{id}")
    fun getByTableId(@PathVariable id: Int): List<Order> {
        return service.findByTableId(id)
    }
    @PostMapping("/public/orders")
    fun newEmptyOrder(@RequestBody newOrder: Order): Order {
        return service.saveEmptyOrder(newOrder);
    }

    @PutMapping("/public/orders/{id}")
    fun updateOrderStatus(@RequestBody order: Order, @PathVariable id: Int): Order {
        return service.updateOrderStatus(order, id)
    }



    init {
        this.service = service
    }
}