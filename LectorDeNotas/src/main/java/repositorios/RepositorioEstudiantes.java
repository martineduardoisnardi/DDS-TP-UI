package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepositorioEstudiantes {
	private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public RepositorioEstudiantes() {
		// TODO Auto-generated constructor stub
	}


	
	public void agregarEstudiante(Estudiante unEstudiante) {
		estudiantes.add(unEstudiante);
	}
	
	public List<Estudiante> todos(){
		return estudiantes;
	}
	//implementar busqueda para saber si hay nro de legajo correspondiente a estudiante
	public boolean estudianteValido(int legajo) {
		//List<int> legajos = new ArrayList<int>();
		//legajos = estudiantes.stream().mapToInt(unEstudiante -> unEstudiante.getLegajo()).collect()
		return true;
	}
}
