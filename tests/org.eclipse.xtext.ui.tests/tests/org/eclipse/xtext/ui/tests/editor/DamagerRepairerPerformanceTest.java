/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.FastDamagerRepairer;
import org.eclipse.xtext.ui.editor.XtextDamagerRepairer;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("deprecation")
public class DamagerRepairerPerformanceTest extends TestCase implements ITokenScanner {

	private IPresentationDamager xtextDamager;
	private IPresentationDamager fastDamager;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		xtextDamager = createXtextRegionDamager();
		fastDamager = createFastRegionDamager();
	}
	
	@Override
	protected void tearDown() throws Exception {
		xtextDamager = null;
		fastDamager = null;
		super.tearDown();
	}
	
	protected class Tester implements IDocumentListener {
	
		protected IRegion lastRegion;
		private final IPresentationDamager damager;
		private Document doc;
		
		protected Tester(IPresentationDamager damager) {
			this.damager = damager;
			doc = new Document("");
			damager.setDocument(doc);
			doc.addDocumentListener(this);
		}
		
		protected void appendAndCheck(String text, int offsetFix) throws BadLocationException {
			int offset = doc.getLength();
			doc.replace(offset, 0, text);
			assertEquals(Math.max(0, offset + offsetFix), Math.min(doc.getLength(), text.length() - offsetFix));
		}
		
		protected void prependAndCheck(String text, int lengthFix) throws BadLocationException {
			doc.replace(0, 0, text);
			assertEquals(0, Math.min(text.length() + lengthFix, doc.getLength()));
		}
		
		public void documentChanged(DocumentEvent event) {
			lastRegion = damager.getDamageRegion(null, event, false);
		}

		public void documentAboutToBeChanged(DocumentEvent event) {
		}
		
		protected void assertEquals(int expStart, int expLength) {
			Assert.assertEquals("offset", expStart, lastRegion.getOffset());
			Assert.assertEquals("length", expLength, lastRegion.getLength());
		}
	}
	
	public void testAppendWithFastDamagerRepairer() throws BadLocationException {
		doTestAppend(fastDamager, 0);
	}
	
	public void testAppendWithXtextDamagerRepairer() throws BadLocationException {
		doTestAppend(xtextDamager, -1);
	}
	
	public void testPrependWithFastDamagerRepairer() throws BadLocationException {
		doTestPrepend(fastDamager, 0);
	}
	
	public void testPrependWithXtextDamagerRepairer() throws BadLocationException {
		doTestPrepend(xtextDamager, 3);
	}
	
	protected void doTestAppend(IPresentationDamager damager, int offsetFix) throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < 2000; i++) {
			tester.appendAndCheck("abc ", offsetFix);
		}
	}
	
	protected void doTestPrepend(IPresentationDamager damager, int lengthFix) throws BadLocationException {
		Tester tester = new Tester(damager);
		for(int i = 0; i < 2000; i++) {
			tester.prependAndCheck("abc ", lengthFix);
		}
	}
	
	protected IPresentationDamager createXtextRegionDamager() {
		XtextDamagerRepairer repairer = new XtextDamagerRepairer(this, new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		return repairer;
	}
	
	protected IPresentationDamager createFastRegionDamager() {
		FastDamagerRepairer result = new FastDamagerRepairer(this, new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		return result;
	}
	
	public void setRange(IDocument document, int offset, int length) {
	}

	public IToken nextToken() {
		return null;
	}

	public int getTokenOffset() {
		return 0;
	}

	public int getTokenLength() {
		return 0;
	}
}
