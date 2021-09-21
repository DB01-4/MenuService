package com.example.menuservice.repo

import com.example.menuservice.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<Category, Int>