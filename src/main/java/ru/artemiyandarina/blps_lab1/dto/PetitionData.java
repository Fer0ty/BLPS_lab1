package ru.artemiyandarina.blps_lab1.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import ru.artemiyandarina.blps_lab1.entity.PetitionEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PetitionData {
    private Long id;
    @Size(max = 255)
    @NonNull
    private String title;
    @Size(max = 8000)
    @NonNull
    private String description;
    private LocalDateTime startDate;
    private UserData creator;
    private String country;

    public PetitionData(PetitionEntity petition) {
        this.setId(petition.getId());
        this.setStartDate(petition.getStartDate());
        this.setTitle(petition.getTitle());
        this.setDescription(petition.getDescription());
        this.setCreator(new UserData(petition.getCreator()));
        this.setCountry(petition.getCountry());
    }
}
