package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;

import com.argentinaprograma.portafolioweb.model.Imagen;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.model.Redes;

public interface InfoService {
	ResponseEntity<?> editarInfoP(Perfil per);
	ResponseEntity<?> editarRedes(Redes redes);
	ResponseEntity<?> editarFoto(Imagen foto);
}
