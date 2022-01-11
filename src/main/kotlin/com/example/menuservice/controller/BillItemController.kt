package com.example.menuservice.controller

import com.example.menuservice.model.Bill
import com.example.menuservice.model.BillItem
import com.example.menuservice.model.Category
import com.example.menuservice.service.BillItemService
import com.example.menuservice.service.BillService
import org.springframework.web.bind.annotation.*

@RequestMapping(path = ["api/"])
@CrossOrigin(origins = ["*"])
@RestController
internal class BillItemController (service: BillItemService) {

    private val service: BillItemService

    @GetMapping("public/billItems")
    fun all(): List<BillItem> {
        return service.billItems
    }

    @PostMapping("public/billItem/post")
    fun newCategory(@RequestBody newBillItem: BillItem): BillItem {
        return service.saveBillItem(newBillItem)!!
    }

    init {
        this.service = service
    }
}