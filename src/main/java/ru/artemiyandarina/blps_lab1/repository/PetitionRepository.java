package ru.artemiyandarina.blps_lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.artemiyandarina.blps_lab1.entity.PetitionEntity;

import java.util.List;

@Repository
public interface PetitionRepository extends JpaRepository<PetitionEntity, Long> {
    List<PetitionEntity> findByCountryContainingIgnoreCase(String title);
    List<PetitionEntity> findByCreatorId(Long creatorId);
}