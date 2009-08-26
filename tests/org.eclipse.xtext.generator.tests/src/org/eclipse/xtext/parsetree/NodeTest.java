/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeTest extends AbstractXtextTests {

	private AbstractNode rootNode;

	private AbstractNode kindLeaf;

	private AbstractNode kindNode;

	private AbstractNode hiddenLeaf;

	private String model;

	@Override
	protected void setUp() throws Exception {
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
		kindLeaf = NodeUtil.findLeafNodeAtOffset((CompositeNode) rootNode, model.indexOf("kind") + 1);
		hiddenLeaf = kindLeaf.getParent().getChildren().get(kindLeaf.getParent().getChildren().indexOf(kindLeaf) + 1);
		kindNode = kindLeaf.getParent();
	}

	public void testRootGetOffset() {
		assertEquals(model.indexOf("spielplatz"), rootNode.getOffset());
	}

	public void testRootGetTotalOffset() {
		assertEquals(0, rootNode.getTotalOffset());
	}

	public void testRootGetLength() {
		assertEquals(model.indexOf('}') - model.indexOf("spielplatz") + 1, rootNode.getLength());
	}

	public void testRootGetTotalLength() {
		assertEquals(model.length(), rootNode.getTotalLength());
	}

	public void testRootGetLine() {
		assertEquals(3, rootNode.getLine());
	}

	public void testRootGetTotalLine() {
		assertEquals(1, rootNode.getTotalLine());
	}

	public void testRootEndLine() {
		assertEquals(8, rootNode.endLine());
	}

	public void testRootTotalEndLine() {
		assertEquals(10, rootNode.totalEndLine());
	}

	public void testCompositeGetOffset() {
		assertEquals(model.indexOf("kind"), kindNode.getOffset());
	}

	public void testCompositeGetTotalOffset() {
		assertEquals(model.indexOf("{") + 1, kindNode.getTotalOffset());
	}

	public void testCompositeGetLength() {
		assertEquals(model.indexOf(')') - model.indexOf("kind") + 1, kindNode.getLength());
	}

	public void testCompositeGetTotalLength() {
		assertEquals(model.indexOf(')') - model.indexOf("{"), kindNode.getTotalLength());
	}

	public void testCompositeGetLine() {
		assertEquals(5, kindNode.getLine());
	}

	public void testCompositeGetTotalLine() {
		assertEquals(3, kindNode.getTotalLine());
	}

	public void testCompositeEndLine() {
		assertEquals(6, kindNode.endLine());
	}

	public void testCompositeTotalEndLine() {
		assertEquals(6, kindNode.totalEndLine());
	}

	public void testLeafGetOffset() {
		assertEquals(model.indexOf("kind"), kindLeaf.getOffset());
	}

	public void testLeafGetTotalOffset() {
		assertEquals(model.indexOf("kind"), kindLeaf.getOffset());
	}

	public void testLeafGetLength() {
		assertEquals("kind".length(), kindLeaf.getLength());
	}

	public void testLeafGetTotalLength() {
		assertEquals("kind".length(), kindLeaf.getLength());
	}

	public void testLeafGetLine() {
		assertEquals(5, kindLeaf.getLine());
	}

	public void testLeafGetTotalLine() {
		assertEquals(5, kindLeaf.getTotalLine());
	}

	public void testLeafEndLine() {
		assertEquals(5, kindLeaf.endLine());
	}

	public void testLeafTotalEndLine() {
		assertEquals(5, kindLeaf.totalEndLine());
	}

	public void testHiddenLeafGetOffset() {
		assertEquals(model.indexOf("kind") + "kind".length(), hiddenLeaf.getOffset());
	}

	public void testHiddenLeafGetTotalOffset() {
		assertEquals(model.indexOf("kind") + "kind".length(), hiddenLeaf.getOffset());
	}

	public void testHiddenLeafGetLength() {
		assertEquals(" ".length(), hiddenLeaf.getLength());
	}

	public void testHiddenLeafGetTotalLength() {
		assertEquals(" ".length(), hiddenLeaf.getLength());
	}

	public void testHiddenLeafGetLine() {
		assertEquals(5, hiddenLeaf.getLine());
	}

	public void testHiddenLeafGetTotalLine() {
		assertEquals(5, hiddenLeaf.getTotalLine());
	}

	public void testHiddenLeafEndLine() {
		assertEquals(5, hiddenLeaf.endLine());
	}

	public void testHiddenLeafTotalEndLine() {
		assertEquals(5, kindLeaf.totalEndLine());
	}

}
