package vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Estudiante;
import repositorios.RepositorioEstudiantes;
import repositorios.Repositorios;

@SuppressWarnings("hiding")
@Observable
public class LoginVM<Estudiante> {
	
	private int legajo;
	private String contrasenia;
	private List<model.Estudiante> estudiantes;// = new ArrayList<Estudiante>();;
	private Estudiante estudianteSeleccionado; 
	
	public LoginVM() {
		this.estudiantes = Repositorios.estudiantes.todos();
	}

	public void validarLegajo() {
		//new RepositorioEstudiantes()
		if (((RepositorioEstudiantes) estudiantes).estudianteValido(legajo)) {
		//	throw new 
		}
		
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
