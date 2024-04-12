package ru.artemiyandarina.blps_lab1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemiyandarina.blps_lab1.dto.PetitionData;
import ru.artemiyandarina.blps_lab1.service.PetitionService;

import java.util.List;

@RestController
@RequestMapping("/api/petition")
@CrossOrigin
public class PetitionController {

    @Autowired
    private PetitionService petitionService;

    @PostMapping()
    public ResponseEntity<?> createPetition(@RequestBody PetitionData petition, @RequestParam Long creatorId) {
        try {
            return ResponseEntity.ok(petitionService.createPetition(petition, creatorId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal error while creating petition");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePetitionById(@PathVariable Long id) {
        try {
            PetitionService.deletePetitionById(id);
            return ResponseEntity.ok("Petition deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal error while deleting petition");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPetitions() {
        try {
            List<PetitionData> petitionDataList = petitionService.getAll();
            return ResponseEntity.ok(petitionDataList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal error while deleting petition");
        }

    }
}
