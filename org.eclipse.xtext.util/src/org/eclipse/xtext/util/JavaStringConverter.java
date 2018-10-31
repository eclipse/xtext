/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * Reusable and customizable implementation of the methdo pair 
 * {@link Strings#convertToJavaString(String)} and 
 * {@link Strings#convertFromJavaString(String, boolean)}.
 * 
 * @since 2.16
 */
public class JavaStringConverter {
	
	/**
	 * Resolve Java control character sequences with to the actual character value.
	 * Optionally handle unicode escape sequences, too. 
	 */
	public String convertFromJavaString(String string, boolean useUnicode) {
		int length = string.length();
		StringBuilder result = new StringBuilder(length);
		return convertFromJavaString(string, useUnicode, 0, result);
	}
	
	protected String convertFromJavaString(String string, boolean useUnicode, int index, StringBuilder result) {
		int length = string.length();
		while(index < length) {
			index = unescapeCharAndAppendTo(string, useUnicode, index, result);
		}
		return result.toString();
	}
	
	protected int unescapeCharAndAppendTo(String string, boolean useUnicode, int index, StringBuilder result) {
		char c = string.charAt(index++);
		if (c == '\\') {
			index = doUnescapeCharAndAppendTo(string, useUnicode, index, result);
		} else {
			validateAndAppendChar(result, c);
		}
		return index;
	}
	
	protected void validateAndAppendChar(StringBuilder result, char c) {
		if (validate(result, c)) {
			result.append(c);	
		}
	}
	
	protected boolean validate(StringBuilder result, char c) {
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
				break;
			case 'u':
				if (useUnicode) {
					return unescapeUnicodeSequence(string, index, result);
				}
				// intentional fallThrough
			default:
				return handleUnknownEscapeSequence(string, c, useUnicode, index, result);
		}
		validateAndAppendChar(result, c);
		return index;
	}

	protected int handleUnknownEscapeSequence(String string, char c, boolean useUnicode, int index, StringBuilder result) {
		throw new IllegalArgumentException("Illegal escape character \\" + c);
	}
	
	protected int unescapeUnicodeSequence(String string, int index, StringBuilder result) {
		try {
			return doUnescapeUnicodeEscapeSequence(string, index, result);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Illegal \\uxxxx encoding in " + string);
		}
	}

	protected int doUnescapeUnicodeEscapeSequence(String string, int index, StringBuilder result) throws NumberFormatException {
		if(isInvalidUnicodeEscapeSequence(string, index))
			return handleInvalidUnicodeEscapeSequnce(string, index, result);
		char appendMe = (char) Integer.parseInt(string.substring(index, index + 4), 16);
		validateAndAppendChar(result, appendMe);
		return index + 4;
	}

	/**
	 * Return true if the chars starting at index do not appear to be a unicode
	 * escape sequence (without the leading backslash u}.
	 */
	protected boolean isInvalidUnicodeEscapeSequence(String string, int index) {
		return index+4 > string.length();
	}
	
	protected int handleInvalidUnicodeEscapeSequnce(String string, int index, StringBuilder result) {
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

	protected static boolean isHex(char c) {
		switch (c) {
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
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
				return true;
			default:
				return false;
		}
	}
}