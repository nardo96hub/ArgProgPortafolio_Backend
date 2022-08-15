package com.argentinaprograma.portafolioweb.service.imp;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.argentinaprograma.portafolioweb.repository.UsuarioRepository;
import com.argentinaprograma.portafolioweb.service.UsuarioService;
@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService{
	@Autowired
	private UsuarioRepository repoUsu;


	@Override
	public boolean existeUsuario(String usu) {
		return repoUsu.existsByUsuario(usu);
	}

}
