package com.argentinaprograma.portafolioweb.service.imp;




import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.argentinaprograma.portafolioweb.model.*;
import com.argentinaprograma.portafolioweb.model.rol.Rol;
import com.argentinaprograma.portafolioweb.repository.*;

import com.argentinaprograma.portafolioweb.service.PerfilService;
import com.argentinaprograma.portafolioweb.service.UsuarioService;



@Service
@Transactional
public class PerfilServiceImp implements PerfilService{

	@Autowired
	private PerfilRepository repoPerfil;
	

	@Autowired
	private RolRepository repoRol;
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UsuarioService serviUsu;

	
	@Override
	public Perfil guardarPerfil(Perfil perfil) {
		return repoPerfil.save(perfil);
	}


	public Perfil buscarPerfil() {
		
		
		return repoPerfil.obtenerPerfil().get();
	}
	public Long cantidadPerfil() {
		return repoPerfil.cantidadPerfil();
	}

	public ResponseEntity<?> enviarPerfilFront(Perfil perfil) {
		return ResponseEntity.ok().body(perfil);
	}


	public ResponseEntity<?> obtenerPerfilFront() {
		Perfil p=this.buscarPerfil();
		if(p==null) {
			p=crearPerfil();
		}
		return this.enviarPerfilFront(p);
	}
	private Perfil registro(String usu, String contra) {
		
		if(!serviUsu.existeUsuario(usu)) {
			
			Usuario newUsuario=new Usuario(usu, encoder.encode(contra));
			Set<Roles> roles=new HashSet<Roles>();
			Roles rol=repoRol.findByRol(Rol.ROLE_ADMIN).get();
			roles.add(rol);
			newUsuario.setRoles(roles);
			Perfil newPerfil=new Perfil();
			newPerfil.setUsuario(newUsuario);
			/*newPerfil.setAcer(new Acerca());
			newPerfil.setPuesto("");
			newPerfil.setImagen(new Imagen());
			newPerfil.setInfoPersonal(new Personal());
		*/
			
			//this.guardarPerfil(newPerfil);
		
			return newPerfil;
		}
		return null;
	}
	public Perfil crearPerfil() {
		Perfil perfil;
		Acerca acerca;
		Personal infoP;
		Skill skill;
		Proyecto proy;
		Educacion edu;
		Experiencia exp;
		
		
		Roles rol=new Roles(Rol.ROLE_ADMIN);
		repoRol.save(rol);
		
		
		perfil=this.registro("user", "user");
		
		acerca=new Acerca("Soy un programar con ganas de conseguir mas experiencia laboral  relacionada con la programacion.");
		perfil.setAcer(acerca);
		infoP=new Personal("Luciano","Nardelli", "nardelli96@gmail.com","Rosario,Santa Fe");
		perfil.setImagen(new Imagen("https://4.bp.blogspot.com/-jDcqEFr898k/XBAeeuO_B3I/AAAAAAAAAEM/ugCkZsDFoN8_HGj34Mcs6O61GvNDzcKaACLcBGAs/s1600/phpCode.png", "../../../assets/img/MyFoto.jpg"));
		
		

		perfil.setPersonal(infoP);
	
	
		
		skill=new Skill("Java","Avanzado");
		
		perfil.agregarSkill(skill);
		skill=new Skill("JavaScript","Basico");
		perfil.agregarSkill(skill);
		skill=new Skill("Html","Intermedio");
		perfil.agregarSkill(skill);
		skill=new Skill("CSS","Basico");
		perfil.agregarSkill(skill);
		skill=new Skill("Angular","Intermedio");
		perfil.agregarSkill(skill);
		skill=new Skill("C/C++","Intermedio");
		perfil.agregarSkill(skill);
	
		skill=new Skill("Haskell","Basico");
		perfil.agregarSkill(skill);
		
		edu=new Educacion("U.N.R. Instituto Politecnico Superior 'General San Martin'", "Analista en Sistemas ", "2020 en curso");
		perfil.agregarEdu(edu);
		edu=new Educacion("Colegio San Jorge", "Titulo Secundario:Modalidad Economia y Gestion de las Organizaciones ", "2014");
		perfil.agregarEdu(edu);
		edu=new Educacion("Codo a Codo FullStack", "Diseño de paginas WEB ", "2021-300hs");
		perfil.agregarEdu(edu);
		edu=new Educacion("Egg Educacion - Polo Tic Rosario - UNR- Programa T.TEC", "Full Stack Developer JAVA", "2021-550hs");
		perfil.agregarEdu(edu);
		edu=new Educacion("Neoris", "NEORIS LAB SAP Commissions", "2022-27hs");
		perfil.agregarEdu(edu);
		edu=new Educacion("Codo a Codo", "Backend Java ", "2022-150hs");
		perfil.agregarEdu(edu);
	
		perfil.setPuesto("Programador FullStack");
		
		proy=new Proyecto("Ruleta", "Implementacion de una Ruleta en java utilizando interfaz graficas", "https://github.com/nardo96hub/RuletaJava");
		perfil.agregarProy(proy);
		proy=new Proyecto("Libreria", "Implementacion de una libreria en java utilizando Thymeleaf", "https://github.com/nardo96hub/LibreriaSpring");
		perfil.agregarProy(proy);
		proy=new Proyecto("Proyecto Codo a Codo", "Implementacion de una pagina con login utilizando java servelet", "https://github.com/nardo96hub/ProyectoFinal_CodoACodo");
		perfil.agregarProy(proy);
		proy=new Proyecto("ProgramandoComunidad", "Un proyecto realizado con unos amigos en el cual consiste en crear una pagina en java en la cual ONG y programadores se pueden unir y dependiendo de los proyectos que publican la ONG  y los programadores se pueden unir al proyecto", "https://github.com/nardo96hub/ProgramandoComunidad_PF");
		perfil.agregarProy(proy);
		
		exp=new Experiencia("tit","emp","jor","anio","lugar");
		perfil.agregarExp(exp);
	
		this.guardarPerfil(perfil);
		
		return perfil;
	}
}
