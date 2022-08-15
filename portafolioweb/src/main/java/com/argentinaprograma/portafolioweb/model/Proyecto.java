package com.argentinaprograma.portafolioweb.model;




import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proyecto;
	private String nombreP;
	@Column(length = 4000)
	private String descripcion;
	private String link;
	
	public Proyecto() {}
	public Proyecto(String nombreP,String descripcion,String link) {
		this.nombreP=nombreP;
		this.descripcion=descripcion;
		this.link=link;
	}
	public Long getId_proyecto() {
		return id_proyecto;
	}
	public void setId_proyecto(Long id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id_proyecto, link, nombreP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id_proyecto, other.id_proyecto)
				&& Objects.equals(link, other.link) && Objects.equals(nombreP, other.nombreP);
	}
	@Override
	public String toString() {
		return "Proyecto [id_proyecto=" + id_proyecto + ", nombreP=" + nombreP + ", descripcion=" + descripcion
				+ ", link=" + link + "]";
	}
	
	
}
