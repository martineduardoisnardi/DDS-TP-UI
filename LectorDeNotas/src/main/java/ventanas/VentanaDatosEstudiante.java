package ventanas;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;


import model.Estudiante;
import filtros.LectorDeNotasFiltrosDeTexto;
import vm.DatosEstudianteVM;

public class VentanaDatosEstudiante extends SimpleWindow<DatosEstudianteVM> {

	public VentanaDatosEstudiante(WindowOwner parent, Estudiante estudiante) {
		super(parent, new DatosEstudianteVM(estudiante));
		this.getDelegate().setErrorViewer(this);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.configureLayout(mainPanel);
		this.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) {
		this.setTitle("Panel de Notas");
		new Label(panelPrincipal).bindValueToProperty("saludo");
		new Label(panelPrincipal).setText("============================================");
		new Label(panelPrincipal).setText("Mis Datos").setFontSize(12);

		Panel panelDatosEstudiante = new Panel(panelPrincipal);
		panelDatosEstudiante.setLayout(new ColumnLayout(3));

		new Label(panelDatosEstudiante).setText("Legajo:");

		NumericField codigo = new NumericField(panelDatosEstudiante);
		codigo.bindValueToProperty("codigo");
		codigo.bindEnabledToProperty("editar");
		codigo.setWidth(150);

		Label controlCodigo = new Label(panelDatosEstudiante);
		controlCodigo.bindValueToProperty("controlCodigo").setTransformer(new TransformadorControlCodigo());
		controlCodigo.bindForegroundToProperty("controlCodigo").setTransformer(new TransformadorColor());
		controlCodigo.setFontSize(8);
		controlCodigo.bindVisibleToProperty("editar");

		new Label(panelDatosEstudiante).setText("Nombre:");

		TextBox nombre = new TextBox(panelDatosEstudiante);
		nombre.withFilter(LectorDeNotasFiltrosDeTexto.FILTRO_ALFABETICO);
		nombre.bindValueToProperty("nombre");
		nombre.bindEnabledToProperty("editar");
		nombre.setWidth(150);

		Label controlNombre = new Label(panelDatosEstudiante);
		controlNombre.bindValueToProperty("controlNombre").setTransformer(new TransformadorControlNombre());
		controlNombre.bindForegroundToProperty("controlNombre").setTransformer(new TransformadorColor());
		controlNombre.setFontSize(8);
		controlNombre.bindVisibleToProperty("editar");

		new Label(panelDatosEstudiante).setText("Apellido:");

		TextBox apellido = new TextBox(panelDatosEstudiante);
		apellido.withFilter(LectorDeNotasFiltrosDeTexto.FILTRO_ALFABETICO);
		apellido.bindValueToProperty("apellido");
		apellido.bindEnabledToProperty("editar");
		apellido.setWidth(150);

		Label controlApellido = new Label(panelDatosEstudiante);
		controlApellido.bindValueToProperty("controlApellido").setTransformer(new TransformadorControlApellido());
		controlApellido.bindForegroundToProperty("controlApellido")
				.setTransformer(new TransformadorColor());
		controlApellido.setFontSize(8);
		controlApellido.bindVisibleToProperty("editar");

		new Label(panelDatosEstudiante).setText("Github:");

		TextBox gitHub = new TextBox(panelDatosEstudiante);
		gitHub.withFilter(LectorDeNotasFiltrosDeTexto.FILTRO_ALFANUMERICO);
		gitHub.bindValueToProperty("gitHub");
		gitHub.bindEnabledToProperty("editar");
		gitHub.setWidth(150);

		Label controlGitHub = new Label(panelDatosEstudiante);
		controlGitHub.bindValueToProperty("controlGitHub").setTransformer(new TransformadorControlGitHub());
		controlGitHub.bindForegroundToProperty("controlGitHub").setTransformer(new TransformadorColor());
		controlGitHub.setFontSize(8);
		controlGitHub.bindVisibleToProperty("editar");

		new Label(panelDatosEstudiante).setText("Editar Mis Datos");

		CheckBox editarEstudiante = new CheckBox(panelDatosEstudiante);
		editarEstudiante.bindValueToProperty("editar");

		Button actualizarDatosEstudiante = new Button(panelDatosEstudiante);
		actualizarDatosEstudiante.setCaption("Actualizar Mis Datos");
		actualizarDatosEstudiante.bindEnabledToProperty("controlEditar");
		actualizarDatosEstudiante.onClick(() -> this.getModelObject().actualizarDatosEstudiante());

		new Label(panelPrincipal).setText("============================================");

		Panel panelNotasDelEstudiante = new Panel(panelPrincipal);
		panelNotasDelEstudiante.setLayout(new VerticalLayout());

		new Label(panelPrincipal).setText("Mis Notas").setFontSize(12);

	}
	
	@Override
	protected void addActions(Panel panelAcciones) {
/*		Button checkAsignacion = new Button(panelAcciones);
		checkAsignacion.setCaption("Chequear Mis Notas");
		checkAsignacion.onClick(()-> this.getModelObject().checkAsignacionesEstudiante());
*/
	}	
	
}
