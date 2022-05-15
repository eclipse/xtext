/*******************************************************************************
 * Copyright (c) 2008, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Strings {

	public static final String[] EMPTY_ARRAY = new String[0];

	public static boolean equalsIgnoreWhitespace(String left, String right) {
		String l = left == null ? "" : left.replaceAll("\\s", "");
		String r = right == null ? "" : right.replaceAll("\\s", "");
		return l.equals(r);
	}

	public static boolean equal(String literal, String name) {
		return isEmpty(literal) ? isEmpty(name) : literal.equals(name);
	}

	public static String notNull(Object o) {
		return String.valueOf(o);
	}

	public static String emptyIfNull(String s) {
		return (s == null) ? "" : s;
	}

	public static String concat(String separator, List<String> list) {
		return concat(separator, list, 0);
	}

	public static <T> String toString(Collection<T> list, Function<T, String> toString, String delim) {
		StringBuffer buffer = new StringBuffer();
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T t = iterator.next();
			buffer.append(toString.apply(t));
			if (iterator.hasNext())
				buffer.append(delim);
		}
		return buffer.toString();
	}

	public static String concat(String separator, List<String> list, int skip) {
		StringBuffer buff = new StringBuffer();
		int lastIndex = list.size() - skip;
		for (int i = 0; i < lastIndex; i++) {
			buff.append(list.get(i));
			if (i + 1 < lastIndex)
				buff.append(separator);
		}
		String string = buff.toString();
		return string.trim().length() == 0 ? null : string;
	}

	public static String skipLastToken(String value, String separator) {
		int endIndex = value.lastIndexOf(separator);
		if (endIndex > 0)
			return value.substring(0, endIndex);
		return value;
	}

	public static String lastToken(String value, String separator) {
		int index = value.lastIndexOf(separator) + separator.length();
		if (index < value.length())
			return value.substring(index, value.length());
		return "";
	}

	public static String toFirstUpper(String s) {
		if (s == null || s.length() == 0 || Character.isUpperCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toUpperCase();
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static boolean isEmpty(String s) {
		return s == null || s.equals("");
	}

	public static String newLine() {
		return System.getProperty("line.separator");
	}
	
	/**
	 * @since 2.13
	 */
	public static String toPlatformLineSeparator(CharSequence cs) {
		return cs.toString().replaceAll("\r?\n", Strings.newLine());
	}
	
	/**
	 * @since 2.14
	 */
	public static String toUnixLineSeparator(CharSequence cs) {
		return cs.toString().replaceAll("\r?\n", "\n");
	}

	public static String toFirstLower(String s) {
		if (s == null || s.length() == 0 || Character.isLowerCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toLowerCase();
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	private static final JavaStringConverter CONVERTER = new JavaStringConverter();
	
	/**
	 * Resolve Java control character sequences with to the actual character value.
	 * Optionally handle unicode escape sequences, too. 
	 */
	public static String convertFromJavaString(String string, boolean useUnicode) {
		return CONVERTER.convertFromJavaString(string, useUnicode);
	}

	/**
	 * Escapes control characters with a preceding backslash.
	 * Encodes special chars as unicode escape sequence. 
	 * The resulting string is safe to be put into a Java string literal between
	 * the quotes.
	 */
	public static String convertToJavaString(String theString) {
		return CONVERTER.convertToJavaString(theString, true);
	}
	
	/**
	 * Escapes control characters with a preceding backslash.
	 * Optionally encodes special chars as unicode escape sequence. 
	 * The resulting string is safe to be put into a Java string literal between
	 * the quotes.
	 */
	public static String convertToJavaString(String input, boolean useUnicode) {
		return CONVERTER.convertToJavaString(input, useUnicode);
	}

	public static char toHex(int i) {
		return CONVERTER.toHex(i);
	}

	/**
	 * Splits a string around matches of the given delimiter string.
	 * <p>
	 * This method works similar to {@link String#split(String)} but does not treat the delimiter
	 * as a regular expression. This makes it perform better in most cases where this feature is not
	 * necessary. Furthermore this implies that trailing empty segments will not be part of the
	 * result.
	 * <p>
	 * For delimiters of length 1 it is preferred to use {@link #split(String, char)} instead.
	 * 
	 * @param value
	 *            the string to split
	 * @param delimiter
	 *            the delimiting string (e.g. "::")
	 * 
	 * @return the list of strings computed by splitting the string around matches of the given delimiter
	 * without trailing empty segments. Never <code>null</code> and the list does not contain any <code>null</code> values.
	 * 
	 * @throws NullPointerException
	 *             If the {@code value} or {@code delimiter} is {@code null}
	 */
	public static List<String> split(String value, String delimiter) {
		List<String> result = new ArrayList<String>();
		int lastIndex = 0;
		int index = value.indexOf(delimiter, lastIndex);
		int pendingEmptyStrings = 0;
		while (index != -1) {
			String addMe = value.substring(lastIndex, index);
			if (addMe.length() == 0)
				pendingEmptyStrings++;
			else {
				while(pendingEmptyStrings > 0) {
					result.add("");
					pendingEmptyStrings--;
				}
				result.add(addMe);
			}
			lastIndex = index + delimiter.length();
			index = value.indexOf(delimiter, lastIndex);
		}
		if (lastIndex != value.length()) {
			while(pendingEmptyStrings > 0) {
				result.add("");
				pendingEmptyStrings--;
			}
			result.add(value.substring(lastIndex));
		}
		return result;
	}

	/**
	 * Splits a string around matches of the given delimiter character.
	 * <p>
	 * This method works similar to {@link String#split(String)} but does not treat the delimiter
	 * as a regular expression. This makes it perform better in most cases where this feature is not
	 * necessary. Furthermore this implies that trailing empty segments will not be part of the
	 * result.
	 * 
	 * @param value
	 *            the string to split
	 * @param delimiter
	 *            the delimiting character (e.g. '.' or ':')
	 * 
	 * @return the list of strings computed by splitting the string around matches of the given delimiter
	 * without trailing empty segments. Never <code>null</code> and the list does not contain any <code>null</code> values.
	 * 
	 * @throws NullPointerException
	 *             If the {@code value} is {@code null}
	 * @see String#split(String)
	 * @since 2.3
	 */
	public static List<String> split(String value, char delimiter) {
		List<String> result = new ArrayList<String>();
		int lastIndex = 0;
		int index = value.indexOf(delimiter, lastIndex);
		int pendingEmptyStrings = 0;
		while (index != -1) {
			String addMe = value.substring(lastIndex, index);
			if (addMe.length() == 0)
				pendingEmptyStrings++;
			else {
				while(pendingEmptyStrings > 0) {
					result.add("");
					pendingEmptyStrings--;
				}
				result.add(addMe);
			}
			lastIndex = index + 1;
			index = value.indexOf(delimiter, lastIndex);
		}
		if (lastIndex != value.length()) {
			while(pendingEmptyStrings > 0) {
				result.add("");
				pendingEmptyStrings--;
			}
			result.add(value.substring(lastIndex));
		}
		return result;
	}

	public static final char SEPARATOR = ':';

	/**
	 * @param strings array of strings, may not be <code>null</code> and may not contain any <code>null</code> values.
	 * @throws NullPointerException if the array of strings or any element in the array is <code>null</code>
	 */
	public static String pack(String[] strings) {
		if (strings != null && strings.length > 0) {
			StringBuffer buffer = new StringBuffer();
			for (String s : strings) {
				buffer.append(s.length());
				buffer.append(SEPARATOR);
				buffer.append(s);
			}
			return buffer.toString();
		}
		return null;
	}

	public static String[] unpack(String packed) {
		if (isEmpty(packed)) {
			return null;
		} else {
			List<String> strings = Lists.newArrayList();
			unpack(strings, packed);
			return strings.toArray(new String[strings.size()]);
		}
	}

	private static void unpack(List<String> strings, String packed) {
		int delimiterIndex = packed.indexOf(":");
		int size = Integer.parseInt(packed.substring(0, delimiterIndex));
		int endIndex = delimiterIndex + 1 + size;
		strings.add(packed.substring(delimiterIndex + 1, endIndex));
		if (endIndex < packed.length()) {
			unpack(strings, packed.substring(endIndex));
		}
	}

	public static String removeLeadingWhitespace(String indentationString) {
		int i = 0;
		while (i<indentationString.length() && Character.isWhitespace(indentationString.charAt(i)))
			i++;
		return indentationString.substring(i);
	}
	
	private static final char[] separator = System.getProperty("line.separator").toCharArray();

	/**
	 * Counts the number of line breaks. Assumes {@code '\r'}, {@code '\n'} or {@code '\r\n'} to be valid line breaks.
	 * 
	 * This follows the semantics of the {@link LineNumberReader}.
	 * 
	 * @since 2.3
	 */
	public static int countLineBreaks(CharSequence text) {
		return countLineBreaks(text, 0, text.length());
	}
	
	/**
	 * Counts the number of line breaks. Assumes {@code '\r'}, {@code '\n'} or {@code '\r\n'} to be valid line breaks.
	 * 
	 * This follows the semantics of the {@link LineNumberReader}.
	 * 
	 * @since 2.9
	 */
	public static int countLineBreaks(CharSequence text, int startInclusive, int endExclusive) {
		int result = 0;
		for (int i = startInclusive; i < endExclusive; i++) {
			char ch= text.charAt(i);
			if (ch == '\r') {
				result++;
				if (i + 1 < endExclusive) {
					if (text.charAt(i + 1) == '\n') {
						i++;
					}
				}
			} else if (ch == '\n') {
				result++;
			}
		}
		return result;
	}
	
	/**
	 * Assumes {@code '\r'}, {@code '\n'} or {@code '\r\n'} to be valid line breaks.
	 * 
	 * @since 2.6
	 */
	public static CharSequence trimTrailingLineBreak(CharSequence s) {
		if (s == null)
			return null;
		if (s.length() == 0)
			return s;
		if (s.charAt(s.length() - 1) == '\n') {
			if (s.length() > 1 && s.charAt(s.length() - 2) == '\r') {
				return s.subSequence(0, s.length() - 2);
			}
			return s.subSequence(0, s.length() - 1);
		}
		if (s.charAt(s.length() - 1) == '\r') {
			return s.subSequence(0, s.length() - 1);
		}
		return s;
	}
	
	/**
	 * Counts the number of lines where {@link #separator} is assumed to be the only valid line break sequence.
	 * A string without any line separators returns {@code 0} as the number of lines.
	 */
	public static int countLines(String text) {
		return countLines(text, separator);
	}

	/**
	 * Counts the number of lines where the given separator sequence is the only valid line break sequence.
	 * A string without any line separators returns {@code 0} as the number of lines.
	 */
	public static int countLines(String text, char[] separator) {
		return countLines(text, separator, 0, text.length());
	}

	/**
	 * Counts the number of lines between {@code startInclusive} and {@code endExclusive}
	 * where the given separator sequence is the only valid line break sequence.
	 * A string without any line separators in that range returns {@code 0} as the number of lines.
	 * 
	 * @since 2.9
	 */
	public static int countLines(String text, char[] separator, int startInclusive, int endExclusive) {
		int line = 0;
		if (separator.length == 1) {
			char c = separator[0];
			for (int i = startInclusive; i < endExclusive; i++) {
				if (text.charAt(i) == c) {
					line++;
				}
			}
		} else if (separator.length == 2) {
			char c1 = separator[0];
			char c2 = separator[1];
			for (int i = startInclusive; i < endExclusive; i++) {
				if (text.charAt(i) == c1 && endExclusive > i + 1 && text.charAt(i + 1) == c2) {
					line++;
					i++;
				} else if (text.charAt(i) == c2) {
					line++;
				}
			}
		} else {
			throw new IllegalArgumentException("Separators with more than two characters are unexpected");
		}
		return line;
	}
	
	// TODO is it worthwhile to deprecate this method and fix the typo 'Whitespace'?
	public static String getLeadingWhiteSpace(String original) {
		for(int i=0; i < original.length(); i++) {
			if (!Character.isWhitespace(original.charAt(i))) {
				return original.substring(0, i);
			}
		}
		return original;
	}
	
	/**
	 * @since 2.1
	 */
	public static String wordWrap(String string, int maxCharsPerLine) {
		StringBuilder document = new StringBuilder();
		StringBuilder line = new StringBuilder();
		StringBuilder word = new StringBuilder();
		StringBuilder ws = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '\n') {
				line.append(ws);
				line.append(word);
				line.append("\n");
				document.append(line);
				line = new StringBuilder();
				word = new StringBuilder();
				ws = new StringBuilder();
			} else if (Character.isWhitespace(c)) {
				if (line.length() + word.length() + 1 > maxCharsPerLine) {
					line.append("\n");
					document.append(line);
					line = new StringBuilder();
					line.append(word);
					word = new StringBuilder();
					ws = new StringBuilder();
					ws.append(c);
				} else if (word.length() == 0) {
					ws.append(c);
				} else {
					line.append(ws);
					line.append(word);
					word = new StringBuilder();
					ws = new StringBuilder();
					ws.append(c);
				}
			} else {
				word.append(c);
			}
		}
		if (line.length() + word.length() + 1 > maxCharsPerLine) {
			document.append(line);
			document.append("\n");
			document.append(word);
		} else {
			document.append(line);
			document.append(ws);
			document.append(word);
		}
		return document.toString();
	}
	
	/**
	 * Calculates the Levenshtein text edit distance
	 * 
	 * copied &amp; adapted (cost = 1) from org.eclipse.jdt.internal.ui.text.spelling.engine.DefaultPhoneticDistanceAlgorithm
	 * 
	 * @param from source string, may not be null
	 * @param to target string, may not be null
	 * @return Levenshtein distance between from and to
	 * 
	 * @since 2.27
	 */
	public static int getLevenshteinDistance(String from, String to) {
		Preconditions.checkNotNull(from, "from");
		Preconditions.checkNotNull(to, "to");
		final int COST=1;
		final char[] first = (" " + from).toCharArray(); //$NON-NLS-1$
		final char[] second = (" " + to).toCharArray(); //$NON-NLS-1$
		final int rows = first.length;
		final int columns = second.length;
		final int[][] metric = new int[rows][columns];
		for (int column = 1; column < columns; column++) {
			metric[0][column]= metric[0][column - 1] + COST;
		}
		for (int row = 1; row < rows; row++) {
			metric[row][0] = metric[row - 1][0] + COST;
		}
		char source, target;
		int swap= Integer.MAX_VALUE;
		int change= Integer.MAX_VALUE;
		int minimum, diagonal, insert, remove;
		for (int row = 1; row < rows; row++) {
			source = first[row];
			for (int column = 1; column < columns; column++) {
				target= second[column];
				diagonal= metric[row - 1][column - 1];
				if (source == target) {
					metric[row][column] = diagonal;
					continue;
				}
				change = Integer.MAX_VALUE;
				if (Character.toLowerCase(source) == Character.toLowerCase(target))
					change = COST + diagonal;
				swap = Integer.MAX_VALUE;
				if (row != 1 && column != 1 && source == second[column - 1] && first[row - 1] == target)
					swap= COST + metric[row - 2][column - 2];
				minimum = COST + diagonal;
				if (swap < minimum)
					minimum = swap;
				remove = metric[row][column - 1];
				if (COST + remove < minimum)
					minimum = COST + remove;
				insert = metric[row - 1][column];
				if (COST + insert < minimum)
					minimum = COST + insert;
				if (change < minimum)
					minimum = change;
				metric[row][column] = minimum;
			}
		}
		return metric[rows - 1][columns - 1];
	}

}
