package com.argentinaprograma.portafolioweb.model.respuestaBack;

import java.util.Objects;

public class MensajeRespuesta {
	private String mensaje;
	
	public MensajeRespuesta() {	}
	public MensajeRespuesta(String m) {
		mensaje=m;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mensaje);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensajeRespuesta other = (MensajeRespuesta) obj;
		return Objects.equals(mensaje, other.mensaje);
	}
	@Override
	public String toString() {
		return "MensajeRespuesta [mensaje=" + mensaje + "]";
	}
	
	
}
