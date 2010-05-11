/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReplaceRegion {

	private int offset;
	private int length;
	private String text;

	public ReplaceRegion(TextLocation location, String text) {
		this.offset = location.getOffset();
		this.length = location.getLength();
		this.text = text;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public String getText() {
		return text;
	}

}
