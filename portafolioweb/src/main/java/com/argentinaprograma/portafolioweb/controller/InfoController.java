package com.argentinaprograma.portafolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.portafolioweb.model.Imagen;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.model.Redes;
import com.argentinaprograma.portafolioweb.service.InfoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/info")
public class InfoController {
	
	@Autowired
	private InfoService serviInfo;
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/infoP")
	public ResponseEntity<?>editarInfoP(@RequestBody Perfil per){
		return serviInfo.editarInfoP(per);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/redes")
	public ResponseEntity<?>editarRedes(@RequestBody Redes redes){
		return serviInfo.editarRedes(redes);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/fotos")
	public ResponseEntity<?>editarFotos(@RequestBody Imagen img){
		return serviInfo.editarFoto(img);
	}

}
