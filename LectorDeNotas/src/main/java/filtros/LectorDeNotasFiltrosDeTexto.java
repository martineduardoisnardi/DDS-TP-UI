package filtros;

import org.uqbar.arena.filters.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;

public interface LectorDeNotasFiltrosDeTexto extends TextFilter{

	@Override
	public default boolean accept(TextInputEvent arg0) {
		return false;
	}

	public final static TextFilter FILTRO_ALFABETICO = new TextFilter() {
		@Override
		public boolean accept(TextInputEvent event) {
			return event.getPotentialTextResult().matches("[ A-Za-z]*");
		}
	};

	public final static TextFilter FILTRO_ALFANUMERICO = new TextFilter() {
		@Override
		public boolean accept(TextInputEvent event) {
			return event.getPotentialTextResult().matches("[A-Za-z1-9-_]*");
		}
	};
}
