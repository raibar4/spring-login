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

import com.formacionspring.app.apirest.entity.Empleado;
import com.formacionspring.app.apirest.services.EmpleadoService;

@RestController
@RequestMapping("api")
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicio;

	@GetMapping("empleados")
	public List<Empleado> empleado() {
		return servicio.findAll();
	}

	@GetMapping("empleados/{id}")
	public ResponseEntity<?> empleadoShow(@PathVariable Long id) {
		Empleado empleado = null;
		Map<String, Object> response = new HashMap<>();

		try {
			empleado = servicio.findbyId(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (empleado == null) {
			response.put("mensaje", "El empleado ID:".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}

	@PostMapping("empleados")
	public ResponseEntity<?> saveEmpleado(@RequestBody Empleado empleado) {
		Empleado empleadoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			empleadoNew = servicio.save(empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido creado con éxito!");
		response.put("", empleadoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("empleados/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Empleado empleado, @PathVariable Long id) {

		Empleado empleadoActual = servicio.findbyId(id);
		Map<String, Object> response = new HashMap<>();

		try {
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setSalario(empleado.getSalario());
			empleadoActual.setTelefono(empleado.getTelefono());
			empleadoActual.setDni(empleado.getDni());
			empleadoActual.setDepartamento(empleado.getDepartamento());
			empleadoActual.setUser(empleado.getUser());

			servicio.save(empleadoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido actualizado con éxito!");
		response.put("", empleadoActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("empleados/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
		Empleado empleadoBorrado = servicio.findbyId(id);
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
		response.put("", empleadoBorrado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
