package com.argentinaprograma.portafolioweb.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.argentinaprograma.portafolioweb.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	 
	Optional<Usuario> findByUsuario(String usu);
	
	Boolean existsByUsuario(String usu);	


	

	 
}
