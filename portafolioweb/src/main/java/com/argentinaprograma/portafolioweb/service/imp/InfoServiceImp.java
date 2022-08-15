package com.argentinaprograma.portafolioweb.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Imagen;
import com.argentinaprograma.portafolioweb.model.Perfil;
import com.argentinaprograma.portafolioweb.model.Redes;
import com.argentinaprograma.portafolioweb.service.InfoService;
import com.argentinaprograma.portafolioweb.service.PerfilService;

@Service
@Transactional
public class InfoServiceImp implements InfoService {

	@Autowired
	private PerfilService serviPerfil;

	public ResponseEntity<?> editarInfoP(Perfil per) {

		serviPerfil.guardarPerfil(per);		
		return serviPerfil.enviarPerfilFront(per);
	}


	public ResponseEntity<?> editarRedes(Redes redes) {
		Perfil perfil=serviPerfil.buscarPerfil();
		
		if(redes.getFacebook().contains("facebook.com")) {
			perfil.getPersonal().getRedes().setFacebook(redes.getFacebook());
			
		}
		if(redes.getTwitter().contains("twitter.com")) {
			perfil.getPersonal().getRedes().setTwitter(redes.getTwitter());	
		}
		if(redes.getInstagram().contains("instagram.com")) {
			perfil.getPersonal().getRedes().setInstagram(redes.getInstagram());
		}
		if(redes.getGithub().contains("github.com")) {
			perfil.getPersonal().getRedes().setGithub(redes.getGithub());
		}
		if(redes.getLinkedin().contains("linkedin.com")) {
			perfil.getPersonal().getRedes().setLinkedin(redes.getLinkedin());
		}
		serviPerfil.guardarPerfil(perfil);
		
		return serviPerfil.enviarPerfilFront(perfil);
	}


	public ResponseEntity<?> editarFoto(Imagen foto) {
		Perfil perfil=serviPerfil.buscarPerfil();
		perfil.getImagen().setPerfil(foto.getPerfil());
		perfil.getImagen().setPortada(foto.getPortada());
		serviPerfil.guardarPerfil(perfil);
		return serviPerfil.enviarPerfilFront(perfil);
	}

}
