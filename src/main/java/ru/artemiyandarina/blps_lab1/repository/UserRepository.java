package ru.artemiyandarina.blps_lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab1.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);

}