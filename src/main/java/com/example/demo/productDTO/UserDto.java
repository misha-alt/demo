package com.example.demo.productDTO;

import com.example.demo.model.RolesOfUsers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private  Long id;
    private String login;
    private String password;
    private Set<RolesOfUsers> authority;

}
