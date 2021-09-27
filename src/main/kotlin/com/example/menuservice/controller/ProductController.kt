package com.example.menuservice.controller

import com.example.menuservice.model.Product
import com.example.menuservice.repo.ProductRepo
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RestController
internal class ProductController(repository: ProductRepo) {
    private val repository: ProductRepo

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/products")
    fun all(): List<Product> {
        return repository.findAll()
    }

    // end::get-aggregate-root[]
    @PostMapping("/products")
    fun newEmployee(@RequestBody newProduct: Product): Product {
        return repository.save(newProduct)
    }

    // Single item
    @GetMapping("/products/{id}")
    fun one(@PathVariable id: Int): Optional<Product> {
        return repository.findById(id)
    }

    @PutMapping("/products/{id}")
    fun replaceProduct(@RequestBody newProduct: Product, @PathVariable id: Int): Product {
        return repository.findById(id)
                .map { product ->
                    product.name = newProduct.name
                    product.description = newProduct.description
                    product.allergies = newProduct.allergies
                    product.price = newProduct.price
                    repository.save(product)
                }
                .orElseGet {
                    repository.save(newProduct)
                }
    }

    @DeleteMapping("/products/{id}")
    fun deleteEmployee(@PathVariable id: Int) {
        repository.deleteById(id)
    }

    init {
        this.repository = repository
    }
}