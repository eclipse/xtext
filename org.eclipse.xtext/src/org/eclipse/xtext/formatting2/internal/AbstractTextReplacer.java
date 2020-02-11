/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;


/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTextReplacer implements ITextReplacer {

	private final IFormattableDocument document; // TODO: remove
	private final ITextSegment region;

	protected AbstractTextReplacer(IFormattableDocument document, ITextSegment region) {
		super();
		this.document = document;
		this.region = region;
	}

	public IFormattableDocument getDocument() {
		return document;
	}

	@Override
	public ITextSegment getRegion() {
		return region;
	}
}
