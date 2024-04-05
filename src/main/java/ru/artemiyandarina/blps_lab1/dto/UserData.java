package ru.artemiyandarina.blps_lab1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.artemiyandarina.blps_lab1.entity.UserEntity;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserData {
    private long id;
    private String firstName;
    private String lastName;


    public UserData(UserEntity user){
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
    }


}
