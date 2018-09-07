package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import excepciones.ExcepcionLegajo;
import repositorios.RepositorioAsignaciones;
import repositorios.RepositorioEstudiantes;
import repositorios.Repositorios;

@Observable
public class Estudiante {
	private int legajo;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String usuarioGithub;
	private List<Asignacion> asignaciones;
	private List<model.Asignacion> asignaciones2;
	
	public Estudiante(int legajo, String contrasenia) {
		this.legajo = legajo;
		this.contrasenia = contrasenia;
	}
	


	
	public void actualizarDatos(int legajo, String nombre, String apellido, String UsuarioGithub) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioGithub = UsuarioGithub;
	}
	
	public List<Asignacion> asignacionesDelEstudiante() {
		return this.asignaciones = ((RepositorioAsignaciones) asignaciones).todos();
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