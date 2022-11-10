package com.example.axsos.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.dojoninja.models.Dojo;
import com.example.axsos.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojorepository;

	public DojoService(DojoRepository dojorepository) {
		this.dojorepository = dojorepository;
	}
	public List<Dojo> alldojos(){
		return dojorepository.findAll();
	}
	
	public Dojo createDojo(Dojo a) {
		return dojorepository.save(a);
	}
	
	 public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojorepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	
	 public Dojo updateDojo(Dojo b) {
			return this.dojorepository.save(b);
			
		}
	 
	 public void deleteDojo(Long id) {
		 dojorepository.deleteById(id);
	 }
	 
}
