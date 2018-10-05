package ventanas;

import model.Estudiante;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import excepciones.ExcepcionEstudiante;
import excepciones.LectorDeNotasExcepciones;
import excepciones.ExcepcionToken;
import vm.LoginVM;

public class VentanaLogin extends TransactionalDialog<LoginVM>{
	
	public VentanaLogin (WindowOwner owner){
		super(owner, new LoginVM());
	}
	
	@Override
	protected void createFormPanel(Panel panelLogin) {
		this.setTitle("Lector de Notas - Login");
		
		new Label(panelLogin)
		.setText("Seleccione un estudiante")
		.setFontSize(14);
		
		Panel seleccionEstudiante = new Panel(panelLogin);
		seleccionEstudiante.setLayout(new ColumnLayout(2));
		
		new Label(seleccionEstudiante).setText("Estudiante");
		Selector<Estudiante> selector = new Selector<Estudiante>(seleccionEstudiante);
		selector.allowNull(false);
		selector.bindItemsToProperty("estudiantes").setAdapter(new PropertyAdapter(Estudiante.class, "alias"));
		selector.bindValueToProperty("estudianteSeleccionado");
		
		Label white = new Label (panelLogin);
		white.setHeight(100);
		white.setWidth(120);
	}
	
	@Override
	protected void addActions(Panel panelDeLogin) {
		new Button(panelDeLogin)
		.setCaption("Iniciar Sesion")
		.onClick(this::accept)
		.setAsDefault()
		.disableOnError();
		
		new Button(panelDeLogin)
		.setCaption("Cerrar")
		.onClick(this::cancel);
	}
		
	@Override
	protected void executeTask() {
		try {
			this.getModelObject().autenticar();
		} catch (ExcepcionToken e){
			throw new LectorDeNotasExcepciones(e.getMessage());
		} catch (ExcepcionEstudiante e){
			throw new LectorDeNotasExcepciones("Hubo un problema de autenticacion" + e.getMessage());
		}
		SimpleWindow<?> studentPanel = new VentanaDatosEstudiante(this, this.getModelObject()
				.getEstudianteSeleccionado());
		studentPanel.open();
		this.cancelTask();
	}
}
