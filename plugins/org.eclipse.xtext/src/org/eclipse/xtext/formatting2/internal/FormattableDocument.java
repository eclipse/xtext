/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.FormattingNotApplicableException;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class FormattableDocument implements IFormattableDocument {

	public static class FilteredSubDocument extends SubDocument {

		private final Predicate<ITextReplacer> filter;

		public FilteredSubDocument(ITextSegment region, IFormattableDocument parent, Predicate<ITextReplacer> filter) {
			super(region, parent);
			this.filter = filter;
		}

		@Override
		public void addReplacer(ITextReplacer replacer) {
			if (filter.apply(replacer))
				super.addReplacer(replacer);
		}

	}

	protected static class MaxLineWidthDocument extends SubDocument {
		private final int maxLineWidth;

		public MaxLineWidthDocument(ITextSegment region, FormattableDocument parent, int maxLineWidth) {
			super(region, parent);
			this.maxLineWidth = maxLineWidth;
		}

		@Override
		public void addReplacer(ITextReplacer replacer) {
			validate(replacer);
			super.addReplacer(replacer);
		}

		@Override
		public ITextReplacerContext createReplacements(ITextReplacerContext context) {
			ITextReplacerContext last = super.createReplacements(context);
			List<ITextReplacement> replacements = last.getReplacementsUntil(context);
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
			return last;
		}

		protected void validate(HiddenRegionReplacer replacer) throws FormattingNotApplicableException {
			IHiddenRegionFormatting formatting = replacer.getFormatting();
			Integer newLineMin = formatting.getNewLineMin();
			if (newLineMin != null && newLineMin > 0)
				throw new FormattingNotApplicableException();
		}

		protected void validate(ITextReplacer replacer) throws FormattingNotApplicableException {
			if (replacer instanceof HiddenRegionReplacer)
				validate((HiddenRegionReplacer) replacer);
		}
	}

	public static class RootDocument extends FormattableDocument {

		private final AbstractFormatter2 formatter;

		public RootDocument(AbstractFormatter2 formatter) {
			super();
			this.formatter = formatter;
		}

		public AbstractFormatter2 getFormatter() {
			return formatter;
		}

		public ITextSegment getRegion() {
			return (ITextSegment) formatter.getRequest().getTextRegionAccess();
		}

		public FormatterRequest getRequest() {
			return formatter.getRequest();
		}

	}

	public static class SubDocument extends FormattableDocument implements IFormattableSubDocument,
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

		public AbstractFormatter2 getFormatter() {
			return parent.getFormatter();
		}

		public ITextSegment getRegion() {
			return region;
		}

		public FormatterRequest getRequest() {
			return parent.getRequest();
		}

		public IFormattableSubDocument requireFitsInLine() {
			return requireFitsInLine(region.getOffset(), region.getLength());
		}

		public IFormattableSubDocument requireFitsInLine(int offset, int length) {
			Integer maxLineWidth = getRequest().getPreferences().getPreference(FormatterPreferenceKeys.maxLineWidth);
			return requireFitsInLine(offset, length, maxLineWidth);
		}

		public IFormattableSubDocument requireFitsInLine(int offset, int length, int maxLineWidth) {
			TextSegment segment = new TextSegment(getTextRegionAccess(), offset, length);
			MaxLineWidthDocument document = new MaxLineWidthDocument(segment, this, maxLineWidth);
			addReplacer(document);
			return document;
		}

	}

	private final TextSegmentSet<ITextReplacer> replacers;

	protected FormattableDocument() {
		super();
		this.replacers = createTextReplacerSet();
	}

	public void addReplacer(ITextReplacer replacer) {
		if (!this.getRegion().contains(replacer.getRegion())) {
			String frameTitle = getClass().getSimpleName();
			ITextSegment frameRegion = getRegion();
			String replacerTitle = replacer.getClass().getSimpleName();
			ITextSegment replacerRegion = replacer.getRegion();
			RegionsOutsideFrameException exception = new RegionsOutsideFrameException(frameTitle, frameRegion,
					Tuples.create(replacerTitle, replacerRegion));
			getRequest().getProblemHandler().accept(exception);
			return;
		}
		try {
			replacers.add(replacer, getFormatter().createTextReplacerMerger());
		} catch (ConflictingRegionsException e) {
			getRequest().getProblemHandler().accept(e);
		}
	}

	public ISemanticRegion append(ISemanticRegion token, Procedure1<IHiddenRegionFormatter> after) {
		if (token != null) {
			IHiddenRegion gap = token.getNextHiddenRegion();
			set(gap, after);
		}
		return token;
	}

	public <T extends EObject> T append(T owner, Procedure1<IHiddenRegionFormatter> after) {
		if (owner != null) {
			IHiddenRegion gap = getTextRegionAccess().trailingHiddenRegion(owner);
			set(gap, after);
		}
		return owner;
	}

	// TODO: use org.eclipse.xtext.formatting2.TextReplacements
	protected String applyTextReplacements(Iterable<ITextReplacement> replacements) {
		ITextSegment region = getRegion();
		String input = region.getText();
		ArrayList<ITextReplacement> list = Lists.newArrayList(replacements);
		Collections.sort(list);
		int startOffset = region.getOffset();
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

	protected ITextReplacerContext createReplacements(ITextReplacerContext previous) {
		Integer maxLineWidth = getRequest().getPreferences().getPreference(FormatterPreferenceKeys.maxLineWidth);
		ITextReplacerContext context = ((TextReplacerContext) previous).withDocument(this);
		ITextReplacerContext wrappable = null;
		Set<ITextReplacer> wrapped = Sets.newHashSet();
		LinkedList<ITextReplacer> queue = new LinkedList<ITextReplacer>();
		for (ITextReplacer replacer : replacers)
			queue.add(replacer);
		while (!queue.isEmpty()) {
			ITextReplacer replacer = queue.poll();
			context = context.withReplacer(replacer);
			if (wrappable != null && needsAutowrap(wrappable, context, maxLineWidth)) {
				// TODO: raise report if replacer claims it can do autowrap but then doesn't
				while (context != wrappable) {
					ITextReplacer r = context.getReplacer();
					if (r != null) {
						queue.addFirst(r);
					}
					context = context.getPreviousContext();
				}
				replacer = context.getReplacer();
				context.setAutowrap(true);
				wrappable = null;
			}
			ITextReplacerContext nextContext = replacer.createReplacements(context);
			Integer canAutowrap = context.canAutowrap();
			if (canAutowrap != null && canAutowrap >= 0 && !context.isAutowrap() && !wrapped.contains(replacer)) {
				boolean can = true;
				if (wrappable != null) {
					int lastEndOffset = wrappable.canAutowrap() + wrappable.getReplacer().getRegion().getEndOffset();
					int thisEndOffset = canAutowrap + context.getReplacer().getRegion().getEndOffset();
					can = lastEndOffset < thisEndOffset;
				}
				if (can) {
					wrappable = context;
					wrapped.add(replacer);
				}
			}
			context = nextContext;
		}
		return ((TextReplacerContext) context).withDocument(previous.getDocument());
	}

	protected TextSegmentSet<ITextReplacer> createTextReplacerSet() {
		return new ArrayListTextSegmentSet<ITextReplacer>(ITextReplacer.GET_REGION,
				new Function<ITextReplacer, String>() {
					public String apply(ITextReplacer input) {
						return input.getClass().getSimpleName();
					}
				});
	}

	public void formatConditionally(EObject owner, ISubFormatter... formatters) {
		ITextRegionAccess access = getTextRegionAccess();
		int offset = access.leadingHiddenRegion(owner).getEndOffset();
		int length = access.trailingHiddenRegion(owner).getOffset() - offset;
		formatConditionally(offset, length, formatters);
	}

	public void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException {
		ConditionalReplacer replacer = new ConditionalReplacer(this, offset, length, ImmutableList.copyOf(formatters));
		addReplacer(replacer);
	}

	public ITypedPreferenceValues getPreferences() {
		return getFormatter().getPreferences();
	}

	public ITextRegionAccess getTextRegionAccess() {
		return getRequest().getTextRegionAccess();
	}

	public Throwable getTrace(ITextReplacer replacer) {
		return replacers.getTraces().get(replacer);
	}

	protected boolean needsAutowrap(ITextReplacerContext wrappable, ITextReplacerContext context, int maxLineWidth) {
		if (context.getLeadingCharsInLineCount() > maxLineWidth)
			return true;
		int offset = wrappable.getReplacer().getRegion().getOffset();
		int length = context.getReplacer().getRegion().getEndOffset() - offset;
		if (length > wrappable.canAutowrap())
			return false;
		//		for (ITextReplacement rep : context.getReplacementsUntil(wrappable))
		//			if (rep.getReplacementText().contains("\n"))
		//				return true;
		//		TextSegment region = new TextSegment(getTextRegionAccess(), offset, length);
		//		String text = TextReplacements.apply(region, );
		//		if (text.contains("\n"))
		//			return true;
		return false;
	}

	public ISemanticRegion prepend(ISemanticRegion token, Procedure1<IHiddenRegionFormatter> before) {
		if (token != null) {
			IHiddenRegion gap = token.getPreviousHiddenRegion();
			set(gap, before);
		}
		return token;
	}

	public <T extends EObject> T prepend(T owner, Procedure1<IHiddenRegionFormatter> before) {
		if (owner != null) {
			IHiddenRegion gap = getTextRegionAccess().leadingHiddenRegion(owner);
			set(gap, before);
		}
		return owner;
	}

	public List<ITextReplacement> renderToTextReplacements() {
		ITextReplacerContext first = getFormatter().createTextReplacerContext(this);
		ITextReplacerContext last = createReplacements(first);
		List<ITextReplacement> replacements = last.getReplacementsUntil(first);
		return replacements;
	}

	public IHiddenRegion set(IHiddenRegion hiddenRegion, Procedure1<IHiddenRegionFormatter> init) {
		if (hiddenRegion != null) {
			AbstractFormatter2 formatter = getFormatter();
			IHiddenRegionFormatting formatting = formatter.createHiddenRegionFormatting();
			init.apply((IHiddenRegionFormatter) formatting);
			ITextReplacer replacer = formatter.createHiddenRegionReplacer(hiddenRegion, formatting);
			addReplacer(replacer);
		}
		return hiddenRegion;
	}

	public ISemanticRegion surround(ISemanticRegion token, Procedure1<IHiddenRegionFormatter> beforeAndAfter) {
		prepend(token, beforeAndAfter);
		append(token, beforeAndAfter);
		return token;
	}

	public <T extends EObject> T surround(T owner, Procedure1<IHiddenRegionFormatter> beforeAndAfter) {
		prepend(owner, beforeAndAfter);
		append(owner, beforeAndAfter);
		return owner;
	}

	@Override
	public String toString() {
		TextRegionsToString toString = new TextRegionsToString();
		toString.setFrame(this.getRegion());
		for (ITextReplacer repl : replacers)
			toString.add(repl.getRegion(), repl.toString());
		return toString.toString();
	}

	public IFormattableSubDocument withReplacerFilter(Predicate<ITextReplacer> filter) {
		return new FilteredSubDocument(getRegion(), this, filter);
	}

}
