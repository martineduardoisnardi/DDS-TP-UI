package ventanas;

import org.uqbar.arena.bindings.ValueTransformer;

public class TransformadorControlGitHub implements ValueTransformer<Boolean, String> {

	@Override
	public Class<Boolean> getModelType() {
		return null;
	}

	@Override
	public Class<String> getViewType() {
		return null;
	}

	@Override
	public String modelToView(Boolean arg0) {
		return arg0 ? "OK" : "Usuario invalido";
	}

	@Override
	public Boolean viewToModel(String arg0) {
		return null;
	}

}
