package vm;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import model.Asignacion;
import model.Estudiante;

@Observable
public class DatosEstudianteVM {
	private Estudiante estudiante;
	private int legajo;
	private String nombre;
	private String apellido;
	private String gitHub;
	private boolean editar = false;
	private static final int NUMERO_DIGITOS_LEGAJO = 7;
	private Asignacion asignacionSeleccionada;

	public DatosEstudianteVM(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public void actualizarDatosEstudiante() {
		estudiante.actualizarDatos(legajo, nombre, apellido, gitHub);
		editar = false;
	}
	
	public void readAsignaciones() {

	}

	public int getLegajo() {
		return estudiante.getLegajo();
	}

	public void setLegajo(int _legajo) {
		this.legajo = _legajo;
		ObservableUtils.firePropertyChanged(this, "controlLegajo");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
	}

	public String getNombre() {
		return estudiante.getNombre();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		ObservableUtils.firePropertyChanged(this, "controlNombre");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
	}

	public String getApellido() {
		return estudiante.getApellido();
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
		ObservableUtils.firePropertyChanged(this, "controlApellido");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
	}

	public String getGitHub() {
		return estudiante.getUsuarioGithub();
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
		ObservableUtils.firePropertyChanged(this, "controlGitHub");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
	}
	
	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
		this.legajo = estudiante.getLegajo();
		this.nombre = estudiante.getNombre();
		this.apellido = estudiante.getApellido();
		this.gitHub = estudiante.getUsuarioGithub();
		ObservableUtils.firePropertyChanged(this, "legajo");
		ObservableUtils.firePropertyChanged(this, "nombre");
		ObservableUtils.firePropertyChanged(this, "apellido");
		ObservableUtils.firePropertyChanged(this, "gitHub");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
		ObservableUtils.firePropertyChanged(this, "controlLegajo");
		ObservableUtils.firePropertyChanged(this, "controlNombre");
		ObservableUtils.firePropertyChanged(this, "controlApellido");
		ObservableUtils.firePropertyChanged(this, "controlGitHub");
	}
	
	public List<Asignacion> getAsignacionesDelEstudiante() {
		return estudiante.asignacionesDelEstudiante();
	}
	

	public Asignacion getAsignacionSeleccionada() {
		return asignacionSeleccionada;
	}
    
	public List<Asignacion> getAsignaciones() {
		return estudiante.getAsignaciones();
	}
	
	public boolean isControlLegajo() {
		return Integer.toString(legajo).length() == NUMERO_DIGITOS_LEGAJO;
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