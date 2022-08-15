package com.argentinaprograma.portafolioweb.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.argentinaprograma.portafolioweb.model.respuestaBack.Login;
import com.argentinaprograma.portafolioweb.model.respuestaBack.UsuarioRespuesta;
import com.argentinaprograma.portafolioweb.security.UserDetailsImpl;
import com.argentinaprograma.portafolioweb.security.jwt.JwtUtils;
import com.argentinaprograma.portafolioweb.service.LoginLogout;
import com.argentinaprograma.portafolioweb.model.respuestaBack.MensajeRespuesta;

@Service
public class LoginLogoutImp implements LoginLogout{
	
	@Autowired
	AuthenticationManager authenticationManager;
		
	@Autowired
	private JwtUtils jwtUtils;
	 
	public ResponseEntity<?> login(Login login) {
		
		Authentication autenticacion=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getContrasena()));
		SecurityContextHolder.getContext().setAuthentication(autenticacion);
		UserDetailsImpl userDetails=(UserDetailsImpl) autenticacion.getPrincipal();
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
		String jwt=jwtUtils.generateTokenFromUsername(autenticacion);//token
		UsuarioRespuesta jwtReturn=new UsuarioRespuesta(jwt,"Bearer",userDetails.getUsername(),userDetails.getAuthorities()); 
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(jwtReturn);
	}

	public ResponseEntity<?> logout() {		
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(new MensajeRespuesta("Has sido Desconectado! en logout"));
	}

}
