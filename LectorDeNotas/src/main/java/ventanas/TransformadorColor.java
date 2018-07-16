package ventanas;

import java.awt.Color;

import org.apache.commons.collections15.Transformer;

public class TransformadorColor implements Transformer<Boolean, Color> {
	@Override
	public Color transform(Boolean passed) {
		return passed ? Color.green : Color.RED;
	}
}