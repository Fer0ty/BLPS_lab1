package ru.artemiyandarina.blps_lab1.schemas.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRead extends UserBase {
    private Long id;
}
