/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * Reusable and customizable implementation of the method pair
 * {@link Strings#convertToJavaString(String)} and 
 * {@link Strings#convertFromJavaString(String, boolean)}.
 * 
 * @since 2.16
 */
public class JavaStringConverter {
	
	/**
	 * Resolve Java control character sequences to the actual character value.
	 * Optionally handle unicode escape sequences, too. 
	 */
	public String convertFromJavaString(String string, boolean useUnicode) {
		int firstEscapeSequence = string.indexOf('\\');
		if (firstEscapeSequence == -1) {
			return string;
		}
		int length = string.length();
		StringBuilder result = new StringBuilder(length);
		appendRegion(string, 0, firstEscapeSequence, result);
		return convertFromJavaString(string, useUnicode, firstEscapeSequence, result);
	}

	protected void appendRegion(String string, int fromInclusive, int toExclusive, StringBuilder result) {
		if (validateRegion(string, fromInclusive, toExclusive, result)) {
			result.append(string, fromInclusive, toExclusive);	
		} else {
			for(int i = fromInclusive; i < toExclusive; i++) {
				validateAndAppendChar(string.charAt(i), result);
			}
		}
	}
	
	protected boolean validateRegion(String string, int fromInclusive, int toExclusive, StringBuilder result) {
		return true;
	}

	protected String convertFromJavaString(String string, boolean useUnicode, int index, StringBuilder result) {
		int length = string.length();
		while(index < length) {
			index = unescapeCharAndAppendTo(string, useUnicode, index, result);
			if (index < length) {
				int nextEscapeSequence = string.indexOf('\\', index);
				if (nextEscapeSequence == -1) {
					appendRegion(string, index, length, result);
					index = length;
				} else {
					appendRegion(string, index, nextEscapeSequence, result);
					index = nextEscapeSequence;
				}
			}
		}
		return result.toString();
	}
	
	protected int unescapeCharAndAppendTo(String string, boolean useUnicode, int index, StringBuilder result) {
		char c = string.charAt(index++);
		if (c == '\\') {
			return doUnescapeCharAndAppendTo(string, useUnicode, index, result);
		}
		validateAndAppendChar(c, result);
		return index;
	}
	
	protected void validateAndAppendChar(char c, StringBuilder result) {
		if (validate(c, result)) {
			result.append(c);	
		}
	}
	
	protected boolean validate(char c, StringBuilder result) {
		return true;
	}

	protected int doUnescapeCharAndAppendTo(String string, boolean useUnicode, int index, StringBuilder result) {
		char c = string.charAt(index++);
		switch(c) {
			case 'b':
				c = '\b';
				break;	
			case 't':
				c = '\t';
				break;
			case 'n':
				c = '\n';
				break;
			case 'f':
				c = '\f';
				break;
			case 'r':
				c = '\r';
				break;
			case '"':
			case '\'':
			case '\\':
				// append as is
				break;
			case 'u':
				if (useUnicode) {
					return unescapeUnicodeSequence(string, index, result);
				}
				// intentional fallThrough
			default:
				return handleUnknownEscapeSequence(string, c, useUnicode, index, result);
		}
		validateAndAppendChar(c, result);
		return index;
	}

	protected int handleUnknownEscapeSequence(String string, char c, boolean useUnicode, int index, StringBuilder result) {
		throw new IllegalArgumentException("Illegal escape character \\" + c);
	}
	
	protected int unescapeUnicodeSequence(String string, int index, StringBuilder result) {
		if(!isInvalidUnicodeEscapeSequence(string, index)) {
			char c1 = string.charAt(index);
			char c2 = string.charAt(index+1);
			char c3 = string.charAt(index+2);
			char c4 = string.charAt(index+3);
			if (isHex(c1) && isHex(c2) && isHex(c3) && isHex(c4)) {
				int appendMe = 0;
				appendMe = buildChar(appendMe, c1);
				appendMe = buildChar(appendMe, c2);
				appendMe = buildChar(appendMe, c3);
				appendMe = buildChar(appendMe, c4);
				validateAndAppendChar((char) appendMe, result);
				return index + 4;
			}
		}
		return handleInvalidUnicodeEscapeSequence(string, index, result);
	}

	private int buildChar(int appendMe, char c) {
		if (c <= '9') {
			return (appendMe << 4) + c - '0';
		} else if (c >= 'a') {
			return (appendMe << 4) + c - 'a' + 10;
		} else {
			return (appendMe << 4) + c - 'A' + 10;
		}
	}

	/**
	 * Return true if the chars starting at index do not appear to be a unicode
	 * escape sequence (without the leading backslash u}.
	 */
	protected boolean isInvalidUnicodeEscapeSequence(String string, int index) {
		return index+4 > string.length();
	}
	
	protected int handleInvalidUnicodeEscapeSequence(String string, int index, StringBuilder result) {
		throw new IllegalArgumentException("Illegal \\uxxxx encoding in " + string + " at index " + index);
	}
	
	/**
	 * Escapes control characters with a preceding backslash.
	 * Encodes special chars as unicode escape sequence. 
	 * The resulting string is safe to be put into a Java string literal between
	 * the quotes.
	 */
	public String convertToJavaString(String theString) {
		return convertToJavaString(theString, true);
	}
	
	/**
	 * Escapes control characters with a preceding backslash.
	 * Optionally encodes special chars as unicode escape sequence. 
	 * The resulting string is safe to be put into a Java string literal between
	 * the quotes.
	 */
	public String convertToJavaString(String input, boolean useUnicode) {
		int length = input.length();
		StringBuilder result = new StringBuilder(length + 4);
		for (int i = 0; i < length; i++) {
			escapeAndAppendTo(input.charAt(i), useUnicode, result);
		}
		return result.toString();
	}
	
	protected void escapeAndAppendTo(char c, boolean useUnicode, StringBuilder result) {
		String appendMe;
		switch (c) {
			case '\b':
				appendMe = "\\b";
				break;	
			case '\t':
				appendMe = "\\t";
				break;
			case '\n':
				appendMe = "\\n";
				break;
			case '\f':
				appendMe = "\\f";
				break;
			case '\r':
				appendMe = "\\r";
				break;
			case '"':
				appendMe = "\\\"";
				break;
			case '\'':
				appendMe = "\\'";
				break;
			case '\\':
				appendMe = "\\\\";
				break;
			default:
				if (useUnicode && mustEncodeAsEscapeSequence(c)) {
					result.append("\\u");
					for (int i = 12; i >= 0; i-=4) {
						result.append(toHex((c >> i) & 0xF));
					}
				} else {
					result.append(c);
				}
				return;
		}
		result.append(appendMe);
	}
	
	protected boolean mustEncodeAsEscapeSequence(char next) {
		return next < 0x0020 || next > 0x007e;
	}
	
	public char toHex(int i) {
		return "0123456789ABCDEF".charAt(i & 0xF);
	}
	
	protected boolean isHexSequence(String in, int off, int chars) {
		return doIsHexSequence(in, off, chars);
	}
	
	public static boolean doIsHexSequence(String in, int off, int chars) {
		for (int i = off; i < in.length() && i < off + chars; i++) {
			char c = in.charAt(i);
			if (!isHex(c)) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isHexSequence(char[] in, int off, int chars) {
		return doIsHexSequence(in, off, chars);
	}
	
	public static boolean doIsHexSequence(char[] in, int off, int chars) {
		for (int i = off; i < in.length && i < off + chars; i++) {
			char c = in[i];
			if (!isHex(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isHex(char c) {
		// this performs slightly better than a switch on all the 22 valid chars especially
		// for the mismatches
		
		return '0' <= c && (c = (char) (c| 0x20)) <= 'f' && (c <= '9' || 'a' <= c);
	}
	
}