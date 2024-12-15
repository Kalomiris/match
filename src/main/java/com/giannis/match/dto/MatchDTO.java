package com.giannis.match.dto;

import com.giannis.match.entity.MatchOdd;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MatchDTO {

    public MatchDTO(Long id, String description, LocalDate matchDate, LocalTime matchTime, String teamA, String teamB, String sport) {
        this.id = id;
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

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
    @Pattern(regexp = "BASKETBALL|FOOTBALL", message = "Sport must be either BASKETBALL or FOOTBALL")
    private String sport;

    private List<MatchOddDTO> matchOdds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<MatchOddDTO> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOddDTO> matchOdds) {
        this.matchOdds = matchOdds;
    }

    public @NotBlank(message = "Description is mandatory") String getDescription() {
        return description;
    }

    public @NotNull(message = "Match date is required") LocalDate getMatchDate() {
        return matchDate;
    }

    public @NotNull(message = "Match time is required") LocalTime getMatchTime() {
        return matchTime;
    }

    public @NotBlank(message = "Team A is required") String getTeamA() {
        return teamA;
    }

    public @NotBlank(message = "Team B is required") String getTeamB() {
        return teamB;
    }

    public @NotBlank(message = "Sport is required") String getSport() {
        return sport;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(@NotBlank(message = "Description is mandatory") String description) {
        this.description = description;
    }

    public void setMatchDate(@NotNull(message = "Match date is required") LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public void setMatchTime(@NotNull(message = "Match time is required") LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public void setTeamA(@NotBlank(message = "Team A is required") String teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(@NotBlank(message = "Team B is required") String teamB) {
        this.teamB = teamB;
    }

    public void setSport(@NotBlank(message = "Sport is required") String sport) {
        this.sport = sport;
    }
}
