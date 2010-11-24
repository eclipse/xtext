/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;

/**
 * Unit test for <code>ParseTreeUtil</code>.
 *
 * @author Michael Clay - Initial contribution and API
 * @see ParseTreeUtil
 */
public class ParseTreeUtilTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}

	public void testGetLastCompleteNodeByOffset() throws Exception {
		String text = "spielplatz 1 \"junit\" {  ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		assertTrue("expect leafnode as last complete element", lastCompleteNodeByOffset instanceof LeafNode);
		assertEquals("expect leafnode with text '{'", ((LeafNode) lastCompleteNodeByOffset).getText(), "{");
	}

	public void testGetLastCompleteNodeByOffset2() throws Exception {
		String text = "spielplatz 1 \"junit\" {";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		assertTrue("expect leafnode as last complete element", lastCompleteNodeByOffset instanceof LeafNode);
		assertEquals("expect leafnode with text '{'", ((LeafNode) lastCompleteNodeByOffset).getText(), "{");
	}

}
