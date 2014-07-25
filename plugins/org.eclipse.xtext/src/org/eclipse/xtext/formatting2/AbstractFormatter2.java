/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.internal.FormattableDocument;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormatting;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormattingMerger;
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer;
import org.eclipse.xtext.formatting2.internal.MultilineCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineCodeCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer;
import org.eclipse.xtext.formatting2.internal.TextReplacement;
import org.eclipse.xtext.formatting2.internal.TextReplacerContext;
import org.eclipse.xtext.formatting2.internal.TextReplacerMerger;
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormatter2 implements IFormatter2 {

	@Extension
	protected ITextRegionAccess regionAccess;

	private IFormatterRequest request = null;

	public ITextReplacer createCommentReplacer(IComment comment) {
		EObject grammarElement = comment.getGrammarElement();
		if (grammarElement instanceof AbstractRule) {
			String ruleName = ((AbstractRule) grammarElement).getName();
			if (ruleName.startsWith("ML"))
				return new MultilineCommentReplacer(comment, '*');
			if (ruleName.startsWith("SL")) {
				if (comment.getIndentation().getLength() > 0)
					return new SinglelineDocCommentReplacer(comment, "//");
				else
					return new SinglelineCodeCommentReplacer(comment, "//");
			}
		}
		String elementName = new GrammarElementTitleSwitch().showQualified().showRule().doSwitch(grammarElement);
		throw new IllegalStateException("No " + ITextReplacer.class.getSimpleName() + " configured for " + elementName);
	}

	public IFormattableDocument createFormattableDocument() {
		return new FormattableDocument.RootDocument(this);
	}

	public IFormattableSubDocument createFormattableSubDocument(ITextSegment region, IFormattableDocument parent) {
		return new FormattableDocument.SubDocument(region, parent);
	}

	public IHiddenRegionFormatting createHiddenRegionFormatting() {
		return new HiddenRegionFormatting(this);
	}

	public IMerger<IHiddenRegionFormatting> createHiddenRegionFormattingMerger() {
		return new HiddenRegionFormattingMerger(this);
	}

	public ITextReplacer createHiddenRegionReplacer(IHiddenRegion region, IHiddenRegionFormatting formatting) {
		return new HiddenRegionReplacer(region, formatting);
	}

	public ITextReplacer createWhitespaceReplacer(ITextSegment hiddens, IHiddenRegionFormatting formatting) {
		return new WhitespaceReplacer(hiddens, formatting);
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
		try {
			initalize(request);
			IFormattableDocument document = createFormattableDocument();
			format(document);
			List<ITextReplacement> replacements = document.renderToTextReplacements();
			return replacements;
		} finally {
			reset();
		}
	}

	public ITypedPreferenceValues getPreferences() {
		return request.getPreferences();
	}

	public IFormatterRequest getRequest() {
		return request;
	}

	protected void initalize(IFormatterRequest request) {
		this.request = request;
		this.regionAccess = request.getTextRegionAccess();
	}

	protected void reset() {
		this.request = null;
		this.regionAccess = null;
	}

}
