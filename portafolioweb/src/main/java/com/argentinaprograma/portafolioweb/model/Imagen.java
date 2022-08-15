package com.argentinaprograma.portafolioweb.model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_imagen;
	private String portada;
	private String perfil;
	
	public Imagen() {}
	public Imagen(String portada,String perfil) {
		this.portada=portada;
		this.perfil=perfil;
	}
	public Long getId_imagen() {
		return id_imagen;
	}
	public void setId_imagen(Long id_imagen) {
		this.id_imagen = id_imagen;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_imagen, perfil, portada);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagen other = (Imagen) obj;
		return Objects.equals(id_imagen, other.id_imagen) && Objects.equals(perfil, other.perfil)
				&& Objects.equals(portada, other.portada);
	}
	@Override
	public String toString() {
		return "Imagen [id_imagen=" + id_imagen + ", portada=" + portada + ", perfil=" + perfil + "]";
	}

	

}
