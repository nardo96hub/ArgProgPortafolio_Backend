package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;

import com.argentinaprograma.portafolioweb.model.Perfil;



public interface PerfilService {

	Perfil guardarPerfil(Perfil perfil);
	Perfil buscarPerfil();
	ResponseEntity<?> enviarPerfilFront(Perfil perfil);
	Perfil crearPerfil();
	ResponseEntity<?>obtenerPerfilFront();
	Long cantidadPerfil();
}
