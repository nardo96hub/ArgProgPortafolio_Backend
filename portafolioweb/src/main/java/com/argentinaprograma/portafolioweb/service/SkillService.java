package com.argentinaprograma.portafolioweb.service;

import org.springframework.http.ResponseEntity;

import com.argentinaprograma.portafolioweb.model.Skill;

public interface SkillService {

	ResponseEntity<?> crearSkill(Skill skill);
	ResponseEntity<?> editarSkill(Long id,Skill skill);
	ResponseEntity<?> borrarSkillId(Long id);

}
