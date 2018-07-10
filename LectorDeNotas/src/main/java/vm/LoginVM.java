package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Estudiante;
/*
import model.repositorios.Repositorios;
*/
@SuppressWarnings("hiding")
@Observable
public class LoginVM<Estudiante> {
	
	private int codigo;
	private String contrasenia;
	private boolean editar = false;
	/*
	public LoginVM() {
		this.estudiante = Repositorios.estudiantes.todos();
	}

	public void autenticar() {
		this.estudianteSeleccionado.autenticar();
	}
*/
	public int getCodigo() {
		return codigo;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/*
	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
*/
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
