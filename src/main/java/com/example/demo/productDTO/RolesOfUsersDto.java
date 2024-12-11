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
    private  Long id;
    private String rolename;
    private Set<UserDto> userDtoSet;
}
