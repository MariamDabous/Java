package com.example.axsos.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.axsos.dojoninja.models.Dojo;



public interface DojoRepository extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();
}
