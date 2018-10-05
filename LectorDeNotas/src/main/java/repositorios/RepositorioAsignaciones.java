package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Asignacion;

public class RepositorioAsignaciones {
	
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
		
	public List<Asignacion> todos() {
		return asignaciones;
	}
	
}
