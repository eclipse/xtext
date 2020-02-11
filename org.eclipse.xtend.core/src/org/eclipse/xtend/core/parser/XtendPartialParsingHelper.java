/*******************************************************************************
 * Copyright (c) 2008-2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.Token;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.xbase.parser.TokenSequencePreservingPartialParsingHelper;

import com.google.inject.Inject;

/**
 * A customized partial parsing helper that falls eagerly back to a full parse
 * as soon as the new token sequence would be different from the old one.
 * This approach allows to benefit from partial parsing whenever a token content
 * is edited (e.g. the content of a comment, identifier or string literal)
 * while not producing bogus lookahead information.
 * 
 * Mostly copied and refactored from the default implementation.
 * 
 * @author Sebastian Zarnekow
 */
public class XtendPartialParsingHelper extends TokenSequencePreservingPartialParsingHelper {

	@Inject
	private FlexerFactory flexerFactory;

	@Override
	protected boolean isSameTokenSequence(String originalText, String newText, int expectedLength) {
		try {
			InternalFlexer originalSequence = flexerFactory.createFlexer(new StringReader(originalText));
			InternalFlexer newSequence = flexerFactory.createFlexer(new StringReader(newText));
			int token = originalSequence.advance();
			int newLength = 0;
			while(token != Token.EOF) {
				if (token != newSequence.advance()) {
					return false;
				}
				newLength += newSequence.getTokenLength();
				token = originalSequence.advance();
			}
			return newLength == expectedLength;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}