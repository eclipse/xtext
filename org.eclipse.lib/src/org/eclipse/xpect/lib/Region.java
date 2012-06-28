package org.eclipse.xpect.lib;

import org.eclipse.xpect.lib.IXpectParameterProvider.IRegion;

public class Region implements IRegion {

	private final int length;

	private final int offset;

	public Region(int offset, int length) {
		super();
		this.offset = offset;
		this.length = length;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		Region other = (Region) obj;
		return length == other.length && offset == other.offset;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int hashCode() {
		return length + (offset * 13);
	}

}
