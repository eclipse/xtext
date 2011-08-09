/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Wrapper;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectParameterProvider implements IParameterProvider {

	protected static Pattern XPECT_PATTERN = Pattern.compile("(\\S)?XPECT(_TEST_CLASS)?\\s*([a-zA-Z0-9]+)");

	// XPECT foo
	// XPECT foo("param")
	// XPECT foo("param", param2)
	// XPECT foo at location
	// XPECT foo at loca!tion
	// XPECT foo("param") at location
	// XPECT foo --> expectation
	/* XPECT foo ---
	 expectation
	--- */
	/* XPECT foo("param") at location ---
	 expectation
	--- */

	public void collectParameters(XtextResource resource, IParameterAcceptor acceptor) {
		for (ILeafNode leaf : resource.getParseResult().getRootNode().getLeafNodes())
			if (leaf.isHidden() && leaf.getText().contains("XPECT"))
				parseLeaf(resource, leaf, acceptor);

	}

	protected void parseLeaf(XtextResource resource, ILeafNode leaf, IParameterAcceptor acceptor) {
		String text = leaf.getText();
		Matcher matcher = XPECT_PATTERN.matcher(text);
		int offset = 0;
		while (offset < text.length() && matcher.find(offset)) {
			if (matcher.group(2) == null) {
				int newOffset;
				if ((newOffset = parseXpect(resource, leaf, text, matcher.group(3), matcher.end(), acceptor,
						matcher.group(1) != null)) >= 0)
					offset = newOffset;
				else
					offset = matcher.end();
			} else {
				int newOffset;
				if ((newOffset = parseXpectTest(text, matcher.group(3), matcher.end())) >= 0)
					offset = newOffset;
				else
					offset = matcher.end();
			}
		}
	}

	protected int parseStringOrText(String text, int offset, Wrapper<String> value) {
		int newOffset = parseString(text, offset, value);
		if (newOffset < 0)
			newOffset = parseText(text, offset, value);
		return newOffset;
	}

	protected int parseString(String text, int offset, Wrapper<String> value) {
		if (offset < text.length() && text.charAt(offset) == '"') {
			int i = offset + 1;
			while (offset < text.length() && text.charAt(i - 1) == '\\' || text.charAt(i) != '"')
				i++;
			if (text.charAt(i) == '"') {
				value.set(text.substring(offset + 1, i - 1));
				return i;
			}
		}
		return -1;
	}

	protected int parseText(String text, int offset, Wrapper<String> value) {
		int i = offset;
		while (i < text.length())
			switch (text.charAt(i)) {
				case ' ':
				case '\t':
				case '\r':
				case '\n':
					value.set(text.substring(offset, i));
					return i;
				default:
					i++;
			}
		value.set(text.substring(offset, i));
		return i;
	}

	protected int parseXpect(XtextResource res, INode ctx, String text, String method, int offset,
			IParameterAcceptor acceptor, boolean ignore) {
		int newOffset;
		List<String> params = Lists.newArrayList();
		Wrapper<String> location = new Wrapper<String>(null);
		Wrapper<String> expectation = new Wrapper<String>(null);
		offset = skipWhitespace(text, offset);
		if ((newOffset = parseXpectParams(text, offset, params)) >= 0)
			offset = newOffset;
		offset = skipWhitespace(text, offset);
		if ((newOffset = parseXpectLocation(text, offset, location)) >= 0)
			offset = skipWhitespace(text, newOffset);
		if ((newOffset = parseXpectSLExpectation(text, offset, expectation)) >= 0)
			offset = newOffset;
		else if ((newOffset = parseXpectMLExpectation(text, offset, expectation)) >= 0)
			offset = newOffset;

		int loc;
		if (location.get() != null)
			loc = res.getParseResult().getRootNode().getText()
					.indexOf(location.get(), ctx.getOffset() + ctx.getLength());
		else
			loc = ctx.getOffset();
		Object[] testParms = new Object[] { res, loc, params.toArray(new String[params.size()]) };
		acceptor.acceptTest("", method, testParms, expectation.get(), ignore);
		return offset;
	}

	protected int parseXpectLocation(String text, int offset, Wrapper<String> location) {
		if (offset + 1 < text.length() && text.substring(offset, offset + 2).equals("at")) {
			offset = skipWhitespace(text, offset + 2);
			return parseStringOrText(text, offset, location);
		}
		return -1;
	}

	protected int parseXpectMLExpectation(String text, int offset, Wrapper<String> expectation) {
		if (offset + 2 < text.length() && text.substring(offset, offset + 3).equals("---")) {
			int start = text.indexOf('\n', offset + 3);
			int end = text.indexOf("---", offset + 3);
			if (start >= 0 && end >= 0) {
				String substring = text.substring(start + 1, end);
				end = substring.lastIndexOf('\n');
				if (end >= 0) {
					expectation.set(substring.substring(0, end));
					return end;
				}
			}
		}
		return -1;
	}

	protected int parseXpectParams(String text, int offset, List<String> params) {
		if (offset < text.length() && text.charAt(offset) == '(') {
			int index = text.indexOf(')', offset);
			params.add(text.substring(offset, index));
			return index;
		}
		return -1;
	}

	protected int parseXpectSLExpectation(String text, int offset, Wrapper<String> expectation) {
		if (offset + 2 < text.length() && text.substring(offset, offset + 3).equals("-->")) {
			int index = text.indexOf('\n', offset + 3);
			if (index < 0)
				index = text.length();
			expectation.set(text.substring(offset + 3, index));
			return index;
		}
		return -1;
	}

	protected int parseXpectTest(String text, String name, int offset) {
		return -1;
	}

	protected int skipWhitespace(String text, int offset) {
		int i = offset;
		while (i < text.length())
			switch (text.charAt(i)) {
				case ' ':
				case '\t':
				case '\r':
				case '\n':
					i++;
					break;
				default:
					return i;
			}
		return i;
	}

}
