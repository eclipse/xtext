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
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
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
			@SuppressWarnings("unchecked")
			RegionsOutsideFrameException exception = new RegionsOutsideFrameException(frameTitle, frameRegion,
					Tuples.create(replacerTitle, replacerRegion));
			getRequest().getExceptionHandler().accept(exception);
			return;
		}
		try {
			replacers.add(replacer, getFormatter().createTextReplacerMerger());
		} catch (ConflictingRegionsException e) {
			getRequest().getExceptionHandler().accept(e);
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
		toString.setTitle(getClass().getSimpleName() + " with ITextReplacers");
		for (ITextReplacer repl : replacers)
			toString.add(repl.getRegion(), repl.getClass().getSimpleName() + ": " + repl.toString());
		return toString.toString();
	}

	public IFormattableSubDocument withReplacerFilter(Predicate<ITextReplacer> filter) {
		return new FilteredSubDocument(getRegion(), this, filter);
	}

}
