/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionReplacer implements ITextReplacer {

	private final IHiddenRegionFormatting formatting;
	private final IHiddenRegion region;

	public HiddenRegionReplacer(IHiddenRegion region, IHiddenRegionFormatting formatting) {
		super();
		this.region = region;
		this.formatting = formatting;
	}

	/**
	 * This method is called when we have multiple TextReplacers for this HiddenRegion because the HiddenRegion contains
	 * comments. It applies the formatting configuration from {@link #formatting} to the {@link WhitespaceReplacer} that
	 * surrounds the comment.
	 */
	protected void applyHiddenRegionFormatting(List<ITextReplacer> replacers) {
		IHiddenRegionFormatting separator = findWhitespaceThatSeparatesSemanticRegions(replacers).getFormatting();

		applyIndentation(replacers, separator);

		applySeparatorConfiguration(separator);

		applyPriorityAndDefaultFormatting(replacers, separator);

		introduceNewlinesAroundMLComments(replacers);
	}

	/**
	 * @since 2.23
	 */
	protected void applyIndentation(List<ITextReplacer> replacers, IHiddenRegionFormatting separator) {
		Integer inc = formatting.getIndentationIncrease();
		Integer dec = formatting.getIndentationDecrease();
		if (inc != null && dec != null) {
			((WhitespaceReplacer) replacers.get(0)).getFormatting().setIndentationIncrease(inc);
			((WhitespaceReplacer) replacers.get(replacers.size() - 1)).getFormatting().setIndentationDecrease(dec);
		} else if (inc != null) {
			separator.setIndentationIncrease(inc);
		} else if (dec != null) {
			separator.setIndentationDecrease(dec);
		}
	}

	/**
	 * Apply newline and space configuration to the first whitespace region that follows or contains a linewrap.
	 * @since 2.23
	 */
	protected void applySeparatorConfiguration(IHiddenRegionFormatting separator) {
		separator.setNewLinesDefault(formatting.getNewLineDefault());
		separator.setNewLinesMax(formatting.getNewLineMax());
		separator.setNewLinesMin(formatting.getNewLineMin());
		separator.setSpace(formatting.getSpace());
	}

	/**
	 * @since 2.23
	 */
	protected void applyPriorityAndDefaultFormatting(List<ITextReplacer> replacers, IHiddenRegionFormatting separator) {
		for (int i = 0; i < replacers.size(); i++) {
			ITextReplacer replacer = replacers.get(i);
			if (replacer instanceof WhitespaceReplacer) {
				IHiddenRegionFormatting formatting2 = ((WhitespaceReplacer) replacer).getFormatting();
				formatting2.setPriority(formatting.getPriority());
				if (formatting2 != separator) {
					ITextReplacer previous = (i == 0) ? null : replacers.get(i - 1);
					ITextReplacer next = (i + 1 >= replacers.size()) ? null : replacers.get(i + 1);
					// Don't add single spaces after comments
					if (previous == null || !(previous instanceof CommentReplacer)) {
						// Don't add spaces before ML comments because in the next step
						// a newline will be added in front of ML comments.
						// You don't want to end up with a ML comment on a newline that
						// starts with a space
						if (next == null || !(next instanceof MultilineCommentReplacer)) {
							formatting2.setSpace(replacer.getRegion().getOffset() > 0 ? " " : "");
						}
					}
					formatting2.setNewLinesMin(0);
					formatting2.setNewLinesMax(1);
				}
			}
		}
	}

	/**
	 * @since 2.23
	 */
	protected void introduceNewlinesAroundMLComments(List<ITextReplacer> replacers) {
		for (int i = 0; i < replacers.size(); i++) {
			ITextReplacer replacer = replacers.get(i);
			if (replacer instanceof CommentReplacer) {
				CommentReplacer commentReplacer = ((CommentReplacer) replacer);
				WhitespaceReplacer leading = (WhitespaceReplacer) replacers.get(i - 1);
				WhitespaceReplacer trailing = (WhitespaceReplacer) replacers.get(i + 1);
				commentReplacer.configureWhitespace(leading, trailing);
			}
		}
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		AbstractFormatter2 formatter = context.getFormatter();
		List<IHiddenRegionPart> hiddens = region.getParts();
		if (hiddens.isEmpty()) {
			return formatter.createWhitespaceReplacer(region, formatting).createReplacements(context);
		} else if ((hiddens.size() == 1 && hiddens.get(0) instanceof IWhitespace)) {
			return formatter.createWhitespaceReplacer(hiddens.get(0), formatting).createReplacements(context);
		} else {
			List<ITextReplacer> replacers = createReplacers(formatter);
			applyHiddenRegionFormatting(replacers);
			ITextReplacerContext current = context;
			current.setNextReplacerIsChild();
			for (ITextReplacer replacer : replacers)
				current = replacer.createReplacements(current.withReplacer(replacer));
			return current;
		}
	}

	protected List<ITextReplacer> createReplacers(AbstractFormatter2 formatter) {
		List<ITextSegment> regions = region.getAlternatingMergedSpaceAndComments();
		List<ITextReplacer> replacers = Lists.newArrayListWithCapacity(regions.size());
		for (ITextSegment region : regions) {
			if (region instanceof IComment)
				replacers.add(formatter.createCommentReplacer((IComment) region));
			else
				replacers.add(formatter.createWhitespaceReplacer(region, formatter.createHiddenRegionFormatting()));
		}
		return replacers;
	}

	protected WhitespaceReplacer findWhitespaceThatSeparatesSemanticRegions(List<ITextReplacer> replacers) {
		boolean hasSeenWrap = false;
		for (ITextReplacer replacer : replacers) {
			if (replacer instanceof WhitespaceReplacer) {
				WhitespaceReplacer whitespaceReplacer = (WhitespaceReplacer) replacer;
				hasSeenWrap |= whitespaceReplacer.getRegion().isMultiline();
				if (hasSeenWrap)
					return whitespaceReplacer;
			}
		}
		return (WhitespaceReplacer) replacers.get(replacers.size() - 1);
	}

	public IHiddenRegionFormatting getFormatting() {
		return formatting;
	}

	@Override
	public IHiddenRegion getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}
}
