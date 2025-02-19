package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.productDTO.ProductDto;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);

    List<Product> getAllProduct();

    Product updateProduct( Long id, Product product);

    void  deleteProduct (Long id);
    }

