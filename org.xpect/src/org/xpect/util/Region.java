/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.util;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
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
