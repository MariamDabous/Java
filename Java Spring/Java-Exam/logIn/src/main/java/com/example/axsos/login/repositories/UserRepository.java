package com.example.axsos.login.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsos.login.models.Team;
import com.example.axsos.login.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	Optional<User>findByEmail(String email);
	Optional<User>findById(Long id);
	
	 List<User> findByTeamsNotContains(Team team);
	

}
