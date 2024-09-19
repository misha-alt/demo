package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.productDTO.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long id);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct( Long id, ProductDto productDto);

    void  deleteProduct (Long id);
    }

