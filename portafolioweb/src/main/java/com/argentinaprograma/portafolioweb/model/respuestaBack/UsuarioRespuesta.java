package com.argentinaprograma.portafolioweb.model.respuestaBack;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

public class UsuarioRespuesta {
	private String token;
	private String bearer="Bearer";
	private String username;
	
	private Collection<? extends GrantedAuthority> roles;
	
	
	public UsuarioRespuesta() {	}


	public UsuarioRespuesta(String token, String bearer, String username,
			Collection<? extends GrantedAuthority> roles) {
	
		this.token = token;
		this.bearer = bearer;
		this.username = username;
		
		this.roles = roles;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getBearer() {
		return bearer;
	}


	public void setBearer(String bearer) {
		this.bearer = bearer;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}





	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}


	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bearer, roles, token, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRespuesta other = (UsuarioRespuesta) obj;
		return Objects.equals(bearer, other.bearer)&& Objects.equals(roles, other.roles) && Objects.equals(token, other.token)
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "UsuarioRespuesta [token=" + token + ", bearer=" + bearer + ", username=" + username + ", roles=" + roles + "]";
	}
	
	
	

}
