package com.baki.openapidoc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // Retrieve product from database or any other data source
        // For demonstration, let's create a dummy product
        Product product = new Product(id, "Sample Product", 10.0);
        return product;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // Save product to database or any other data source
        // For demonstration, let's just return the saved product
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        // Update product in database or any other data source
        // For demonstration, let's just return the updated product
        updatedProduct.setId(id);
        return updatedProduct;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        // Delete product from database or any other data source
        // For demonstration, let's just return success status
        // In a real application, you may want to return an appropriate response
    }
}
