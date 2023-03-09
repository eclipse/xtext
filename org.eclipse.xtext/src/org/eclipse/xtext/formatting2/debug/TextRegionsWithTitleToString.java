/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import static org.eclipse.xtext.formatting2.regionaccess.internal.TextRegions.*;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionsWithTitleToString {

	public static class Item {
		private final ITextSegment region;
		private final String title;

		public Item(String title, ITextSegment region) {
			super();
			this.title = title;
			this.region = region;
		}

		public ITextSegment getRegion() {
			return region;
		}

		public String getTitle() {
			return title;
		}
	}

	private ITextSegment frame;
	private List<Item> items = Lists.newArrayList();
	private int leadingLines = 4;
	private ITextRegionAccess textRegionAccess;
	private int trailingLines = 4;

	public TextRegionsWithTitleToString add(String title, ITextSegment region) {
		items.add(new Item(title, region));
		return this;
	}

	protected String box(String title, String content) {
		final int width = 80;
		final int min = 3;
		int titleLength = title.length() + 2;
		final int left = Math.max((width - titleLength) / 2, min);
		StringBuilder result = new StringBuilder();
		result.append(Strings.repeat("-", left));
		result.append(" ");
		result.append(title);
		result.append(" ");
		if (left > min)
			result.append(Strings.repeat("-", width - left - titleLength));
		result.append("\n");
		result.append(org.eclipse.xtext.util.Strings.trimTrailingLineBreak(content));
		result.append("\n");
		result.append(Strings.repeat("-", width));
		return result.toString();
	}

	public ITextSegment getFrame() {
		if (this.frame != null)
			return this.frame;
		ITextRegionAccess access = getTextRegionAccess();
		if (access != null) {
			List<ITextSegment> segments = Lists.newArrayList();
			for (Item item : items)
				segments.add(item.getRegion());
			ITextSegment impactRegion = merge(segments);
			List<ILineRegion> expandToLines = expandToLines(impactRegion, getLeadingLines(), getTrailingLines());
			return merge(expandToLines);
		}
		return null;
	}

	public List<Item> getItems() {
		return items;
	}

	public int getLeadingLines() {
		return leadingLines;
	}

	public ITextRegionAccess getTextRegionAccess() {
		if (this.textRegionAccess != null)
			return this.textRegionAccess;
		for (Item item : this.items)
			return item.region.getTextRegionAccess();
		return null;
	}

	public int getTrailingLines() {
		return trailingLines;
	}

	public TextRegionsWithTitleToString setFrame(ITextSegment frame) {
		this.frame = frame;
		return this;
	}

	public TextRegionsWithTitleToString setLeadingLines(int leadingLines) {
		this.leadingLines = leadingLines;
		return this;
	}

	public TextRegionsWithTitleToString setTextRegionAccess(ITextRegionAccess textRegionAccess) {
		this.textRegionAccess = textRegionAccess;
		return this;
	}

	public TextRegionsWithTitleToString setTrailingLines(int trailingLines) {
		this.trailingLines = trailingLines;
		return this;
	}

	private final String[] BRACKETS_OPEN = { "{{{", "[[[", "(((", "<<<" };
	private final String[] BRACKETS_CLOSE = { "}}}", "]]]", ")))", ">>>" };

	@Override
	public String toString() {
		ITextRegionAccess access = getTextRegionAccess();
		ITextSegment frame = getFrame();
		if (access == null || frame == null)
			return "(null)";
		ITextRegionRewriter rewriter = access.getRewriter();
		StringBuilder builder = new StringBuilder();
		List<ITextReplacement> replacements = Lists.newArrayList();
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			ITextSegment region = item.getRegion();
			String regionStr = "offset=" + region.getOffset() + " length=" + region.getLength();
			String open = i < BRACKETS_OPEN.length ? BRACKETS_OPEN[i] : "[" + i + "[";
			String close = i < BRACKETS_CLOSE.length ? BRACKETS_CLOSE[i] : "]" + i + "]";
			builder.append(open + close + ": " + item.getTitle() + " at " + regionStr + "\n");
			replacements.add(rewriter.createReplacement(region.getOffset(), 0, open));
			replacements.add(rewriter.createReplacement(region.getEndOffset(), 0, close));
		}
		String vizualized = rewriter.renderToString(frame, replacements);
		builder.append(box("document snippet", vizualized));
		return builder.toString();
	}
}
