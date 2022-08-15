package com.argentinaprograma.portafolioweb.model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Redes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_redes;
	private String twitter;
	private String facebook;
	private String instagram;
	private String github;
	private String linkedin;

	public Redes() {}
	public Redes(String twitter,String facebook,String instagram,String github,String linkedin){
		this.twitter=twitter;
		this.facebook=facebook;
		this.instagram=instagram;
		this.github=github;
		this.linkedin=linkedin;
	}
	public Long getId_redes() {
		return id_redes;
	}
	public void setId_redes(Long id_redes) {
		this.id_redes = id_redes;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(facebook, github, id_redes, instagram, linkedin, twitter);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Redes other = (Redes) obj;
		return Objects.equals(facebook, other.facebook) && Objects.equals(github, other.github)
				&& Objects.equals(id_redes, other.id_redes) && Objects.equals(instagram, other.instagram)
				&& Objects.equals(linkedin, other.linkedin) && Objects.equals(twitter, other.twitter);
	}
	@Override
	public String toString() {
		return "Redes [id_redes=" + id_redes + ", twitter=" + twitter + ", facebook=" + facebook + ", instagram="
				+ instagram + ", github=" + github + ", linkedin=" + linkedin + "]";
	}
	
	
}
