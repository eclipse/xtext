/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.highlighting;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareTokenScannerTest extends AbstractXtend2UITestCase {

	private XtextDocument document;
	private ITokenScanner scanner;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		document = get(XtextDocument.class);
		scanner = get(ITokenScanner.class);
	}
	
	protected void initializeScanner(String input) {
		document.set(input);
		scanner.setRange(document, 0, input.length());
	}
	
	public void testRichStringLiteral() {
		initializeScanner("'''foobar'''");
		assertNotSame(Token.EOF, scanner.nextToken());
		assertEquals(0, scanner.getTokenOffset());
		assertEquals("'''foobar'''".length(), scanner.getTokenLength());
	}
	
}
