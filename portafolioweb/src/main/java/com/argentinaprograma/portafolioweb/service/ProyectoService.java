package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;


import com.argentinaprograma.portafolioweb.model.Proyecto;

public interface ProyectoService {
	
	ResponseEntity<?> crearProy(Proyecto proy);
	ResponseEntity<?> editarProy(Long id,Proyecto proy);
	ResponseEntity<?> eliminarProy(Long id);
	
}
