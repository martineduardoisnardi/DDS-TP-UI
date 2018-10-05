package vm;

import java.util.List;
import org.uqbar.commons.utils.Observable;

import model.Estudiante;
import repositorios.Repositorios;

@Observable
public class LoginVM {
	
	private List<Estudiante> estudiantes;
	private Estudiante estudianteSeleccionado;

	public LoginVM() {
		this.estudiantes = Repositorios.estudiantes.todos();
	}

	public void autenticar() {
		this.estudianteSeleccionado.autenticar();
	}
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void setEstudiante(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}

	public void setEstudianteSeleccionado(Estudiante estudianteSeleccionado) {
		this.estudianteSeleccionado = estudianteSeleccionado;
	}
	
}