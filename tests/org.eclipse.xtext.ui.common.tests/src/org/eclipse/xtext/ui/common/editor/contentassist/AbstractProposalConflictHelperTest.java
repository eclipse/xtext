/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AntlrProposalConflictHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractProposalConflictHelperTest extends AbstractXtextTests {

	private IContentAssistProcessorTestSetup setup;
	private ProposalConflictHelper helper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setup = new JavaContentAssistProcessorTestSetup();
		with(setup.getXtextGrammarTestSetup());
		helper = createProposalConflictHelper();
	}
	
	protected abstract ProposalConflictHelper createProposalConflictHelper();

	@Override
	protected void tearDown() throws Exception {
		setup = null;
		helper = null;
		super.tearDown();
	}
	
	public void testID_ID_01() {
		assertTrue(helper.existsConflict("foo", "bar"));
	}
	
	public void testID_ID_02() {
		assertTrue(helper.existsConflict("^foo", "bar"));
	}
	
	public void testID_ID_03() {
		assertFalse(helper.existsConflict("foo", "^bar"));
	}
	
	public void testID_ID_04() {
		assertFalse(helper.existsConflict("^foo", "^bar"));
	}
	
	public void testAlphaKeyword_ID_01() {
		assertTrue(helper.existsConflict("grammar", "foo"));
	}
	
	public void testAlphaKeyword_ID_02() {
		assertFalse(helper.existsConflict("grammar", "^foo"));
	}
	
	public void testID_AlphaKeyword() {
		assertTrue(helper.existsConflict("foo", "enum"));
	}
	
	public void testAlphaKeyword_AlphaKeyword() {
		assertTrue(helper.existsConflict("enum", "terminal"));
	}
	
	public void testBraceKeyword_ID() {
		assertFalse(helper.existsConflict("{", "foo"));
	}
	
	public void testID_BraceKeyword() {
		assertFalse(helper.existsConflict("foo", "{"));
	}
	
	public void testBraceKeyword_BraceKeyword() {
		assertFalse(helper.existsConflict("{", "{"));
	}
	
	public void testSTRING_STRING() {
		assertFalse(helper.existsConflict("'String'", "'String'"));
	}
	
	public void testSTRING_ID() {
		assertFalse(helper.existsConflict("'String'", "foo"));
	}
	
	public void testID_STRING() {
		assertFalse(helper.existsConflict("foo", "'String'"));
	}

	public void testID_INT() {
		assertTrue(helper.existsConflict("foo", "12"));
	}

	public void testINT_ID() {
		assertFalse(helper.existsConflict("11", "foo"));
	}
	
	public void testINT_INT() {
		assertTrue(helper.existsConflict("11", "13"));
	}
	
	public void testID_GrammarID() {
		assertTrue(helper.existsConflict("foo", "bar.zonk"));
	}
	
	public void testAlphaKeyword_GrammarID() {
		assertTrue(helper.existsConflict("grammar", "bar.zonk"));
	}
	
	public void testBraceKeyword_GrammarID() {
		assertFalse(helper.existsConflict("{", "bar.zonk"));
	}
	
	public void testGrammarID_ID() {
		assertTrue(helper.existsConflict("foo.bar", "zonk"));
	}
	
	public void testGrammarID_GrammarID() {
		assertTrue(helper.existsConflict("foo.bar", "zonk.stuff"));
	}
	
	public static class Antlr extends AbstractProposalConflictHelperTest {

		@Override
		protected ProposalConflictHelper createProposalConflictHelper() {
			return get(AntlrProposalConflictHelper.class);
		}
		
	}
}
