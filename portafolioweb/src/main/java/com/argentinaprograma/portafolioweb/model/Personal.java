package com.argentinaprograma.portafolioweb.model;


import java.util.Objects;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity

public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_personal;
	private String Nom;
	private String Ape;
	private String email;
	private String localidad;
	@OneToOne(cascade = CascadeType.ALL)
	private Redes redes;
	
	public Personal() {redes=new Redes("https://www.twitter.com/","https://www.facebook.com/","https://www.instagram.com/","https://www.github.com/","https://www.linkedin.com/");}
	public Personal(String nom,String ape,String email,String lugar) {
		localidad=lugar;
		redes=new Redes("https://www.twitter.com/","https://www.facebook.com/","https://www.instagram.com/","https://www.github.com/","https://www.linkedin.com/");
		Nom=nom;
		Ape=ape;
		this.email=email;
	
	}
	public Long getId_personal() {
		return id_personal;
	}
	public void setId_personal(Long id_personal) {
		this.id_personal = id_personal;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getApe() {
		return Ape;
	}
	public void setApe(String ape) {
		Ape = ape;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Redes getRedes() {
		return redes;
	}
	public void setRedes(Redes redes) {
		this.redes = redes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Ape, Nom, email, id_personal, localidad, redes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(Ape, other.Ape) && Objects.equals(Nom, other.Nom) && Objects.equals(email, other.email)
				&& Objects.equals(id_personal, other.id_personal) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(redes, other.redes);
	}
	@Override
	public String toString() {
		return "Personal [id_personal=" + id_personal + ", Nom=" + Nom + ", Ape=" + Ape + ", email=" + email
				+ ", localidad=" + localidad + ", redes=" + redes + "]";
	}
	
	
	
	

}
