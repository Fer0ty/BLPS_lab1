package ru.artemiyandarina.blps_lab1.schemas.petition;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
@EqualsAndHashCode(callSuper = true)
@Data
public class PetitionRead extends PetitionBase{
    @Schema(example = "1")
    private Long id;
    private String country;
    private Timestamp creationDate;
}
