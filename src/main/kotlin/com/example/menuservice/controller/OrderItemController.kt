package com.example.menuservice.controller

import com.example.menuservice.model.OrderItem
import com.example.menuservice.service.OrderItemService
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["/api"])
@CrossOrigin(origins = ["*"])
@RestController
internal class OrderItemController(service: OrderItemService) {

    private val service: OrderItemService
//
//    @GetMapping("/public/orderitems")
//    fun all(): List<OrderItem> {
//        return service.orderItems
//    }

    @PostMapping("/public/orderitems")
    fun newOrderItem(@RequestBody newOrderItems: List<OrderItem>): List<OrderItem> {
        return service.saveOrderItems(newOrderItems);
    }

    init {
        this.service = service
    }
}