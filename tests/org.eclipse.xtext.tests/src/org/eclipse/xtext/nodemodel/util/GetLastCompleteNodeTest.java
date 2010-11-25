/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class GetLastCompleteNodeTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}

	public void testGetLastCompleteNodeByOffset() throws Exception {
		String text = "spielplatz 1 \"junit\" {  ";
		ICompositeNode rootNode = getRootNodeAndExpect(text, 1);
		INode lastCompleteNodeByOffset = NodeModelUtils.getLastCompleteNodeByOffset(rootNode, text.length());
		assertTrue("expect leafnode as last complete element", lastCompleteNodeByOffset instanceof ILeafNode);
		assertEquals("expect leafnode with text '{'", ((ILeafNode) lastCompleteNodeByOffset).getText(), "{");
	}

	public void testGetLastCompleteNodeByOffset2() throws Exception {
		String text = "spielplatz 1 \"junit\" {";
		ICompositeNode rootNode = getRootNodeAndExpect(text, 1);
		INode lastCompleteNodeByOffset = NodeModelUtils.getLastCompleteNodeByOffset(rootNode, text.length());
		assertTrue("expect leafnode as last complete element", lastCompleteNodeByOffset instanceof ILeafNode);
		assertEquals("expect leafnode with text '{'", ((ILeafNode) lastCompleteNodeByOffset).getText(), "{");
	}

}
