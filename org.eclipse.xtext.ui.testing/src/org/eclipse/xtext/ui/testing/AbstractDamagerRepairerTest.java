/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 * 
 * @since 2.12
 */
public abstract class AbstractDamagerRepairerTest extends Assert implements IDocumentListener, ITokenScanner {

	private IPresentationDamager damager;
	
	protected IRegion lastRegion;
	
	protected OutdatedStateManager outdatedStateManager = new OutdatedStateManager();

	protected OperationCanceledManager operationCanceledManager = new OperationCanceledManager(); 
	
	@Before @BeforeEach
	public void setUp() throws Exception {
		damager = createRegionDamager();
	}
	
	@After @AfterEach
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
			@Override
			public Lexer get() {
				return createLexer();
			}
		});
		XtextDocument document = new XtextDocument(source, null, outdatedStateManager, operationCanceledManager);
		document.set(before);
		return document;
	}
	
	protected void assertEquals(int expStart, int expLength, IRegion actual) {
		assertEquals("offset", expStart, actual.getOffset());
		assertEquals("length", expLength, actual.getLength());
	}
	
	@Override
	public void documentChanged(DocumentEvent event) {
		lastRegion = damager.getDamageRegion(new TypedRegion(0,event.getDocument().getLength(), IDocument.DEFAULT_CONTENT_TYPE), event, false);
	}

	@Override
	public void documentAboutToBeChanged(DocumentEvent event) {
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
