package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/

import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Autowired
//    private DataSource dataSource;
//    /*@Autowired
//    private UserDetailsServiceImpl userDetailsService;*/
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//
//                .antMatchers(HttpMethod.GET,"/test").hasRole("EMPLOEE")
//                .antMatchers(HttpMethod.POST,"/test").hasRole("EMPLOEE")
//                .anyRequest().authenticated()
//                .and().formLogin()
//                //.loginPage("/login").permitAll()
//                .and().logout()
//                .logoutSuccessUrl("/test")
//                .and()
//                .csrf().disable();
//    }
}