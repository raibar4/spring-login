package com.formacionspring.app.apirest.services;

import java.util.List;

import com.formacionspring.app.apirest.entity.Empleado;


public interface EmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado findbyId(Long Id);
	
	public Empleado save(Empleado empleados);
	
	public void delete(Long id);
}
