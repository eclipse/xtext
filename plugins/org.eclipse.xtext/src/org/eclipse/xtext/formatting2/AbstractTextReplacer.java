/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTextReplacer implements ITextReplacer {

	public static class GetRegion implements Function<ITextReplacer, ITextSegment> {
		public ITextSegment apply(ITextReplacer input) {
			return input.getRegion();
		}
	}

	private final IFormattableDocument document;
	private final ITextSegment region;

	protected AbstractTextReplacer(IFormattableDocument document, ITextSegment region) {
		super();
		this.document = document;
		this.region = region;
	}

	public IFormattableDocument getDocument() {
		return document;
	}

	public ITextSegment getRegion() {
		return region;
	}
}
