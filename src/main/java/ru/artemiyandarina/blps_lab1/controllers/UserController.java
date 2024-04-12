package ru.artemiyandarina.blps_lab1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.artemiyandarina.blps_lab1.services.UserService;
import ru.artemiyandarina.blps_lab1.schemas.user.UserRead;
import ru.artemiyandarina.blps_lab1.schemas.user.UserRegister;


@Tag(name = "Пользователи")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Регистрирует пользователя")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserRead registerUser(@RequestBody @Valid UserRegister schema) {
        return userService.register(schema);
    }

    @Operation(summary = "Возвращает пользователя")
    @GetMapping("/{id}")
    public UserRead getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Удаляет пользователя")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
