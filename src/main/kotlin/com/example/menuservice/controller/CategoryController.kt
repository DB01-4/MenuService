package com.example.menuservice.controller

import com.example.menuservice.model.Category
import com.example.menuservice.repo.CategoryRepo
import com.example.menuservice.service.CategoryService
import com.example.menuservice.service.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
internal class CategoryController(service: CategoryService) {
    private val service: CategoryService

    @GetMapping("/categories")
    fun all(): List<Category> {
        return service.categories
    }

    @PostMapping("/categories")
    fun newCategory(@RequestBody newCategory: Category): Category {
        return service.saveCategory(newCategory)!!
    }

    // Single item
    @GetMapping("/categories/{id}")
    fun one(@PathVariable id: Int): Category? {
        return service.getCategoryById(id)
    }

    @PutMapping("/categories/{id}")
    fun replaceCategory(@RequestBody newCategory: Category, @PathVariable id: Int): Category {
        return service.updateCategory(newCategory)
    }

    @DeleteMapping("/categories/{id}")
    fun deleteCategory(@PathVariable id: Int) {
        service.deleteCategory(id)
    }

    init {
        this.service = service
    }
}