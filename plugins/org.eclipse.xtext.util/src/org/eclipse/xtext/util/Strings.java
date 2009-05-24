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

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Strings {

	public static final String[] EMPTY_ARRAY = new String[0];

	public static boolean equalsIgnoreWhitespace(String left, String right) {
		String l = left==null?"":left.replaceAll("\\s","");
		String r = right==null?"":right.replaceAll("\\s","");
		return l.equals(r);
	}

	public static boolean equal(String literal, String name) {
		return isEmpty(name) ? isEmpty(literal) : literal.equals(name);
	}

	public static String notNull(Object o) {
		String string = String.valueOf(o);
		return string == null ? "null" : string;
	}

	public static String emptyIfNull(String s) {
		return (s == null) ? "" : s;
	}

	public static String concat(String separator, List<String> list) {
		return concat(separator, list, 0);
	}
	
	public static <T> String toString(Collection<T> list, Function<T,String> toString, String delim) {
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
		if (s == null || s.length() == 0)
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
		if (s == null || s.length() == 0)
			return s;
		if (s.length() == 1)
			return s.toLowerCase();
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#loadConvert}
	 */
	public static String convertFromJavaString(String javaString) {
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
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
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
				}
				else {
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
					out[outLen++] = aChar;
				}
			}
			else {
				out[outLen++] = aChar;
			}
		}
		return new String(out, 0, outLen);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#saveConvert}
	 */
	public static String convertToJavaString(String theString) {
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
					if ((aChar < 0x0020) || (aChar > 0x007e)) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(toHex((aChar >> 12) & 0xF));
						outBuffer.append(toHex((aChar >> 8) & 0xF));
						outBuffer.append(toHex((aChar >> 4) & 0xF));
						outBuffer.append(toHex(aChar & 0xF));
					}
					else {
						outBuffer.append(aChar);
					}
			}
		}
		return outBuffer.toString();
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	public static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	private static final char[] hexDigit = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * @param value
	 * @param delimiter
	 * @return
	 */
	public static List<String> split(String value, String delimiter) {
		List<String> result = new ArrayList<String>();
		int lastIndex = 0;
		int index = value.indexOf(delimiter, lastIndex);
		while (index!=-1) {
			result.add(value.substring(lastIndex, index));
			lastIndex = index+delimiter.length();
			index = value.indexOf(delimiter, lastIndex);
		}
		result.add(value.substring(lastIndex));
		return result;
	}

}
