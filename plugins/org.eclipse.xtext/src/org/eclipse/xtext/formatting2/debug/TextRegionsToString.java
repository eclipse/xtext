/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionsToString {

	private TextRegionListToString list = new TextRegionListToString();
	private TextRegionsInTextToString text = new TextRegionsInTextToString();

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
		if (string.length() > maxLength)
			string = string.substring(0, maxLength - 3) + "...";
		string = string.replace("\n", "\\n").replace("\r", "\\r");
		return "\"" + string + "\"";
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
