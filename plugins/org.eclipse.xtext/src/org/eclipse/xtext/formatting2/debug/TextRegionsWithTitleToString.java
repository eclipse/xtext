/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import java.util.List;

import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.TextReplacements;
import org.eclipse.xtext.formatting2.internal.TextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

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
		int titleLenght = title.length() + 2;
		final int left = Math.max((width - titleLenght) / 2, min);
		StringBuilder result = new StringBuilder();
		result.append(Strings.repeat("-", left));
		result.append(" ");
		result.append(title);
		result.append(" ");
		if (left > min)
			result.append(Strings.repeat("-", width - left - titleLenght));
		result.append("\n");
		result.append(org.eclipse.xtext.util.Strings.trimTrailingLineBreak(content));
		result.append("\n");
		result.append(Strings.repeat("-", width));
		return result.toString();
	}

	public ITextSegment getFrame() {
		if (this.frame != null)
			return this.frame;
		List<ITextSegment> segments = Lists.newArrayList();
		for (Item item : items)
			segments.add(item.getRegion());
		ITextSegment[] array = segments.toArray(new ITextSegment[segments.size()]);
		ITextRegionAccess regionAccess = getTextRegionAccess();
		if (regionAccess != null)
			return regionAccess.expandRegionsByLines(getLeadingLines(), getTrailingLines(), array);
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
		StringBuilder builder = new StringBuilder();
		List<ITextReplacement> replacements = Lists.newArrayList();
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			ITextSegment region = item.getRegion();
			String regionStr = "offset=" + region.getOffset() + " lenght=" + region.getLength();
			String open = i < BRACKETS_OPEN.length ? BRACKETS_OPEN[i] : "[" + i + "[";
			String close = i < BRACKETS_CLOSE.length ? BRACKETS_CLOSE[i] : "]" + i + "]";
			builder.append(open + close + ": " + item.getTitle() + " at " + regionStr + "\n");
			replacements.add(new TextReplacement(access, region.getOffset(), 0, open));
			replacements.add(new TextReplacement(access, region.getEndOffset(), 0, close));
		}
		String vizualized = TextReplacements.apply(frame, replacements);
		builder.append(box("document snippet", vizualized));
		return builder.toString();
	}
}
