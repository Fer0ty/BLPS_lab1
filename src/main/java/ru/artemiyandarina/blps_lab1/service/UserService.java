package ru.artemiyandarina.blps_lab1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.dto.UserData;
import ru.artemiyandarina.blps_lab1.entity.UserEntity;
import ru.artemiyandarina.blps_lab1.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserData login(String login, String password) {
        UserEntity user = userRepository.findByEmailAndPassword(login, password);
        if (user == null) {
            throw new IllegalArgumentException("invalid email or password");
        } else {
            return new UserData(user);
        }
    }

    public UserData register(UserEntity user) {
        if (user.getEmail() == null || user.getFirstName() == null ||user.getLastName() == null|| user.getPassword() == null) {
            throw new IllegalArgumentException("Login, email, first name, last name and password are required for registration");
        }
        if (user.getEmail().length() > 255) {
            throw new IllegalArgumentException("Email cannot be longer than 255 symbols");
        }
        if (user.getFirstName().length() > 255) {
            throw new IllegalArgumentException("First name cannot be longer than 40 symbols");
        }
        if (user.getLastName().length() > 255) {
            throw new IllegalArgumentException("Last name cannot be longer than 40 symbols");
        }
        if (user.getPassword().length() > 255) {
            throw new IllegalArgumentException("Password cannot be longer than 255 symbols");
        }

        // Email uniqueness check
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Login is already taken");
        }

        // :))))))))))))
        return new UserData(userRepository.save(user));
    }
}
