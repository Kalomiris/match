package com.giannis.match.entity;
import com.giannis.match.enums.Sport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate matchDate;

    private LocalTime matchTime;

    private String teamA;

    private String teamB;

    @Enumerated(EnumType.STRING)
    private Sport sport;
}