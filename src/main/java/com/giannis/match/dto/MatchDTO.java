package com.giannis.match.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
public class MatchDTO {
    private Long id;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Match date is required")
    private LocalDate matchDate;

    @NotNull(message = "Match time is required")
    private LocalTime matchTime;

    @NotBlank(message = "Team A is required")
    private String teamA;

    @NotBlank(message = "Team B is required")
    private String teamB;

    @NotBlank(message = "Sport is required")
    private String sport;
}
