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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultDocumentEditorTest extends AbstractXtextTests {

	private IDocumentEditor editor;
	private Resource resource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		editor = get(IDocumentEditor.class);
	}

	public void testProcess() throws Exception {
		String grammar = "grammar foo.Foo " + "generate foo \"foo://foo/42\" " + "Foo: \"foo\" | \"bar\" | \"baz\"; "
				+ "Bar: foo=Foo;";
		IXtextDocument document = createDocument(grammar);
		
		final Object expected = resource.getContents().get(0);
		Object result = editor.process(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				assertEquals(resource, state);
				Grammar grammar = (Grammar) state.getContents().get(0);
				grammar.setName("foo.Bar");
				return grammar;
			}
		}, document);

		assertEquals(expected, result);
		assertEquals(grammar.replaceFirst("foo\\.Foo", "foo.Bar"), document.get());
	}

	public void testCommentsNotDuplicated() throws Exception {
		String grammar = "grammar foo.Foo\n" 
			+ "generate foo \"http://foo.net/foo\"\n" 
			+ "Foo: // comment in Foo \n"
			+ "// comment before Assignment\n"
			+ "  bars+=/* comment in assignment */Bar // comment after assignment\n"
			+ "// comment before keywod\n"
			+ "'foo';\n" 
			+ "Bar: 'bar';";
		IXtextDocument document = createDocument(grammar);
		editor.process(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				assertEquals(resource, state);
				Grammar grammar = (Grammar) state.getContents().get(0);
				Group group = (Group) grammar.getRules().get(0).getAlternatives();
				Assignment assignment = (Assignment) group.getElements().get(0);
				assignment.setFeature("foobars");
				return grammar;
			}
		}, document);
		assertEquals(grammar.replace("bars", "foobars"), document.get());
	}
	
	private IXtextDocument createDocument(String model) throws Exception {
		resource = getResource(new StringInputStream(model));
		final IXtextDocument document = new XtextDocument() {
			@Override
			public <T> T modify(IUnitOfWork<T, XtextResource> work) {
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
