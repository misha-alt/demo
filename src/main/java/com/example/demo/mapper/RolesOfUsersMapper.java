package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.RolesOfUsersDto;
import com.example.demo.productDTO.UserDto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RolesOfUsersMapper {
    // Маппинг из RolesOfUsers в RolesOfUsersDto
//    public static RolesOfUsersDto mapToRolesOfUsersDto(RolesOfUsers role) {
//        if (role == null) {
//            return null; // или выбросьте исключение
//        }
//
//        Set<UserDto> userDtos = (role.getUserSet() != null) ?
//                role.getUserSet().stream()
//                        .map(user -> {
//                            Set<ProductDto> productDtos = (user.getProducts() != null) ?
//                                    user.getProducts().stream()
//                                            .map(ProductMapper::mappToProdDTO)
//                                            .collect(Collectors.toSet()) :
//                                    new HashSet<>(); // Инициализация пустым множеством, если productSet равно null
//
//                            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), new HashSet<>(), productDtos);
//                        })
//                        .collect(Collectors.toSet()) :
//                new HashSet<>(); // Инициализация пустым множеством, если userSet равно null
//
//        return new RolesOfUsersDto(role.getId(), role.getRolename(), userDtos);
//    }
//
//    // Маппинг из RolesOfUsersDto в RolesOfUsers
//    public static RolesOfUsers mapToRolesOfUsers(RolesOfUsersDto roleDto) {
//        if (roleDto == null) {
//            return null; // или выбросьте исключение
//        }
//
//        Set<User> users = (roleDto.getUserDtoSet() != null) ?
//                roleDto.getUserDtoSet().stream()
//                        .map(userDto -> {
//                            Set<Product> products = (userDto.getProductDtos() != null) ?
//                                    userDto.getProductDtos().stream()
//                                            .map(ProductMapper::mappToProd)
//                                            .collect(Collectors.toSet()) :
//                                    new HashSet<>(); // Инициализация пустым множеством, если productSet равно null
//
//                            return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), new HashSet<>(), products);
//                        })
//                        .collect(Collectors.toSet()) :
//                new HashSet<>(); // Инициализация пустым множеством, если userDtoSet равно null
//
//        return new RolesOfUsers(roleDto.getId(), roleDto.getRolename(), users);
//    }
}
