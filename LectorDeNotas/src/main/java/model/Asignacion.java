package model;

import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion  extends Entity{
	private int id;
	private String titulo;
	private String descripcion;
	private List<Nota> notas;
	
	
	
}
