package com.example.axsos.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.login.models.Project;
import com.example.axsos.login.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	private final ProjectRepository projectrepository;

	public ProjectService(ProjectRepository projectrepository) {
		this.projectrepository = projectrepository;
	}
	public List<Project> allprojects(){
		return projectrepository.findAll();
	}
	
	public Project createProject(Project a) {
		return projectrepository.save(a);
	}
	
	 public Project findProject(Long id) {
	        Optional<Project> optionalProject = projectrepository.findById(id);
	        if(optionalProject.isPresent()) {
	            return optionalProject.get();
	        } else {
	            return null;
	        }
	    }
	
	 public Project updateProject(Project b) {
			return this.projectrepository.save(b);
			
		}
	 
	 public void deleteProject(Long id) {
		 projectrepository.deleteById(id);
	 }
	 
}
