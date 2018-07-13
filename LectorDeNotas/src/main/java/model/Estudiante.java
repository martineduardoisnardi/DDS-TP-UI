package model;

//import java.util.List;

import org.uqbar.commons.utils.Observable;

import excepciones.ExcepcionLegajo;

@Observable
public class Estudiante {
	private int codigo;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String usuarioGithub;

//	private List<Asignacion> asignaciones;
	
	public Estudiante(int codigo, String contrasenia) {
		this.codigo = codigo;
		this.contrasenia = contrasenia;
	}
	
	public void autenticar() {
		if (this.isSetCodigo()) {
			throw new ExcepcionLegajo("Legajo Inexistente");
		}
		this.codigo = this.getCodigo();
		/*		this.nombre = respuesta.getNombre();
		this.apellido = respuesta.getApellido();
		this.usuarioGithub = respuesta.getUsuarioGithub();
		*/
	}
	
	private boolean isSetCodigo() {
		return codigo == 0;
	}
	
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
