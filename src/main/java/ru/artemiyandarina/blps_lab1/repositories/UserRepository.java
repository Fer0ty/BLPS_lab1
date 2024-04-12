package ru.artemiyandarina.blps_lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab1.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}