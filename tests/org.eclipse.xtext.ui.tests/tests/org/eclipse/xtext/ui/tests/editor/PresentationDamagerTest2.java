/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.jface.text.Document;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource2;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class PresentationDamagerTest2 extends PresentationDamagerTest {
	
	@Override
	protected Document createDocument(String before) throws Exception {
		DocumentTokenSource source = new DocumentTokenSource2();
		source.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return createLexer();
			}
		});
		XtextDocument document = new XtextDocument(source, null);
		document.set(before);
		return document;
	}

	@Override
	public void testAddElement() throws Exception {
		assertEquals(4,12,check("foo bar",7,0," honolulu"));
	}
	
	@Override
	public void testBug279061() throws Exception {
		assertEquals(0,5, check("foo(x", 3, 2, "(x"));
	}
	
	@Override
	public void testRemoveFullElement() throws Exception {
		assertEquals(3,1,check("foo bar",4,3,""));
	}
}
