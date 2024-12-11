package com.example.demo.services;

import com.example.demo.model.RolesOfUsers;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.RolesOfUsersDto;

import java.util.List;

public interface RolesOfUsersService {

    RolesOfUsers createRole (RolesOfUsers rolesOfUsers);

    RolesOfUsersDto getById (Long id);

    List<RolesOfUsers> getallRoles();

    RolesOfUsers updateRole(RolesOfUsers roles);

    List<RolesOfUsers> findRoleNam(String rolNam);

}
