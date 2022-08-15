package com.argentinaprograma.portafolioweb.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.argentinaprograma.portafolioweb.model.rol.Rol;


@Entity
@Table(name="roles")
public class Roles {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @Enumerated(EnumType.STRING)
	  private Rol rol;
	  
	  public Roles() {}
	  public Roles(Rol rol) {
		  this.rol=rol;
	  }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, rol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		return Objects.equals(id, other.id) && rol == other.rol;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", rol=" + rol + "]";
	}
	  
	  
}
