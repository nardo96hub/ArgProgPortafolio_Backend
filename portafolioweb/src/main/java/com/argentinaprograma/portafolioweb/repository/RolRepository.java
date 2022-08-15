package com.argentinaprograma.portafolioweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argentinaprograma.portafolioweb.model.Roles;
import com.argentinaprograma.portafolioweb.model.rol.Rol;

public interface RolRepository extends JpaRepository<Roles, Long>{

	Optional<Roles> findByRol(Rol rol);
}
