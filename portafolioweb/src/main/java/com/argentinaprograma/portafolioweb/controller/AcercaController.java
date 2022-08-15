package com.argentinaprograma.portafolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.portafolioweb.model.Acerca;
import com.argentinaprograma.portafolioweb.service.AcercaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/acerca")
public class AcercaController {
	@Autowired
	AcercaService servi_acer;
	@PreAuthorize("isAuthenticated()")
	@PostMapping("")
	public void editarAcerca(@RequestBody Acerca ac) {
		System.out.println("Quiero actualizar");
		servi_acer.editarAcer(ac);
	}

}
