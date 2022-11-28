package com.example.axsos.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsos.login.models.Team;
import com.example.axsos.login.models.User;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
		
		List<Team> findAll();
		
	    List<Team> findByUsersNotContains(User user);

		

	}