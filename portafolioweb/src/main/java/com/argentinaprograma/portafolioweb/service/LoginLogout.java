package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;


import com.argentinaprograma.portafolioweb.model.respuestaBack.Login;

public interface LoginLogout {
	ResponseEntity<?> login(Login login);
	ResponseEntity<?> logout();
	//Perfil registro(String usu,String contra);
	
}
