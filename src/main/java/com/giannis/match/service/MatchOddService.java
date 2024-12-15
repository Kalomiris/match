package com.giannis.match.service;

import com.giannis.match.entity.MatchOdd;
import com.giannis.match.exception.ResourceNotFoundException;
import com.giannis.match.repository.MatchOddsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchOddService {

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddService(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @Transactional
    public MatchOdd saveOdds(MatchOdd odds) {
        return matchOddsRepository.save(odds);
    }

    @Transactional(readOnly = true)
    public List<MatchOdd> findOddsByMatch(Long matchId) {
        return matchOddsRepository.findByMatchId(matchId);
    }

    @Transactional
    public void deleteOdds(Long id) {
        if (!matchOddsRepository.existsById(id)) {
            throw new ResourceNotFoundException("MatchOdds with ID " + id + " not found");
        }
        matchOddsRepository.deleteById(id);
    }
}
