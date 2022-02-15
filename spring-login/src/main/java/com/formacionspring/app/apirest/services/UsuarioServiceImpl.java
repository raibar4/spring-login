package com.formacionspring.app.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspring.app.apirest.dao.UsuarioDao;
import com.formacionspring.app.apirest.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findbyId(Long Id) {
		return usuarioDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuarios) {
		return usuarioDao.save(usuarios);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);

	}

}
