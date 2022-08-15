package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;

import com.argentinaprograma.portafolioweb.model.Acerca;

public interface AcercaService {

	ResponseEntity<?> editarAcer(Acerca ac);

}
