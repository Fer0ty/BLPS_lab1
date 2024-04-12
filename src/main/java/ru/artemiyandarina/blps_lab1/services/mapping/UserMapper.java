package ru.artemiyandarina.blps_lab1.services.mapping;

import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.models.User;
import ru.artemiyandarina.blps_lab1.schemas.user.*;

@Service
public class UserMapper {
    protected User mapUserBaseToEntity(UserBase schema, User entity) {
        entity.setFirstName(schema.getFirstName());
        entity.setLastName(schema.getLastName());
        entity.setEmail(schema.getEmail());
        return entity;
    }

    protected User mapUserBaseToEntity(UserBase schema) {
        return mapUserBaseToEntity(schema, new User());
    }

    public User mapUserRegistrationToEntity(UserRegister schema) {
        User entity = mapUserBaseToEntity(schema);
        entity.setPassword(schema.getPassword());
        return entity;
    }

    public UserRead mapEntityToUserRead(User entity) {
        UserRead schema = new UserRead();
        schema.setId(entity.getId());
        schema.setFirstName(entity.getFirstName());
        schema.setLastName(entity.getLastName());
        schema.setEmail(entity.getEmail());
        return schema;
    }
}

