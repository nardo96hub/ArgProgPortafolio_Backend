package com.argentinaprograma.portafolioweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.portafolioweb.service.EducacionService;
import com.argentinaprograma.portafolioweb.model.Educacion;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/edu")
public class EducacionController {
	@Autowired
	private EducacionService serviEdu;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/crear")
	ResponseEntity<?> crearEdu( @Valid@RequestBody Educacion edu)
	{	
		return serviEdu.crearEdu( edu);
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/{idE}")
	public ResponseEntity<?> editarEdu(@PathVariable Long idE,@RequestBody Educacion edu)
	{
		return serviEdu.editarEdu( idE, edu);
		
	}
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/eliminar/{idE}")
	public ResponseEntity<?> eliminarEdu(@PathVariable Long idE)
	{
		return serviEdu.eliminarEdu(idE);
	}
}
