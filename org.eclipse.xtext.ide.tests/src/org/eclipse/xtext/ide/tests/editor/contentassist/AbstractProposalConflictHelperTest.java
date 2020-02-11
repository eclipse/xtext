/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.contentassist;

import static org.junit.Assert.*;

import org.eclipse.xtext.ide.editor.contentassist.ProposalConflictHelper;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.xtextgrammar.ide.XtextGrammarTestLanguageIdeInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextGrammarTestLanguageIdeInjectorProvider.class)
public abstract class AbstractProposalConflictHelperTest  {
	
	protected abstract ProposalConflictHelper helper();
	
	@Test public void testID_ID_01() {
		assertTrue(helper().existsConflict("foo", "bar", null));
	}
	
	@Test public void testID_ID_02() {
		assertTrue(helper().existsConflict("^foo", "bar", null));
	}
	
	@Test public void testID_ID_03() {
		assertFalse(helper().existsConflict("foo", "^bar", null));
	}
	
	@Test public void testID_ID_04() {
		assertFalse(helper().existsConflict("^foo", "^bar", null));
	}
	
	@Test public void testAlphaKeyword_ID_01() {
		assertTrue(helper().existsConflict("grammar", "foo", null));
	}
	
	@Test public void testAlphaKeyword_ID_02() {
		assertFalse(helper().existsConflict("grammar", "^foo", null));
	}
	
	@Test public void testID_AlphaKeyword() {
		assertTrue(helper().existsConflict("foo", "enum", null));
	}
	
	@Test public void testAlphaKeyword_AlphaKeyword() {
		assertTrue(helper().existsConflict("enum", "terminal", null));
	}
	
	@Test public void testBraceKeyword_ID() {
		assertFalse(helper().existsConflict("{", "foo", null));
	}
	
	@Test public void testID_BraceKeyword() {
		assertFalse(helper().existsConflict("foo", "{", null));
	}
	
	@Test public void testBraceKeyword_BraceKeyword() {
		assertFalse(helper().existsConflict("{", "{", null));
	}
	
	@Test public void testSTRING_STRING() {
		assertFalse(helper().existsConflict("'String'", "'String'", null));
	}
	
	@Test public void testSTRING_ID() {
		assertFalse(helper().existsConflict("'String'", "foo", null));
	}
	
	@Test public void testID_STRING() {
		assertFalse(helper().existsConflict("foo", "'String'", null));
	}

	@Test public void testID_INT() {
		assertTrue(helper().existsConflict("foo", "12", null));
	}

	@Test public void testINT_ID() {
		assertFalse(helper().existsConflict("11", "foo", null));
	}
	
	@Test public void testINT_INT() {
		assertTrue(helper().existsConflict("11", "13", null));
	}
	
	@Test public void testID_GrammarID() {
		assertTrue(helper().existsConflict("foo", "bar.zonk", null));
	}
	
	@Test public void testAlphaKeyword_GrammarID() {
		assertTrue(helper().existsConflict("grammar", "bar.zonk", null));
	}
	
	@Test public void testBraceKeyword_GrammarID() {
		assertFalse(helper().existsConflict("{", "bar.zonk", null));
	}
	
	@Test public void testGrammarID_ID() {
		assertTrue(helper().existsConflict("foo.bar", "zonk", null));
	}
	
	@Test public void testGrammarID_GrammarID() {
		assertTrue(helper().existsConflict("foo.bar", "zonk.stuff", null));
	}
}
