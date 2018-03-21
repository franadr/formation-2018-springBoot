package com.intech.controllers;

import com.intech.dto.TeamDto;
import com.intech.services.TeamService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log
@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	@ApiOperation(
			value = "Retrieve the full team list"
	)
	@GetMapping
	public @ResponseBody Iterable<TeamDto> getAllTeames() {
		log.info("GET /teams");
		return teamService.findAllTeams();
	}

	@ApiOperation(
			value = "Retrieve information about a specific team"
	)
	@GetMapping(value = "/{id}")
	public @ResponseBody TeamDto getATeam(@PathVariable Long id) {
		log.info("GET /teams/" + id);
		return teamService.findTeamById(id);
		// TODO : Java formation => handle no such element Exception
	}

	@ApiOperation(
			value = "Uptade information of a specific team"
	)
	@PutMapping(value = "/{id}")
	public void updateATeam(@PathVariable Long id, @RequestBody @Valid TeamDto team) {
		log.info("PUT /teams/" + id);
		teamService.updateTeam(id, team);
	}

}
