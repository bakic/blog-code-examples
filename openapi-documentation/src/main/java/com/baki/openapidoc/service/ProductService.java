package com.baki.openapidoc.service;

import com.baki.openapidoc.controller.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    public Optional<Product> getProduct(final Long id) {
        return Optional.empty();
    }
}
