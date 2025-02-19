package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.UserDto;

public interface UserService {

    User getUserById(Long id);

    User getUserByLogin(String login);

     boolean checkPassword (String rawPassword, String encodedPassword);

     User createUser(User user);

     User updateUser(User user);


}
