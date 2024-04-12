package ru.artemiyandarina.blps_lab1.schemas.petition;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PetitionBase {
    @Schema(example = "БЛПС")
    @NotBlank
    @Size(max = 50)
    private String title;
    @Schema(example = "ААААААА ПОМОГИТЕ")
    @NotBlank
    private String description;
    @Schema(example = "Russia")
    @NotBlank
    private String country;
}

