package com.formacionspring.app.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspring.app.apirest.dao.DepartamentoDao;
import com.formacionspring.app.apirest.entity.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao departamentoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAll() {
		return (List<Departamento>) departamentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento findbyId(Long Id) {
		return departamentoDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Departamento save(Departamento departamentos) {
		return departamentoDao.save(departamentos);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		departamentoDao.deleteById(id);

	}

}
