/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.hyperlinking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.common.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HyperlinkHelperTest extends AbstractXtextTests {

	private ISetup getSetup() {
		return new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.XtextUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	private HyperlinkHelper helper;
	private XtextResource resource;
	private Grammar grammar;
	private Grammar terminalGrammar;
	private String model;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(getSetup());
		helper = get(HyperlinkHelper.class);
		model = "grammar org.eclipse.xtext.ui.common.HyperlinkTest with org.eclipse.xtext.common.Terminals\n" +
				"generate hyperlinkTest 'http://www.eclipse.org/Xtext/2008/HyperlinkTest'\n" +
				"Model: name=STRING;";
		resource = getResourceFromString(model);
		grammar = (Grammar) resource.getContents().get(0);
		terminalGrammar = grammar.getUsedGrammars().get(0);
		terminalGrammar.eResource().unload();
	}

	@Override
	protected void tearDown() throws Exception {
		resource = null;
		helper = null;
		grammar = null;
		terminalGrammar = null;
		model = null;
		super.tearDown();
	}

	public void testSetup() {
		assertTrue(resource.getErrors().isEmpty());
		assertNull(terminalGrammar.eResource());
		assertTrue(terminalGrammar.eIsProxy());
		assertNotNull(helper);
	}

	public void testCreateHyperlinksByOffset() {
		IHyperlink[] links = helper.createHyperlinksByOffset(resource, model.indexOf("common.Terminals"), true);
		assertNotNull(links);
		assertEquals(1, links.length);
		assertTrue(links[0] instanceof XtextHyperlink);
		checkHyperlink((XtextHyperlink) links[0]);
	}

	private void checkHyperlink(XtextHyperlink action) {
		assertNotNull(action);
		URI uri = action.getURI();
		assertNotNull(uri);
		assertFalse(ClasspathUriUtil.isClasspathUri(uri));
		assertTrue(ClasspathUriUtil.isClasspathUri(EcoreUtil.getURI(terminalGrammar)));
		EObject obj = grammar.eResource().getResourceSet().getEObject(uri, true);
		assertNotNull(obj);
		Grammar terminalGrammar = grammar.getUsedGrammars().get(0);
		assertFalse(terminalGrammar.eIsProxy());
		assertEquals(terminalGrammar, obj);
	}

//	public void testGetOpenDeclarationAction() {
//		OpenDeclarationAction action = helper.getOpenDeclarationAction(resource, model.indexOf("common.Terminals"));
//		checkHyperlink(action);
//	}

}
