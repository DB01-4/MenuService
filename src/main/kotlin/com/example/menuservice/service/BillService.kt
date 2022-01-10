package com.example.menuservice.service

import com.example.menuservice.model.Bill
import com.example.menuservice.model.Order
import com.example.menuservice.repo.BillRepo
import com.example.menuservice.repo.OrderRepo
import org.springframework.stereotype.Service

@Service
class BillService(private val billRepo: BillRepo)
{

    //get orders
    val bills: List<Bill>
        get() = billRepo.findAll()
}