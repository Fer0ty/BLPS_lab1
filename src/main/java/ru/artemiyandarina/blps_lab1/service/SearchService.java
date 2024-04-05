package ru.artemiyandarina.blps_lab1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.dto.PetitionData;
import ru.artemiyandarina.blps_lab1.entity.PetitionEntity;
import ru.artemiyandarina.blps_lab1.repository.PetitionRepository;
import ru.artemiyandarina.blps_lab1.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private PetitionRepository petitionRepository;
    private UserRepository userRepository;
    public List<PetitionData> searchPetitionsByCountry(String county) {
        List<PetitionEntity> petitionEntities = petitionRepository.findByCountryContainingIgnoreCase(county);
        List<PetitionData> petitionDataList = new ArrayList<>();
        for (PetitionEntity pe : petitionEntities) {
            petitionDataList.add(new PetitionData(pe));
        }
        return petitionDataList;
    }

//    todo: searchByCreatorId
}
