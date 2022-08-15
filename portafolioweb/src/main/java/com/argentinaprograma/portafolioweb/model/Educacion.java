package com.argentinaprograma.portafolioweb.model;




import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Educacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Edu;
	private String lugar;
	private String titulo;
	private String anio;
	
	
	public Educacion() {}
	public Educacion(String lugar, String titulo, String anio) {
		this.lugar = lugar;
		this.titulo = titulo;
		this.anio = anio;
		
	}
	public Long getId_Edu() {
		return id_Edu;
	}
	public void setId_Edu(Long id_Edu) {
		this.id_Edu = id_Edu;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anio, id_Edu, lugar, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Educacion other = (Educacion) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(id_Edu, other.id_Edu)
				&& Objects.equals(lugar, other.lugar) && Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Educacion [id_Edu=" + id_Edu + ", lugar=" + lugar + ", titulo=" + titulo + ", anio=" + anio + "]";
	}
	
}
