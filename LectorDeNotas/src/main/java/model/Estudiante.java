package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;
import excepciones.ExcepcionToken;

@Observable
public class Estudiante {
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private String alias;
	private String token;
	private List<Asignacion> asignaciones;
	
	public Estudiante(String alias) {
		this.alias = alias;
	}
	
	public Estudiante(String alias, String token) {
		this.alias = alias;
		this.token = token;
	}
	
	public void autenticar() {
		if (this.isSetToken()) {
			throw new ExcepcionToken("El Usuario no tiene un token asociado.");
		}
		Estudiante respuesta = new RequestService().getAutenticacion(this.token);
		this.code = respuesta.getLegajo();
		this.first_name = respuesta.getNombre();
		this.last_name = respuesta.getApellido();
		this.github_user = respuesta.getUsuarioGithub();
	}

	private boolean isSetToken() {
		return token == null;
	}
	
	public void actualizarDatos(String legajo, String nombre, String apellido, String usuarioGithub) {
		this.code = legajo;
		this.first_name = nombre;
		this.last_name = apellido;
		this.github_user = usuarioGithub;
		new RequestService().putActualizarDatosEstudiante(this);
	}
	
	public void checkAsignaciones() {
		this.asignaciones = new RequestService().getAsignacionesDelEstudiante(this.token);
	}
	
	/****************************************************
	 * Getters
	 ****************************************************/

	public String getToken() {
		return token;
	}
	
	public String getLegajo() {
		return code;
	}
	
	public String getNombre() {
		return first_name;
	}

	public String getApellido() {
		return last_name;
	}

	public String getUsuarioGithub() {
		return github_user;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
}