package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.UserDto;

public interface UserService {

    UserDto getUserById(Long id);
}
