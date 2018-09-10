package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepositorioEstudiantes {
	private static RepositorioEstudiantes instance;
	public List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public static RepositorioEstudiantes getInstance() {
		if (instance == null) {
			instance = new RepositorioEstudiantes();
		}
		return instance;
	}
	
	public void agregarEstudiante(Estudiante unEstudiante) {
		estudiantes.add(unEstudiante);
	}
	
	public List<Estudiante> todos(){
		return estudiantes;
	}

}