/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionReplacer extends AbstractTextSegment implements ITextReplacer {

	private final IHiddenRegionFormatting formatting;

	public HiddenRegionReplacer(IHiddenRegionFormatting formatting) {
		super();
		this.formatting = formatting;
	}

	private void appendIndentation(StringBuilder builder, ITextReplacerContext context, int count) {
		if (count <= 0)
			return;
		String indentation = context.getDocument().getRequest().getPreferences()
				.getPreference(FormatterPreferenceKeys.indentation);
		for (int i = 0; i < count; i++)
			builder.append(indentation);
	}

	private void appendLineSeparators(StringBuilder builder, ITextReplacerContext context, int count) {
		if (count <= 0)
			return;
		String separator = context.getDocument().getRequest().getPreferences()
				.getPreference(FormatterPreferenceKeys.lineSeparator);
		for (int i = 0; i < count; i++)
			builder.append(separator);
	}

	protected int computeNewIndentation(ITextReplacerContext context) {
		Integer indentationIncrease = formatting.getIndentationIncrease();
		Integer indentationDecrease = formatting.getIndentationDecrease();
		int indenation = context.getIndentation();
		if (indentationIncrease != null)
			indenation += indentationIncrease;
		if (indentationDecrease != null)
			indenation -= indentationDecrease;
		if (indenation >= 0)
			return indenation;
		return 0; // TODO: handle indentation underflow
	}

	protected int computeNewLineCount(ITextReplacerContext context) {
		Integer newLineDefault = formatting.getNewLineDefault();
		Integer newLineMin = formatting.getNewLineMin();
		Integer newLineMax = formatting.getNewLineMax();
		if (newLineMin != null || newLineDefault != null || newLineMax != null) {
			IHiddenRegion gap = formatting.getHiddenRegion();
			if (gap.isUndefined()) {
				if (newLineDefault != null)
					return newLineDefault;
				if (newLineMin != null)
					return newLineMin;
				if (newLineMax != null)
					return newLineMax;
			} else {
				int lineCount = gap.getLineCount();
				if (newLineMin != null && newLineMin > lineCount)
					lineCount = newLineMin;
				if (newLineMax != null && newLineMax < lineCount)
					lineCount = newLineMax;
				return lineCount;
			}
		}
		return 0;
	}

	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		IHiddenRegion gap = formatting.getHiddenRegion();
		List<IHiddenRegionPart> hiddens = gap.getParts();
		if (formatting.getAutowrap() == Boolean.TRUE)
			context.setCanAutowrap(true);
		if (gap.isUndefined() || hiddens.isEmpty() || ((hiddens.size() == 1 && hiddens.get(0) instanceof IWhitespace))) {
			String space = formatting.getSpace();
			int newLineCount = computeNewLineCount(context);
			if (newLineCount == 0 && context.isAutowrap()) {
				IAutowrapFormatter onAutowrap = formatting.getOnAutowrap();
				if (onAutowrap != null) {
					onAutowrap.format(formatting.asFormatter(), formatting.getDocument());
				}
				newLineCount = 1;
			}
			int indenationCount = computeNewIndentation(context);
			if (newLineCount == 0) {
				if (space != null)
					context.replaceText(gap, space);
			} else {
				StringBuilder text = new StringBuilder();
				appendLineSeparators(text, context, newLineCount);
				appendIndentation(text, context, indenationCount);
				context.replaceText(gap, text);
			}
			return context.withIndentation(indenationCount);
		} else {
			return context.withIndentation(computeNewIndentation(context));
		}
	}

	public IHiddenRegionFormatting getFormatting() {
		return formatting;
	}

	public int getLength() {
		return formatting.getHiddenRegion().getLength();
	}

	public int getOffset() {
		return formatting.getHiddenRegion().getOffset();
	}

	public ITextRegionAccess getTextRegionAccess() {
		return formatting.getHiddenRegion().getTextRegionAccess();
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}
}
