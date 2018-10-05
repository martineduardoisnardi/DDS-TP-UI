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

import model.Asignacion;
import model.Estudiante;
import filtros.LectorDeNotasFiltrosDeTexto;
import vm.DatosEstudianteVM;

public class VentanaDatosEstudiante extends SimpleWindow<DatosEstudianteVM> {

	public VentanaDatosEstudiante(WindowOwner parent, Estudiante estudiante) {
		super(parent, new DatosEstudianteVM(estudiante));
		this.getDelegate().setErrorViewer(this);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.configureLayout(panelPrincipal);
		this.createMainTemplate(panelPrincipal);
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

		NumericField legajo = new NumericField(panelDatosEstudiante);
		legajo.bindValueToProperty("legajo");
		legajo.bindEnabledToProperty("editar");
		legajo.setWidth(150);
		
		Label controlLegajo = new Label(panelDatosEstudiante);
		controlLegajo.bindValueToProperty("controlLegajo").setTransformer(new TransformadorControlLegajo());
		controlLegajo.bindForegroundToProperty("controlLegajo").setTransformer(new TransformadorColorEnLosValores());
		controlLegajo.setFontSize(8);
		controlLegajo.bindVisibleToProperty("editar");
		
		new Label(panelDatosEstudiante).setText("Nombre:");

		TextBox nombre = new TextBox(panelDatosEstudiante);
		nombre.withFilter(LectorDeNotasFiltrosDeTexto.FILTRO_ALFABETICO);
		nombre.bindValueToProperty("nombre");
		nombre.bindEnabledToProperty("editar");
		nombre.setWidth(150);

		Label controlNombre = new Label(panelDatosEstudiante);
		controlNombre.bindValueToProperty("controlNombre").setTransformer(new TransformadorControlNombre());
		controlNombre.bindForegroundToProperty("controlNombre").setTransformer(new TransformadorColorEnLosValores());
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
				.setTransformer(new TransformadorColorEnLosValores());
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
		controlGitHub.bindForegroundToProperty("controlGitHub").setTransformer(new TransformadorColorEnLosValores());
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
		
		Table<Asignacion> tabla = new Table<Asignacion>(panelPrincipal, Asignacion.class);

		tabla.bindItemsToProperty("asignaciones");
		tabla.bindValueToProperty("asignacionSeleccionada");
		tabla.setNumberVisibleRows(10);

		Column<Asignacion> columnaTitulo = new Column<Asignacion>(tabla);
		columnaTitulo.setTitle("Asignacion");
		columnaTitulo.setFixedSize(200);
		columnaTitulo.bindContentsToProperty("titulo");

		Column<Asignacion> columnaDescripcion = new Column<Asignacion>(tabla);
		columnaDescripcion.setTitle("Descripcion");
		columnaDescripcion.setFixedSize(200);
		columnaDescripcion.bindContentsToProperty("descripcion");

		Column<Asignacion> columnaNota = new Column<Asignacion>(tabla);
		columnaNota.setTitle("Nota");
		columnaNota.setFixedSize(50);
		columnaNota.bindContentsToProperty("ultimaNota");

		Column<Asignacion> columnaEstado = new Column<Asignacion>(tabla);
		columnaEstado.setTitle("Status");
		columnaEstado.setFixedSize(150);
		columnaEstado.bindContentsToProperty("aprobado").setTransformer(new TransformadorAprobadoDesabrobado());
		columnaEstado.bindBackground("aprobado").setTransformer(new TransformadorColor());
	}
	
	@Override
	protected void addActions(Panel panelAcciones) {
		Button checkAsignaciones = new Button(panelAcciones);
		checkAsignaciones.setCaption("Chequear Mis Notas");
		checkAsignaciones.onClick(()-> this.getModelObject().checkAsignacionesDelEstudiante());

	}	
	
}