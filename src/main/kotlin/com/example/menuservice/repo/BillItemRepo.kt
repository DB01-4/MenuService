package com.example.menuservice.repo

import com.example.menuservice.model.Bill
import com.example.menuservice.model.BillItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillItemRepo : JpaRepository<BillItem, Int> {
}