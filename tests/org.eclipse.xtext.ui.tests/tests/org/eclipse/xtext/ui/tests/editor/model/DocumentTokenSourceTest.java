/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentTokenSourceTest extends TestCase {
	
	
	private DocumentTokenSource tokenSource;
	private Document document;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		document = new Document("");
		document.addDocumentListener(new IDocumentListener() {
			
			public void documentChanged(DocumentEvent event) {
				tokenSource.updateStructure(event);
			}
			
			public void documentAboutToBeChanged(DocumentEvent event) {
			}
		});
	}

	public void testConcurrentModification() throws Exception {
		document.set("foo bar");
		Iterator<ILexerTokenRegion> iterator = tokenSource.getTokenInfos().iterator();
		ILexerTokenRegion region = iterator.next();
		region = iterator.next();
		document.set("barfoo");
		region = iterator.next();
		assertEquals(3,region.getLength());
	}
	
}
