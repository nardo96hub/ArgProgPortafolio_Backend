package com.argentinaprograma.portafolioweb.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;


import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;








@Entity

public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_perfil;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Personal personal;
	private String puesto;
	@OneToOne(cascade = CascadeType.ALL)
	private Imagen imagen;
	@OneToOne(cascade = CascadeType.ALL)
	private Acerca acer;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Perfil_Exp", joinColumns = @JoinColumn(name = "id_perfil", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="id_exp", nullable = false))
	private List<Experiencia> experiencia=new ArrayList<Experiencia>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PerfilId")
	private List<Educacion> educacion=new ArrayList<Educacion>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Perfil_Skill", joinColumns = @JoinColumn(name = "id_perfil", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="id_skill", nullable = false))
	private List<Skill> skill=new ArrayList<Skill>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PerfilId")
	private List<Proyecto> proyecto =new ArrayList<Proyecto>();;

	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	
	public Perfil() {}
	public Perfil(Personal infoP,Imagen imagen2, Usuario usuario) {
		personal=infoP;
		imagen=imagen2;
		this.usuario=usuario;
		puesto="";
		acer=new Acerca("Soy un usuario nuevo");

	}
	public void agregarExp(Experiencia exp) {
		experiencia.add(exp);
	}
	public void agregarEdu(Educacion edu) {
		educacion.add(edu);
	}
	public void agregarProy(Proyecto proy) {
		proyecto.add(proy);
	}
	public void agregarSkill(Skill s) {
		skill.add(s);
	}
	public Long getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(Long id_perfil) {
		this.id_perfil = id_perfil;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal infoPersonal) {
		this.personal = infoPersonal;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public Imagen getImagen() {
		return imagen;
	}
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	public Acerca getAcer() {
		return acer;
	}
	public void setAcer(Acerca acer) {
		this.acer = acer;
	}
	public List<Experiencia> getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}
	public List<Educacion> getEducacion() {
		return educacion;
	}
	public void setEducacion(List<Educacion> educacion) {
		this.educacion = educacion;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Proyecto> getProyecto() {
		return proyecto;
	}
	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(acer, educacion, experiencia, id_perfil, imagen, personal, proyecto, puesto, skill,
				usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return Objects.equals(acer, other.acer) && Objects.equals(educacion, other.educacion)
				&& Objects.equals(experiencia, other.experiencia) && Objects.equals(id_perfil, other.id_perfil)
				&& Objects.equals(imagen, other.imagen) && Objects.equals(personal, other.personal)
				&& Objects.equals(proyecto, other.proyecto) && Objects.equals(puesto, other.puesto)
				&& Objects.equals(skill, other.skill) && Objects.equals(usuario, other.usuario);
	}
	@Override
	public String toString() {
		return "Perfil [id_perfil=" + id_perfil + ", personal=" + personal + ", puesto=" + puesto + ", imagen="
				+ imagen + ", acer=" + acer + ", experiencia=" + experiencia + ", educacion=" + educacion + ", skill="
				+ skill + ", proyecto=" + proyecto + ", usuario=" + usuario + "]";
	}

}
