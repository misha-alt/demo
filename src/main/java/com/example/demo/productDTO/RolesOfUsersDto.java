package com.example.demo.productDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesOfUsersDto {
    private  int id;
    private String role_name;
    private Set<UserDto> userDto;
}
