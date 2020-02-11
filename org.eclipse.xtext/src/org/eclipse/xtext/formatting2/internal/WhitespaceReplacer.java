/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class WhitespaceReplacer implements ITextReplacer {

	private final IHiddenRegionFormatting formatting;
	private final ITextSegment region;

	public WhitespaceReplacer(ITextSegment whitespace, IHiddenRegionFormatting formatting) {
		super();
		this.region = whitespace;
		this.formatting = formatting;
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
			if (region instanceof IHiddenRegion && ((IHiddenRegion) region).isUndefined()) {
				if (newLineDefault != null)
					return newLineDefault;
				if (newLineMin != null)
					return newLineMin;
				if (newLineMax != null)
					return newLineMax;
			} else {
				int lineCount = region.getLineCount() - 1;
				if (newLineMin != null && newLineMin > lineCount)
					lineCount = newLineMin;
				if (newLineMax != null && newLineMax < lineCount)
					lineCount = newLineMax;
				return lineCount;
			}
		}
		return 0;
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		if (formatting.getAutowrap() != null && formatting.getAutowrap() >= 0)
			context.setCanAutowrap(formatting.getAutowrap());
		String space = formatting.getSpace();
		int trailingNewLinesOfPreviousRegion = trailingNewLinesOfPreviousRegion();
		int computedNewLineCount = computeNewLineCount(context);
		int newLineCount = Math.max(computedNewLineCount - trailingNewLinesOfPreviousRegion, 0);
		if (newLineCount == 0 && context.isAutowrap()) {
			IAutowrapFormatter onAutowrap = formatting.getOnAutowrap();
			if (onAutowrap != null) {
				onAutowrap.format(region, formatting, context.getDocument());
			}
			newLineCount = 1;
		}
		int indentationCount = computeNewIndentation(context);
		if (newLineCount == 0 && trailingNewLinesOfPreviousRegion == 0) {
			if (space != null)
				context.addReplacement(region.replaceWith(space));
		} else {
			boolean noIndentation = formatting.getNoIndentation() == Boolean.TRUE;
			String newLines = context.getNewLinesString(newLineCount);
			String indentation = noIndentation ? "" : context.getIndentationString(indentationCount);
			context.addReplacement(region.replaceWith(newLines + indentation));
		}
		return context.withIndentation(indentationCount);
	}

	public IHiddenRegionFormatting getFormatting() {
		return formatting;
	}

	@Override
	public ITextSegment getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}

	protected int trailingNewLinesOfPreviousRegion() {
		int offset = region.getOffset();
		if (offset < 1)
			return 0;
		String previous = region.getTextRegionAccess().textForOffset(offset - 1, 1);
		if ("\n".equals(previous))
			return 1;
		return 0;
	}
}
