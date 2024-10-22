package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig   {

    @Autowired
    private DataSource dataSource;
    /*@Autowired
    private UserDetailsServiceImpl userDetailsService;*/

    @Autowired
    private JWTTokenFilter jwtTokenFilter; // Ваша реализация фильтра

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Включаем поддержку CORS
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers(HttpMethod.GET, "/test").hasRole("EMPLOEE")
                        .antMatchers(HttpMethod.POST, "/test").hasRole("EMPLOEE")
                        .antMatchers(HttpMethod.POST,"/auth").permitAll()
                        .anyRequest().authenticated() // Все другие запросы требуют аутентификации
                )
                //.formLogin(withDefaults()) // Используем стандартную форму входа

                .logout(logout -> logout
                        .logoutSuccessUrl("/auth")
                )
                .csrf().disable() // Отключаем CSRF
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // Регистрация фильтра

        return http.build();
    }
}