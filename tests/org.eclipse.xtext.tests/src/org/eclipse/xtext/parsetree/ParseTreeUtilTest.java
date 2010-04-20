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

	public void testGetGrammarElementFromNode() throws Exception {
		String text = "spielplatz 1 \"junit\" {  ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		AbstractElement grammarElementFromNode = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNodeByOffset);
		assertTrue("expect Keyword as last complete grammar element, but was: " + grammarElementFromNode, grammarElementFromNode instanceof Keyword);

		text = "spielplatz 1 \"junit\" { kind (k1 ";
		rootNode = getRootNodeAndExpect(text, 1);
		lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		grammarElementFromNode = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNodeByOffset);
		assertTrue("expect Keyword as last complete grammar element, but was: " + grammarElementFromNode, grammarElementFromNode instanceof RuleCall);
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

	public void testGetCurrentOrFollowingNodeByOffset() throws Exception {
		String text = "spielplatz 1 \"junit\" { kin  ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		LeafNode currentNodeByOffset = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, 26);
		assertEquals("expect leafnode with text 'kin'", currentNodeByOffset.getText(), "kin");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNodeAndExpect(text, 1);
		currentNodeByOffset = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, text.length());
		assertEquals("expect leafnode with text '('", currentNodeByOffset.getText(), "(");

		text = "spielplatz 1 \"junit\" { kind (  ";
		rootNode = getRootNodeAndExpect(text, 1);
		currentNodeByOffset = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, text.length());
		assertEquals("expect leafnode with WS text '__'", currentNodeByOffset.getText(), "  ");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNodeAndExpect(text, 1);
		currentNodeByOffset = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, text.length() - 1);
		assertEquals("expect leafnode with '('", currentNodeByOffset.getText(), "(");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNodeAndExpect(text, 1);
		currentNodeByOffset = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, 0);
		assertEquals("expect leafnode with WS text 'spielplatz'", currentNodeByOffset.getText(), "spielplatz");

		text = "spielplatz 1 \"junit\" { kind(a 1) kind(b 2) }";
		rootNode = getRootNodeAndExpect(text, 0);
		AbstractNode currentCompositeNodeByOffset = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, text
				.indexOf(')') + 1);
		assertTrue(currentCompositeNodeByOffset instanceof CompositeNode);
		String serialized = currentCompositeNodeByOffset.serialize();
		assertEquals("expect compositeNode with text 'kind(b 2)'", serialized, " kind(b 2)");
	}

	public void testGetCurrentOrPrecedingNodeByOffset_01() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind(a 1) kind(b 2) }";
		CompositeNode rootNode = getRootNode(text);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode,
				text.indexOf(')') + 1);
		assertEquals("expect leafnode with text ')'", ")", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_02() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind(a 1)  kind(b 2) }";
		CompositeNode rootNode = getRootNode(text);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode,
				text.indexOf(')') + 2);
		assertEquals("expect leafnode with text '" + text + "'", currentNodeByOffset.serialize(), text);
	}

	public void testGetCurrentOrPrecedingNodeByOffset_03() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind(a 1) kind(b 2) }";
		CompositeNode rootNode = getRootNode(text);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode,
				text.indexOf("kind(b 2)"));
		assertEquals("expect leafnode with text 'kind'", "kind", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_04() throws Exception {
		String text = "spielplatz 1 \"junit\" { kin  ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 26);
		assertEquals("expect node with text ''", "kin", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_05() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, text.length());
		assertEquals("expect leafnode with text '('", "(", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_06() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (  ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, text.length());
		assertEquals("expect node with text '" + text + "'", currentNodeByOffset.serialize(), text);
	}

	public void testGetCurrentOrPrecedingNodeByOffset_07() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, text.length() - 1);
		assertEquals("expect leafnode with text '('", currentNodeByOffset.serialize(), "(");
	}

	public void testGetCurrentOrPrecedingNodeByOffset_08() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 0);
		assertEquals("expect leafnode with text 'spielplatz'", currentNodeByOffset.serialize(), "spielplatz");
	}

	public void testGetCurrentOrPrecedingNodeByOffset_09() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, "spielplatz"
				.length());
		assertEquals("expect leafnode with text 'spielplatz'", currentNodeByOffset.serialize(), "spielplatz");
	}

	public void testGetCurrentOrPrecedingNodeByOffset_10() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, "spielplatz"
				.length() + 1);
		assertEquals("expect leafnode with text '1'", "1", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_11() throws Exception {
		String text = "spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 2);
		assertEquals("expect leafnode with text 'spielplatz'", currentNodeByOffset.serialize(), "spielplatz");
	}

	public void testGetCurrentOrPrecedingNodeByOffset_12() throws Exception {
		String text = "  spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 0);
		assertEquals("expect node with text '" + text + "'", currentNodeByOffset.serialize(), text);
	}

	public void testGetCurrentOrPrecedingNodeByOffset_13() throws Exception {
		String text = "  spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 1);
		assertEquals("expect node with text '" + text + "'", currentNodeByOffset.serialize(), text);
	}

	public void testGetCurrentOrPrecedingNodeByOffset_14() throws Exception {
		String text = "  spielplatz 1 \"junit\" { kind (";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, 2);
		assertEquals("expect leafnode with text 'spielplatz'", "spielplatz", currentNodeByOffset.serialize());
	}

	public void testGetCurrentOrPrecedingNodeByOffset_15() throws Exception {
		String text = "  spielplatz 1 \"junit\" { kind (a  1) ";
		CompositeNode rootNode = getRootNodeAndExpect(text, 1);
		AbstractNode currentNodeByOffset = ParseTreeUtil.getCurrentOrPrecedingNodeByOffset(rootNode, text.indexOf("a  1") + 2);
		assertEquals("expect leafnode with text ' kind (a  1)'", " kind (a  1)", currentNodeByOffset.serialize());
	}

}
