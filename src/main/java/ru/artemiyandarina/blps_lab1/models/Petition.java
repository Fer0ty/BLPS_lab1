package ru.artemiyandarina.blps_lab1.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @Column(name = "country",nullable = false)
    private String country;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
}
