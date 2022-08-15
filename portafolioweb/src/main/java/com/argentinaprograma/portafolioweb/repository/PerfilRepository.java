package com.argentinaprograma.portafolioweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.argentinaprograma.portafolioweb.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	@Query("SELECT p from Perfil p WHERE p.id_perfil=1")
	public Optional<Perfil> obtenerPerfil();
	
	@Query("select p from Perfil p where p.usuario.usuario=:usu")
	public Optional<Perfil> buscarPerfilUsuario(@Param("usu")String usuario);
	@Query("Select COUNT(p) from Perfil p")
	public Long cantidadPerfil();
}
