package com.example.demo.controllers;

import com.example.demo.mailSend.SendEmail;
import com.example.demo.mapper.RolesOfUsersMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.RolesOfUsersDto;
import com.example.demo.productDTO.UserDto;
import com.example.demo.services.RolesOfUsersService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/reg")
public class CreateUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RolesOfUsersService rolesOfUsersService;
    @Autowired
    private SendEmail sendEmail;
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user ){

        RolesOfUsers rolesOfUsers = rolesOfUsersService.getById(2L);


        Set roleSet = new HashSet<>();
        Set<User> userSet = new HashSet<>();

        roleSet.add(rolesOfUsers);
        user.setAuthority(roleSet);


        User savedUser = userService.createUser(user);


        userSet.add(savedUser);
        rolesOfUsers.setUserSet(userSet);

        RolesOfUsers updateRoles = rolesOfUsersService.updateRole(rolesOfUsers);
       RolesOfUsers rolesOfUsers1= rolesOfUsersService.getById(2L);



        rolesOfUsers1.getUserSet().forEach(userElm-> System.out.println(userElm.getLogin()));


        sendEmail.sendSimpleEmail();



        return new ResponseEntity<>(savedUser,  HttpStatus.CREATED);
    }
}






