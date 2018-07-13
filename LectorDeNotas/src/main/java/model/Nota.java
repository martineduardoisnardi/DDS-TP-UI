package model;

import java.util.List;
import java.util.stream.*;

public class Nota {
	private int id;
	private String valor;
	private String creado;
	private String actualizado;
	private static final List<String> NOTAS_CONCEPTUALES_PARA_APROBAR = Stream.of("B+","B","B-","R+","R")
																				 .collect(Collectors.toList());

	public Nota(int _id, String _valor, String _creado, String _actualizado) {
		this.id =  _id;
		this.valor = _valor;
		this.creado = _creado;
		this.actualizado = _actualizado;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValor() {
		return valor;
	}
	
	public Boolean estaAprobado() {
		return esNotaConceptualAprobada(valor) || esNotaNumericaAprobada(valor);
	}
	
	private boolean esNotaConceptualAprobada(String valor) {
		return Integer.parseInt(valor) >= 6;
	}
	
	private boolean esNotaNumericaAprobada(String valor) {
		return NOTAS_CONCEPTUALES_PARA_APROBAR.stream().anyMatch(nota -> nota.equals(valor));
	}
}
