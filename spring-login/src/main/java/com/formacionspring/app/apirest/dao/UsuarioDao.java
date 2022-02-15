package com.formacionspring.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.app.apirest.entity.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario,Long>{

}
