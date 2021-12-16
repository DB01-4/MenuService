package com.example.menuservice.controller

import com.example.menuservice.model.Product
import com.example.menuservice.service.ProductService
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["api/"])
@CrossOrigin(origins = ["*"])
@RestController
internal class ProductController(service: ProductService) {

    private val service: ProductService


    @GetMapping("public/products")
    fun all(): List<Product> {
        return service.products
    }

    @GetMapping("public/products/category/{id}")
    fun getByCategoryId(@PathVariable id: Int): List<Product> {
        return service.findByCategoryId(id)
    }

    @PostMapping("private/products")
    fun newProduct(@RequestBody newProduct: Product): Product {
        return service.saveProduct(newProduct)
    }

    @GetMapping("public/products/{id}")
    fun one(@PathVariable id: Int): Product? {
        return service.getProductById(id)
    }

    @PutMapping("private/products/{id}")
    fun replaceProduct(@RequestBody newProduct: Product, @PathVariable id: Int): Product {
        return service.updateProduct(newProduct)
    }

    @DeleteMapping("private/products/{id}")
    fun deleteProduct(@PathVariable id: Int) {
        service.deleteProduct(id)
    }

    init {
        this.service = service
    }
}