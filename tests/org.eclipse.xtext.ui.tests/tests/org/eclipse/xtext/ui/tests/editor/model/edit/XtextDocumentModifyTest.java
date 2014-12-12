/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class XtextDocumentModifyTest extends AbstractXtextTests {

	private Resource resource;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test public void testProcess() throws Exception {
		String grammar = "grammar foo.Foo " + "generate foo \"foo://foo/42\" " + "Foo: \"foo\" | \"bar\" | \"baz\"; "
				+ "Bar: foo=Foo;";
		IXtextDocument document = createDocument(grammar);
		
		final Object expected = resource.getContents().get(0);
		Object result = document.modify(new IUnitOfWork<Object, XtextResource>() {
			@Override
			public Object exec(XtextResource state) throws Exception {
				assertEquals(resource, state);
				Grammar grammar = (Grammar) state.getContents().get(0);
				grammar.setName("foo.Bar");
				return grammar;
			}
		});

		assertEquals(expected, result);
		assertEquals(grammar.replaceFirst("foo\\.Foo", "foo.Bar"), document.get());
	}

	@Test public void testCommentsNotDuplicated() throws Exception {
		String grammar = "grammar foo.Foo\n" 
			+ "generate foo \"http://foo.net/foo\"\n" 
			+ "Foo: // comment in Foo \n"
			+ "// comment before Assignment\n"
			+ "  bars+=/* comment in assignment */Bar // comment after assignment\n"
			+ "// comment before keywod\n"
			+ "'foo';\n" 
			+ "Bar: 'bar';";
		IXtextDocument document = createDocument(grammar);
		document.modify(new IUnitOfWork<Object, XtextResource>() {
			@Override
			public Object exec(XtextResource state) throws Exception {
				assertEquals(resource, state);
				Grammar grammar = (Grammar) state.getContents().get(0);
				Group group = (Group) grammar.getRules().get(0).getAlternatives();
				Assignment assignment = (Assignment) group.getElements().get(0);
				assignment.setFeature("foobars");
				return grammar;
			}
		});
		assertEquals(grammar.replace("bars", "foobars"), document.get());
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=406811
	@Test public void testSemanticModification() throws Exception {
		String grammar = "grammar foo.Foo\n" 
				+ "generate foo \"http://foo.net/foo\"\n"
				+ "Foo: 'foo';"; 
		IXtextDocument document = createDocument(grammar);
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				Grammar grammar = (Grammar) state.getContents().get(0);
				grammar.setName("foo.Bar");
			}
		});
		assertEquals(grammar.replace("foo.Foo", "foo.Bar"), document.get());
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=406811
	@Test public void testTextualModification() throws Exception {
		final String grammar = "grammar foo.Foo\n" 
				+ "generate foo \"http://foo.net/foo\"\n"
				+ "Foo: 'foo';"; 
		final IXtextDocument document = createDocument(grammar);
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				document.replace(grammar.indexOf("Foo"), 3, "Bar");
			}
		});
		assertEquals(grammar.replace("foo.Foo", "foo.Bar"), document.get());
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=406811
	@Test public void testSemanticAndTextualModification() throws Exception {
		final String grammar = "grammar foo.Foo\n" 
				+ "generate foo \"http://foo.net/foo\"\n"
				+ "Foo: 'foo';"; 
		final IXtextDocument document = createDocument(grammar);
		try {
			document.modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					document.replace(grammar.indexOf("Foo"), 3, "Bar");
					Grammar grammar = (Grammar) state.getContents().get(0);
					grammar.getRules().get(0).setName("Bar");
				}
			});
			fail("Expected exception");
		} catch(RuntimeException e) {
			assertTrue(e.getMessage().contains("Cannot modify document textually and semantically"));
			assertEquals(grammar, document.get());
		}
	}
	
	private IXtextDocument createDocument(String model) throws Exception {
		resource = getResource(new StringInputStream(model));
		DocumentTokenSource tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>(){
			@Override
			public Lexer get() {
				return new InternalXtextLexer();
			}});
		
		final XtextDocument document = new XtextDocument(tokenSource, get(ITextEditComposer.class), new OutdatedStateManager(), new OperationCanceledManager()) {
			@Override
			public <T> T internalModify(IUnitOfWork<T, XtextResource> work) {
				try {
					return work.exec((XtextResource) resource);
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		document.set(model);
		return document;
	}
}
