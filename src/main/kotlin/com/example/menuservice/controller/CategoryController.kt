package com.example.menuservice.controller

import com.example.menuservice.model.Category
import com.example.menuservice.repo.CategoryRepo
import com.example.menuservice.service.CategoryService
import com.example.menuservice.service.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping(path = ["api/"])
@CrossOrigin(origins = ["*"])
@RestController
internal class CategoryController(service: CategoryService) {
    private val service: CategoryService

    @GetMapping("public/categories")
    fun all(): List<Category> {
        return service.categories
    }

    @PostMapping("private/categories")
    fun newCategory(@RequestBody newCategory: Category): Category {
        return service.saveCategory(newCategory)!!
    }

    // Single item
    @GetMapping("public/categories/{id}")
    fun one(@PathVariable id: Int): Category? {
        return service.getCategoryById(id)
    }

    @PutMapping("private/categories/{id}")
    fun replaceCategory(@RequestBody newCategory: Category, @PathVariable id: Int): Category {
        return service.updateCategory(newCategory)
    }

    @DeleteMapping("private/categories/{id}")
    fun deleteCategory(@PathVariable id: Int) {
        service.deleteCategory(id)
    }

    init {
        this.service = service
    }
}