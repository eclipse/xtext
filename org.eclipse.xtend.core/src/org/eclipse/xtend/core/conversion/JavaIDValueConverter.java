/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaIDValueConverter extends IDValueConverter {
	
	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			if (string.charAt(0) == '^') {
				string = string.substring(1);
			}
			String result = convertFromJavaIdentifier(string, node);
			return result;
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	@Override
	protected void assertValidValue(String value) {
		super.assertValidValue(value);
		if (!isValidIdentifierStart(value.charAt(0))) {
			throw new ValueConverterException(value + " is not a valid identifier.", null, null);
		}
		for(int i = 1, length = value.length(); i < length; i++) {
			if (!isValidIdentifierPart(value.charAt(i))) {
				throw new ValueConverterException(value + " is not a valid identifier.", null, null);
			}
		}
	}
	
	@Override
	protected void assertTokens(String value, String result) {
		// ok
	}
	
	@Override
	protected TokenSource getTokenSource(String escapedValue) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean isValidIdentifierStart(char c) {
		return Character.isJavaIdentifierStart(c);
	}
	
	public static boolean isValidIdentifierPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}

	public static String convertFromJavaIdentifier(String identifier, INode node) {
		int idx = identifier.indexOf('\\');
		if (idx < 0) {
			return identifier;
		}
		return doConvertFromJavaString(identifier, idx, node);
	}
	
	private static class ErrorInfo {
		boolean error = false;
		boolean badChar = false;
	}
		
	private static int unescapeCharAndAppendTo(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		char c = string.charAt(index++);
		if (c == '\\') {
			index = doUnescapeCharAndAppendTo(string, index, result, errorInfo);
		} else {
			validateAndAppendChar(result, c, errorInfo);
		}
		return index;
	}
	
	private static int doUnescapeCharAndAppendTo(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		if (string.length() == index) {
			errorInfo.badChar = true;
			return index;
		}
		char c = string.charAt(index++);
		switch(c) {
			case 'u':
				return unescapeUnicodeSequence(string, index, result, errorInfo);
			default:
				errorInfo.badChar = true;
		}
		validateAndAppendChar(result, c, errorInfo);
		return index;
	}
	
	private static int unescapeUnicodeSequence(String string, int index, StringBuilder result, ErrorInfo errorInfo) {
		try {
			if(index+4 > string.length() || !isHexSequence(string, index, 4)) {
				result.append('u');
				errorInfo.error = true;
				return index;
			}
			char appendMe = (char) Integer.parseInt(string.substring(index, index + 4), 16);
			validateAndAppendChar(result, appendMe, errorInfo);
			return index + 4;
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Illegal \\uxxxx encoding in " + string);
		}
	}

	private static void validateAndAppendChar(StringBuilder result, char c, ErrorInfo error) {
		if (result.length() == 0) {
			if (!isValidIdentifierStart(c)) {
				error.badChar = true;
				return;
			}
		} else {
			if (!isValidIdentifierPart(c)) {
				error.badChar = true;
				return;
			}
		}
		result.append(c);
	}
	
	/**
	 * Converts a string with valid or invalid escape sequences to a semantic value.
	 * If the escape sequences are invalid, a {@link ValueConverterException} is thrown
	 * with detailed information about the broken character combination.
	 */
	private static String doConvertFromJavaString(String identifier, int firstEscapeSequence, INode node) throws ValueConverterException {
		int length = identifier.length();
		StringBuilder result = new StringBuilder(length);
		result.append(identifier, 0, firstEscapeSequence);
		ErrorInfo errorInfo = new ErrorInfo();
		int nextIndex = firstEscapeSequence;
		while(nextIndex < length) {
			nextIndex = unescapeCharAndAppendTo(identifier, nextIndex, result, errorInfo);
		}
		
		String asString = result.toString();
		if (errorInfo.error) {
			throw new ValueConverterWithValueException("Illegal escape sequence in identifier '" + identifier + "'", node, asString, null);
		}
		if (errorInfo.badChar) {
			if (result.length() != 0)
				throw new ValueConverterWithValueException("Illegal character in identifier '" + asString + "' (" + identifier + ")", node, asString, null);
			else
				throw new ValueConverterWithValueException("Illegal character in identifier '" + identifier + "'", node, null, null);
		}
		return asString;
	}
	
	private static boolean isHexSequence(String in, int off, int chars) {
		for(int i = off; i < in.length() && i < off + chars; i++) {
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

}
