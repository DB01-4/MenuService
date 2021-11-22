package com.example.menuservice.service;


import com.example.menuservice.model.Product;
import com.example.menuservice.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    //post product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //get products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //get product by id
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    //delete product
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted" + id;
    }

    //update user
    public Product updateProduct(Product product) {
        Product existingProduct=productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        return productRepository.save(existingProduct);
    }


}
