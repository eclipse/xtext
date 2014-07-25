/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
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
	 * This method is when we have multiple TextReplacers for this HiddenRegion because the HiddenRegion contains
	 * comments. It applies the formatting configuration from {@link #formatting} to the {@link WhitespaceReplacer} that
	 * surround the comment.
	 */
	protected void applyHiddenRegionFormatting(List<ITextReplacer> replacers) {
		IHiddenRegionFormatting separator = findWhitespaceThatSeparatesSemanticRegions(replacers).getFormatting();

		// 1. apply indentation 
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

		// 2. apply NewLine and space configuration to the first whitespace region that follows or contains a linewrap.  
		separator.setNewLinesDefault(formatting.getNewLineDefault());
		separator.setNewLinesMax(formatting.getNewLineMax());
		separator.setNewLinesMin(formatting.getNewLineMin());
		separator.setSpace(formatting.getSpace());

		// 3. apply the 'priority' configuration for all and set a default formatting
		for (ITextReplacer replacer : replacers)
			if (replacer instanceof WhitespaceReplacer) {
				IHiddenRegionFormatting formatting2 = ((WhitespaceReplacer) replacer).getFormatting();
				formatting2.setPriority(formatting.getPriority());
				if (formatting2 != separator) {
					formatting2.setSpace(replacer.getRegion().getOffset() > 0 ? " " : "");
					formatting2.setNewLinesMin(0);
					formatting2.setNewLinesMax(1);
				}
			}

		// 4. make sure whitespace before and after multiline comments introduce a NewLine 
		for (int i = 0; i < replacers.size(); i++) {
			ITextReplacer replacer = replacers.get(i);
			if (replacer instanceof CommentReplacer) {
				if (replacer.getRegion().getText().trim().contains("\n")) {
					enforceNewLine((WhitespaceReplacer) replacers.get(i - 1));
					enforceNewLine((WhitespaceReplacer) replacers.get(i + 1));
				} else if (!replacer.getRegion().isMultiline()) {
					enforceSingleSpace((WhitespaceReplacer) replacers.get(i - 1));
					enforceSingleSpace((WhitespaceReplacer) replacers.get(i + 1));
				}
			}
		}
	}

	protected void enforceSingleSpace(WhitespaceReplacer replacer) {
		if (replacer.getRegion().getOffset() <= 0)
			return;
		IHiddenRegionFormatting fmt = replacer.getFormatting();
		String space = fmt.getSpace();
		if (space == null || space.length() < 1)
			fmt.setSpace(" ");
	}

	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		AbstractFormatter2 formatter = context.getFormatter();
		List<IHiddenRegionPart> hiddens = region.getParts();
		if (region.isUndefined() || hiddens.isEmpty()) {
			return formatter.createWhitespaceReplacer(region, formatting).createReplacements(context);
		} else if ((hiddens.size() == 1 && hiddens.get(0) instanceof IWhitespace)) {
			return formatter.createWhitespaceReplacer(hiddens.get(0), formatting).createReplacements(context);
		} else {
			List<ITextReplacer> replacers = createReplacers(formatter, hiddens);
			applyHiddenRegionFormatting(replacers);
			ITextReplacerContext current = context;
			current.setNextReplacerIsChild();
			for (ITextReplacer replacer : replacers)
				current = replacer.createReplacements(current.withReplacer(replacer));
			return current;
		}
	}

	/**
	 * returns a list that starts with whitespace, ends with whitespace and contains a sequence of strictly alternating
	 * whitespace- and comment-regions.
	 */
	protected List<ITextReplacer> createReplacers(AbstractFormatter2 formatter, List<IHiddenRegionPart> parts) {
		ITextSegment last = null;
		List<ITextReplacer> result = Lists.newArrayList();
		for (IHiddenRegionPart part : parts) {
			if (part instanceof IWhitespace) {
				if (last == null || last instanceof IComment) {
					result.add(formatter.createWhitespaceReplacer(part, formatter.createHiddenRegionFormatting()));
				} else {
					int mergedLength = last.getLength() + part.getLength();
					TextSegment merged = new TextSegment(part.getTextRegionAccess(), last.getOffset(), mergedLength);
					IHiddenRegionFormatting formatting2 = formatter.createHiddenRegionFormatting();
					result.set(result.size() - 1, formatter.createWhitespaceReplacer(merged, formatting2));
				}
			}
			if (part instanceof IComment) {
				if (last == null || last instanceof IComment) {
					TextSegment region = new TextSegment(part.getTextRegionAccess(), part.getOffset(), 0);
					result.add(formatter.createWhitespaceReplacer(region, formatter.createHiddenRegionFormatting()));
				}
				result.add(formatter.createCommentReplacer((IComment) part));
			}
			last = part;
		}
		if (last instanceof IComment) {
			TextSegment region = new TextSegment(last.getTextRegionAccess(), last.getOffset() + last.getLength(), 0);
			result.add(formatter.createWhitespaceReplacer(region, formatter.createHiddenRegionFormatting()));
		}
		return result;
	}

	protected void enforceNewLine(WhitespaceReplacer replacer) {
		if (replacer.getRegion().getOffset() <= 0)
			return;
		IHiddenRegionFormatting fmt = replacer.getFormatting();
		Integer min = fmt.getNewLineMin();
		if (min == null || min < 1)
			fmt.setNewLinesMin(1);
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

	public IHiddenRegion getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}
}
