/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.actions;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ActionTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage;
import org.eclipse.xtext.testlanguages.actionLang.Model;
import org.eclipse.xtext.testlanguages.actionLang.Parent;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrParserTest extends AbstractXtextTests {

	private ActionTestLanguageGrammarAccess grammarAccess;
	private ParserTestHelper helper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ActionTestLanguageStandaloneSetup.class);
		grammarAccess = get(ActionTestLanguageGrammarAccess.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}

	@Override
	public void tearDown() throws Exception {
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
	@Test public void testParseWithoutActionCall() throws Exception {
		XtextResource resource = helper.getResourceFromString("myID");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertNotNull("model", model);
		assertEquals(model.eClass().getName(), ActionLangPackage.Literals.CHILD, model.eClass());
		ICompositeNode node = NodeModelUtils.getNode(model);
		assertNotNull("node", node);
		assertEquals("node.grammarElement", grammarAccess.getModelAccess().getChildParserRuleCall_0(), node.getGrammarElement());
		assertEquals(node.getChildren().toString(), 1, Iterables.size(node.getChildren()));
		INode childNode = node.getFirstChild();
		assertTrue(childNode.toString(), childNode instanceof ILeafNode);
		assertEquals("childNode.grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(), childNode.getGrammarElement());
		assertFalse("childNode.element", childNode.hasDirectSemanticElement());

		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		assertNotNull("rootNode", rootNode);
		assertEquals("rootNode.grammarElement", grammarAccess.getModelRule(), rootNode.getGrammarElement());
		assertEquals(rootNode.getChildren().toString(), 1, Iterables.size(rootNode.getChildren()));
		assertEquals("node is child of rootNode", rootNode, node.getParent());
		assertFalse("rootNode.element", rootNode.hasDirectSemanticElement());
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
	@Test public void testParseWithActionCall() throws Exception {
		XtextResource resource = helper.getResourceFromString("myID otherID");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertNotNull("model", model);
		assertEquals(model.eClass().getName(), ActionLangPackage.Literals.PARENT, model.eClass());
		ICompositeNode node = NodeModelUtils.getNode(model);
		assertNotNull("node", node);
		assertNotNull("node", node);
		assertEquals("node.grammarElement", grammarAccess.getModelAccess().getParentLeftAction_1_0(), node.getGrammarElement());
		assertEquals(node.getChildren().toString(), 2, Iterables.size(node.getChildren()));
		ICompositeNode firstChildNode = (ICompositeNode) node.getFirstChild();
		assertEquals("firstChildNode.grammarElement", grammarAccess.getModelRule(), firstChildNode.getGrammarElement());
		assertFalse("firstChildNode.element", firstChildNode.hasDirectSemanticElement());
		assertEquals(firstChildNode.getChildren().toString(), 1, Iterables.size(firstChildNode.getChildren()));

		INode childNode = firstChildNode.getFirstChild();
		assertTrue(childNode.toString(), childNode instanceof ICompositeNode);
		assertEquals("childNode.grammarElement", grammarAccess.getModelAccess().getChildParserRuleCall_0(), childNode.getGrammarElement());
		assertEquals("childNode.element", ((Parent)model).getLeft(), childNode.getSemanticElement());
		assertEquals(((ICompositeNode) childNode).getChildren().toString(), 1, Iterables.size(((ICompositeNode) childNode).getChildren()));
		assertEquals("childNode.children[0].grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(),
				((ICompositeNode) childNode).getFirstChild().getGrammarElement());

		ICompositeNode secondChildNode = (ICompositeNode) node.getFirstChild().getNextSibling();
		assertEquals("childNode.grammarElement", grammarAccess.getModelAccess().getRightChildParserRuleCall_1_1_0(), secondChildNode.getGrammarElement());
		assertEquals("childNode.element", ((Parent)model).getRight(), secondChildNode.getSemanticElement());

		INode otherChildNode = secondChildNode.getFirstChild().getNextSibling();
		assertTrue(otherChildNode.toString(), otherChildNode instanceof ILeafNode);
		assertEquals("otherChildNode.grammarElement", grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(),	otherChildNode.getGrammarElement());

		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		assertNotNull("rootNode", rootNode);
		assertEquals("rootNode.grammarElement", grammarAccess.getModelAccess().getParentLeftAction_1_0(), rootNode.getGrammarElement());
		assertEquals(node, rootNode);
	}


}
