package com.argentinaprograma.portafolioweb.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;






@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	@NotBlank
	private String usuario;
	@NotBlank
	private String contrasena;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", 
	             joinColumns = @JoinColumn(name = "user_id"),
	             inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Roles> roles = new HashSet<>();


	
	public Usuario() {
		
	}
	public Usuario(String usuario,String contrasena) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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

	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contrasena, id_usuario, roles, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contrasena, other.contrasena) 
				&& Objects.equals(id_usuario, other.id_usuario) && Objects.equals(roles, other.roles)
				&& Objects.equals(usuario, other.usuario);
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena  + ", roles=" + roles + "]";
	}
	

}
