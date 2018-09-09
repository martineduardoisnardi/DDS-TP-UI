package repositorios;

import java.util.List;

import model.Asignacion;
import model.Estudiante;
import model.Nota;

public class Fixture {
//    private static List<Nota> notas;
//    private static Nota bien, regular;
//    private static List<Asignacion> asignaciones;
    private static Asignacion tp1, tp2;
    
	public static void initialize() {
		Estudiante jorgeMuhsisoglu = new Estudiante(1265908, "Jorge1234", "Jorge", "Muhsisoglu", "jmuhsisoglu");
	    Estudiante martinIsnardi = new Estudiante(1379938, "martin", "Martin", "Isnardi", "misnardi");
/*	    
	    bien = new Nota(1, "B");
	    regular = new Nota(2, "R");
	    
	    notas.add(bien);
	    notas.add(regular);
*/	    
	    tp1 = new Asignacion(1, "TP1", "Trabajo Practico 1", null);
	    tp2 = new Asignacion(2, "TP2", "Trabajo Practico 2", null);
	    
//	    asignaciones.add(tp1);
//	    asignaciones.add(tp2);
	    
	    Repositorios.estudiantes.agregarEstudiante(jorgeMuhsisoglu);
	    Repositorios.estudiantes.agregarEstudiante(martinIsnardi);
	    
	    Repositorios.asignaciones.agregarAsignacion(tp1);
	    Repositorios.asignaciones.agregarAsignacion(tp2);
	    
	}
	
}
