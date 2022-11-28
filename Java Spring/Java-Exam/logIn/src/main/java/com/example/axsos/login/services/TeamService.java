package com.example.axsos.login.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.axsos.login.models.Team;
import com.example.axsos.login.models.User;
import com.example.axsos.login.repositories.TeamRepository;

@Repository
public class TeamService {
	private final TeamRepository teamRepository;

	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}
	
	public List<Team> allTeams() {
		return teamRepository.findAll();
	}
	
	public Team findTeam(Long id) {
		return this.teamRepository.findById(id).orElse(null);
	}
	
	public Team updateTeam(Team b) {
		return this.teamRepository.save(b);
		
	}
	
	public List<Team> notselected2(User a){
		return teamRepository.findByUsersNotContains(a);
	}
	
	public void deleteTeam(Long id) {
		teamRepository.deleteById(id);
	 }
	

}
