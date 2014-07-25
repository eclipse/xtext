/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.List;

import org.eclipse.xtext.formatter.FormatterPreferenceKeys;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.formatter.ITextReplacer;
import org.eclipse.xtext.formatter.ITextReplacer.Mergeable;
import org.eclipse.xtext.formatter.ITokenAccess.IGap;
import org.eclipse.xtext.formatter.ITokenAccess.IHidden;
import org.eclipse.xtext.formatter.ITokenAccess.IWhitespace;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GapReplacer implements ITextReplacer, Mergeable<ITextReplacer> {

	public static class Factory implements ITextReplacer.Factory<IGapFormatting> {

		@Inject
		private CommentReplacer.Factory commentReplacerFactory;

		public ITextReplacer create(IGapFormatting parameter) {
			return new GapReplacer(parameter, commentReplacerFactory);
		}

		public CommentReplacer.Factory getCommentReplacerFactoy() {
			return commentReplacerFactory;
		}
	}

	private final CommentReplacer.Factory commentReplacerFactory;
	private final IGapFormatting formatting;

	public GapReplacer(IGapFormatting formatting, CommentReplacer.Factory commentReplacerFactory) {
		super();
		this.formatting = formatting;
		this.commentReplacerFactory = commentReplacerFactory;
	}

	private void appendIndentation(StringBuilder builder, Context context, int count) {
		if (count <= 0)
			return;
		String indentation = context.getRequest().getPreferences().getPreference(FormatterPreferenceKeys.indentation);
		for (int i = 0; i < count; i++)
			builder.append(indentation);
	}

	private void appendLineSeparators(StringBuilder builder, Context context, int count) {
		if (count <= 0)
			return;
		String separator = context.getRequest().getPreferences().getPreference(FormatterPreferenceKeys.lineSeparator);
		for (int i = 0; i < count; i++)
			builder.append(separator);
	}

	protected int computeNewIndentation(Context context) {
		Integer indentationIncrease = formatting.getIndentationIncreaseValue();
		Integer indentationDecrease = formatting.getIndentationDecreaseValue();
		int indenation = context.getFlow().getIndentation();
		if (indentationIncrease != null)
			indenation += indentationIncrease;
		if (indentationDecrease != null)
			indenation -= indentationDecrease;
		if (indenation >= 0)
			return indenation;
		return 0; // TODO: handle indentation underflow
	}

	protected int computeNewLineCount(Context context) {
		Integer newLineDefault = formatting.getNewLineDefaultValue();
		Integer newLineMin = formatting.getNewLineMinValue();
		Integer newLineMax = formatting.getNewLineMaxValue();
		if (newLineMin != null || newLineDefault != null || newLineMax != null) {
			IGap gap = formatting.getGapValue();
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

	protected boolean computeAutowrap(Context context) {
		if (!Boolean.TRUE.equals(formatting.getAutowrapValue()))
			return false;
		int charsInLineCount = context.getLeadingCharsInLineCount();
		// TODO: compute space to next wrap, not just next token
		int nextTokenLenght = formatting.getGapValue().getNextToken().getLength();
		int maxLenght = context.getRequest().getPreferences().getPreference(FormatterPreferenceKeys.maxLineWidth);
		return charsInLineCount + nextTokenLenght > maxLenght;
	}

	public Flow createReplacements(Context context) {
		IGap gap = formatting.getGapValue();
		List<IHidden> hiddens = gap.getWhitespaceAndComments();
		if (gap.isUndefined() || hiddens.isEmpty() || ((hiddens.size() == 1 && hiddens.get(0) instanceof IWhitespace))) {
			String space = formatting.getSpace();
			int newLineCount = computeNewLineCount(context);
			int indenationCount = computeNewIndentation(context);
			if (newLineCount == 0 && computeAutowrap(context))
				newLineCount = 1;
			if (newLineCount == 0) {
				if (space != null)
					context.replaceText(gap, space);
			} else {
				StringBuilder text = new StringBuilder();
				appendLineSeparators(text, context, newLineCount);
				appendIndentation(text, context, indenationCount);
				context.replaceText(gap, text);
			}
			return context.getFlow().withIndentation(indenationCount);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public IGapFormatting getFormatting() {
		return formatting;
	}

	@SuppressWarnings("unchecked")
	public ITextReplacer mergeWith(ITextReplacer other) {
		if (other == null || !(other instanceof GapReplacer) || !(formatting instanceof Mergeable<?>))
			return null;
		IGapFormatting m = ((Mergeable<IGapFormatting>) formatting).mergeWith(((GapReplacer) other).getFormatting());
		if (m == null)
			return null;
		return new GapReplacer(m, commentReplacerFactory);
	}

	@Override
	public String toString() {
		return new GapFormattingToString().apply(formatting);
	}
}
