package com.giannis.match.service;

import com.giannis.match.entity.Match;
import com.giannis.match.entity.MatchOdd;
import com.giannis.match.exception.ResourceNotFoundException;
import com.giannis.match.repository.MatchOddsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MatchOddServiceTest {

    @Mock
    private MatchOddsRepository matchOddsRepository;

    @Mock
    private MatchService matchService;

    @InjectMocks
    private MatchOddService matchOddService;

    private MatchOdd matchOdd;

    @BeforeEach
    void setUp() {
        Match match = new Match();
        match.setId(1L);
        match.setDescription("Football Match");
        match.setTeamA("Team A");
        match.setTeamB("Team B");

        matchOdd = new MatchOdd();
        matchOdd.setId(1L);
        matchOdd.setSpecifier("Home Win");
        matchOdd.setOdd(2.5);
        matchOdd.setMatch(match);
    }

    @Test
    void testSaveOdds() {
        when(matchOddsRepository.save(matchOdd)).thenReturn(matchOdd);

        MatchOdd savedMatchOdd = matchOddService.saveOdds(matchOdd);

        assertNotNull(savedMatchOdd);
        assertEquals(1L, savedMatchOdd.getId());
        assertEquals("Home Win", savedMatchOdd.getSpecifier());
        assertEquals(2.5, savedMatchOdd.getOdd());
        verify(matchOddsRepository, times(1)).save(matchOdd);
    }

    @Test
    void testFindOddsByMatchSuccess() {
        when(matchOddsRepository.findByMatchId(1L)).thenReturn(Arrays.asList(matchOdd));

        var odds = matchOddService.findOddsByMatch(1L);

        assertNotNull(odds);
        assertFalse(odds.isEmpty());
        assertEquals(1, odds.size());
        assertEquals("Home Win", odds.get(0).getSpecifier());
        verify(matchOddsRepository, times(1)).findByMatchId(1L);
    }

    @Test
    void testFindOddsByMatchNotFound() {
        when(matchOddsRepository.findByMatchId(1L)).thenReturn(Arrays.asList());

        var odds = matchOddService.findOddsByMatch(1L);

        assertTrue(odds.isEmpty());
        verify(matchOddsRepository, times(1)).findByMatchId(1L);
    }

    @Test
    void testDeleteOddsSuccess() {
        when(matchOddsRepository.existsById(1L)).thenReturn(true);

        matchOddService.deleteOdds(1L);

        verify(matchOddsRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteOddsNotFound() {
        when(matchOddsRepository.existsById(1L)).thenReturn(false);

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            matchOddService.deleteOdds(1L);
        });

        assertEquals("MatchOdds with ID 1 not found", exception.getMessage());
        verify(matchOddsRepository, times(0)).deleteById(1L);
    }
}
