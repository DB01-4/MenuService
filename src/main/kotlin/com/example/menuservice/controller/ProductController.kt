package com.example.menuservice.controller

import com.example.menuservice.model.Product
import com.example.menuservice.service.ProductService
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["api/private"])
@CrossOrigin(origins = ["*"])
@RestController
internal class ProductController(service: ProductService) {

    private val service: ProductService


    @GetMapping("/products")
    fun all(): List<Product> {
        return service.products
    }

    @GetMapping("/products/category/{id}")
    fun getByCategoryId(@PathVariable id: Int): List<Product> {
        return service.findByCategoryId(id)
    }

    @PostMapping("/products")
    fun newProduct(@RequestBody newProduct: Product): Product {
        return service.saveProduct(newProduct)
    }

    @GetMapping("/products/{id}")
    fun one(@PathVariable id: Int): Product? {
        return service.getProductById(id)
    }

    @PutMapping("/products/{id}")
    fun replaceProduct(@RequestBody newProduct: Product, @PathVariable id: Int): Product {
        return service.updateProduct(newProduct)
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id: Int) {
        service.deleteProduct(id)
    }

    init {
        this.service = service
    }
}