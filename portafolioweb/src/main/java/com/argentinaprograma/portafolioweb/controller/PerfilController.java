package com.argentinaprograma.portafolioweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprograma.portafolioweb.model.respuestaBack.Login;
import com.argentinaprograma.portafolioweb.service.LoginLogout;
import com.argentinaprograma.portafolioweb.service.PerfilService;

@RestController
@CrossOrigin
@RequestMapping("/api/perfil")
public class PerfilController {
	@Autowired
	private PerfilService servi_perfil;
	@Autowired
	private LoginLogout log;
	@GetMapping("/get")
	private ResponseEntity<?> getPerfil(){
		
		if(servi_perfil.cantidadPerfil()>0) {
			return ResponseEntity.ok().body(servi_perfil.buscarPerfil());
		}else {
			return ResponseEntity.ok().body(servi_perfil.crearPerfil());
		}
		
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		return log.logout();
	}
	@PostMapping("/login")
	public ResponseEntity<?>login(@Valid@RequestBody Login login){
		return log.login(login);
	}
	

}
