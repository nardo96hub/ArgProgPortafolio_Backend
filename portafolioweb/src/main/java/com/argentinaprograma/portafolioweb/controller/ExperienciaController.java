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

import com.argentinaprograma.portafolioweb.model.Experiencia;
import com.argentinaprograma.portafolioweb.service.ExperienciaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/exp")
public class ExperienciaController {
	
	@Autowired
	private ExperienciaService serviExp;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/crear")
	public ResponseEntity<?> crearExp(@Valid@RequestBody Experiencia exp){
		return serviExp.crearExp(exp);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/{idE}")
	public ResponseEntity<?> editarExp(@PathVariable Long idE,@RequestBody Experiencia exp){
		return serviExp.editarExp(idE, exp);
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/eliminar/{idE}")
	public ResponseEntity<?> eliminar(@PathVariable Long idE){
		return serviExp.eliminarExp(idE);
	}
}
