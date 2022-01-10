package com.example.menuservice.repo

import com.example.menuservice.model.Bill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillRepo : JpaRepository<Bill, Int> {
}