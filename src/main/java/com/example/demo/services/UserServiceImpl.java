package com.example.demo.services;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.productDTO.UserDto;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);

        // Проверяем, есть ли пользователь, и получаем его, если он существует
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // Извлекаем User из Optional
            return UserMapper.mapToUserDto(user);
        } else {
            // Обработайте случай, когда пользователь не найден, например, выбросьте исключение
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
    @Override
    public UserDto getUserByLogin(String login) {
        User user = userRepo.findUserByLogin(login);
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public boolean  checkPassword(String rawPassword, String comparisonPassword) {
        return rawPassword.equals(comparisonPassword);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepo.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }
}