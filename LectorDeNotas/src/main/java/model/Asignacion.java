package model;

import java.util.List;
import model.Nota;
import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion {
	private int id;
	private String title;
	private String description;
	private List<Nota> grades;
	
	public boolean isAprobado() {
		if (grades.isEmpty()) {
			return true;
		}
		return grades.get(grades.size()-1).isAprobado();
	}

	public String getUltimaNota() {
		if (grades.isEmpty()) {
			return "-";
		}

		return grades.get(grades.size()-1).getValor();
	}


	public int getId() {
		return id;
	}

	public String getTitulo() {
		return title;
	}

	public String getDescripcion() {
		return description;
	}

	public List<Nota> getNotas() {
		return grades;
	}

	public void setNotas(List<Nota> notas) {
		this.grades = notas;
	}	
	
}