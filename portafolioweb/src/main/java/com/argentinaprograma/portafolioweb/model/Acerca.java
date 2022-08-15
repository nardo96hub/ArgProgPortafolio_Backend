package com.argentinaprograma.portafolioweb.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Acerca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_acer;
	@Column(length = 4000)
	private String acer;
	
	public Acerca() {}
	public Acerca(String acer) {
		this.acer=acer;
	}
	public Long getId_acer() {
		return id_acer;
	}
	public void setId_acer(Long id_acer) {
		this.id_acer = id_acer;
	}
	public String getAcer() {
		return acer;
	}
	public void setAcer(String acer) {
		this.acer = acer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(acer, id_acer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acerca other = (Acerca) obj;
		return Objects.equals(acer, other.acer) && Objects.equals(id_acer, other.id_acer);
	}
	@Override
	public String toString() {
		return "Acerca [id_acer=" + id_acer + ", acer=" + acer + "]";
	}
	
	
	
}
