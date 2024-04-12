package ru.artemiyandarina.blps_lab1.schemas.petition;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PetitionCreate extends PetitionBase {
    @Size(max = 30)
    private String country;
}



