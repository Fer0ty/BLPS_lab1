package ru.artemiyandarina.blps_lab1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionCreate;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionRead;
import ru.artemiyandarina.blps_lab1.services.PetitionService;

import java.util.Set;

@Tag(
        name = "Петиция",
        description = "Тут находятся описание методов для работы с петициями."
)
@RestController
@RequestMapping("/petition")
@Validated
public class PetitionController {
    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @Operation(
            summary = "Создать петицию",
            description = "Создает новую петицию."
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PetitionRead createPetition(@RequestBody @Valid PetitionCreate schema) {
        return petitionService.create(schema);
    }

    @Operation(
            summary = "Список петиций",
            description = "Возвращает список всех петиций."
    )
    @GetMapping
    public Set<PetitionRead> getAll() {
        return petitionService.getAll();
    }

    @Operation(
            summary = "Возвращает петицию",
            description = "Возвращает информацию о петиции."
    )
    @GetMapping("/{id}")
    public PetitionRead getPetition(@PathVariable Long id) {
        return petitionService.getById(id);
    }

    @Operation(
            summary = "Удалить петицию",
            description = "Удаляет петицию по её идентификатору."
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePetition(@PathVariable Long id) {
        petitionService.delete(id);
    }

    @GetMapping("country/{country}")
    public Set<PetitionRead> getByCountry(@PathVariable String country) {
        return petitionService.getByCountry(country);
    }

}
