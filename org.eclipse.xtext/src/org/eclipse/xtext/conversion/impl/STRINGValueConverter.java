/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class STRINGValueConverter extends AbstractLexerBasedConverter<String> {

	@Override
	protected String toEscapedString(String value) {
		return '"' + Strings.convertToJavaString(value, false) + '"';
	}

	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			if (string.length() == 1) {
				throw new ValueConverterWithValueException(getStringNotClosedMessage(), node, "", null);
			}
			return convertFromString(string, node);
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	/**
	 * Converts a string literal (including leading and trailing single or double quote) to a semantic
	 * string value. Recovers from invalid escape sequences and announces the first problem with a
	 * {@link ValueConverterWithValueException}.
	 * 
	 * @since 2.7
	 * @throws ValueConverterWithValueException if the given string is syntactically invalid.
	 * @see Strings#convertFromJavaString(String, boolean)
	 */
	protected String convertFromString(String literal, INode node) throws ValueConverterWithValueException {
		int length = literal.length();
		StringBuilder result = new StringBuilder(length);
		ErrorInfo errorInfo = new ErrorInfo();
		int nextIndex = 1;
		while(nextIndex < length - 1) {
			nextIndex = unescapeCharAndAppendTo(literal, nextIndex, result, errorInfo);
		}
		
		if (nextIndex < length) {
			if (nextIndex != length - 1) {
				throw new IllegalStateException();
			}
			char next = literal.charAt(nextIndex);
			if (literal.charAt(0) != next) {
				result.append(next);
				if (errorInfo.errorMessage == null) {
					if (next == '\\') {
						errorInfo.errorMessage = getInvalidEscapeSequenceMessage();
						errorInfo.errorIndex = nextIndex;
						errorInfo.errorLength = 1;
					} else {
						errorInfo.errorMessage = getStringNotClosedMessage();
					}
				} else {
					errorInfo.errorMessage = getStringNotClosedMessage();
					errorInfo.errorIndex = -1;
					errorInfo.errorLength = -1;
				}
			}
		} else if (nextIndex == length) {
			errorInfo.errorMessage = getStringNotClosedMessage();
		}
		if (errorInfo.errorMessage != null) {
			throw new ValueConverterWithValueException(errorInfo.errorMessage, node, result.toString(), errorInfo.errorIndex,
					errorInfo.errorLength, null);
		}
		return result.toString();
	}
		
	/**
	 * @since 2.7
	 */
	protected String getInvalidEscapeSequenceMessage() {
		return "Invalid escape sequence (valid ones are  \\b  \\t  \\n  \\f  \\r  \\\"  \\'  \\\\ )";
	}
	
	/**
	 * @since 2.7
	 */
	protected String getStringNotClosedMessage() {
		return "String literal is not properly closed";
	}
	
	private static class ErrorInfo {
		String errorMessage = null;
		int errorIndex = -1;
		int errorLength = -1;
	}
		
	private int unescapeCharAndAppendTo(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		char c = string.charAt(index++);
		if (c == '\\') {
			index = doUnescapeCharAndAppendTo(string, index, result, errorInfo);
		} else {
			result.append(c);
		}
		return index;
	}
	
	private int doUnescapeCharAndAppendTo(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		if (string.length() == index) {
			if (errorInfo.errorMessage == null) {
				errorInfo.errorMessage = getInvalidEscapeSequenceMessage();
				errorInfo.errorIndex = index - 1;
				errorInfo.errorLength = 1;
			}
			return index;
		}
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
				return unescapeUnicodeSequence(string, index, result, errorInfo);
			default:
				if (errorInfo.errorMessage == null) {
					errorInfo.errorMessage = getInvalidEscapeSequenceMessage();
					errorInfo.errorIndex = index - 2;
					errorInfo.errorLength = 2;
				}
		}
		result.append(c);
		return index;
	}
	
	private int unescapeUnicodeSequence(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		try {
			if (index+4 > string.length() || !isHexSequence(string, index, 4)) {
				result.append('u');
				errorInfo.errorMessage = "Invalid unicode";
				errorInfo.errorIndex = index - 2;
				errorInfo.errorLength = 2;
				return index;
			}
			result.append((char) Integer.parseInt(string.substring(index, index + 4), 16));
			return index + 4;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal \\uxxxx encoding in " + string);
		}
	}
	
	private boolean isHexSequence(String in, int off, int chars) {
		for (int i = off; i < in.length() && i < off + chars; i++) {
			char c = in.charAt(i);
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
					continue;
				default:
					return false;
			}
		}
		return true;
	}

	/**
	 * @since 2.7
	 */
	protected boolean isHexSequence(char[] in, int off, int chars) {
		for (int i = off; i < in.length && i < off + chars; i++) {
			char c = in[i];
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
					continue;
				default:
					return false;
			}
		}
		return true;
	}

}