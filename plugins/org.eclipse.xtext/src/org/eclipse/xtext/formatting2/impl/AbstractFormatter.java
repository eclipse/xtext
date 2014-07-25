/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.List;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.IInternalFormatter;
import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormatter implements IInternalFormatter {

	@Extension
	protected ITextRegionAccess regionAccess;

	private IFormatterRequest request = null;

	public ITextReplacer createCommentReplacer(IComment comment) {
		return new CommentReplacer(comment);
	}

	public IFormattableDocument createFormattableDocument() {
		return new FormattableDocument.RootDocument(this);
	}

	public IFormattableSubDocument createFormattableSubDocument(int offset, int length, IFormattableDocument parent) {
		return new FormattableDocument.SubDocument(offset, length, parent);
	}

	public IHiddenRegionFormatting createHiddenRegionFormatting(IFormattableDocument document,
			IHiddenRegion hiddenRegion) {
		return new HiddenRegionFormatting(document, hiddenRegion);
	}

	public IMerger<IHiddenRegionFormatting> createHiddenRegionFormattingMerger() {
		return new HiddenRegionFormattingMerger(this);
	}

	public ITextReplacer createHiddenRegionReplacer(IHiddenRegionFormatting hiddenRegionFormatting) {
		return new HiddenRegionReplacer(hiddenRegionFormatting);
	}

	public ITextReplacement createTextReplacement(int offset, int length, String text) {
		return new TextReplacement(getRequest().getTextRegionAccess(), offset, length, text);
	}

	public ITextReplacerContext createTextReplacerContext(IFormattableDocument document) {
		return new TextReplacerContext(document);
	}

	public IMerger<ITextReplacer> createTextReplacerMerger() {
		return new TextReplacerMerger(this);
	}

	protected abstract void format(IFormattableDocument document);

	final public List<ITextReplacement> format(IFormatterRequest request) {
		if (this.request != null)
			throw new IllegalStateException("A formatter-object can only be used once.");
		this.request = request;
		this.regionAccess = request.getTextRegionAccess();
		initalize();
		IFormattableDocument document = createFormattableDocument();
		format(document);
		return document.renderToTextReplacements();
	}

	public IFormatterRequest getRequest() {
		return request;
	}

	protected void initalize() {
	}

}
