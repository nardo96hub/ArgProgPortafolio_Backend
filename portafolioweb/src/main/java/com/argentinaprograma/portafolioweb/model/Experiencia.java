package com.argentinaprograma.portafolioweb.model;




import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Exp;
	private String titulo;
	private String empresa;
	private String jornada;
	private String anio;
	private String lugar;

	/*@ManyToMany()
	@JoinTable(
			name="Perfil_Experiencia",
			joinColumns = @JoinColumn(name="exp_id"),
			inverseJoinColumns = @JoinColumn(name="perfil_id")
			)
	private Set<Perfil> perfil_exp=new HashSet<Perfil>();*/
	
	public Experiencia(String tit,String em,String jor,String anio,String lug) {
		titulo=tit;empresa=em;jornada=jor;this.anio=anio;lugar=lug;
		
	}

	public Experiencia() {
		
	}

	public Long getId_Exp() {
		return id_Exp;
	}

	public void setId_Exp(Long id_Exp) {
		this.id_Exp = id_Exp;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, empresa, id_Exp, jornada, lugar, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experiencia other = (Experiencia) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(id_Exp, other.id_Exp) && Objects.equals(jornada, other.jornada)
				&& Objects.equals(lugar, other.lugar) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Experiencia [id_Exp=" + id_Exp + ", titulo=" + titulo + ", empresa=" + empresa + ", jornada=" + jornada
				+ ", anio=" + anio + ", lugar=" + lugar + "]";
	}
	
}
