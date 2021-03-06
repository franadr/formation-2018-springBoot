package com.intech.converters;

import com.intech.api.MemberDto;
import com.intech.api.TeamDto;
import com.intech.model.Team;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public final class TeamConverter implements Converter<Team, TeamDto> {

	@Override
	public TeamDto convert(Team team) {
		TeamDto dto = new TeamDto();
		BeanUtils.copyProperties(team, dto);
		dto.setMembers(team.getMembers().stream()
			.map(member-> new MemberDto(member.getHeroName(),"/superheroes/"+member.getIdHero()))
			.collect(Collectors.toList()));
		return dto;
	}

}
