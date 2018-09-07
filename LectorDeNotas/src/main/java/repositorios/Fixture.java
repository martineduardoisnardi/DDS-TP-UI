package repositorios;

import model.Estudiante;

public class Fixture {

	public static void initialize() {
		Estudiante jorgeMuhsisoglu = new Estudiante(1101231, "Jorge1234");
	    Estudiante martinIsnardi = new Estudiante(1379938, "martin");
	    
	    Repositorios.estudiantes.agregarEstudiante(jorgeMuhsisoglu);
	    Repositorios.estudiantes.agregarEstudiante(martinIsnardi);
	}
	
}
