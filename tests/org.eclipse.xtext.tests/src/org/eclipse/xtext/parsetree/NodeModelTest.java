/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.TestLanguageStandaloneSetup;

import com.google.common.collect.Iterators;
import com.google.inject.internal.Lists;

public class NodeModelTest extends AbstractXtextTests {

	private static final String MODEL = "reducible 'x' choice optional y choice z reducible 'x' 'y'";

	public void testNavigabilityAst2Node() throws Exception {
		EObject object = getModel(MODEL);
		checkNavigabilityAst2Node(object);
		for (Iterator<EObject> i = object.eAllContents(); i.hasNext();) {
			checkNavigabilityAst2Node(i.next());
		}
	}

	public void testNavigabilityNode2Ast() throws Exception {
		EObject object = getModel(MODEL);
		EList<Adapter> adapters = object.eAdapters();
		assertEquals(1 /* compositeNode */ + 1 /* cache */, adapters.size());
		ICompositeNode rootNode = (ICompositeNode) adapters.get(0);
		assertTrue(rootNode.getParent() == null);
		checkNavigabilityNode2Ast(rootNode);
		for (Iterator<INode> i = rootNode.treeIterator(); i.hasNext();) {
			checkNavigabilityNode2Ast(i.next());
		}
	}

	public void testGrammarElement() throws Exception {
		ICompositeNode rootNode = getRootNode2(MODEL);
		EObject rootGrammarElement = rootNode.getGrammarElement();
		assertTrue(rootGrammarElement instanceof ParserRule);
		for (Iterator<INode> i = rootNode.treeIterator(); i.hasNext();) {
			INode next = i.next();
			if (next == rootNode) {
				EObject grammarElement = next.getGrammarElement();
				assertTrue(grammarElement.toString(), grammarElement instanceof ParserRule);
			} else if (next instanceof ICompositeNode) {
				ICompositeNode compositeNode = (ICompositeNode) next;
				EObject grammarElement = compositeNode.getGrammarElement();
				assertTrue(grammarElement.toString(), GrammarUtil.isParserRuleCall(grammarElement)
						|| grammarElement instanceof Action);
			} else if (next instanceof ILeafNode) {
				ILeafNode leafNode = (ILeafNode) next;
				EObject grammarElement = leafNode.getGrammarElement();
				assertNotNull(grammarElement);
			}
		}
	}

	private void checkNavigabilityAst2Node(EObject object) {
		EList<Adapter> adapters = object.eAdapters();
		assertEquals(1 /* compositeNode */ + 1 /* cache */, adapters.size());
		ICompositeNode adapter = (ICompositeNode) adapters.get(0);
		assertEquals(object, adapter.getSemanticElement());
	}

	private void checkNavigabilityNode2Ast(INode node) {
		if (node.hasDirectSemanticElement()) {
			EObject astElement = node.getSemanticElement();
			EList<Adapter> adapters = astElement.eAdapters();
			assertEquals(1 /* compositeNode */ + 1 /* cache */, adapters.size());
			ICompositeNode adapter = (ICompositeNode) adapters.get(0);
			assertEquals(node, adapter);
		} 
	}

	public static boolean isTerminalRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return calledRule != null && (calledRule instanceof TerminalRule);
		}
		return false;
	}

	public void testTokenTexts() throws Exception {
		Pattern whitespacePattern = Pattern.compile("\\s*");
		String[] tokenTexts = MODEL.split(" ");
		int tokenIndex = 0;
		INode rootNode = getRootNode2(MODEL);
		for (Iterator<INode> i = rootNode.treeIterator(); i.hasNext();) {
			INode next = i.next();
			if (next instanceof ILeafNode) {
				ILeafNode leafNode = (ILeafNode) next;
				String tokenText = leafNode.getText();
				if (!whitespacePattern.matcher(tokenText).matches()) {
					assertEquals(tokenTexts[tokenIndex++], tokenText);
				}
			}
		}
	}

	public void testKeywordInAlternative() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		EObject object = getModel("d / e");
		ICompositeNode root = NodeModelUtils.getNode(object).getRootNode();
		List<ILeafNode> nodes = Lists.newArrayList(Iterators.filter(root.treeIterator(), ILeafNode.class));
		assertTrue(nodes.get(2).getGrammarElement() instanceof Keyword);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(TestLanguageStandaloneSetup.class);
	}

}
