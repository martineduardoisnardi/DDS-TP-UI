package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Asignacion;

public class RepositorioAsignaciones {
	private static RepositorioAsignaciones instance;
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
	public static RepositorioAsignaciones getInstance() {
		if (instance == null) {
			instance = new RepositorioAsignaciones();
		}
		return instance;
	}
	
	public void agregarAsignacion(Asignacion unaAsigancion) {
		asignaciones.add(unaAsigancion);
	}
	
	public List<Asignacion> todos(){
		return asignaciones;
	}
	
}