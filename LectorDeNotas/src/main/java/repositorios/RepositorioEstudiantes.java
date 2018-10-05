package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepositorioEstudiantes {
	
	public List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
	public void add(Estudiante unEstudiante) {
		estudiantes.add(unEstudiante);
	}
	
	public List<Estudiante> todos(){
		return estudiantes;
	}

}