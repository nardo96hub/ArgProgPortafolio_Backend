package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;

import com.argentinaprograma.portafolioweb.model.Educacion;

public interface EducacionService {
	ResponseEntity<?> crearEdu(Educacion edu);
	ResponseEntity<?> editarEdu(Long id,Educacion edu);
	ResponseEntity<?> eliminarEdu(Long id);
}
