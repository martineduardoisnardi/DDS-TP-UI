package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Estudiante;

@SuppressWarnings("hiding")
@Observable
public class LoginVM<Estudiante> {
	
	private int legajo;
	private String contrasenia;
	private Estudiante estudianteSeleccionado; 

	
	public LoginVM() {
		//.contrasenia.this.estudiante = Repositorios.estudiantes.todos();
	}

	public void validarLegajo() {
		//new RepositorioEstudiantes()
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setCodigo(int codigo) {
		this.legajo = legajo;
	}
	
	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
