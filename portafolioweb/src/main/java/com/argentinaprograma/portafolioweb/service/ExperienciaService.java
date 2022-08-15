package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;


import com.argentinaprograma.portafolioweb.model.Experiencia;

public interface ExperienciaService {
	ResponseEntity<?> crearExp(Experiencia exp);
	ResponseEntity<?> editarExp(Long id,Experiencia exp);
	ResponseEntity<?> eliminarExp(Long id);
}
