package vm;

import excepciones.LoginException;
import java.util.List;
import org.uqbar.commons.utils.Observable;
import model.Estudiante;
import repositorios.Repositorios;

@Observable
public class LoginVM {
	
	private int legajo;
	private String contrasenia;
	private List<Estudiante> estudiantes;
	private Estudiante estudianteSeleccionado;

	public LoginVM() {
		this.estudiantes = Repositorios.estudiantes.todos();
	}

	public void validarEstudiante() {
		Estudiante estudiantePreSeleccionado = estudiantes.stream()
		                        .filter(estudiante -> estudiante.getLegajo() == legajo)
							    .findAny().orElse(null);
		
		if (estudiantePreSeleccionado == null) {	
			throw new LoginException("El número de Legajo no corresponde a un alumno de la UTN");
		}
		
		if (estudiantePreSeleccionado.getContrasenia() == contrasenia) {
			throw new LoginException("La contraseña ingresada es incorrecta");
		}else {
			estudianteSeleccionado = estudiantePreSeleccionado;
		}

		
	}
	
	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}