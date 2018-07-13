package ventanas;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import excepciones.ExcepcionLegajo;
import excepciones.LectorDeNotasExcepciones;
import filtros.LectorDeNotasFiltrosDeTexto;
import vm.LoginVM;
import model.Estudiante;


//@SuppressWarnings({ "serial", "rawtypes" })
@SuppressWarnings({"rawtypes" })
public class VentanaLogin extends TransactionalDialog<LoginVM>{
	
	public VentanaLogin (WindowOwner owner){
		super(owner, new LoginVM());
	}
	
	@Override
	protected void createFormPanel(Panel panelLogin) {
		this.setTitle("Lector de Notas - Login");
				
		Panel seleccionEstudiante = new Panel(panelLogin);
		seleccionEstudiante.setLayout(new ColumnLayout(2));
		
		new Label(seleccionEstudiante).setText("Legajo");
		
		NumericField codigo = new NumericField(seleccionEstudiante);
		codigo.bindValueToProperty("legajo");
		codigo.setWidth(150);
		
		new Label(seleccionEstudiante).setText("Contraseña");

		TextBox contrasenia = new TextBox(seleccionEstudiante);
		contrasenia.withFilter(LectorDeNotasFiltrosDeTexto.FILTRO_ALFANUMERICO);
		contrasenia.bindValueToProperty("contrasenia");
		contrasenia.setWidth(150);
		
		Label blanco = new Label (panelLogin);
		blanco.setHeight(100);
		blanco.setWidth(120);
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
			this.getModelObject().validarLegajo();
		} catch (ExcepcionLegajo e){
			throw new LectorDeNotasExcepciones(e.getMessage());
		}
//		SimpleWindow<?> panelDatosEstudiante = new VentanaDatosEstudiante(this, Estudiante estudiante);
//		panelDatosEstudiante.open();
//		this.cancelTask();
	}
}
