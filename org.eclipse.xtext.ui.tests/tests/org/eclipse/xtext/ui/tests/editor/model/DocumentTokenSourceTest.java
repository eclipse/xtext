/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentTokenSourceTest extends Assert {
	
	
	private DocumentTokenSource tokenSource;
	private Document document;
	
	@Before
	public void setUp() throws Exception {
		tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>() {
			@Override
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		document = new Document("");
		document.addDocumentListener(new IDocumentListener() {
			
			@Override
			public void documentChanged(DocumentEvent event) {
				tokenSource.updateStructure(event);
			}
			
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}
		});
	}
	
	
	@Test public void testInsertComment() throws Exception {
		document.set("bar 345 grammar : so 'baz & so'");
		IRegion region = tokenSource.getLastDamagedRegion();
		ArrayList<ILexerTokenRegion> list = Lists.newArrayList(tokenSource.getTokenInfos());
		document.replace(8, 7, "/*grammar*/");
		IRegion region2 = tokenSource.getLastDamagedRegion();
		assertTrue(!region.equals(region2));
		ArrayList<ILexerTokenRegion> list2 = Lists.newArrayList(tokenSource.getTokenInfos());
		assertTrue(!list.equals(list2));
	}

	@Test public void testConcurrentModification() throws Exception {
		document.set("foo bar");
		Iterator<ILexerTokenRegion> iterator = tokenSource.getTokenInfos().iterator();
		ILexerTokenRegion region = iterator.next();
		region = iterator.next();
		document.set("barfoo");
		region = iterator.next();
		assertEquals(3,region.getLength());
	}
	
}
