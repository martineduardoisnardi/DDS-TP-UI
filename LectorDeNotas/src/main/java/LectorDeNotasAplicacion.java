import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import repositorios.Fixture;
import ventanas.VentanaLogin;

public class LectorDeNotasAplicacion extends Application{

	public static void main(String[] args) {
		Fixture.initialize();
		new LectorDeNotasAplicacion().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new VentanaLogin(this);
	}
}
