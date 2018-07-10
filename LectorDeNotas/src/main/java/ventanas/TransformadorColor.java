package ventanas;

import java.awt.Color;

import org.uqbar.arena.bindings.ValueTransformer;

public class TransformadorColor implements ValueTransformer<Boolean, Color> {

	@Override
	public Class<Boolean> getModelType() {
		return null;
	}

	@Override
	public Class<Color> getViewType() {
		return null;
	}

	@Override
	public Color modelToView(Boolean arg0) {
		return arg0 ? Color.GREEN : Color.RED;
	}

	@Override
	public Boolean viewToModel(Color arg0) {
		return null;
	}

}
