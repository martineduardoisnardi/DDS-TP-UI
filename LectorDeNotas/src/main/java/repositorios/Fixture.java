package repositorios;

import model.Estudiante;
import repositorios.Repositorios;

public class Fixture {
	
	public static void initialize() {
		Estudiante test = new Estudiante("TEST", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		Estudiante mIsnardi = new Estudiante("MIsnardi");
		Estudiante jMuhsisoglu = new Estudiante("JMuhsisoglu");
	
		Repositorios.estudiantes.add(test);
		Repositorios.estudiantes.add(mIsnardi);
		Repositorios.estudiantes.add(jMuhsisoglu);
	}

}
