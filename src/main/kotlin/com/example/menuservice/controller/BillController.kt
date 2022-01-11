package com.example.menuservice.controller

import com.example.menuservice.model.Bill
import com.example.menuservice.service.BillService
import org.springframework.web.bind.annotation.*

@RequestMapping(path = ["/api"])
@CrossOrigin(origins = ["*"])
@RestController
internal class BillController (service: BillService) {

    private val service: BillService

    @GetMapping("/public/bills")
    fun all(): List<Bill> {
        return service.bills
    }

    init {
        this.service = service
    }
}