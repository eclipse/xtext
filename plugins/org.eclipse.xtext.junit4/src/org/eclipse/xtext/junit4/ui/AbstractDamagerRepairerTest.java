/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

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
import org.eclipse.xtext.ui.editor.PresentationDamager;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractDamagerRepairerTest extends Assert implements IDocumentListener, ITokenScanner {

	private IPresentationDamager damager;
	
	protected IRegion lastRegion;
	
	@Before
	public void setUp() throws Exception {
		damager = createRegionDamager();
	}
	
	@After
	public void tearDown() throws Exception {
		damager = null;
		lastRegion = null;
	}
	
	protected IRegion check(String before, int start, int replaceLength, String text) throws Exception {
		Document doc = createDocument(before);
		damager.setDocument(doc);
		doc.addDocumentListener(this);
		doc.replace(start, replaceLength, text);
		return lastRegion;
	}

	protected IPresentationDamager createRegionDamager() {
		return new PresentationDamager();
	}

	protected abstract Lexer createLexer();
	
	protected Document createDocument(String before) throws Exception {
		DocumentTokenSource source = new DocumentTokenSource();
		source.setLexer(new Provider<Lexer>() {
			public Lexer get() {
				return createLexer();
			}
		});
		XtextDocument document = new XtextDocument(source, null);
		document.set(before);
		return document;
	}
	
	protected void assertEquals(int expStart, int expLength, IRegion actual) {
		assertEquals("offset", expStart, actual.getOffset());
		assertEquals("length", expLength, actual.getLength());
	}
	
	public void documentChanged(DocumentEvent event) {
		lastRegion = damager.getDamageRegion(new TypedRegion(0,event.getDocument().getLength(), IDocument.DEFAULT_CONTENT_TYPE), event, false);
	}

	public void documentAboutToBeChanged(DocumentEvent event) {
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
