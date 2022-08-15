package com.argentinaprograma.portafolioweb.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Educacion;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.repository.EducacionRepository;
import com.argentinaprograma.portafolioweb.service.EducacionService;
import com.argentinaprograma.portafolioweb.service.PerfilService;

@Service
@Transactional
public class EducacionServiceImp implements EducacionService {

	@Autowired
	private EducacionRepository repo_edu;
	@Autowired
	private PerfilService servi_perfil;
	public ResponseEntity<?> crearEdu(Educacion edu) {
		Perfil perfil=servi_perfil.buscarPerfil();
		perfil.agregarEdu(edu);
		servi_perfil.guardarPerfil(perfil);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

	
	public ResponseEntity<?> editarEdu(Long id,Educacion edu) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Educacion editar=repo_edu.findById(id).get();
		editar.setAnio(edu.getAnio());
		editar.setLugar(edu.getLugar());
		editar.setTitulo(edu.getTitulo());
		repo_edu.save(editar);
		return servi_perfil.enviarPerfilFront(perfil);
	}

	
	public ResponseEntity<?> eliminarEdu(Long id) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Educacion borrar=repo_edu.findById(id).get();
		perfil.getEducacion().remove(borrar);
		servi_perfil.guardarPerfil(perfil);
		repo_edu.deleteById(id);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

}
