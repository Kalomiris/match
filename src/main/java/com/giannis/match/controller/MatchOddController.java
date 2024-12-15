package com.giannis.match.controller;

import com.giannis.match.dto.MatchOddDTO;
import com.giannis.match.entity.Match;
import com.giannis.match.entity.MatchOdd;
import com.giannis.match.mappper.MatchMapper;
import com.giannis.match.service.MatchOddService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches/{matchId}/odd")
@Validated
public class MatchOddController {

    private final MatchOddService oddsService;
    private final MatchMapper matchMapper;

    public MatchOddController(MatchOddService oddsService, MatchMapper matchMapper) {
        this.oddsService = oddsService;
        this.matchMapper = matchMapper;
    }

    @PostMapping
    public MatchOddDTO createOdds(@PathVariable Long matchId, @Valid @RequestBody MatchOddDTO oddsDTO) {
        MatchOdd odd = matchMapper.toMatchOddsEntity(oddsDTO);
        Match match = new Match();
        match.setId(matchId);
        odd.setMatch(match);
        return matchMapper.toMatchOddsDTO(oddsService.saveOdds(odd));
    }
}
