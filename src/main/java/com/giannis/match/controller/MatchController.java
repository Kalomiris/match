package com.giannis.match.controller;

import com.giannis.match.dto.MatchDTO;
import com.giannis.match.entity.Match;
import com.giannis.match.mappper.MatchMapper;
import com.giannis.match.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;
    private final MatchMapper matchMapper;

    public MatchController(MatchService matchService, MatchMapper matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @PostMapping
    public MatchDTO createMatch(@Valid @RequestBody MatchDTO matchDTO) {
        Match match = matchMapper.toMatchEntity(matchDTO);
        return matchMapper.toMatchDTO(matchService.saveMatch(match));
    }

    @GetMapping("/{id}")
    public MatchDTO getMatchById(@PathVariable Long id) {
        Match match = matchService.findMatchById(id);
        return matchMapper.toMatchDTO(match);
    }

    @GetMapping("/all")
    public List<MatchDTO> getAll() {
        List<Match> matches = matchService.getAllMatches();
        return matches.stream()
                .map(matchMapper::toMatchDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MatchDTO updateMatch(@PathVariable Long id, @Valid @RequestBody MatchDTO updatedDTO) {
        Match existingMatch = matchService.findMatchById(id);
        Match updatedMatch = matchMapper.toMatchEntity(updatedDTO);
        updatedMatch.setId(existingMatch.getId());
        return matchMapper.toMatchDTO(matchService.saveMatch(updatedMatch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
