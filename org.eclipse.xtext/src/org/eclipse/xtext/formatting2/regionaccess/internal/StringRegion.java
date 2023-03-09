/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringRegion extends AbstractTextSegment {
	private final int length;
	private final int offset;
	private final StringBasedRegionAccess access;

	protected StringRegion(StringBasedRegionAccess access, int offset, int length) {
		super();
		this.access = access;
		this.offset = offset;
		this.length = length;
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
	public ITextRegionAccess getTextRegionAccess() {
		return access;
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withOrigin(this).highlightOrigin().toString();
	}
}