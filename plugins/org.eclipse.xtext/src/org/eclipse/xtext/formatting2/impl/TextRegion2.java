/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtext.formatting2.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegion2 extends AbstractTextRegion2 {

	private final int length;
	private final int offset;
	private final ITextRegionAccess regionAccess;

	public TextRegion2(ITextRegionAccess regionAccess, int offset, int length) {
		super();
		this.regionAccess = regionAccess;
		this.offset = offset;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public int getOffset() {
		return offset;
	}

	public ITextRegionAccess getTextRegionAccess() {
		return regionAccess;
	}

}
