package ru.artemiyandarina.blps_lab1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.dto.PetitionData;
import ru.artemiyandarina.blps_lab1.entity.PetitionEntity;
import ru.artemiyandarina.blps_lab1.entity.UserEntity;
import ru.artemiyandarina.blps_lab1.repository.PetitionRepository;
import ru.artemiyandarina.blps_lab1.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {

    @Autowired
    private static PetitionRepository petitionRepository;

    @Autowired
    private UserRepository userRepository;

    public PetitionData createPetition(PetitionData petition, Long authorId) {
        // Check if title is not empty
        if (petition.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Petition title cannot be empty");
        }
        if (petition.getTitle().length() > 255) {
            throw new IllegalArgumentException("Petition title cannot be longer than 255 symbols");
        }
        if (petition.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Petition title cannot be empty");
        }
        if (petition.getDescription().length() > 8000) {
            throw new IllegalArgumentException("Petition description cannot be longer than 8000 symbols");
        }
        if (petition.getCountry().isEmpty()){
            throw new IllegalArgumentException("Country name cannot be empty");
        }
        if (petition.getCountry().length()>255){
            throw new IllegalArgumentException("Country name cannot be longer than 255 symbols");
        }

        // Find creator
        UserEntity creator = userRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Creator not found"));
        PetitionEntity petitionEntity = new PetitionEntity();
        petitionEntity.setTitle(petitionEntity.getTitle());
        petitionEntity.setDescription(petitionEntity.getDescription());
        petitionEntity.setCreator(creator);
        petitionEntity.setCountry(petitionEntity.getCountry());
        petitionEntity.setStartDate(LocalDateTime.now());

        return new PetitionData(petitionRepository.save(petitionEntity));
    }

    public PetitionData getPetitionById(Long issueId) {
        try {
            PetitionEntity petition = petitionRepository.findById(issueId).orElse(null);
            if (petition == null) {
                return null;
            }
            return new PetitionData(petition);
        } catch (Exception e) {
            throw new IllegalArgumentException("Internal error while finding issue");
        }
    }

    public static void deletePetitionById(Long issueId) {
        try {
            petitionRepository.deleteById(issueId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Internal error while deleting issue");
        }

    }

    public List<PetitionData> getAll() {
        try {
            List<PetitionEntity> petitionEntities = petitionRepository.findAll();
            List<PetitionData> petitionDataList = new ArrayList<>();
            for (PetitionEntity pe : petitionEntities) {
                petitionDataList.add(new PetitionData(pe));
            }
            return petitionDataList;
        } catch (Exception e) {
            throw new IllegalArgumentException("Internal error while getting issues");
        }
    }
}
