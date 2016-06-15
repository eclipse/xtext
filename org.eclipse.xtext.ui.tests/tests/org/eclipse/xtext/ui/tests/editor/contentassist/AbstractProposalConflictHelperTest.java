/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.contentassist.ProposalConflictHelper;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.XtextGrammarUiTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.XtextGrammarUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.ui.XtextGrammarUiTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractProposalConflictHelperTest extends AbstractXtextTests {

	private ProposalConflictHelper helper;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(getXtextGrammarTestSetup());
		helper = createProposalConflictHelper();
	}
	
	public ISetup getXtextGrammarTestSetup() {
		return new XtextGrammarUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new XtextGrammarUiTestLanguageRuntimeModule(),
						new XtextGrammarUiTestLanguageUiModule(Activator.getInstance()),
						new SharedStateModule()));
			}
		};
	}
	
	protected abstract ProposalConflictHelper createProposalConflictHelper();

	@Override
	public void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}
	
	@Test public void testID_ID_01() {
		assertTrue(helper.existsConflict("foo", "bar", null));
	}
	
	@Test public void testID_ID_02() {
		assertTrue(helper.existsConflict("^foo", "bar", null));
	}
	
	@Test public void testID_ID_03() {
		assertFalse(helper.existsConflict("foo", "^bar", null));
	}
	
	@Test public void testID_ID_04() {
		assertFalse(helper.existsConflict("^foo", "^bar", null));
	}
	
	@Test public void testAlphaKeyword_ID_01() {
		assertTrue(helper.existsConflict("grammar", "foo", null));
	}
	
	@Test public void testAlphaKeyword_ID_02() {
		assertFalse(helper.existsConflict("grammar", "^foo", null));
	}
	
	@Test public void testID_AlphaKeyword() {
		assertTrue(helper.existsConflict("foo", "enum", null));
	}
	
	@Test public void testAlphaKeyword_AlphaKeyword() {
		assertTrue(helper.existsConflict("enum", "terminal", null));
	}
	
	@Test public void testBraceKeyword_ID() {
		assertFalse(helper.existsConflict("{", "foo", null));
	}
	
	@Test public void testID_BraceKeyword() {
		assertFalse(helper.existsConflict("foo", "{", null));
	}
	
	@Test public void testBraceKeyword_BraceKeyword() {
		assertFalse(helper.existsConflict("{", "{", null));
	}
	
	@Test public void testSTRING_STRING() {
		assertFalse(helper.existsConflict("'String'", "'String'", null));
	}
	
	@Test public void testSTRING_ID() {
		assertFalse(helper.existsConflict("'String'", "foo", null));
	}
	
	@Test public void testID_STRING() {
		assertFalse(helper.existsConflict("foo", "'String'", null));
	}

	@Test public void testID_INT() {
		assertTrue(helper.existsConflict("foo", "12", null));
	}

	@Test public void testINT_ID() {
		assertFalse(helper.existsConflict("11", "foo", null));
	}
	
	@Test public void testINT_INT() {
		assertTrue(helper.existsConflict("11", "13", null));
	}
	
	@Test public void testID_GrammarID() {
		assertTrue(helper.existsConflict("foo", "bar.zonk", null));
	}
	
	@Test public void testAlphaKeyword_GrammarID() {
		assertTrue(helper.existsConflict("grammar", "bar.zonk", null));
	}
	
	@Test public void testBraceKeyword_GrammarID() {
		assertFalse(helper.existsConflict("{", "bar.zonk", null));
	}
	
	@Test public void testGrammarID_ID() {
		assertTrue(helper.existsConflict("foo.bar", "zonk", null));
	}
	
	@Test public void testGrammarID_GrammarID() {
		assertTrue(helper.existsConflict("foo.bar", "zonk.stuff", null));
	}
}
