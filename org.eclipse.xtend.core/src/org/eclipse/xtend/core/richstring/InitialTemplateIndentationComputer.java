/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.richstring;

import java.util.List;

import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.util.XtendSwitch;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;

/**
 * Computes the initial indentation of a rich string according to
 * the semantics in the Xtend language specification. That is, especially
 * the first and the last line have to be ignored if they only consist whitespace.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InitialTemplateIndentationComputer extends XtendSwitch<String> {
	
	private final String initial;

	/**
	 * @param initial the assumed indentation if the first line contains text. May not be <code>null</code>.
	 */
	public InitialTemplateIndentationComputer(CharSequence initial) {
		if (initial == null)
			throw new IllegalArgumentException("Initial indentation must not be null.");
		this.initial = initial.toString();
	}
	
	@Override
	public String caseRichString(RichString object) {
		String result = null;
		List<XExpression> elements = object.getExpressions();
		for(int i= 0; i< elements.size();) {
			XExpression element = elements.get(i);
			String elementResult = null;
			int nextIndex = i+1;
			if (element instanceof RichStringLiteral) {
				RichStringLiteral literal = (RichStringLiteral) element;
				if (nextIndex == elements.size()) { // last one
					elementResult = getLeadingWhitespace(literal.getValue(), literal);
				} else if (!(elements.get(nextIndex) instanceof RichStringLiteral)) {
					elementResult = getLeadingWhitespace(literal.getValue(), literal);
				} else {
					StringBuilder run = new StringBuilder(Strings.emptyIfNull(literal.getValue()));
					RichStringLiteral next = null;
					do {
						next = (RichStringLiteral) elements.get(nextIndex);
						run.append(next.getValue());
						nextIndex++;
					} while(nextIndex < elements.size() && elements.get(nextIndex) instanceof RichStringLiteral);
					elementResult = getLeadingWhitespace(run.toString(), next);
				}
			}
			if (elementResult == null && i == 0)
				return initial;
			result = getBetterString(result, elementResult);
			if (Strings.isEmpty(result))
				return result;
			i = nextIndex;
		}
		return result;
	}

	protected String getBetterString(String current, String candidate) {
		if (candidate == null)
			return current;
		if (candidate.length() == 0)
			return candidate;
		if (current == null || current.length() > candidate.length())
			current = candidate;
		return current;
	}
	
	private String getLeadingWhitespace(String value, RichStringLiteral lastLiteral) {
		List<TextLine> lines = TextLines.splitString(value);
		// no line breaks or immediately closed string literal => no initial indentation
		if (lines.size() <= 1) {
			return null;
		}
		TextLine firstLine = lines.get(0);
		// first line has content == no initial indentation
		if (!firstLine.containsOnlyWhitespace()) { 
			return null;
		}
		String result = null;
		boolean emptyLineSeen = false;
		for (int i = 1; i < lines.size(); i++) {
			TextLine line = lines.get(i);
			CharSequence leadingWS = line.getLeadingWhiteSpace();
			// line is not empty
			if (leadingWS.length() != line.length()) {
				if (leadingWS.length() == 0)
					return "";
				result = getBetterString(result, leadingWS.toString());
			} else {
				// some tools tend to right trim text files by default (e.g. git)
				// that's why we ignore empty lines
				RichString completeString = (RichString) lastLiteral.eContainer();
				List<XExpression> siblings = completeString.getExpressions();
				if (siblings.get(siblings.size() - 1) != lastLiteral) {
					if (leadingWS.length() == 0) { // empty line
						emptyLineSeen = true;
					} else {
						result = getBetterString(result, leadingWS.toString());
					}
				}
			}
		}
		if (emptyLineSeen && result == null)
			return "";
		return result;
	}
	
}