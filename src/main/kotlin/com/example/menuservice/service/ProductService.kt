package com.example.menuservice.service

import com.example.menuservice.model.Product
import com.example.menuservice.repo.ProductRepo
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepo) {
    //post product
    fun saveProduct(product: Product): Product {
        return productRepository.save(product)
    }

    //get products
    val products: List<Product>
        get() = productRepository.findAll()

    //get product by id
    fun getProductById(id: Int): Product {
        return productRepository.findById(id).orElse(null)
    }

    //find products by category id
    fun findByCategoryId(id: Int): List<Product> {
        return productRepository.findByCategoryId(id)
    }

    //delete product
    fun deleteProduct(id: Int): String {
        productRepository.deleteById(id)
        return "Product deleted$id"
    }

    //update user
    fun updateProduct(product: Product): Product {
        val existingProduct = productRepository.findById(product.id!!).orElse(null)
        existingProduct.name = product.name
        existingProduct.description = product.description
        existingProduct.allergies = product.allergies
        existingProduct.nutrition = product.nutrition
        existingProduct.price = product.price
        existingProduct.image = product.image
        existingProduct.inStock = product.inStock
        existingProduct.category = product.category
        
        return productRepository.save(existingProduct)
    }
}