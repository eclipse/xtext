/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model.edit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultDocumentEditorTest extends AbstractXtextTests {

	private IDocumentEditor editor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		editor = get(IDocumentEditor.class);
	}

	public void testProcess() throws Exception {
		String grammar = "grammar foo.Foo " + "generate foo \"foo://foo/42\" " + "Foo: \"foo\" | \"bar\" | \"baz\"; "
				+ "Bar: foo=Foo; ";
		final Resource res = getResource(new StringInputStream(grammar));
		final Object expected = res.getContents().get(0);
		final IXtextDocument document = new XtextDocument() {
			@Override
			public <T> T modify(IUnitOfWork<T, XtextResource> work) {
				try {
					return work.exec((XtextResource) res);
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		document.set(grammar);

		Object result = editor.process(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				assertEquals(res, state);
				Grammar grammar = (Grammar) state.getContents().get(0);
				grammar.setName("foo.Bar");
				return grammar;
			}
		}, document);

		assertEquals(expected, result);
		assertEquals(grammar.replaceFirst("foo\\.Foo", "foo.Bar"), document.get());
	}

}
