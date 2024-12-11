package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.productDTO.ProductDto;

public class ProductMapper {
    public static ProductDto  mappToProdDTO(Product product){

        return new ProductDto(product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCity()
        );
    }

    public static Product mappToProd(ProductDto productDto){
        return new Product(productDto.getId(),
                productDto.getTitle(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getCity()
        );
    }
}
