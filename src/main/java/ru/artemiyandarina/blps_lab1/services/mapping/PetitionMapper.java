package ru.artemiyandarina.blps_lab1.services.mapping;

import org.springframework.stereotype.Service;
import ru.artemiyandarina.blps_lab1.enums.Country;
import ru.artemiyandarina.blps_lab1.models.Petition;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionBase;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionCreate;
import ru.artemiyandarina.blps_lab1.schemas.petition.PetitionRead;

import java.sql.Timestamp;

@Service
public class PetitionMapper {
    protected Petition mapPetitionBaseToEntity(PetitionBase schema, Petition entity) {
        entity.setTitle(schema.getTitle());
        entity.setDescription(schema.getDescription());
        entity.setCreationDate(new Timestamp(System.currentTimeMillis()));
        entity.setCountry(schema.getCountry());
        entity.setOwner(schema.getOwner());
        return entity;
    }

    protected Petition mapPetitionBaseToEntity(PetitionBase schema) {
        return mapPetitionBaseToEntity(schema, new Petition());
    }

    public Petition mapPetitionCreateToEntity(PetitionCreate schema) {
        return mapPetitionBaseToEntity(schema);
    }

    public PetitionRead mapEntityToPetitionRead(Petition entity) {
        PetitionRead schema = new PetitionRead();
        schema.setId(entity.getId());
        schema.setTitle(entity.getTitle());
        schema.setDescription(entity.getDescription());
        schema.setCreationDate(entity.getCreationDate());
        schema.setCountry(entity.getCountry());
        return schema;
    }

}
