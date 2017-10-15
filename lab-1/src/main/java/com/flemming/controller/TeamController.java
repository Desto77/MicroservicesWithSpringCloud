package com.flemming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flemming.model.Team;
import com.flemming.repository.TeamRepository;

public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}

	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable("id") Long id) {
		return teamRepository.findOne(id);
	}

}
