/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Pair;
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

	private TextSegmentSet<ITextReplacer> replacers = null;

	protected FormattableDocument() {
		super();
	}

	protected TextSegmentSet<ITextReplacer> getReplacers() {
		if (replacers == null)
			replacers = createTextReplacerSet();
		return replacers;
	}

	@Override
	public void addReplacer(ITextReplacer replacer) {
		if (!this.getRegion().contains(replacer.getRegion())) {
			String frameTitle = getClass().getSimpleName();
			ITextSegment frameRegion = getRegion();
			String replacerTitle = replacer.getClass().getSimpleName();
			ITextSegment replacerRegion = replacer.getRegion();
			RegionsOutsideFrameException exception = new RegionsOutsideFrameException(frameTitle, frameRegion,
					Tuples.create(replacerTitle, replacerRegion));
			getRequest().getExceptionHandler().accept(exception);
			return;
		}
		try {
			getReplacers().add(replacer, getFormatter().createTextReplacerMerger());
		} catch (ConflictingRegionsException e) {
			getRequest().getExceptionHandler().accept(e);
		}
	}

	@Override
	public ISemanticRegion append(ISemanticRegion token, Procedure1<? super IHiddenRegionFormatter> after) {
		if (token != null) {
			IHiddenRegion gap = token.getNextHiddenRegion();
			set(gap, after);
		}
		return token;
	}

	@Override
	public <T extends EObject> T append(T owner, Procedure1<? super IHiddenRegionFormatter> after) {
		if (owner != null) {
			IEObjectRegion region = getTextRegionAccess().regionForEObject(owner);
			if (region != null) {
				IHiddenRegion gap = region.getNextHiddenRegion();
				set(gap, after);
			}
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
		ITextReplacerContext context = previous.withDocument(this);
		ITextReplacerContext wrappable = null;
		Set<ITextReplacer> wrapped = Sets.newHashSet();
		Iterator<ITextReplacer> replacers = getReplacers().iterator();
		while (replacers.hasNext()) {
			ITextReplacer replacer = replacers.next();
			context = context.withReplacer(replacer);
			if (wrappable != null && context.isWrapSincePrevious()) {
				wrappable = null;
			}
			if (wrappable != null && needsAutowrap(wrappable, context, maxLineWidth)) {
				// TODO: raise report if replacer claims it can do autowrap but
				// then doesn't
				while (context != wrappable) {
					context = context.getPreviousContext();
				}
				replacer = context.getReplacer();
				replacers = getReplacers().iteratorAfter(replacer);
				context.setAutowrap(true);
				wrappable = null;
			}
			ITextReplacerContext nextContext = replacer.createReplacements(context);
			if (wrappable != null && context.isWrapInRegion()) {
				wrappable = null;
			} else {
				Integer canAutowrap = context.canAutowrap();
				if (canAutowrap != null && canAutowrap >= 0 && !context.isAutowrap() && !wrapped.contains(replacer)) {
					boolean can = true;
					if (wrappable != null) {
						int lastEndOffset = wrappable.canAutowrap()
								+ wrappable.getReplacer().getRegion().getEndOffset();
						int thisEndOffset = canAutowrap + context.getReplacer().getRegion().getEndOffset();
						can = lastEndOffset < thisEndOffset;
					}
					if (can) {
						wrappable = context;
						wrapped.add(replacer);
					}
				}
			}
			context = nextContext;
		}
		return context.withDocument(previous.getDocument());
	}

	protected TextSegmentSet<ITextReplacer> createTextReplacerSet() {
		return new ArrayListTextSegmentSet<ITextReplacer>(ITextReplacer.GET_REGION,
				new Function<ITextReplacer, String>() {
					@Override
					public String apply(ITextReplacer input) {
						if (input instanceof HiddenRegionReplacer)
							return new HiddenRegionFormattingToString()
									.apply(((HiddenRegionReplacer) input).getFormatting());
						return input.getClass().getSimpleName();
					}
				}, getRequest().isEnableDebugTracing());
	}

	@Override
	public <T> T format(T obj) {
		AbstractFormatter2 formatter = getFormatter();
		if (formatter.shouldFormat(obj, this)) {
			try {
				formatter.format(obj, this);
			} catch (RegionTraceMissingException e) {
				throw e;
			} catch (Exception e) {
				IAcceptor<Exception> handler = getRequest().getExceptionHandler();
				handler.accept(e);
			}
		}
		return obj;
	}

	@Override
	public void formatConditionally(EObject owner, ISubFormatter... formatters) {
		IEObjectRegion region = getTextRegionAccess().regionForEObject(owner);
		if (region != null)
			formatConditionally(region.getOffset(), region.getLength(), formatters);
	}

	@Override
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

	@Override
	public <T1 extends ISemanticRegion, T2 extends ISemanticRegion> //
	Pair<T1, T2> interior(Pair<T1, T2> pair, Procedure1<? super IHiddenRegionFormatter> init) {
		return interior(pair.getKey(), pair.getValue(), init);
	}

	@Override
	public <T extends EObject> T interior(T object, Procedure1<? super IHiddenRegionFormatter> init) {
		if (object != null) {
			IEObjectRegion objRegion = getTextRegionAccess().regionForEObject(object);
			if (objRegion != null) {
				IHiddenRegion previous = objRegion.getPreviousHiddenRegion();
				IHiddenRegion next = objRegion.getNextHiddenRegion();
				if (previous != null && next != null && previous != next) {
					interior(previous.getNextSemanticRegion(), next.getPreviousSemanticRegion(), init);
				}
			}
		}
		return object;
	}

	@Override
	public <T1 extends ISemanticRegion, T2 extends ISemanticRegion> //
	Pair<T1, T2> interior(T1 first, T2 second, Procedure1<? super IHiddenRegionFormatter> init) {
		if (first != null && second != null) {
			set(first.getNextHiddenRegion(), second.getPreviousHiddenRegion(), init);
		}
		return Pair.of(first, second);
	}

	protected boolean needsAutowrap(ITextReplacerContext wrappable, ITextReplacerContext context, int maxLineWidth) {
		if (context.getLeadingCharsInLineCount() > maxLineWidth)
			return true;
		int offset = wrappable.getReplacer().getRegion().getOffset();
		int length = context.getReplacer().getRegion().getEndOffset() - offset;
		if (length > wrappable.canAutowrap())
			return false;
		// for (ITextReplacement rep : context.getReplacementsUntil(wrappable))
		// if (rep.getReplacementText().contains("\n"))
		// return true;
		// TextSegment region = new TextSegment(getTextRegionAccess(), offset,
		// length);
		// String text = TextReplacements.apply(region, );
		// if (text.contains("\n"))
		// return true;
		return false;
	}

	@Override
	public ISemanticRegion prepend(ISemanticRegion token, Procedure1<? super IHiddenRegionFormatter> before) {
		if (token != null) {
			IHiddenRegion gap = token.getPreviousHiddenRegion();
			set(gap, before);
		}
		return token;
	}

	@Override
	public <T extends EObject> T prepend(T owner, Procedure1<? super IHiddenRegionFormatter> before) {
		if (owner != null) {
			IEObjectRegion region = getTextRegionAccess().regionForEObject(owner);
			if (region != null) {
				IHiddenRegion gap = region.getPreviousHiddenRegion();
				set(gap, before);
			}
		}
		return owner;
	}

	@Override
	public List<ITextReplacement> renderToTextReplacements() {
		ITextReplacerContext first = getFormatter().createTextReplacerContext(this);
		ITextReplacerContext last = createReplacements(first);
		List<ITextReplacement> replacements = last.getReplacementsUntil(first);
		return replacements;
	}

	@Override
	public Pair<IHiddenRegion, IHiddenRegion> set(IHiddenRegion first, IHiddenRegion second,
			Procedure1<? super IHiddenRegionFormatter> init) {
		if (first != null && second != null) {
			AbstractFormatter2 formatter = getFormatter();
			IHiddenRegionFormatting f1 = formatter.createHiddenRegionFormatting();
			IHiddenRegionFormatting f2 = formatter.createHiddenRegionFormatting();
			init.apply(formatter.createHiddenRegionFormatter(f1, f2));
			ITextReplacer replacer1 = formatter.createHiddenRegionReplacer(first, f1);
			ITextReplacer replacer2 = formatter.createHiddenRegionReplacer(second, f2);
			addReplacer(replacer1);
			addReplacer(replacer2);
		}
		return Pair.of(first, second);
	}

	@Override
	public IHiddenRegion set(IHiddenRegion hiddenRegion, Procedure1<? super IHiddenRegionFormatter> init) {
		if (hiddenRegion != null) {
			AbstractFormatter2 formatter = getFormatter();
			IHiddenRegionFormatting formatting = formatter.createHiddenRegionFormatting();
			init.apply(formatter.createHiddenRegionFormatter(formatting));
			ITextReplacer replacer = formatter.createHiddenRegionReplacer(hiddenRegion, formatting);
			addReplacer(replacer);
		}
		return hiddenRegion;
	}

	@Override
	public ISemanticRegion surround(ISemanticRegion token, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter) {
		if (token != null) {
			IHiddenRegion previous = token.getPreviousHiddenRegion();
			IHiddenRegion next = token.getNextHiddenRegion();
			set(previous, next, beforeAndAfter);
		}
		return token;
	}

	@Override
	public <T extends EObject> T surround(T owner, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter) {
		if (owner != null && !owner.eIsProxy()) {
			IEObjectRegion region = getTextRegionAccess().regionForEObject(owner);
			if (region == null)
				return owner;
			IHiddenRegion previous = region.getPreviousHiddenRegion();
			IHiddenRegion next = region.getNextHiddenRegion();
			set(previous, next, beforeAndAfter);
		}
		return owner;
	}

	@Override
	public String toString() {
		TextRegionsToString toString = new TextRegionsToString();
		toString.setFrame(this.getRegion());
		toString.setTitle(getClass().getSimpleName() + " with ITextReplacers");
		for (ITextReplacer repl : getReplacers())
			toString.add(repl.getRegion(), repl.getClass().getSimpleName() + ": " + repl.toString());
		return toString.toString();
	}

	@Override
	public IFormattableSubDocument withReplacerFilter(Predicate<? super ITextReplacer> filter) {
		return new FilteredSubDocument(getRegion(), this, filter);
	}
}
