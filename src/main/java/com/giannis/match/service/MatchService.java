package com.giannis.match.service;

import com.giannis.match.entity.Match;
import com.giannis.match.exception.ResourceNotFoundException;
import com.giannis.match.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Transactional
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Transactional(readOnly = true)
    public Match findMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match with ID " + id + " not found"));
    }

    @Transactional
    public void deleteMatch(Long id) {
        if (!matchRepository.existsById(id)) {
            throw new ResourceNotFoundException("Match with ID " + id + " not found");
        }
        matchRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
