/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.internal;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

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

		public int indexOf(String str, int fromIndex) {
			return semantic.indexOf(str, fromIndex);
		}

		public int length() {
			return semantic.length();
		}

		public void migrateFrom(FormattedString source, Mapping mapping) {
			int src = mapping.srcOffset;
			int dst = mapping.dstOffset;
			int len = mapping.length;
			if (src > 0 && dst > 0) {
				src++;
				dst++;
				len--;
			}
			if (src + len + 1 < source.formatting.length && dst + len == semantic.length())
				len++;
			System.arraycopy(source.formatting, src, formatting, dst, len);
		}

		public String substring(int index, int lenght) {
			return semantic.substring(index, lenght);
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

	protected class Mapping {
		protected FormattedString dst;
		protected int dstOffset;
		protected int length;
		protected FormattedString src;
		protected int srcOffset;

		public Mapping(FormattedString src, FormattedString dst, int srcOffset, int dstOffset, int length) {
			super();
			this.src = src;
			this.dst = dst;
			this.srcOffset = srcOffset;
			this.dstOffset = dstOffset;
			this.length = length;
		}

		@Override
		public String toString() {
			String s1 = src.substring(srcOffset, srcOffset + length);
			String s2 = dst.substring(dstOffset, dstOffset + length);
			if (s1.equals(s2))
				return s1;
			return "'" + s1 + "' != '" + s2 + "'";
		}

	}

	protected class Region {
		protected int length;
		protected int offset;

		public Region(int offset, int length) {
			super();
			this.offset = offset;
			this.length = length;
		}

		@Override
		public String toString() {
			return offset + ">" + length;
		}
	}

	protected static final Pattern WS = Pattern.compile("\\s+", Pattern.MULTILINE);

	protected int countOverlappingChars(FormattedString s1, FormattedString s2, int s1Offset, int s2Offset) {
		int i = 0;
		while (i + s1Offset < s1.length() && i + s2Offset < s2.length()
				&& s1.charAt(i + s1Offset) == s2.charAt(i + s2Offset))
			i++;
		return i;
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

	protected void findLinearMatches(FormattedString formattedString, FormattedString toBeFormattedString,
			List<Mapping> mappings, List<Region> remainingRegions) {
		int i1 = 0;
		int i2 = 0;
		while (i1 < formattedString.length() && i2 < toBeFormattedString.length()) {
			int match = countOverlappingChars(formattedString, toBeFormattedString, i1, i2);
			if (match > 0) {
				mappings.add(new Mapping(formattedString, toBeFormattedString, i1, i2, match));
				i1 += match;
				i2 += match;
			}
			if (i1 >= formattedString.length() || i2 >= toBeFormattedString.length())
				return;
			int[] next = findNextOverlappingChar(formattedString, toBeFormattedString, i1, i2);
			if (next == null) {
				remainingRegions.add(new Region(i2, toBeFormattedString.length() - i2));
				return;
			}
			remainingRegions.add(new Region(i2, next[1]));
			i1 += next[0];
			i2 += next[1];
		}
	}

	protected int[] findNextOverlappingChar(FormattedString s1, FormattedString s2, int s1Offset, int s2Offset) {
		final int lenght = 2;
		if (lenght + s2Offset >= s2.length())
			return null;
		int[] best = null;
		int i1 = 0;
		while (i1 + lenght + s1Offset < s1.length()) {
			String cand = s1.substring(s1Offset + i1, s1Offset + i1 + lenght);
			int i2 = s2.indexOf(cand, s2Offset) - s2Offset;
			if (i2 >= 0 && (best == null || best[0] + best[1] > i1 + i2))
				best = new int[] { i1, i2 };
			if (best != null && best[0] + best[1] > i1)
				return best;
			i1++;
		}
		return best;
	}

	public String migrate(String formattedString, String toBeFormattedString) {
		return migrate(formattedString, toBeFormattedString, WS);
	}

	public String migrate(String formattedString, String toBeFormattedString, Pattern format) {
		if (Strings.isEmpty(toBeFormattedString) || Strings.isEmpty(formattedString))
			return toBeFormattedString;
		FormattedString formatted = createFormattedString(formattedString, format);
		FormattedString toBeFormatted = createFormattedString(toBeFormattedString, format);
		if (formatted.semantic.equals(toBeFormatted.semantic))
			return formattedString;
		List<Mapping> mappings = Lists.newArrayList();
		List<Region> remainingRegions = Lists.newArrayList();
		findLinearMatches(formatted, toBeFormatted, mappings, remainingRegions);
		for (Mapping m : mappings)
			toBeFormatted.migrateFrom(formatted, m);
		return toBeFormatted.toString();
	}

}
