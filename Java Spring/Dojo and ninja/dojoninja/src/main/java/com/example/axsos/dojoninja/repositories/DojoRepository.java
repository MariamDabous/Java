package com.example.axsos.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsos.dojoninja.models.Dojo;


@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    
	List<Dojo> findAll();
}
