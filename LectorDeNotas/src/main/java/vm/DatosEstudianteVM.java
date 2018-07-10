package vm;

//import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

//import model.Asignacion;
import model.Estudiante;

@Observable
public class DatosEstudianteVM {
	private Estudiante estudiante;
	private int codigo;
	private String nombre;
	private String apellido;
	private String gitHub;
	private boolean editar = false;
	private static final int NUMERO_DIGITOS_CODIGO = 8;
//	private Asignacion asignacionSeleccionada;

	public DatosEstudianteVM(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public void actualizarDatosEstudiante() {
		estudiante.actualizarDatos(codigo, nombre, apellido, gitHub);
		editar = false;
	}
/*
	public void checkAsignacionesEstudiante() {
		estudiante.checkAsignaciones();
		ObservableUtils.firePropertyChanged(this, "asignaciones");
	}
*/
	public void readAsignaciones() {

	}

	public int getCodigo() {
		return estudiante.getCodigo();
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
		ObservableUtils.firePropertyChanged(this, "controlCodigo");
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
		this.codigo = estudiante.getCodigo();
		this.nombre = estudiante.getNombre();
		this.apellido = estudiante.getApellido();
		this.gitHub = estudiante.getUsuarioGithub();
		ObservableUtils.firePropertyChanged(this, "codigo");
		ObservableUtils.firePropertyChanged(this, "nombre");
		ObservableUtils.firePropertyChanged(this, "apellido");
		ObservableUtils.firePropertyChanged(this, "gitHub");
		ObservableUtils.firePropertyChanged(this, "controlEditar");
		ObservableUtils.firePropertyChanged(this, "controlCodigo");
		ObservableUtils.firePropertyChanged(this, "controlNombre");
		ObservableUtils.firePropertyChanged(this, "controlApellido");
		ObservableUtils.firePropertyChanged(this, "controlGitHub");
	}
/*
	public Asignacion getAsignacionSeleccionada() {
		return asignacionSeleccionada;
	}
    
	public List<Asignacion> getAsignaciones() {
		return estudiante.getAsignaciones();
	}
*/	
	public boolean isControlCodigo() {
		return codigo == NUMERO_DIGITOS_CODIGO;
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
		return this.isEditar() && this.isControlCodigo() && this.isControlNombre() && this.isControlApellido()
				&& this.isControlGitHub();
	}

	public String getSaludo() {
		return "Bienvenido !!!";
	}

}