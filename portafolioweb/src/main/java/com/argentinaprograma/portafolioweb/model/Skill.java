package com.argentinaprograma.portafolioweb.model;


import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Skill;
	private String lenguaje;
	private String nivel;

	public Skill() {}
	public Skill(String lenguaje, String nivel) {
		
		this.lenguaje = lenguaje.toUpperCase();
		this.nivel = nivel.toUpperCase();
	
	}
	public Long getId_Skill() {
		return id_Skill;
	}
	public void setId_Skill(Long id_Skill) {
		this.id_Skill = id_Skill;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_Skill, lenguaje, nivel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(id_Skill, other.id_Skill) && Objects.equals(lenguaje, other.lenguaje)
				&& Objects.equals(nivel, other.nivel);
	}
	@Override
	public String toString() {
		return "Skill [id_Skill=" + id_Skill + ", lenguaje=" + lenguaje + ", nivel=" + nivel + "]";
	}
	
}
