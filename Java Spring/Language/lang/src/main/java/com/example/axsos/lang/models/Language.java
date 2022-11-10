package com.example.axsos.lang.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="languages")
public class Language {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    
    @NotNull
    @Size(min = 2, max = 20)
    private String creator;
    
    @NotNull
    private String currentVersion;

}
