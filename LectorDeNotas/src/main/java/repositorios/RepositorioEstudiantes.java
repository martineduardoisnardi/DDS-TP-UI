package repositorios;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepositorioEstudiantes {
	private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public RepositorioEstudiantes() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante JorgeMuhsisoglu = new Estudiante(11111, "Jorge1234");
	public Estudiante MartinIsnardi = new Estudiante(22222, "Martin1234");
	
	public void agregarEstudiante(Estudiante unEstudiante) {
		estudiantes.add(unEstudiante);
	}
	
	//implementar busqueda para saber si hay nro de legajo correspondiente a estudiante
}
