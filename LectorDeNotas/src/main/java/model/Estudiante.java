package model;

//import java.util.List;

import org.uqbar.commons.utils.Observable;

import excepciones.ExcepcionLegajo;

@Observable
public class Estudiante {
	private int legajo;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String usuarioGithub;

//	private List<Asignacion> asignaciones;
	
	public Estudiante(int legajo, String contrasenia) {
		this.legajo = legajo;
		this.contrasenia = contrasenia;
	}
	

	public void validarLegajo() {
		if (this.isSetLegajo()) {
			throw new ExcepcionLegajo("Legajo Inexistente");
		}
		this.legajo = this.getLegajo();
		/*		this.nombre = respuesta.getNombre();
		this.apellido = respuesta.getApellido();
		this.usuarioGithub = respuesta.getUsuarioGithub();
		*/
	}
	
	private boolean isSetLegajo() {
		return legajo == 0;
	}
	
	public void actualizarDatos(int legajo, String nombre, String apellido, String UsuarioGithub) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioGithub = UsuarioGithub;
	}

	/****************************************************
	 * Getters
	 ****************************************************/

	public int getLegajo() {
		return legajo;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}
/*
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}*/
}
