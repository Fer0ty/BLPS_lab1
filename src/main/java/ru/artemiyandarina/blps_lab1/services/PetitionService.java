package ru.artemiyandarina.blps_lab1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.models.Petition;
import ru.artemiyandarina.blps_lab1.models.User;
import ru.artemiyandarina.blps_lab1.repositories.PetitionRepository;
import ru.artemiyandarina.blps_lab1.repositories.UserRepository;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionCreate;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionRead;
import ru.artemiyandarina.blps_lab1.schemas.user.UserRegister;
import ru.artemiyandarina.blps_lab1.services.mapping.PetitionMapper;
import ru.artemiyandarina.blps_lab1.exceptions.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetitionService {
    final PetitionRepository petitionRepository;
    final PetitionMapper petitionMapper;
    final UserRepository userRepository;

    public Set<PetitionRead> getAll() {
        return petitionRepository.findAll().stream()
                .map(petitionMapper::mapEntityToPetitionRead)
                .collect(Collectors.toSet());
    }

    public PetitionRead create(PetitionCreate schema) {
        Petition newPetition = petitionMapper.mapPetitionCreateToEntity(schema);
        User checkUser = userRepository.findById(newPetition.getOwner().getId()).orElseThrow(NotFoundException::new);
        if (checkUser.getEmail().equals(newPetition.getOwner().getEmail()) &&
        checkUser.getPassword().equals(newPetition.getOwner().getPassword())){
            newPetition = petitionRepository.save(newPetition);
        } else {
            throw new NotFoundException();
        }
        return petitionMapper.mapEntityToPetitionRead(newPetition);
    }


    public PetitionRead getById(Long id) {
        Petition petition = petitionRepository.findById(id).orElseThrow(NotFoundException::new);
        return petitionMapper.mapEntityToPetitionRead(
                petition
        );
    }

    public void delete(Long petitionId) {
        Petition petition = petitionRepository.findById(petitionId).orElseThrow(NotFoundException::new);
        petitionRepository.delete(
                petition
        );
    }

    public Set<PetitionRead> getByCountry(String country) {
        return petitionRepository.findByCountry(country).stream()
                .map(petitionMapper::mapEntityToPetitionRead)
                .collect(Collectors.toSet());
    }

//    public Set<PetitionRead> getByTopic(String topic) {
//        return petitionRepository.findByTopic(topic).stream()
//                .map(petitionMapper::mapEntityToPetitionRead)
//                .collect(Collectors.toSet());
//    }

}
