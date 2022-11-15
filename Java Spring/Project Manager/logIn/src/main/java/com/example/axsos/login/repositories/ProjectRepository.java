package com.example.axsos.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsos.login.models.Project;


@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long> {
	List<Project> findAll();

}
