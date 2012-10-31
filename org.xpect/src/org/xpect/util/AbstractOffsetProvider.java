package org.xpect.util;

public abstract class AbstractOffsetProvider extends AbstractIntegerProvider {
	@Override
	protected String getValue() {
		return String.valueOf(getOffset());
	}

	public abstract int getOffset();
}
