package ru.artemiyandarina.blps_lab1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "petition")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PetitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private UserEntity creator;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDateTime startDate;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
}
