package ru.artemiyandarina.blps_lab1.services;

import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.models.User;
import ru.artemiyandarina.blps_lab1.repositories.UserRepository;

import ru.artemiyandarina.blps_lab1.schemas.user.UserRead;
import ru.artemiyandarina.blps_lab1.schemas.user.UserRegister;
import ru.artemiyandarina.blps_lab1.services.mapping.UserMapper;
import ru.artemiyandarina.blps_lab1.exceptions.NotFoundException;
@Service
public class UserService {
    final UserRepository userRepository;
    final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserRead register(UserRegister schema) {
        User newUser = userMapper.mapUserRegistrationToEntity(schema);
        newUser = userRepository.save(newUser);
        return userMapper.mapEntityToUserRead(newUser);
    }

    public UserRead getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        return userMapper.mapEntityToUserRead(user);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.delete(user);
    }
}
