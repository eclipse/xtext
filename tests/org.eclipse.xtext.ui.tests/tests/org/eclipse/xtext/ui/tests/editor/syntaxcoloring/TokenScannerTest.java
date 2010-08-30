/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentToken;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TokenScanner;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenScannerTest extends TestCase {

	public void testFullRange() throws Exception {
		TokenScanner scanner = getTokenScanner(3, 4, 3, 2);
		scanner.setRange(null, 0, 12);

		scanner.nextToken();
		assertEquals(3, scanner.getTokenLength());
		assertEquals(0, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(4, scanner.getTokenLength());
		assertEquals(3, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(3, scanner.getTokenLength());
		assertEquals(7, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(2, scanner.getTokenLength());
		assertEquals(10, scanner.getTokenOffset());
		assertEquals(Token.EOF, scanner.nextToken());
	}
	
	public void testBeginning() throws Exception {
		TokenScanner scanner = getTokenScanner(3, 4, 3, 2);
		scanner.setRange(null, 0, 7);
		
		scanner.nextToken();
		assertEquals(3, scanner.getTokenLength());
		assertEquals(0, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(4, scanner.getTokenLength());
		assertEquals(3, scanner.getTokenOffset());
		assertEquals(Token.EOF, scanner.nextToken());
	}
	
	public void testMidRange() throws Exception {
		TokenScanner scanner = getTokenScanner(3, 4, 3, 2);
		scanner.setRange(null, 3, 7);
		
		scanner.nextToken();
		assertEquals(4, scanner.getTokenLength());
		assertEquals(3, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(3, scanner.getTokenLength());
		assertEquals(7, scanner.getTokenOffset());
		assertEquals(Token.EOF, scanner.nextToken());
	}
	
	public void testTrailingRange() throws Exception {
		TokenScanner scanner = getTokenScanner(3, 4, 3, 2);
		scanner.setRange(null, 7, 5);
		
		scanner.nextToken();
		assertEquals(3, scanner.getTokenLength());
		assertEquals(7, scanner.getTokenOffset());
		scanner.nextToken();
		assertEquals(2, scanner.getTokenLength());
		assertEquals(10, scanner.getTokenOffset());
		assertEquals(Token.EOF, scanner.nextToken());
	}

	public TokenScanner getTokenScanner(int... lengths) throws Exception {
		final List<IXtextDocumentToken> tokens = Lists.newArrayList();
		for (final int length : lengths) {
			tokens.add(new IXtextDocumentToken() {

				public int getLength() {
					return length;
				}

				public int getAntlrTokenType() {
					return 4711;
				}
			});
		}
		TokenScanner tokenScanner = new TokenScanner() {
			@Override
			protected List<? extends IXtextDocumentToken> getTokens(IDocument document) {
				return tokens;
			}
			
			@Override
			protected IToken createToken() {
				return Token.UNDEFINED;
			}
		};
		return tokenScanner;

	}
}
