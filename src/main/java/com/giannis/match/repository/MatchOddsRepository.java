package com.giannis.match.repository;

import com.giannis.match.entity.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdd, Long> {
    List<MatchOdd> findByMatchId(Long matchId);
}