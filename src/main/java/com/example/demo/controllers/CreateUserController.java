package com.example.demo.controllers;

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
    @PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto ){

//        UserDto userDto1 = new UserDto();
//        userDto1.setLogin("John");
//        userDto1.setPassword("123");
//
//
//        RolesOfUsers rolesOfUsers = new RolesOfUsers();
//        rolesOfUsers.setRoleName("ROLE_ADMIN");
//
//
//        Set roleSet = new HashSet<>();
//        Set userSet = new HashSet<>();
//
//
//        roleSet.add(rolesOfUsers);
//        userDto1.setAuthority(roleSet);
//
//
//        userSet.add(UserMapper.mapToUser(userDto1));
//        rolesOfUsers.setUserSet(userSet);
//
//        UserDto savedUser = userService.createUser(userDto1);
//
//        // Инициализация userSet, если он равен null
//        if (rolesOfUsers.getUserSet() == null) {
//            rolesOfUsers.setUserSet(new HashSet<>()); // Инициализация здесь
//        }
//
//
//        UserDto userTest= userService.getUserByLogin("John");
//
//
//        return new ResponseEntity<>(userTest,  HttpStatus.CREATED);
   //=================================================================

        RolesOfUsersDto rolesOfUsers = new RolesOfUsersDto();
        rolesOfUsers.setRolename("ROLE_ADMIN");

        Set roleSet = new HashSet<>();
        Set<UserDto> userSet = new HashSet<>();

        roleSet.add(rolesOfUsers);
        userDto.setAuthority(roleSet);

        userSet.add(userDto);
        rolesOfUsers.setUserDtoSet(userSet);


        UserDto savedUser = userService.createUser(userDto);



        RolesOfUsers roles = RolesOfUsersMapper.mapToRolesOfUsers(rolesOfUsers);
        rolesOfUsersService.updateRole(roles);


//        List<RolesOfUsers> list= rolesOfUsersService.findRoleNam(rolesOfUsers.getRolename());
//        RolesOfUsers rolesOfUsersFromDB = list.get(0);

        UserDto  user2 = userService.getUserByLogin(userDto.getLogin());



//        for (RolesOfUsersDto rolesOfUsers1:user2.getAuthority()) {
//           if(rolesOfUsers1.getUserDtoSet().isEmpty()||rolesOfUsers1.getUserDtoSet().equals(null)){
//                System.out.println( "user3.getLogin()");
//            }
//
//        }

        //=================================================
        List <RolesOfUsers>  rolesOfUsers1 = rolesOfUsersService.findRoleNam(rolesOfUsers.getRolename());
        RolesOfUsers rolesOfUsers2 = rolesOfUsers1.get(0);

        for (User user:rolesOfUsers2.getUserSet()) {
            System.out.println(  user.getLogin());

        }


        //===================================================



        return new ResponseEntity<>(savedUser,  HttpStatus.CREATED);
    }
}

/*public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
    ProductDto saveProd = productService.createProduct(productDto);
    return  new ResponseEntity<>(saveProd, HttpStatus.CREATED);
}*/







/* RolesOfUsers rolesOfUsers = new RolesOfUsers();
        rolesOfUsers.setRoleName("ROLE_ADMIN");


        Set roleSet = new HashSet<>();
        Set userSet = new HashSet<>();

        roleSet.add(rolesOfUsers);
        userDto.setAuthority(roleSet);


        userSet.add(userDto);

        rolesOfUsers.setUserSet(userSet);

        Set<UserDto> set = rolesOfUsers.getUserSet();

        for (UserDto user:set) {

            System.out.println(user.getLogin());
        }

        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser,  HttpStatus.CREATED);*/




//=========================
/*
RolesOfUsers rolesOfUsers = new RolesOfUsers();
        rolesOfUsers.setRoleName("ROLE_ADMIN");

User user = UserMapper.mapToUser(userDto);
Set <RolesOfUsers> roleSet = new HashSet<>();
        roleSet.add(rolesOfUsers);
        user.setAuthority(roleSet);




Set<User> userSet = new HashSet<>();
         userSet.add(user);
        rolesOfUsers.setUserSet(userSet);


UserDto savedUser = userService.createUser(userDto);

        return new ResponseEntity<>(savedUser,  HttpStatus.CREATED);
*/





