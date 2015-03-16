/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializedRegion extends AbstractTextSegment {
	private final SerializerBasedRegionAccess tokenAccess;
	private final int offset;
	private final String text;

	protected SerializedRegion(SerializerBasedRegionAccess tokenAccess, int offset, String text) {
		super();
		this.tokenAccess = tokenAccess;
		this.offset = offset;
		this.text = text;
	}

	@Override
	public int getLength() {
		return text.length();
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return tokenAccess;
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withOrigin(this).hightlightOrigin().toString();
	}

	@Override
	public String getText() {
		return text;
	}
}