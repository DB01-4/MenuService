package com.example.menuservice.service

import com.example.menuservice.model.Category
import com.example.menuservice.repo.CategoryRepo
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepo: CategoryRepo) {
    
    //post product
    fun saveCategory(category: Category): Category? {
        return categoryRepo.save(category)
    }

    //get products
    val categories: List<Category>
        get() = categoryRepo.findAll()

    //get product by id
    fun getCategoryById(id: Int): Category? {
        return categoryRepo.findById(id).orElse(null)
    }

    //delete product
    fun deleteCategory(id: Int): String {
        categoryRepo.deleteById(id)
        return "Category deleted$id"
    }

    //update user
    fun updateCategory(category: Category): Category {
        val existingCategory = categoryRepo.findById(category.id!!).orElse(null)
        existingCategory.name = category.name
        existingCategory.description = category.description
        existingCategory.image = category.image
        return categoryRepo.save(existingCategory)
    }
}