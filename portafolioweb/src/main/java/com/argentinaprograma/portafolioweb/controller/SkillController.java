package com.argentinaprograma.portafolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.argentinaprograma.portafolioweb.model.Skill;

import com.argentinaprograma.portafolioweb.service.SkillService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/skill")
public class SkillController {
	@Autowired
	private SkillService servi_skill;

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/crear")
	public ResponseEntity<?> crearSkill(@RequestBody Skill skill) {
		return servi_skill.crearSkill(skill);
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarSkill(@PathVariable Long id,@RequestBody Skill skill) {
	 return	servi_skill.editarSkill(id,skill);
		
	}
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarSkillId(@PathVariable(name="id") Long id) {
		return servi_skill.borrarSkillId(id);
		
	}

}
