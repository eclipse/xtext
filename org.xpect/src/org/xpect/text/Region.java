/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.text;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Region implements IRegion {

	private final CharSequence document;
	private final int length;
	private final int offset;

	public Region(CharSequence document, int offset, int length) {
		super();
		this.offset = offset;
		this.length = length;
		this.document = document;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		Region other = (Region) obj;
		return length == other.length && offset == other.offset;
	}

	public CharSequence getDocument() {
		return document;
	}

	public int getLength() {
		return length;
	}

	public int getOffset() {
		return offset;
	}

	public String getRegionText() {
		if (offset >= 0 && length >= 0) {
			int endIndex = offset + length;
			String result = document.subSequence(offset, endIndex).toString();
			return result;
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		return length + (offset * 13);
	}

	@Override
	public String toString() {
		return new RegionToString().with(this).toString();
	}

}
