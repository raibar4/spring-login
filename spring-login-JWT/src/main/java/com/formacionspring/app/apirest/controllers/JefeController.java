package com.formacionspring.app.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.app.apirest.entity.Jefe;
import com.formacionspring.app.apirest.services.JefeService;

@RestController
@RequestMapping("api")
public class JefeController {
	@Autowired
	private JefeService servicio;

	@GetMapping("jefes")
	public List<Jefe> jefe() {
		return servicio.findAll();
	}

	@GetMapping("jefes/{id}")
	public ResponseEntity<?> empleadoShow(@PathVariable Long id) {
		Jefe jefe = null;
		Map<String, Object> response = new HashMap<>();

		try {
			jefe = servicio.findbyId(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (jefe == null) {
			response.put("mensaje", "El empleado ID:".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Jefe>(jefe, HttpStatus.OK);
	}

	@PostMapping("jefes")
	public ResponseEntity<?> saveEmpleado(@RequestBody Jefe jefe) {
		Jefe jefeNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			jefeNew = servicio.save(jefe);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido creado con éxito!");
		response.put("", jefeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("jefes/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Jefe jefe, @PathVariable Long id) {

		Jefe jefeActual = servicio.findbyId(id);
		Map<String, Object> response = new HashMap<>();

		try {
			jefeActual.setNombre(jefe.getNombre());
			jefeActual.setSalario(jefe.getSalario());
			jefeActual.setTelefono(jefe.getTelefono());
			jefeActual.setDni(jefe.getDni());
			jefeActual.setDepartamento(jefe.getDepartamento());
			jefeActual.setUser(jefe.getUser());

			servicio.save(jefeActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido actualizado con éxito!");
		response.put("", jefeActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("jefes/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
		Jefe jefeBorrado = servicio.findbyId(id);
		Map<String, Object> response = new HashMap<>();

		try {

			servicio.delete(id);
		}

		catch (DataAccessException e) {
			response.put("mensaje", "Error al borrar el empleado de la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El empleado ha sido borrado con éxito!");
		response.put("", jefeBorrado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
