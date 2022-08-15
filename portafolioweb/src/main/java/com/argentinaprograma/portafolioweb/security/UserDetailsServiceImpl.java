package com.argentinaprograma.portafolioweb.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.Usuario;
import com.argentinaprograma.portafolioweb.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
	private UsuarioRepository repoUser;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repoUser.findByUsuario(username).get();
		return UserDetailsImpl.build(user);
	}
}
