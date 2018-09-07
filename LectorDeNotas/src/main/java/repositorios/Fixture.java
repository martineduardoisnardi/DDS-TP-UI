package repositorios;

import model.Asignacion;
import model.Estudiante;

public class Fixture {

	public static void initialize() {
		Estudiante jorgeMuhsisoglu = new Estudiante(1265908, "Jorge1234", "Jorge", "Muhsisoglu", "jmuhsisoglu");
	    Estudiante martinIsnardi = new Estudiante(1379938, "martin", "Martin", "Isnardi", "misnardi");
	    	    
	    Repositorios.estudiantes.agregarEstudiante(jorgeMuhsisoglu);
	    Repositorios.estudiantes.agregarEstudiante(martinIsnardi);
	}
	
}
