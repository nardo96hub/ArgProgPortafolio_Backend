package com.argentinaprograma.portafolioweb.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Acerca;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.repository.AcercaRepository;
import com.argentinaprograma.portafolioweb.service.AcercaService;
import com.argentinaprograma.portafolioweb.service.PerfilService;
@Service
@Transactional
public class AcercaServiceImp implements AcercaService{

	@Autowired
	PerfilService servi_perfil;
	@Autowired
	AcercaRepository repo_acer;
	@Override
	public ResponseEntity<?> editarAcer(Acerca ac) {
		Perfil perfil=servi_perfil.buscarPerfil();
		Acerca editar=repo_acer.findById(perfil.getId_perfil()).get();
		editar.setAcer(ac.getAcer());
		repo_acer.save(editar);
		return servi_perfil.enviarPerfilFront(perfil);
		
		
	}
	

}
