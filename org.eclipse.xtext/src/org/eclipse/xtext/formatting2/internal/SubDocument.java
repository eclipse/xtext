/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SubDocument extends FormattableDocument implements IFormattableSubDocument,
		ICompositeTextReplacer {

	private final IFormattableDocument parent;
	private final ITextSegment region;

	public SubDocument(ITextSegment region, IFormattableDocument parent) {
		super();
		this.region = region;
		this.parent = parent;
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext previous) {
		ITextReplacerContext context = ((TextReplacerContext) previous).withDocument(this);
		context.setNextReplacerIsChild();
		return ((TextReplacerContext) super.createReplacements(context)).withDocument(previous.getDocument());
	}

	@Override
	public AbstractFormatter2 getFormatter() {
		return parent.getFormatter();
	}

	@Override
	public ITextSegment getRegion() {
		return region;
	}

	@Override
	public FormatterRequest getRequest() {
		return parent.getRequest();
	}

	@Override
	public IFormattableSubDocument requireFitsInLine() {
		return requireFitsInLine(region.getOffset(), region.getLength());
	}

	public IFormattableSubDocument requireFitsInLine(int offset, int length) {
		Integer maxLineWidth = getRequest().getPreferences().getPreference(FormatterPreferenceKeys.maxLineWidth);
		return requireFitsInLine(offset, length, maxLineWidth);
	}

	@Override
	public IFormattableSubDocument requireFitsInLine(int offset, int length, int maxLineWidth) {
		TextSegment segment = new TextSegment(getTextRegionAccess(), offset, length);
		MaxLineWidthDocument document = new MaxLineWidthDocument(segment, this, maxLineWidth);
		addReplacer(document);
		return document;
	}

}