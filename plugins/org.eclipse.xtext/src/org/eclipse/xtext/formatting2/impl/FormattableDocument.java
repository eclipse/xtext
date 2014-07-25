/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.FormattingNotApplicableException;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegion;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ISemanticRegion;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.ITextRegionAccess;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacer.Flow;
import org.eclipse.xtext.formatting2.ITextReplacer.Mergeable;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.ITextSegmentMerger;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class FormattableDocument extends AbstractTextSegment implements IFormattableDocument {

	protected static class ConditionalReplacer extends AbstractTextSegment implements ITextReplacer {

		private final FormattableDocument document;
		private final int length;
		private final int offset;
		private final List<ISubFormatter> subFormatters;

		public ConditionalReplacer(FormattableDocument document, int offset, int length,
				List<ISubFormatter> subFormatters) {
			super();
			this.offset = offset;
			this.length = length;
			this.document = document;
			this.subFormatters = subFormatters;
		}

		public Flow createReplacements(ITextReplacerContext context) {
			for (ISubFormatter formatter : subFormatters) {
				try {
					SubDocument subDocument = new SubDocument(offset, length, document);
					formatter.format(subDocument);
					List<ITextReplacement> replacements = subDocument.renderToTextReplacements(context);
					for (ITextReplacement replacement : replacements)
						context.replaceText(replacement);
					return context.getFlow();
				} catch (FormattingNotApplicableException e) {
					continue;
				}
			}
			throw new FormattingNotApplicableException();
		}

		public int getLength() {
			return length;
		}

		public int getOffset() {
			return offset;
		}

		public ITextRegionAccess getTextRegionAccess() {
			return document.getTextRegionAccess();
		}
	}

	protected static class MaxLineWidthDocument extends SubDocument {
		private final int maxLineWidth;

		public MaxLineWidthDocument(int offset, int length, FormattableDocument parent, int maxLineWidth) {
			super(offset, length, parent);
			this.maxLineWidth = maxLineWidth;
		}

		@Override
		protected List<ITextReplacement> renderToTextReplacements(ITextReplacerContext context) {
			List<ITextReplacement> replacements = super.renderToTextReplacements(context);
			String string = applyTextReplacements(replacements);
			if (string.contains("\n"))
				throw new FormattingNotApplicableException();
			if (context != null) {
				int leadingCharCount = context.getLeadingCharsInLineCount();
				int formattedLength = string.length();
				int lineLength = leadingCharCount + formattedLength;
				if (lineLength > maxLineWidth)
					throw new FormattingNotApplicableException();
			}
			return replacements;
		}

		@Override
		public void setReplacer(int offset, int length, ITextReplacer replacer) {
			validate(replacer);
			super.setReplacer(offset, length, replacer);
		}

		protected void validate(HiddenRegionReplacer replacer) throws FormattingNotApplicableException {
			IHiddenRegionFormatting formatting = replacer.getFormatting();
			Integer newLineMin = formatting.getNewLineMinValue();
			if (newLineMin != null && newLineMin > 0)
				throw new FormattingNotApplicableException();
		}

		protected void validate(ITextReplacer replacer) throws FormattingNotApplicableException {
			if (replacer instanceof HiddenRegionReplacer)
				validate((HiddenRegionReplacer) replacer);
		}
	}

	protected static class ReplacerContext extends AbstractTextSegment implements ITextReplacerContext,
			Mergeable<ReplacerContext> {
		private final FormattableDocument document;
		private Flow flow = null;
		private List<ITextReplacement> leadingReplacements;
		private final int length;
		private final int offset;
		private TextSegmentSet<ITextReplacement> replacements = null;

		private final ITextReplacer replacer;

		public ReplacerContext(FormattableDocument document, int offset, int lenght, ITextReplacer replacer) {
			super();
			Preconditions.checkNotNull(replacer);
			this.document = document;
			this.offset = offset;
			this.length = lenght;
			this.replacer = replacer;
		}

		public Flow getFlow() {
			return flow;
		}

		public int getLeadingCharsInLineCount() {
			ITextRegionAccess access = getTextRegionAccess();
			int lastOffset = this.offset;
			int count = 0;
			for (int i = leadingReplacements.size() - 1; i > 0; i--) {
				ITextReplacement rep = leadingReplacements.get(i);
				int endOffset = rep.getEndOffset();
				String between = access.getText(endOffset, lastOffset - endOffset);
				int idx = between.lastIndexOf('\n');
				if (idx >= 0)
					return count + logicalLenght(between.substring(idx + 1));
				count += logicalLenght(between);
				String text = rep.getReplacementText();
				int idx2 = text.lastIndexOf('\n');
				if (idx2 >= 0)
					return count + logicalLenght(text.substring(idx2 + 1));
				count += logicalLenght(text);
				lastOffset = rep.getOffset();
			}
			String rest = access.getText(0, lastOffset);
			int idx = rest.lastIndexOf('\n');
			if (idx >= 0)
				return count + logicalLenght(rest.substring(idx + 1));
			count += lastOffset;
			return count;
		}

		public List<ITextReplacement> getLeadingReplacements() {
			return ImmutableList.copyOf(leadingReplacements);
		}

		public int getLength() {
			return length;
		}

		public int getOffset() {
			return offset;
		}

		public ITextReplacer getReplacer() {
			return replacer;
		}

		public IFormatterRequest getRequest() {
			return document.getRequest();
		}

		public ITextRegionAccess getTextRegionAccess() {
			return document.getTextRegionAccess();
		}

		public boolean isInsideFormattedRegion() {
			return true; // TODO: implement
		}

		protected int logicalLenght(String text) {
			ITypedPreferenceValues preferences = getRequest().getPreferences();
			String indentation = preferences.getPreference(FormatterPreferenceKeys.indentation);
			if (!"\t".equals(indentation))
				return text.length();
			int indentationLength = preferences.getPreference(FormatterPreferenceKeys.indentationLength);
			int length = 0;
			for (int i = 0; i < text.length(); i++)
				if (text.charAt(i) == '\t')
					length += indentationLength;
				else
					length++;
			return length;
		}

		@SuppressWarnings("unchecked")
		public ReplacerContext mergeWith(ReplacerContext other) {
			if (replacer instanceof Mergeable) {
				int newOffset = Math.min(getOffset(), other.getOffset());
				int newLength = Math.max(getEndOffset(), other.getEndOffset()) - newOffset;
				ITextReplacer merged = ((Mergeable<ITextReplacer>) replacer).mergeWith(other.replacer);
				if (merged != null)
					return document.createReplacerContext(newOffset, newLength, merged);
			}
			return null;
		}

		public void replaceText(CharSequence text) {
			replaceText(getOffset(), getLength(), text);
		}

		public void replaceText(int offset, int lenght, CharSequence text) {
			Preconditions.checkNotNull(text);
			TextReplacement replacement = document.createReplacement(offset, lenght, text.toString());
			replaceText(replacement);
		}

		public void replaceText(ITextSegment region, CharSequence text) {
			replaceText(region.getOffset(), region.getLength(), text);
		}

		public void replaceText(ITextReplacement replacement) {
			replacements.add(replacement);
		}

		@Override
		public String toString() {
			//			ToStringHelper helper = Objects.toStringHelper(this);
			//			return helper.add("offset", offset).add("length", length).add("replacer", replacer).toString();
			return replacer.toString();
		}
	}

	protected static class ReplacerFlow implements ITextReplacer.Flow {

		private final int indentation;

		protected ReplacerFlow() {
			this(0);
		}

		protected ReplacerFlow(int indentation) {
			super();
			this.indentation = indentation;
		}

		public int getIndentation() {
			return indentation;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(ITextReplacer.Flow.class).add("indentation", indentation).toString();
		}

		public Flow withIndentation(int indentation) {
			return new ReplacerFlow(indentation);
		}
	}

	public static class RootDocument extends FormattableDocument {

		//		private final int initialIndentation;

		private final ITextReplacer.Factory<IHiddenRegionFormatting> replacerFactory;

		private final IFormatterRequest request;

		public RootDocument(IFormatterRequest request, int initialIndentation,
				ITextReplacer.Factory<IHiddenRegionFormatting> factory) {
			super(request);
			this.request = request;
			//			this.initialIndentation = initialIndentation;
			this.replacerFactory = factory;
		}

		public int getLength() {
			ITextSegment tokens = (ITextSegment) request.getTokens();
			return tokens.getLength();
		}

		public int getOffset() {
			return 0;
		}

		public ITextReplacer.Factory<IHiddenRegionFormatting> getReplacerFactory() {
			return replacerFactory;
		}

		@Override
		public IFormatterRequest getRequest() {
			return request;
		}

		@Override
		protected RootDocument getRoot() {
			return this;
		}
	}

	protected static class SubDocument extends FormattableDocument implements IFormattableSubDocument, ITextReplacer {

		private final int length;
		private final int offset;
		private final FormattableDocument parent;

		public SubDocument(int offset, int length, FormattableDocument parent) {
			super(parent.getRequest());
			this.offset = offset;
			this.length = length;
			this.parent = parent;
		}

		public Flow createReplacements(ITextReplacerContext context) {
			List<ITextReplacement> replacements = renderToTextReplacements(context);
			for (ITextReplacement replacment : replacements)
				context.replaceText(replacment);
			return context.getFlow();
		}

		public int getLength() {
			return length;
		}

		public int getOffset() {
			return offset;
		}

		@Override
		protected RootDocument getRoot() {
			return parent.getRoot();
		}

		public IFormattableSubDocument requireFitsInLine() {
			return requireFitsInLine(offset, length);
		}

		public IFormattableSubDocument requireFitsInLine(int offset, int length) {
			Integer maxLineWidth = getRequest().getPreferences().getPreference(FormatterPreferenceKeys.maxLineWidth);
			return requireFitsInLine(offset, length, maxLineWidth);
		}

		public IFormattableSubDocument requireFitsInLine(int offset, int length, int maxLineWidth) {
			MaxLineWidthDocument document = new MaxLineWidthDocument(offset, length, this, maxLineWidth);
			setReplacer(offset, length, document);
			return document;
		}

	}

	protected static class TextReplacement extends AbstractTextSegment implements ITextReplacement {
		private final int length;
		private final int offset;
		private final String replacement;
		private final ITextRegionAccess tokens;

		public TextReplacement(ITextRegionAccess tokens, int offset, int length, String text) {
			super();
			this.tokens = tokens;
			this.offset = offset;
			this.length = length;
			this.replacement = text;
		}

		public int getLength() {
			return length;
		}

		public int getOffset() {
			return offset;
		}

		public String getReplacementText() {
			return replacement;
		}

		public ITextRegionAccess getTextRegionAccess() {
			return tokens;
		}

		@Override
		public String toString() {
			return "[" + getText() + "|" + getReplacementText() + "]";
		}

	}

	@SuppressWarnings("serial")
	protected static class TextReplacementList extends ArrayList<ITextReplacement> {

		public TextReplacementList() {
			super();
		}

		public TextReplacementList(Collection<? extends ITextReplacement> initial) {
			super(initial);
		}

		@Override
		public String toString() {
			return new RegionsToString<ITextReplacement>().apply(this);
		}
	}

	private final TextSegmentSet<ReplacerContext> replacers;

	protected FormattableDocument(IFormatterRequest request) {
		super();
		this.replacers = createRegionSet1(this, request.getProblemHandler());
	}

	public ISemanticRegion append(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> after) {
		if (token != null) {
			IHiddenRegion gap = token.getTrailingGap();
			set(gap, after);
		}
		return token;
	}

	public <T extends EObject> T append(T owner, Procedure1<IHiddenRegionFormatting> after) {
		if (owner != null) {
			IHiddenRegion gap = getTextRegionAccess().trailingGap(owner);
			set(gap, after);
		}
		return owner;
	}

	protected String applyTextReplacements(Iterable<ITextReplacement> replacements) {
		String input = getText();
		ArrayList<ITextReplacement> list = Lists.newArrayList(replacements);
		Collections.sort(list);
		int startOffset = getOffset();
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (ITextReplacement r : list) {
			int offset = r.getOffset() - startOffset;
			result.append(input.subSequence(lastOffset, offset));
			result.append(r.getReplacementText());
			lastOffset = offset + r.getLength();
		}
		result.append(input.subSequence(lastOffset, input.length()));
		return result.toString();
	}

	private IHiddenRegionFormatting createGapFormatting(IHiddenRegion gap) {
		return new HiddenRegionFormatting(this, gap);
	}

	protected TextSegmentSet<ReplacerContext> createRegionSet1(ITextSegment root, FormatterProblemReporter handler) {
		ITextSegmentMerger<ReplacerContext> merger = new TextReplacerMerger<ReplacerContext>();
		return new ArrayListTextSegmentSet<ReplacerContext>(root, merger, handler);
	}

	protected <T extends ITextSegment> TextSegmentSet<T> createRegionSet(ITextSegment root,
			FormatterProblemReporter handler) {
		return new ArrayListTextSegmentSet<T>(root, null, handler);
	}

	protected TextReplacement createReplacement(int offset, int lenght, String text) {
		return new TextReplacement(getTextRegionAccess(), offset, lenght, text);
	}

	protected ReplacerContext createReplacerContext(int newOffset, int newLength, ITextReplacer replacer) {
		return new ReplacerContext(this, newOffset, newLength, replacer);
	}

	protected ReplacerFlow createReplacerFlow() {
		return new ReplacerFlow(0);
	}

	public void formatConditionally(EObject owner, ISubFormatter... formatters) {
		ITextRegionAccess access = getTextRegionAccess();
		int offset = access.leadingGap(owner).getEndOffset();
		int length = access.trailingGap(owner).getOffset() - offset;
		formatConditionally(offset, length, formatters);
	}

	public void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException {
		ConditionalReplacer replacer = new ConditionalReplacer(this, offset, length, ImmutableList.copyOf(formatters));
		setReplacer(offset, length, replacer);
	}

	public IFormatterRequest getRequest() {
		return getRoot().getRequest();
	}

	protected abstract RootDocument getRoot();

	public ITextRegionAccess getTextRegionAccess() {
		return getRequest().getTokens();
	}

	protected boolean isInRequestedRange(ITextReplacement repl) {
		for (org.eclipse.xtext.util.ITextRegion region : getRequest().getRegions())
			if (region.getOffset() <= repl.getOffset() && region.getOffset() + region.getLength() > repl.getEndOffset())
				return true;
		return false;
	}

	public ISemanticRegion prepend(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> before) {
		if (token != null) {
			IHiddenRegion gap = token.getLeadingGap();
			set(gap, before);
		}
		return token;
	}

	public <T extends EObject> T prepend(T owner, Procedure1<IHiddenRegionFormatting> before) {
		if (owner != null) {
			IHiddenRegion gap = getTextRegionAccess().leadingGap(owner);
			set(gap, before);
		}
		return owner;
	}

	public List<ITextReplacement> renderToTextReplacements() {
		List<ITextReplacement> replacements = renderToTextReplacements(null);
		return replacements;
	}

	protected List<ITextReplacement> renderToTextReplacements(ITextReplacerContext context) {
		List<ITextReplacement> result = new TextReplacementList();
		List<ITextReplacement> leading;
		ITextReplacer.Flow flow;
		if (context == null) {
			leading = new TextReplacementList();
			flow = createReplacerFlow();
		} else {
			leading = new TextReplacementList(context.getLeadingReplacements());
			flow = context.getFlow();
		}
		for (ReplacerContext replacer : replacers) {
			replacer.flow = flow;
			replacer.leadingReplacements = leading;
			replacer.replacements = createRegionSet(replacer, getRequest().getProblemHandler());
			try {
				flow = replacer.replacer.createReplacements(replacer);
				for (ITextReplacement repl : replacer.replacements)
					if (isInRequestedRange(repl)) {
						result.add(repl);
						leading.add(repl);
					}
			} finally {
				replacer.flow = null;
				replacer.leadingReplacements = null;
				replacer.replacements = null;
			}
		}
		return result;
	}

	protected void set(IHiddenRegion gap, Procedure1<IHiddenRegionFormatting> init) {
		if (gap != null) {
			IHiddenRegionFormatting formatting = createGapFormatting(gap);
			init.apply(formatting);
			ITextReplacer replacer = getRoot().getReplacerFactory().create(formatting);
			setReplacer(gap.getOffset(), gap.getLength(), replacer);
		}
	}

	public void setReplacer(int offset, int length, ITextReplacer replacer) {
		ReplacerContext range = createReplacerContext(offset, length, replacer);
		replacers.add(range);
	}

	public ITextSegment setReplacer(ITextSegment region, ITextReplacer replacer) {
		if (region != null) {
			setReplacer(region.getOffset(), region.getLength(), replacer);
		}
		return region;
	}

	public ISemanticRegion surround(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> beforeAndAfter) {
		prepend(token, beforeAndAfter);
		append(token, beforeAndAfter);
		return token;
	}

	public <T extends EObject> T surround(T owner, Procedure1<IHiddenRegionFormatting> beforeAndAfter) {
		prepend(owner, beforeAndAfter);
		append(owner, beforeAndAfter);
		return owner;
	}

	@Override
	public String toString() {
		RegionsToString<ReplacerContext> toString = new RegionsToString<ReplacerContext>();
		toString.withRoot(this);
		toString.withRegionToString(new Function<ReplacerContext, String>() {
			public String apply(ReplacerContext input) {
				ITextReplacer replacer = input.getReplacer();
				if (replacer instanceof HiddenRegionReplacer) {
					String string = new HiddenRegionFormattingToString().apply(((HiddenRegionReplacer) replacer)
							.getFormatting());
					return "[" + input.getText() + "|" + string + "]";
				} else if (replacer instanceof ConditionalReplacer) {
					String string = ((ConditionalReplacer) replacer).subFormatters.size() + "";
					return "[" + input.getText() + "|ConditionalReplacer:" + string + "]";
				}
				return replacer.toString();
			}
		});
		return toString.apply(replacers);
	}

}
