package com.example.axsos.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.dojoninja.models.Ninja;
import com.example.axsos.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjarepository;

	public NinjaService(NinjaRepository ninjarepository) {
		this.ninjarepository = ninjarepository;
	}
	public List<Ninja> allninjas(){
		return ninjarepository.findAll();
	}
	
	public Ninja createNinja(Ninja a) {
		return ninjarepository.save(a);
	}
	
	 public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjarepository.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
	
	 public Ninja updateNinja(Ninja b) {
			return this.ninjarepository.save(b);
			
		}
	 
	 public void deleteNinja(Long id) {
		 ninjarepository.deleteById(id);
	 }
	 
}
