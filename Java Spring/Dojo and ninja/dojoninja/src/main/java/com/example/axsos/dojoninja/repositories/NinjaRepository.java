package com.example.axsos.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.axsos.dojoninja.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}
