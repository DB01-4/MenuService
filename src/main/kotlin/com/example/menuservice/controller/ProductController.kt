package com.example.menuservice.controller

import com.example.menuservice.model.Product
import com.example.menuservice.repo.ProductRepo
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
internal class ProductController(repository: ProductRepo) {
    private val repo: ProductRepo

    @GetMapping("/products")
    fun all(): List<Product> {
        return repo.findAll()
    }

    @GetMapping("/products/category/{id}")
    fun getByCategoryId(@PathVariable id: Int): List<Product> {
        return repo.findByCategoryId(id)
    }

    @PostMapping("/products")
    fun newProduct(@RequestBody newProduct: Product): Product {
        return repo.save(newProduct)
    }

    @GetMapping("/products/{id}")
    fun one(@PathVariable id: Int): Optional<Product> {
        return repo.findById(id)
    }

    @PutMapping("/products/{id}")
    fun replaceProduct(@RequestBody newProduct: Product, @PathVariable id: Int): Product {
        return repo.findById(id)
                .map { product ->
                    product.name = newProduct.name
                    product.description = newProduct.description
                    product.allergies = newProduct.allergies
                    product.price = newProduct.price
                    repo.save(product)
                }
                .orElseGet {
                    repo.save(newProduct)
                }
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id: Int) {
        repo.deleteById(id)
    }

    init {
        this.repo = repository
    }
}