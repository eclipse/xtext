/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegions;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionsInTextToString {

	private ITextSegment frame;
	private List<ITextReplacement> items = Lists.newArrayList();
	private int leadingLines = 4;
	private ITextRegionAccess textRegionAccess;
	private String title = "document snippet";
	private int trailingLines = 4;

	public TextRegionsInTextToString add(ITextReplacement region) {
		items.add(region);
		return this;
	}

	public TextRegionsInTextToString add(ITextSegment region, String title) {
		items.add(region.replaceWith(title));
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
			ITextSegment impactRegion = TextRegions.merge(this.items);
			List<ILineRegion> expandToLines = TextRegions.expandToLines(impactRegion, getLeadingLines(),
					getTrailingLines());
			return TextRegions.merge(expandToLines);
		}
		return null;
	}

	public List<ITextReplacement> getItems() {
		return items;
	}

	public int getLeadingLines() {
		return leadingLines;
	}

	public ITextRegionAccess getTextRegionAccess() {
		if (this.textRegionAccess != null)
			return this.textRegionAccess;
		for (ITextReplacement item : this.items)
			return item.getTextRegionAccess();
		return null;
	}

	public String getTitle() {
		return title;
	}

	public int getTrailingLines() {
		return trailingLines;
	}

	public TextRegionsInTextToString setFrame(ITextSegment frame) {
		this.frame = frame;
		return this;
	}

	public TextRegionsInTextToString setLeadingLines(int leadingLines) {
		this.leadingLines = leadingLines;
		return this;
	}

	public TextRegionsInTextToString setTextRegionAccess(ITextRegionAccess textRegionAccess) {
		this.textRegionAccess = textRegionAccess;
		return this;
	}

	public TextRegionsInTextToString setTitle(String title) {
		this.title = title;
		return this;
	}

	public TextRegionsInTextToString setTrailingLines(int trailingLines) {
		this.trailingLines = trailingLines;
		return this;
	}

	@Override
	public String toString() {
		try {
			ITextRegionAccess access = getTextRegionAccess();
			ITextSegment frame = getFrame();
			if (access == null || frame == null)
				return box(title, "(no changes)");
			StringBuilder builder = new StringBuilder();
			String vizualized = access.getRewriter().renderToString(frame, items);
			builder.append(box(title, vizualized));
			return builder.toString();
		} catch (Exception e) {
			return box("error", e.getMessage() + "\n" + Throwables.getStackTraceAsString(e));
		}
	}

}
