package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.UserDto;

public class ProductMapper {
//    public static ProductDto  mappToProdDTO(Product product){
//
//        if (product == null) {
//            return null;
//        }
//
//        UserDto userDto = UserMapper.mapToUserDto(product.getUser());
//
//        return new ProductDto(product.getId(),
//                product.getTitle(),
//                product.getDescription(),
//                product.getPrice(),
//                product.getCity(),
//                userDto
//
//
//        );
//    }
//
//    public static Product mappToProd(ProductDto productDto){
//
//        if (productDto == null) {
//            return null;
//        }
//
//        User user = UserMapper.mapToUser(productDto.getUserDto());
//
//        return new Product(productDto.getId(),
//                productDto.getTitle(),
//                productDto.getDescription(),
//                productDto.getPrice(),
//                productDto.getCity(),
//                user
//        );
//    }
}
