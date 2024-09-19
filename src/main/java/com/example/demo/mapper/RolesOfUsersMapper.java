package com.example.demo.mapper;

import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.RolesOfUsersDto;
import com.example.demo.productDTO.UserDto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RolesOfUsersMapper {
    // Маппинг из RolesOfUsers в RolesOfUsersDto
    public static RolesOfUsersDto mapToRolesOfUsersDto(RolesOfUsers role) {
        Set<UserDto> userDtos = role.getUserSet().stream()
                .map(user -> new UserDto(user.getId(), user.getLogin(), user.getPassword(), new HashSet<>()))
                .collect(Collectors.toSet());

        return new RolesOfUsersDto(role.getId(), role.getRole_name(), userDtos);
    }

    // Маппинг из RolesOfUsersDto в RolesOfUsers
    public static RolesOfUsers mapToRolesOfUsers(RolesOfUsersDto roleDto) {
        Set<User> users = roleDto.getUserDto().stream()
                .map(userDto -> new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), new HashSet<>()))
                .collect(Collectors.toSet());

        return new RolesOfUsers(roleDto.getId(), roleDto.getRole_name(), users);
    }
}

