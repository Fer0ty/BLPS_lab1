package ru.artemiyandarina.blps_lab1.schemas.petition;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.artemiyandarina.blps_lab1.models.User;

@EqualsAndHashCode(callSuper = true)
@Data
public class PetitionCreate extends PetitionBase {
    @Size(max = 30)
    @Schema(example = "RUSSIA")
    private String country;

    private User owner;
}



