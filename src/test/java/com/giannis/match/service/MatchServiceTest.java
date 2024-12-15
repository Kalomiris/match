package com.giannis.match.service;

import com.giannis.match.entity.Match;
import com.giannis.match.entity.MatchOdd;
import com.giannis.match.exception.ResourceNotFoundException;
import com.giannis.match.repository.MatchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MatchServiceTest {

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchService matchService;

    private Match match;

    @BeforeEach
    void setUp() {
        match = new Match();
        match.setId(1L);
        match.setDescription("Football Match");
        match.setMatchDate(LocalDate.of(2024, 12, 16));
        match.setMatchTime(LocalTime.of(18, 30));
        match.setTeamA("Team A");
        match.setTeamB("Team B");

        MatchOdd matchOdd = new MatchOdd();
        matchOdd.setId(1L);
        matchOdd.setSpecifier("Home Win");
        matchOdd.setOdd(2.5);
        matchOdd.setMatch(match);
        match.setMatchOdds(Collections.singletonList(matchOdd)); // Add the odd to the match's odds list
    }

    @Test
    void testSaveMatch() {
        when(matchRepository.save(match)).thenReturn(match);

        Match savedMatch = matchService.saveMatch(match);

        assertNotNull(savedMatch);
        assertEquals(1L, savedMatch.getId());
        assertEquals("Football Match", savedMatch.getDescription());
        assertNotNull(savedMatch.getMatchOdds());
        assertEquals(1, savedMatch.getMatchOdds().size()); // Ensure the odds are associated correctly
        verify(matchRepository, times(1)).save(match);
    }

    @Test
    void testFindMatchByIdSuccess() {
        when(matchRepository.findById(1L)).thenReturn(Optional.of(match));

        Match foundMatch = matchService.findMatchById(1L);

        assertNotNull(foundMatch);
        assertEquals(1L, foundMatch.getId());
        assertEquals("Football Match", foundMatch.getDescription());
        assertNotNull(foundMatch.getMatchOdds());
        assertEquals(1, foundMatch.getMatchOdds().size()); // Verify that match odds are present
        verify(matchRepository, times(1)).findById(1L);
    }

    @Test
    void testFindMatchByIdNotFound() {
        when(matchRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            matchService.findMatchById(1L);
        });

        assertEquals("Match with ID 1 not found", exception.getMessage());
        verify(matchRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteMatchSuccess() {
        when(matchRepository.existsById(1L)).thenReturn(true);

        matchService.deleteMatch(1L);

        verify(matchRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteMatchNotFound() {
        when(matchRepository.existsById(1L)).thenReturn(false);

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            matchService.deleteMatch(1L);
        });

        assertEquals("Match with ID 1 not found", exception.getMessage());
        verify(matchRepository, times(0)).deleteById(1L);
    }

    @Test
    void testGetAllMatches() {
        when(matchRepository.findAll()).thenReturn(Collections.singletonList(match));

        var result = matchService.getAllMatches();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Football Match", result.get(0).getDescription());
        assertNotNull(result.get(0).getMatchOdds());
        assertEquals(1, result.get(0).getMatchOdds().size()); // Verify odds associated with match
        verify(matchRepository, times(1)).findAll();
    }
}
