/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Function;
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

	public static String toFirstLower(String s) {
		if (s == null || s.length() == 0 || Character.isLowerCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toLowerCase();
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#loadConvert}
	 */
	public static String convertFromJavaString(String javaString, boolean useUnicode) {
		char[] in = javaString.toCharArray();
		int off = 0;
		int len = javaString.length();
		char[] convtBuf = new char[len];
		char aChar;
		char[] out = convtBuf;
		int outLen = 0;
		int end = off + len;

		while (off < end) {
			aChar = in[off++];
			if (aChar == '\\') {
				aChar = in[off++];
				if (useUnicode && aChar == 'u') {
					// Read the xxxx
					int value = 0;
					if(off+4 > end)
						throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
					for (int i = 0; i < 4; i++) {
						aChar = in[off++];
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
						}
					}
					out[outLen++] = (char) value;
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					else if (aChar == 'b')
						aChar = '\b';
					else if (aChar == '"')
						aChar = '\"';
					else if (aChar == '\'')
						aChar = '\'';
					else if (aChar == '\\')
						aChar = '\\';
					else
						throw new IllegalArgumentException("Illegal escape character \\" + aChar);
					out[outLen++] = aChar;
				}
			} else {
				out[outLen++] = aChar;
			}
		}
		return new String(out, 0, outLen);
	}

	public static String convertToJavaString(String theString) {
		return convertToJavaString(theString, true);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#saveConvert}
	 */
	public static String convertToJavaString(String theString, boolean useUnicode) {
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuffer outBuffer = new StringBuffer(bufLen);

		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
				case ' ':
					outBuffer.append(' ');
					break;
				case '\t':
					outBuffer.append('\\');
					outBuffer.append('t');
					break;
				case '\n':
					outBuffer.append('\\');
					outBuffer.append('n');
					break;
				case '\r':
					outBuffer.append('\\');
					outBuffer.append('r');
					break;
				case '\f':
					outBuffer.append('\\');
					outBuffer.append('f');
					break;
				case '\b':
					outBuffer.append('\\');
					outBuffer.append('b');
					break;
				case '\'':
					outBuffer.append('\\');
					outBuffer.append('\'');
					break;
				case '"':
					outBuffer.append('\\');
					outBuffer.append('"');
					break;
				default:
					if (useUnicode && ((aChar < 0x0020) || (aChar > 0x007e))) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(toHex((aChar >> 12) & 0xF));
						outBuffer.append(toHex((aChar >> 8) & 0xF));
						outBuffer.append(toHex((aChar >> 4) & 0xF));
						outBuffer.append(toHex(aChar & 0xF));
					} else {
						outBuffer.append(aChar);
					}
			}
		}
		return outBuffer.toString();
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	/**
	 * Copied from {@link java.util.Properties}
	 */
	public static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
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
	 * @since 2.3
	 */
	public static int countLineBreaks(CharSequence text) {
		int result = 0;
		char ch;
		int length= text.length();
		for (int i= 0; i < length; i++) {
			ch= text.charAt(i);
			if (ch == '\r') {
				result++;
				if (i + 1 < length) {
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
	 * Counts the number of lines where {@link #separator} is assumed to be a valid line break.
	 */
	public static int countLines(String text) {
		return countLines(text, separator);
	}

	public static int countLines(String text, char[] separator) {
		int line = 0;
		if (separator.length == 1) {
			char c = separator[0];
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == c) {
					line++;
				}
			}
		} else if (separator.length == 2) {
			char c1 = separator[0];
			char c2 = separator[1];
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == c1 && text.length() > i + 1 && text.charAt(i + 1) == c2) {
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
}
