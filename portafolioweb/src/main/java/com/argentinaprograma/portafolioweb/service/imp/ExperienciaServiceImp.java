package com.argentinaprograma.portafolioweb.service.imp;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Experiencia;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.repository.ExperienciaRepository;
import com.argentinaprograma.portafolioweb.service.ExperienciaService;
import com.argentinaprograma.portafolioweb.service.PerfilService;

@Service
@Transactional
public class ExperienciaServiceImp implements ExperienciaService{

	@Autowired
	private PerfilService servi_perfil;
	@Autowired
	private ExperienciaRepository repo_exp;
	
	public ResponseEntity<?> crearExp(Experiencia exp) {
		Perfil perfil=servi_perfil.buscarPerfil();
		perfil.agregarExp(exp);
		servi_perfil.guardarPerfil(perfil);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

	
	public ResponseEntity<?> editarExp(Long id,Experiencia exp) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Experiencia editar=repo_exp.findById(id).get();
		editar.setAnio(exp.getAnio());
		editar.setTitulo(exp.getTitulo());
		editar.setEmpresa(exp.getEmpresa());
		editar.setJornada(exp.getJornada());
		editar.setLugar(exp.getLugar());
		repo_exp.save(editar);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}


	public ResponseEntity<?> eliminarExp(Long id) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Experiencia borrar=repo_exp.findById(id).get();
		perfil.getExperiencia().remove(borrar);
		servi_perfil.guardarPerfil(perfil);
		repo_exp.deleteById(id);
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

}
