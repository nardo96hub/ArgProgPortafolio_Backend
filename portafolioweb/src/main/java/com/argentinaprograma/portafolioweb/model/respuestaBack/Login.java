package com.argentinaprograma.portafolioweb.model.respuestaBack;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class Login {
	@NotBlank
	private String usuario;
	@NotBlank
	private String contrasena;
	
	public Login() {}
	public Login(String usu,String contra) {
		usuario=usu;
		contrasena=usu;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contrasena, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(usuario, other.usuario);
	}
	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
	
	
}
