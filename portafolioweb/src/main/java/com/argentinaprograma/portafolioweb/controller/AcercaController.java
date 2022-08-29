package com.argentinaprograma.portafolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.portafolioweb.model.Acerca;
import com.argentinaprograma.portafolioweb.service.AcercaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/acerca")
public class AcercaController {
	@Autowired
	AcercaService servi_acer;
	@PreAuthorize("isAuthenticated()")
	@PutMapping("")
	public ResponseEntity<?> editarAcerca(@RequestBody Acerca ac) {
	
		return servi_acer.editarAcer(ac);
	
	}

}
