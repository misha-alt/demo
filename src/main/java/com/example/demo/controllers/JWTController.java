package com.example.demo.controllers;

import com.example.demo.config.JWTTokenProvider;
import com.example.demo.model.User;
import com.example.demo.productDTO.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class JWTController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;


    @PostMapping()
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        UserDto foundUser = userService.getUserByLogin(user.getLogin());

        if (foundUser != null && userService.checkPassword(user.getPassword(), foundUser.getPassword())) {
            String token = jwtTokenProvider.createToken(foundUser.getLogin());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            System.out.println("token ok");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}