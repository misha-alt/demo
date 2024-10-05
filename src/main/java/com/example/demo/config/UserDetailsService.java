package com.example.demo.config;

/*import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//@Service
//@EnableWebSecurity
@Configuration
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserService userService;

    public UserDetailsService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       UserDto userDto = userService.getUserByLogin(login);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }




        return new org.springframework.security.core.userdetails.User(
                userDto.getLogin(),
                userDto.getPassword(),
                getAuthorities(UserMapper.mapToUser(userDto))
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(RolesOfUsers roleOfPerson:user.getAuthority()){
            authorities.add(new SimpleGrantedAuthority(roleOfPerson.getRole_name()));
        }
        return authorities;
    }
}
