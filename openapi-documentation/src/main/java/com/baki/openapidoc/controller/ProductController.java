package com.baki.openapidoc.controller;

import com.baki.openapidoc.exception.NotFoundException;
import com.baki.openapidoc.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The product",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "404", description = "Product not found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NotFoundException.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid ID",
                            content = @Content)}
    )
    public Product getProductById(@PathVariable Long id) {

        return productService.getProduct(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
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
