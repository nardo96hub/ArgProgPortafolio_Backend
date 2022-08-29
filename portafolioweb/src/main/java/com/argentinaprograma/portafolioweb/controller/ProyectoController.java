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

import com.argentinaprograma.portafolioweb.model.Proyecto;
import com.argentinaprograma.portafolioweb.service.ProyectoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/proy")
public class ProyectoController {
	@Autowired
	private ProyectoService serviProy;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/crear")
	public ResponseEntity<?> crearProyecto(@Valid@RequestBody Proyecto proy){
		return serviProy.crearProy(proy);
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/{idPr}")
	public ResponseEntity<?> editarProy(@PathVariable Long idPr,@RequestBody Proyecto proy){
		return serviProy.editarProy(idPr,proy);
	}
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/eliminar/{idPr}")
	public ResponseEntity<?> eliminar(@PathVariable Long idPr){
		return serviProy.eliminarProy(idPr);
	}
}
