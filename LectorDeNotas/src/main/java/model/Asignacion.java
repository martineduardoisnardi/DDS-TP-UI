package model;

import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion extends Entity{
	private int id;
	private String titulo;
	private String descripcion;
	private List<Nota> notas;
	
	public boolean estaAprobado() {
		if (notas.isEmpty()) {
			return true;
		}
		return notas.get(notas.size()-1).estaAprobado();
	}

	public String getUltimaNota() {
		if (notas.isEmpty()) {
			return "-";
		}

		return notas.get(notas.size()-1).getValor();
	}


	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}	
	
}