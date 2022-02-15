package com.formacionspring.app.apirest.services;

import java.util.List;

import com.formacionspring.app.apirest.entity.Departamento;


public interface DepartamentoService {
	public List<Departamento> findAll();
	
	public Departamento findbyId(Long Id);
	
	public Departamento save(Departamento departamentos);
	
	public void delete(Long id);
}
