package com.argentinaprograma.portafolioweb.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.model.Proyecto;
import com.argentinaprograma.portafolioweb.repository.ProyectoRepository;
import com.argentinaprograma.portafolioweb.service.PerfilService;
import com.argentinaprograma.portafolioweb.service.ProyectoService;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService{

	@Autowired
	private ProyectoRepository repo_proy;
	@Autowired
	private PerfilService servi_perfil;
	
	
	public ResponseEntity<?> crearProy(Proyecto proy) {
		Perfil perfil=servi_perfil.buscarPerfil();
		perfil.agregarProy(proy);
		servi_perfil.guardarPerfil(perfil);
		return servi_perfil.enviarPerfilFront(perfil);
	}


	public ResponseEntity<?> editarProy(Long id,Proyecto proy) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Proyecto editar=repo_proy.findById(id).get();
		editar.setDescripcion(proy.getDescripcion());
		editar.setLink(proy.getLink());
		editar.setNombreP(proy.getNombreP());
		repo_proy.save(editar);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

	
	public ResponseEntity<?> eliminarProy(Long id) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Proyecto borrar=repo_proy.findById(id).get();
		perfil.getProyecto().remove(borrar);
		servi_perfil.guardarPerfil(perfil);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

}
