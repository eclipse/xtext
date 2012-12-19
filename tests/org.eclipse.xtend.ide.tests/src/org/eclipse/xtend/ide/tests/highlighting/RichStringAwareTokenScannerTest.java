/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareTokenScannerTest extends AbstractXtendUITestCase {

	private XtextDocument document;
	private ITokenScanner scanner;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		document = get(XtextDocument.class);
		scanner = get(ITokenScanner.class);
	}
	
	@Override
	public void tearDown() throws Exception {
		document = null;
		scanner = null;
		super.tearDown();
	}
	
	protected void initializeScanner(String input) {
		document.set(input);
		scanner.setRange(document, 0, input.length());
	}
	
	@Test public void testRichStringLiteral() {
		initializeScanner("'''foobar'''");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals("'''foobar'''".length(), scanner.getTokenLength());
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	@Test public void testRichStringStart() {
		initializeScanner("'''foobar«");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals("'''foobar".length(), scanner.getTokenLength());
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals("'''foobar".length(), scanner.getTokenOffset());
		assertEquals(1, scanner.getTokenLength());
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	@Test public void testRichStringEnd() {
		initializeScanner("»foobar'''");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals(1, scanner.getTokenLength());
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(1, scanner.getTokenOffset());
		assertEquals("foobar'''".length(), scanner.getTokenLength());
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	@Test public void testRichStringBetween_01() {
		initializeScanner("»«");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals(2, scanner.getTokenLength());
		assertSame(Token.EOF, scanner.nextToken());
	}
	
	@Test public void testRichStringBetween_02() {
		initializeScanner("»foobar«");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals(1, scanner.getTokenLength());
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(1, scanner.getTokenOffset());
		assertEquals("foobar".length(), scanner.getTokenLength());
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals("»foobar".length(), scanner.getTokenOffset());
		assertEquals(1, scanner.getTokenLength());
		assertSame(Token.EOF, scanner.nextToken());
	}
	
}
