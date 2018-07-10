package model;

//import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Estudiante {
	private int codigo;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String usuarioGithub;

//	private List<Asignacion> asignaciones;

	public void actualizarDatos(int codigo, String nombre, String apellido, String UsuarioGithub) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioGithub = UsuarioGithub;
	}

	/****************************************************
	 * Getters
	 ****************************************************/

	public int getCodigo() {
		return codigo;
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
