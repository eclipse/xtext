/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.PresentationDamager;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow
 */
public class DamagerRepairerPerformanceTest extends Assert implements ITokenScanner {

	private static final int MAX = 5000;
	private IPresentationDamager damager;
	
	@Before
	public void setUp() throws Exception {
		damager = createRegionDamager();
	}
	
	@After
	public void tearDown() throws Exception {
		damager = null;
	}
	
	protected class Tester implements IDocumentListener {
	
		protected IRegion lastRegion;
		private final IPresentationDamager damager;
		private Document doc;
		
		protected Tester(IPresentationDamager damager) {
			this.damager = damager;
			doc = createDocument("");
			damager.setDocument(doc);
			doc.addDocumentListener(this);
		}
		
		protected Document createDocument(String before) {
			DocumentTokenSource source = new DocumentTokenSource();
			source.setLexer(new Provider<Lexer>() {
				@Override
				public Lexer get() {
					return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
				}
			});
			XtextDocument document = new XtextDocument(source, null, new OutdatedStateManager(), new OperationCanceledManager());
			document.set(before);
			return document;
		}
		
		protected void appendAndCheck(String text) throws BadLocationException {
			int offset = doc.getLength();
			doc.replace(offset, 0, text);
			assertEquals(Math.max(0, offset - 1), Math.min(doc.getLength(), text.length() + 1));
		}
		
		protected void insertAndCheck(String text, int offset) throws BadLocationException {
			doc.replace(offset, 0, text);
			assertEquals(Math.max(0, offset - 1), Math.min(doc.getLength(), text.length() + 1));
		}
		
		protected void prependAndCheck(String text) throws BadLocationException {
			doc.replace(0, 0, text);
			assertEquals(0, Math.min(text.length(), doc.getLength()));
		}
		
		@Override
		public void documentChanged(DocumentEvent event) {
			lastRegion = damager.getDamageRegion(new TypedRegion(0,event.getDocument().getLength(), IDocument.DEFAULT_CONTENT_TYPE), event, false);
		}

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {
		}
		
		protected void assertEquals(int expStart, int expLength) {
			Assert.assertEquals("offset", expStart, lastRegion.getOffset());
			Assert.assertEquals("length", expLength, lastRegion.getLength());
		}
	}
	
	@Test public void testAppend() throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < MAX; i++) {
			tester.appendAndCheck("abc ");
		}
	}
	
	@Test public void testAppend2() throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < MAX; i++) {
			tester.appendAndCheck("abc ");
		}
	}
	
	@Test public void testInsert() throws BadLocationException {
		Tester tester = new Tester(damager);
		tester.insertAndCheck("abc ", 0);
		int offset = tester.doc.getLength();
		for(int i = 0; i < MAX; i++) {
			tester.insertAndCheck("abc ", offset);
		}
	}
	
	@Test public void testInsert2() throws BadLocationException {
		Tester tester = new Tester(damager);
		tester.insertAndCheck("abc ", 0);
		int offset = tester.doc.getLength();
		for(int i = 0; i < MAX; i++) {
			tester.insertAndCheck("abc ", offset);
		}
	}
	
	@Test public void testPrepend() throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < MAX; i++) {
			tester.prependAndCheck("abc ");
		}
	}
	
	@Test public void testPrepend2() throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < MAX; i++) {
			tester.prependAndCheck("abc ");
		}
	}
	
	protected IPresentationDamager createRegionDamager() {
		return new PresentationDamager();
	}
	
	@Override
	public void setRange(IDocument document, int offset, int length) {
	}

	@Override
	public IToken nextToken() {
		return null;
	}

	@Override
	public int getTokenOffset() {
		return 0;
	}

	@Override
	public int getTokenLength() {
		return 0;
	}
}
