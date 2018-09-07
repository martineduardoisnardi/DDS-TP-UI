package vm;

import java.util.List;

//import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import model.Asignacion;
//import model.Asignacion;
import model.Estudiante;

@Observable
public class DatosEstudianteVM {
	private Estudiante estudiante;
	private int legajo;
	private String nombre;
	private String apellido;
	private String gitHub;
	private static final int NUMERO_DIGITOS_CODIGO = 7;
//	private Asignacion asignacionSeleccionada;

	public DatosEstudianteVM(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public void actualizarDatosEstudiante() {
		estudiante.actualizarDatos(legajo, nombre, apellido, gitHub);
	}
	
	public void readAsignaciones() {

	}

	public int getLegajo() {
		return estudiante.getLegajo();
	}

	public void setLegajo(int _legajo) {
		this.legajo = _legajo;
		ObservableUtils.firePropertyChanged(this, "controlLegajo");
	}

	public String getNombre() {
		return estudiante.getNombre();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		ObservableUtils.firePropertyChanged(this, "controlNombre");
	}

	public String getApellido() {
		return estudiante.getApellido();
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
		ObservableUtils.firePropertyChanged(this, "controlApellido");
	}

	public String getGitHub() {
		return estudiante.getUsuarioGithub();
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
		ObservableUtils.firePropertyChanged(this, "controlGitHub");
	}
		
	public List<Asignacion> asignacionesDelEstudiante() {
		return estudiante.asignacionesDelEstudiante();
	}
	
/*
	public Asignacion getAsignacionSeleccionada() {
		return asignacionSeleccionada;
	}
    
	public List<Asignacion> getAsignaciones() {
		return estudiante.getAsignaciones();
	}
*/	
	public boolean isControlLegajo() {
		return Integer.toString(legajo).length() == NUMERO_DIGITOS_CODIGO;
	}

	public boolean isControlNombre() {
		return nombre.matches("[[A-Za-z]+][A-Za-z ]*");
	}

	public boolean isControlApellido() {
		return apellido.matches("[[A-Za-z]+][A-Za-z ]*");
	}

	public boolean isControlGitHub() {
		return gitHub.matches("[A-Za-z1-9-]++");
	}

	public boolean isControlEditar() {
		return this.isControlLegajo() && this.isControlNombre() && this.isControlApellido()
				&& this.isControlGitHub();
	}
	
	public String getSaludo() {
		return "Bienvenido !!!";
	}

}