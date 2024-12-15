package com.giannis.match.mappper;

import com.giannis.match.dto.MatchDTO;
import com.giannis.match.dto.MatchOddDTO;
import com.giannis.match.entity.Match;
import com.giannis.match.entity.MatchOdd;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    MatchDTO toMatchDTO(Match match);

    Match toMatchEntity(MatchDTO dto);

    MatchOddDTO toMatchOddsDTO(MatchOdd odds);

    MatchOdd toMatchOddsEntity(MatchOddDTO dto);
}
