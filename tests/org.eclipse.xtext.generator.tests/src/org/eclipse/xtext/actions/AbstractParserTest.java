/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.actions;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ActionTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage;
import org.eclipse.xtext.testlanguages.actionLang.Model;
import org.eclipse.xtext.testlanguages.actionLang.Parent;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserTest extends AbstractXtextTests {

	private ActionTestLanguageGrammarAccess grammarAccess;
	private ParserTestHelper helper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ActionTestLanguageStandaloneSetup.class);
		grammarAccess = get(ActionTestLanguageGrammarAccess.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY));
	}

	@Override
	protected void tearDown() throws Exception {
		grammarAccess = null;
		super.tearDown();
	}

	/**
	 * Model: '<code>myID</code>'
	 * The following parse tree is expected:
	 * <pre>
	 * CompositeNode (GrammarElement: Rule[Model], Element: null)
	 *  |
	 * CompositeNode (GrammarElement: RuleCall[Child], Element: Child[myID])
	 *  |
	 * LeafNode (GrammarElement: RuleCall[ID], Element: null)
	 * </pre>
	 */
	public void testParseWithoutActionCall() throws Exception {
		XtextResource resource = helper.getResourceFromString("myID");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertNotNull("model", model);
		assertEquals(model.eClass().getName(), ActionLangPackage.Literals.CHILD, model.eClass());
		NodeAdapter adapter = NodeUtil.getNodeAdapter(model);
		assertNotNull("adapter", adapter);
		CompositeNode node = adapter.getParserNode();
		assertNotNull("node", node);
		assertEquals("node.grammarElement", grammarAccess.getModelAccess().getChildParserRuleCall_0(), node.getGrammarElement());
		assertEquals(node.getChildren().toString(), 1, node.getChildren().size());
		AbstractNode childNode = node.getChildren().get(0);
		assertTrue(childNode.toString(), childNode instanceof LeafNode);
		assertEquals("childNode.grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(), childNode.getGrammarElement());
		assertNull("childNode.element", childNode.getElement());

		CompositeNode rootNode = resource.getParseResult().getRootNode();
		assertNotNull("rootNode", rootNode);
		assertEquals("rootNode.grammarElement", grammarAccess.getModelRule(), rootNode.getGrammarElement());
		assertEquals(rootNode.getChildren().toString(), 1, rootNode.getChildren().size());
		assertEquals("node is child of rootNode", rootNode, node.getParent());
		assertNull("rootNode.element", rootNode.getElement());
	}

	/**
	 * Model: '<code>myID otherID</code>'
	 * The following parse tree is expected:
	 * <pre>
	 * CompositeNode (GrammarElement: Action, Element: Parent[left: Child[myID], right: Child[otherID]])
	 *  |________________________________________________________________________,
	 * CompositeNode (GrammarElement: Rule[Model], Element: null)               CompositeNode (GrammarElement: RuleCall[Child], Element: Child[otherID])
	 *  |                                                                        |________________,
	 * CompositeNode (GrammarElement: RuleCall[Child], Element: Child[myID])    LeafNode (WS)    LeafNode (GrammarElement: RuleCall[ID], Element: null)
	 *  |
	 * LeafNode (GrammarElement: RuleCall[ID], Element: null)
	 * </pre>
	 */
	public void testParseWithActionCall() throws Exception {
		XtextResource resource = helper.getResourceFromString("myID otherID");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertNotNull("model", model);
		assertEquals(model.eClass().getName(), ActionLangPackage.Literals.PARENT, model.eClass());
		NodeAdapter adapter = NodeUtil.getNodeAdapter(model);
		assertNotNull("adapter", adapter);
		CompositeNode node = adapter.getParserNode();
		assertNotNull("node", node);
		assertEquals("node.grammarElement", grammarAccess.getModelAccess().getParentLeftAction_1_0(), node.getGrammarElement());
		assertEquals(node.getChildren().toString(), 2, node.getChildren().size());
		CompositeNode firstChildNode = (CompositeNode) node.getChildren().get(0);
		assertEquals("firstChildNode.grammarElement", grammarAccess.getModelRule(), firstChildNode.getGrammarElement());
		assertNull("firstChildNode.element", firstChildNode.getElement());
		assertEquals(firstChildNode.getChildren().toString(), 1, firstChildNode.getChildren().size());

		AbstractNode childNode = firstChildNode.getChildren().get(0);
		assertTrue(childNode.toString(), childNode instanceof CompositeNode);
		assertEquals("childNode.grammarElement", grammarAccess.getModelAccess().getChildParserRuleCall_0(), childNode.getGrammarElement());
		assertEquals("childNode.element", ((Parent)model).getLeft(), childNode.getElement());
		assertEquals(((CompositeNode) childNode).getChildren().toString(), 1, ((CompositeNode) childNode).getChildren().size());
		assertEquals("childNode.children[0].grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(),
				((CompositeNode) childNode).getChildren().get(0).getGrammarElement());

		CompositeNode secondChildNode = (CompositeNode) node.getChildren().get(1);
		assertEquals("childNode.grammarElement", grammarAccess.getModelAccess().getRightChildParserRuleCall_1_1_0(), secondChildNode.getGrammarElement());
		assertEquals("childNode.element", ((Parent)model).getRight(), secondChildNode.getElement());

		AbstractNode otherChildNode = secondChildNode.getChildren().get(1);
		assertTrue(otherChildNode.toString(), otherChildNode instanceof LeafNode);
		assertEquals("otherChildNode.grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(),	otherChildNode.getGrammarElement());

		CompositeNode rootNode = resource.getParseResult().getRootNode();
		assertNotNull("rootNode", rootNode);
		assertEquals("rootNode.grammarElement", grammarAccess.getModelAccess().getParentLeftAction_1_0(), rootNode.getGrammarElement());
		assertEquals(node, rootNode);
	}


}
