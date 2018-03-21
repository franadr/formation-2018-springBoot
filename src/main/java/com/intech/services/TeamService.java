package com.intech.services;

import com.intech.converters.TeamConverter;
import com.intech.dto.TeamDto;
import com.intech.errors.exceptions.HeroNotFoundException;
import com.intech.model.Team;
import com.intech.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeamService {

	private TeamRepository teamRepository;

	private TeamConverter teamConverter;

	public TeamService(TeamRepository teamRepository, TeamConverter teamConverter){
	    this.teamRepository = teamRepository;
	    this.teamConverter = teamConverter;
    }

	public List<TeamDto> findAllTeams() {
		return StreamSupport.stream(teamRepository.findAll().spliterator(), false)
                .map(teamConverter::convert)
                .collect(Collectors.toList());
	}

	public TeamDto findTeamById(Long id) {
		return teamRepository.findById(id)
				.map(teamConverter::convert)
				.orElseThrow(()->new HeroNotFoundException(id));
	}

	public void updateTeam(Long id, TeamDto teamDto) {
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(()->new HeroNotFoundException(id));

        Team modifiedTeam = existingTeam.toBuilder()
                .name(teamDto.getName())
                .build();

        teamRepository.save(modifiedTeam);
	}

}
