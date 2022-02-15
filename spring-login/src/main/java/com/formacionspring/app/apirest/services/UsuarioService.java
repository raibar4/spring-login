package com.formacionspring.app.apirest.services;

import java.util.List;

import com.formacionspring.app.apirest.entity.Usuario;


public interface UsuarioService {
	public List<Usuario> findAll();
	
	public Usuario findbyId(Long Id);
	
	public Usuario save(Usuario usuarios);
	
	public void delete(Long id);
}
