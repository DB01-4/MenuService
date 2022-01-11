package com.example.menuservice.service

import com.example.menuservice.model.BillItem
import com.example.menuservice.repo.BillItemRepo
import org.springframework.stereotype.Service

@Service
class BillItemService(private val billItemRepo: BillItemRepo)
{

    //get orders
    val billItems: List<BillItem>
        get() = billItemRepo.findAll()

    //post bill
    fun saveBillItem(BillItem: BillItem): BillItem? {
        return billItemRepo.save(BillItem)
    }
}