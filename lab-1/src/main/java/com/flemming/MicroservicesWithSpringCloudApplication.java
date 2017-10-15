package com.flemming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flemming.model.Player;
import com.flemming.model.Team;
import com.flemming.repository.TeamRepository;

@SpringBootApplication
public class MicroservicesWithSpringCloudApplication {

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesWithSpringCloudApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<Player>();
		players.add(new Player("Grzejnik", "Bramkarz"));
		
		List<Team> teamList = new ArrayList<Team>();

		Team team1 = new Team("team_1", "Lodz", players);
		Team team2 = new Team("team_2", "Gdansk", null);

		teamList.add(team1);
		teamList.add(team2);

		teamRepository.save(teamList);
	}
}
