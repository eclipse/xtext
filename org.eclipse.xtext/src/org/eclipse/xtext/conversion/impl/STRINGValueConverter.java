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
		char[] in = literal.toCharArray();
		int off = 1;
		int len = literal.length() - 1;
		char[] convtBuf = new char[len];
		char aChar;
		char[] out = convtBuf;
		int outLen = 0;
		int end = off + len;

		String errorMessage = null;
		int errorIndex = -1;
		int errorLength = -1;
		while (off < end - 1) {
			aChar = in[off++];
			if (aChar == '\\') {
				if (off < end - 1) {
					aChar = in[off++];
					switch (aChar) {
						case 'u':
							// Try to read the xxxx
							int value = 0;
							if (off + 4 > end || !isHexSequence(in, off, 4)) {
								out[outLen++] = aChar;
								if (errorMessage == null) {
									errorMessage = "Invalid unicode";
									errorIndex = off - 2;
									errorLength = 2;
								}
								break;
							} else {
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
								break;
							}
						case 't':
							out[outLen++] = '\t';
							break;
						case 'r':
							out[outLen++] = '\r';
							break;
						case 'n':
							out[outLen++] = '\n';
							break;
						case 'f':
							out[outLen++] = '\f';
							break;
						case 'b':
							out[outLen++] = '\b';
							break;
						case '"':
							out[outLen++] = '"';
							break;
						case '\'':
							out[outLen++] = '\'';
							break;
						case '\\':
							out[outLen++] = '\\';
							break;
						default:
							if (errorMessage == null) {
								errorMessage = getInvalidEscapeSequenceMessage();
								errorIndex = off - 2;
								errorLength = 2;
							}
							out[outLen++] = aChar;
							break;
					}
				} else {
					if (errorMessage == null) {
						errorMessage = getInvalidEscapeSequenceMessage();
						errorIndex = off - 1;
						errorLength = 1;
					}
				}
			} else {
				out[outLen++] = aChar;
			}
		}
		if (off < end) {
			if (off != end - 1) {
				throw new IllegalStateException();
			}
			aChar = in[off];
			if (in[0] != in[off]) {
				out[outLen++] = aChar;
				if (errorMessage == null) {
					if (in[off] == '\\') {
						errorMessage = getInvalidEscapeSequenceMessage();
						errorIndex = off;
						errorLength = 1;
					} else {
						errorMessage = getStringNotClosedMessage();
					}
				} else {
					errorMessage = getStringNotClosedMessage();
					errorIndex = -1;
					errorLength = -1;
				}
			}
		}
		if (errorMessage != null) {
			throw new ValueConverterWithValueException(errorMessage, node, new String(out, 0, outLen), errorIndex,
					errorLength, null);
		}
		return new String(out, 0, outLen);
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