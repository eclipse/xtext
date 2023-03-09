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

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionsToString {

	private TextRegionListToString list = new TextRegionListToString();
	private TextRegionsInTextToString text = new TextRegionsInTextToString();
	private boolean ignoreCarriageReturnInQuotes = false;
	
	public boolean isIgnoreCarriageReturnInQuotes() {
		return ignoreCarriageReturnInQuotes;
	}
	
	public TextRegionsToString setIgnoreCarriageReturnInQuotes(boolean ignoreCarriageReturnInQuotes) {
		this.ignoreCarriageReturnInQuotes = ignoreCarriageReturnInQuotes;
		return this;
	}

	public TextRegionsToString add(ITextReplacement region) {
		return add(region, region.getReplacementText());
	}

	public TextRegionsToString add(ITextSegment region, String description) {
		text.add(region, getReplacement(region, region.getText()));
		list.add(region, quote(region.getText(), 20) + ": " + description);
		return this;
	}

	public TextRegionsToString addAllReplacements(Iterable<? extends ITextReplacement> regions) {
		for (ITextReplacement region : regions)
			addReplacement((ITextSegment) region, region.getReplacementText());
		return this;
	}

	public TextRegionsToString addReplacement(ITextReplacement region, String description) {
		return addReplacement(region, region.getReplacementText(), description);
	}

	public TextRegionsToString addReplacement(ITextSegment region, String replacement) {
		text.add(region, getReplacement(region, replacement));
		list.add(region, quote(region.getText(), 20) + " -> " + quote(replacement, 20));
		return this;
	}

	public TextRegionsToString addReplacement(ITextSegment region, String replacement, String description) {
		text.add(region, getReplacement(region, replacement));
		list.add(region, quote(region.getText(), 20) + " -> " + quote(replacement, 20) + ": " + description);
		return this;
	}

	protected String getReplacement(ITextSegment region, String replacement) {
		String string = region.getText();
		if (Strings.equal(string, replacement))
			return "<" + region.getOffset() + "|" + replacement + ">";
		return "<" + region.getOffset() + ":" + region.getLength() + "|" + replacement + ">";
	}

	protected String quote(String string, int maxLength) {
		if (string == null)
			return "null";
		List<String> result =Lists.newArrayList();
		int max = Math.min( string.length(), maxLength +1);
		for (int i = 0; i < max; i++) {
			char c = string.charAt(i);
			switch (c) {
			case '\n':
				result.add("\\n");
				break;
			case '\r':
				if (ignoreCarriageReturnInQuotes) {
					max = Math.min(max+1, string.length());
				} else {
					result.add("\\r");
				}
				break;
			default:
				result.add(String.valueOf(c));
			}
		}
		
		if (result.size() > maxLength) {
			result = result.subList(0, maxLength - 3);
			result.add("...");
		}
		return "\"" + Joiner.on("").join( result) + "\"";
	}

	public TextRegionsToString setTitle(String title) {
		text.setTitle(title + " (syntax: <offset|text>)");
		return this;
	}

	public TextRegionsToString setFrame(ITextSegment frame) {
		this.text.setFrame(frame);
		return this;
	}

	public TextRegionsToString setLeadingLines(int leadingLines) {
		this.text.setLeadingLines(leadingLines);
		return this;
	}

	public TextRegionsToString setTextRegionAccess(ITextRegionAccess textRegionAccess) {
		this.text.setTextRegionAccess(textRegionAccess);
		return this;
	}

	public TextRegionsToString setTrailingLines(int trailingLines) {
		this.text.setTrailingLines(trailingLines);
		return this;
	}

	@Override
	public String toString() {
		return text + "\n" + list;
	}
}
