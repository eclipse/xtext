/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTextReplacer extends AbstractTextSegment implements ITextReplacer {

	private final IFormattableDocument document;
	private final int length;
	private final int offset;

	protected AbstractTextReplacer(IFormattableDocument document, int offset, int length) {
		super();
		this.document = document;
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
		return document.getRequest().getTextRegionAccess();
	}

	protected IFormattableDocument getDocument() {
		return document;
	}

}
