/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.XtextFactory;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LeafNodeTest extends AbstractNodeTest {

	@Override
	protected LeafNode createNode() {
		return new LeafNode();
	}

	@Override
	@Test public void testGetText_Default() {
		ICompositeNode rootNode = builder.newRootNode("my input!");
		ILeafNode leafNode = builder.newLeafNode(3, 5, null, false, null, rootNode);
		assertEquals("input", leafNode.getText());
	}

	@Override
	@Test public void testGetText_Empty() {
		ICompositeNode rootNode = builder.newRootNode("my input");
		ILeafNode leafNode = builder.newLeafNode(0, 0, null, false, null, rootNode);
		assertEquals("", leafNode.getText());
	}

	@Override
	@Test public void testTotalOffset() {
		ICompositeNode rootNode = builder.newRootNode("my input");
		ILeafNode leafNode = builder.newLeafNode(3, 5, null, false, null, rootNode);
		assertEquals(3, leafNode.getTotalOffset());
	}

	@Override
	@Test public void testTotalEndOffset() {
		ICompositeNode rootNode = builder.newRootNode("my input");
		ILeafNode leafNode = builder.newLeafNode(3, 5, null, false, null, rootNode);
		assertEquals(8, leafNode.getTotalEndOffset());
	}

	@Override
	@Test public void testTotalLength() {
		ICompositeNode rootNode = builder.newRootNode("my input");
		ILeafNode leafNode = builder.newLeafNode(3, 5, null, false, null, rootNode);
		assertEquals(5, leafNode.getTotalLength());
	}

	@Override
	@Test public void testGetGrammarElement() {
		LeafNode leafNode = createNode();
		Keyword grammarElement = XtextFactory.eINSTANCE.createKeyword();
		leafNode.basicSetGrammarElement(grammarElement);
		assertSame(grammarElement, leafNode.getGrammarElement());
	}

	@Override
	@Test public void testGetSyntaxErrorMessage() {
		LeafNode leafNode = createNode();
		SyntaxErrorMessage errorMessage = new SyntaxErrorMessage("message", null);
		leafNode.basicSetSyntaxErrorMessage(errorMessage);
		assertSame(errorMessage, leafNode.getSyntaxErrorMessage());
	}

	@Override
	@Test public void testGetSemanticElement() {
		ICompositeNode rootNode = builder.newRootNode("input");
		ICompositeNode parent = builder.newCompositeNode(null, 0, rootNode);
		EObject semanticElement = EcoreFactory.eINSTANCE.createEObject();
		builder.associateWithSemanticElement(parent, semanticElement);
		LeafNode leafNode = createNode();
		builder.addChild(parent, leafNode);
		assertSame(semanticElement, leafNode.getSemanticElement());
	}

}
