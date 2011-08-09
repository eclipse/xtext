/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.1
 */
public class FormattingMigrator {

	protected class FormattedString {
		protected String[] formatting;
		protected String semantic;

		public FormattedString(String source) {
			this.semantic = source;
			this.formatting = new String[source.length() + 1];
		}

		public FormattedString(String semantic, String[] formatting) {
			super();
			this.semantic = semantic;
			this.formatting = formatting;
		}

		public char charAt(int index) {
			return semantic.charAt(index);
		}

		public int length() {
			return semantic.length();
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < semantic.length(); i++) {
				if (formatting[i] != null)
					result.append(formatting[i]);
				result.append(semantic.charAt(i));
			}
			if (formatting[semantic.length()] != null)
				result.append(formatting[semantic.length()]);
			return result.toString();
		}
	}

	protected class FormattingMatch {
		protected int overlapCharsAfter;
		protected int overlapCharsBefore;
		protected int overlapTokensAfter;
		protected int overlapTokensBefore;
		protected int pos;

		public FormattingMatch(int pos) {
			super();
			this.pos = pos;
		}

		protected void calcOverlap(FormattedString s1, int i1, FormattedString s2, int i2) {
			overlapCharsAfter = 0;
			overlapCharsBefore = 0;
			overlapTokensAfter = 0;
			overlapTokensBefore = 0;
			int downTo = Math.min(i1, i2);
			int i = 1;
			while (downTo - i >= 0 && s1.charAt(i1 - i) == s2.charAt(i2 - i)) {
				overlapCharsBefore++;
				if (s1.formatting[i1 - i] != null || s2.formatting[i2 - i] != null)
					overlapTokensBefore++;
				i++;
			}
			int upTo = Math.min(s1.length() - i1, s2.length() - i2);
			int j = 1;
			while (j < upTo && s1.charAt(i1 + j) == s2.charAt(i2 + j)) {
				overlapCharsAfter++;
				if (s1.formatting[i1 + j + 1] != null || s2.formatting[i2 + j + 1] != null)
					overlapTokensAfter++;
				j++;
			}
		}

		public int getOverlapChars() {
			return overlapCharsBefore + overlapCharsAfter;
		}

		public int getOverlapTokens() {
			return overlapTokensBefore + overlapTokensAfter;
		}
	}

	protected FormattedString createFormattedString(String string, Pattern format) {
		Matcher matcher = format.matcher(string);
		StringBuffer semantic = new StringBuffer();
		String[] formatting = new String[string.length() + 1];
		int lastEnd = 0;
		while (matcher.find()) {
			semantic.append(string.substring(lastEnd, matcher.start()));
			formatting[semantic.length()] = matcher.group();
			lastEnd = matcher.end();
		}
		semantic.append(string.substring(lastEnd));
		return new FormattedString(semantic.toString(), formatting);
	}

	protected FormattingMatch match(FormattedString searchFor, int searchAt, FormattedString searchIn) {
		char c1 = searchAt > 0 ? searchFor.charAt(searchAt - 1) : 0;
		char c2 = searchAt < searchFor.length() ? searchFor.charAt(searchAt) : 0;
		FormattingMatch lastMatch = null;
		for (int i = 0; i < searchIn.length(); i++) {
			FormattingMatch match = null;
			if (searchIn.charAt(i) == c1) {
				match = new FormattingMatch(i + 1);
				match.calcOverlap(searchFor, searchAt - 1, searchIn, i);
			} else if (searchIn.charAt(i) == c2) {
				match = new FormattingMatch(i);
				match.calcOverlap(searchFor, searchAt, searchIn, i);
			}
			if (match != null && qualifies(match) && (lastMatch == null || precedes(match, lastMatch)))
				lastMatch = match;
		}
		return lastMatch;
	}

	public String migrate(String formattedString, String toBeFormattedString, Pattern format) {
		FormattedString formatted = createFormattedString(formattedString, format);
		FormattedString toBeFormatted = createFormattedString(toBeFormattedString, format);
		if (formatted.semantic.equals(toBeFormatted.semantic))
			return formattedString;
		FormattedString result = new FormattedString(toBeFormatted.semantic);
		for (int i = 0; i <= formatted.semantic.length(); i++)
			if (formatted.formatting[i] != null) {
				FormattingMatch match = match(formatted, i, result);
				if (match != null) {
					//					result.formatting[match.pos] = "[" + formatted.formatting[i] + i + "]";
					result.formatting[match.pos] = formatted.formatting[i];
					if (toBeFormatted.formatting[match.pos] != null)
						toBeFormatted.formatting[match.pos] = null;
				}
			}
		for (int i = 0; i <= toBeFormatted.semantic.length(); i++)
			if (toBeFormatted.formatting[i] != null)
				result.formatting[i] = toBeFormatted.formatting[i];
		return result.toString();
	}

	protected boolean precedes(FormattingMatch candidate, FormattingMatch competitor) {
		if (candidate.getOverlapTokens() > competitor.getOverlapTokens())
			return true;
		if (candidate.getOverlapChars() > competitor.getOverlapChars())
			return true;
		return false;
	}

	protected boolean qualifies(FormattingMatch match) {
		return match.getOverlapTokens() >= 1;
	}

}
