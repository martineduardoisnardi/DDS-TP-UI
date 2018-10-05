package model;

import java.util.List;
import java.util.stream.*;

public class Nota {
	
	private int id;
	private String value;
	private String created_at;
	private String updated_at;
	private static final List<String> NOTAS_CONCEPTUALES_PARA_APROBAR = Stream.of("B+","B","B-","R+","R")
																				 .collect(Collectors.toList());

	public Nota(int id, String value, String created_at, String update_at) {
		this.id =  id;
		this.value = value;
		this.created_at = created_at;
		this.updated_at = update_at;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValor() {
		return value;
	}
	
	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public Boolean isAprobado() {
		return isNotaConceptualAprobada(value) || isNotaNumericaAprobada(value);
	}
	
	private boolean isNotaNumericaAprobada(String valor) {
		return Integer.parseInt(valor) >= 6;
	}
	
	private boolean isNotaConceptualAprobada(String valor) {
		return NOTAS_CONCEPTUALES_PARA_APROBAR.stream().anyMatch(nota -> nota.equals(valor));
	}
}