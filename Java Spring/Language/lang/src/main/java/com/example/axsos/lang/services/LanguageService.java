package com.example.axsos.lang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.lang.models.Language;
import com.example.axsos.lang.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languagerepository;

	public LanguageService(LanguageRepository languagerepository) {
		this.languagerepository = languagerepository;
	}
	public List<Language> alllanguages(){
		return languagerepository.findAll();
	}
	
	public Language createLanguage(Language a) {
		return languagerepository.save(a);
	}
	
	 public Language findLanguage(Long id) {
	        Optional<Language> optionalLanguage = languagerepository.findById(id);
	        if(optionalLanguage.isPresent()) {
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
	
	 public Language updateLanguage(Language b) {
			return this.languagerepository.save(b);
			
		}
	 
	 public void deleteLanguage(Long id) {
		 languagerepository.deleteById(id);
	 }
	 
	 

	
	
}
