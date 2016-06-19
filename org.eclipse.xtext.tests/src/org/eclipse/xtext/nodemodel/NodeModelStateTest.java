/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelStateTest extends AbstractXtextTests {

	private INode rootNode;

	private INode kindLeaf;

	private INode kindNode;

	private INode hiddenLeaf;

	private String model;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		model = "// comment before root\n" +
				"\n" +
				"  spielplatz 0 \"Rummel\" {\n" +
				"    // comment belongs to next composite\n" +
				"    kind // inner comment\n" +
				"      ( Bob 1) // trailing comment\n" +
				"    // comment in next line\n" +
				"  }\n" +
				"// comment after root\n";
		rootNode = getRootNode(model);
		kindLeaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, model.indexOf("kind") + 1);
		hiddenLeaf = kindLeaf.getNextSibling();
		kindNode = kindLeaf.getParent();
	}

	@Test public void testRootGetOffset() {
		assertEquals(model.indexOf("spielplatz"), rootNode.getOffset());
	}

	@Test public void testRootGetTotalOffset() {
		assertEquals(0, rootNode.getTotalOffset());
	}

	@Test public void testRootGetLength() {
		assertEquals(model.indexOf('}') - model.indexOf("spielplatz") + 1, rootNode.getLength());
	}

	@Test public void testRootGetTotalLength() {
		assertEquals(model.length(), rootNode.getTotalLength());
	}

	@Test public void testRootGetLine() {
		assertEquals(3, rootNode.getStartLine());
	}

	@Test public void testRootGetTotalLine() {
		assertEquals(1, rootNode.getTotalStartLine());
	}

	@Test public void testRootEndLine() {
		assertEquals(8, rootNode.getEndLine());
	}

	@Test public void testRootTotalEndLine() {
		assertEquals(10, rootNode.getTotalEndLine());
	}

	@Test public void testCompositeGetOffset() {
		assertEquals(model.indexOf("kind"), kindNode.getOffset());
	}

	@Test public void testCompositeGetTotalOffset() {
		assertEquals(model.indexOf("{") + 1, kindNode.getTotalOffset());
	}

	@Test public void testCompositeGetLength() {
		assertEquals(model.indexOf(')') - model.indexOf("kind") + 1, kindNode.getLength());
	}

	@Test public void testCompositeGetTotalLength() {
		assertEquals(model.indexOf(')') - model.indexOf("{"), kindNode.getTotalLength());
	}

	@Test public void testCompositeGetLine() {
		assertEquals(5, kindNode.getStartLine());
	}

	@Test public void testCompositeGetTotalLine() {
		assertEquals(3, kindNode.getTotalStartLine());
	}

	@Test public void testCompositeEndLine() {
		assertEquals(6, kindNode.getEndLine());
	}

	@Test public void testCompositeTotalEndLine() {
		assertEquals(6, kindNode.getTotalEndLine());
	}

	@Test public void testLeafGetOffset() {
		assertEquals(model.indexOf("kind"), kindLeaf.getOffset());
	}

	@Test public void testLeafGetTotalOffset() {
		assertEquals(model.indexOf("kind"), kindLeaf.getOffset());
	}

	@Test public void testLeafGetLength() {
		assertEquals("kind".length(), kindLeaf.getLength());
	}

	@Test public void testLeafGetTotalLength() {
		assertEquals("kind".length(), kindLeaf.getLength());
	}

	@Test public void testLeafGetLine() {
		assertEquals(5, kindLeaf.getStartLine());
	}

	@Test public void testLeafGetTotalLine() {
		assertEquals(5, kindLeaf.getTotalStartLine());
	}

	@Test public void testLeafEndLine() {
		assertEquals(5, kindLeaf.getEndLine());
	}

	@Test public void testLeafTotalEndLine() {
		assertEquals(5, kindLeaf.getTotalEndLine());
	}

	@Test public void testHiddenLeafGetOffset() {
		assertEquals(model.indexOf("kind") + "kind".length(), hiddenLeaf.getOffset());
	}

	@Test public void testHiddenLeafGetTotalOffset() {
		assertEquals(model.indexOf("kind") + "kind".length(), hiddenLeaf.getOffset());
	}

	@Test public void testHiddenLeafGetLength() {
		assertEquals(" ".length(), hiddenLeaf.getLength());
	}

	@Test public void testHiddenLeafGetTotalLength() {
		assertEquals(" ".length(), hiddenLeaf.getLength());
	}

	@Test public void testHiddenLeafGetLine() {
		assertEquals(5, hiddenLeaf.getStartLine());
	}

	@Test public void testHiddenLeafGetTotalLine() {
		assertEquals(5, hiddenLeaf.getTotalStartLine());
	}

	@Test public void testHiddenLeafEndLine() {
		assertEquals(5, hiddenLeaf.getEndLine());
	}

	@Test public void testHiddenLeafTotalEndLine() {
		assertEquals(5, kindLeaf.getTotalEndLine());
	}

}
