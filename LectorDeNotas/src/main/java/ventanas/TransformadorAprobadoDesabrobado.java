package ventanas;

import org.apache.commons.collections15.Transformer;

public final class TransformadorAprobadoDesabrobado implements Transformer<Boolean, String> {

	@Override
	public String transform(Boolean passed) {
		return passed ? "APROBADO" : "DESAPROBADO";
	}
}