package com.argentinaprograma.portafolioweb.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.model.Skill;
import com.argentinaprograma.portafolioweb.repository.SkillRepository;
import com.argentinaprograma.portafolioweb.service.PerfilService;
import com.argentinaprograma.portafolioweb.service.SkillService;

@Service
@Transactional
public class SkillServiceImp implements SkillService{
	@Autowired
	private PerfilService servi_perfil;
	@Autowired
	private SkillRepository repo_skill;

	public ResponseEntity<?> crearSkill(Skill skill) {
		Perfil perfil=servi_perfil.buscarPerfil();
		perfil.agregarSkill(skill);
		servi_perfil.guardarPerfil(perfil);
	

		return servi_perfil.enviarPerfilFront(perfil);
	}


	public ResponseEntity<?> editarSkill(Long id,Skill skill) {
	
		Perfil perfil=servi_perfil.buscarPerfil();
		Skill editar=repo_skill.findById(id).get();
		
		
		editar.setLenguaje(skill.getLenguaje());
		editar.setNivel(skill.getNivel());
		repo_skill.save(editar);
		
		
		
		return servi_perfil.enviarPerfilFront(perfil);
	}

	

	public ResponseEntity<?> borrarSkillId(Long id) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Skill borrar=repo_skill.findById(id).get();
		perfil.getSkill().remove(borrar);
		servi_perfil.guardarPerfil(perfil);
		
		
		
		repo_skill.delete(borrar);
		
	
		return servi_perfil.enviarPerfilFront(perfil);
	}

}
