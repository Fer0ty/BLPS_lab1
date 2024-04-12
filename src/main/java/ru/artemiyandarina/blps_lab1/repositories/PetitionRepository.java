package ru.artemiyandarina.blps_lab1.repositories;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab1.models.Petition;

import java.util.List;
import java.util.Optional;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
    Optional<Petition> findById(@NonNull Long id);

    List<Petition> findByCountry(String country);

    List<Petition> findByTopic(String topic);
}
