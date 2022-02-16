package com.formacionspring.app.apirest.services;

import java.util.List;

import com.formacionspring.app.apirest.entity.Jefe;


public interface JefeService {

	public List<Jefe> findAll();
	
	public Jefe findbyId(Long Id);
	
	public Jefe save(Jefe jefes);
	
	public void delete(Long id);
}
