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

public class UserMapper {



        public static UserDto mapToUserDto (User user){
//            Set<RolesOfUsers> rolesDto = user.getAuthority().stream()
//                    .map(role -> new RolesOfUsers(role.getId(), role.getRoleName(), new HashSet<>()))
//                    .collect(Collectors.toSet());
            // Проверка на null для authority

            Set<RolesOfUsersDto> rolesDto = (user.getAuthority() != null) ?
                    user.getAuthority().stream()
                            .map(role -> new RolesOfUsersDto(role.getId(), role.getRolename(), new HashSet<>()))
                            .collect(Collectors.toSet()) :
                    new HashSet<>(); // Инициализация пустым множеством, если authority равно null

            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), rolesDto);
        }

        // Маппинг из UserDto в User
    public static User mapToUser (UserDto userDto){
    Set<RolesOfUsers> roles =  (userDto.getAuthority() != null)
            ? userDto.getAuthority().stream()
            .map(roleDto -> new RolesOfUsers(roleDto.getId(), roleDto.getRolename(), new HashSet<>()))
            .collect(Collectors.toSet()): new HashSet<>();

    return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), roles);
}
    }


//public static User mapToUser (UserDto userDto){
//    Set<RolesOfUsers> roles =  (userDto.getAuthority() != null)
//            ? userDto.getAuthority().stream()
//            .map(roleDto -> new RolesOfUsers(roleDto.getId(), roleDto.getRoleName(), new HashSet<>()))
//            .collect(Collectors.toSet()): new HashSet<>();
//
//    return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), roles);
//}


//public static User mapToUser (UserDto userDto){
//    Set<RolesOfUsers> roles = userDto.getAuthority().stream()
//            .map(roleDto -> new RolesOfUsers(roleDto.getId(), roleDto.getRoleName(), new HashSet<>()))
//            .collect(Collectors.toSet());
//
//    return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), roles);
//}