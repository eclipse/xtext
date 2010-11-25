/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNodeTest extends AbstractCompositeNodeTest {

	@Override
	public void testTextOffsetLength() {
		RootNode root = new RootNode();
		String completeContent = " completeContent ";
		root.basicSetCompleteContent(completeContent);
		LeafNode firstChild = new LeafNode();
		firstChild.basicSetTotalLength(1);
		firstChild.basicSetTotalOffset(0);
		addChild(root, firstChild);
		CompositeNodeWithSemanticElement composite = createCompositeNode();
		LeafNode child = new LeafNode();
		child.basicSetTotalOffset(1);
		child.basicSetTotalLength(completeContent.trim().length());
		addChild(composite, child);
		addChild(root, composite);
		LeafNode lastChild = new LeafNode();
		lastChild.basicSetTotalLength(1);
		lastChild.basicSetTotalOffset(completeContent.length() - 2);
		addChild(root, lastChild);
		assertEquals(completeContent.trim(), composite.getText());
		assertEquals(1, composite.getTotalOffset());
		assertEquals(completeContent.trim().length(), composite.getTotalLength());
	}
	
	public void testGetTotalOffsetWithoutChildren() {
		RootNode rootNode = new RootNode();
		rootNode.basicSetCompleteContent("my string");
		LeafNode leafNode = new LeafNode();
		leafNode.basicSetTotalOffset(0);
		leafNode.basicSetTotalLength(3);
		addChild(rootNode, leafNode);
		CompositeNodeWithSemanticElement firstChild = createCompositeNode();
		CompositeNodeWithSemanticElement firstGrandChild = createCompositeNode();
		CompositeNodeWithSemanticElement secondChild = createCompositeNode();
		CompositeNodeWithSemanticElement secondGrandChild = createCompositeNode();
		CompositeNodeWithSemanticElement thirdChild = createCompositeNode();
		CompositeNodeWithSemanticElement thirdGrandChild = createCompositeNode();
		addChild(rootNode, firstChild);
		addChild(firstChild, firstGrandChild);
		addChild(rootNode, secondChild);
		addChild(secondChild, secondGrandChild);
		addChild(rootNode, thirdChild);
		addChild(thirdChild, thirdGrandChild);
		
		assertEquals(0, rootNode.getTotalOffset());		
		assertEquals(0, rootNode.getOffset());		
		assertEquals(3, firstChild.getTotalOffset());		
		assertEquals(3, firstChild.getOffset());		
		assertEquals(3, firstGrandChild.getTotalOffset());		
		assertEquals(3, firstGrandChild.getOffset());		
		assertEquals(3, secondChild.getTotalOffset());		
		assertEquals(3, secondChild.getOffset());		
		assertEquals(3, secondGrandChild.getTotalOffset());		
		assertEquals(3, secondGrandChild.getOffset());		
		assertEquals(3, thirdChild.getTotalOffset());		
		assertEquals(3, thirdChild.getOffset());		
		assertEquals(3, thirdGrandChild.getTotalOffset());		
		assertEquals(3, thirdGrandChild.getOffset());		
	}
	
	@Override
	protected AbstractNode getFirstChild(ICompositeNode node) {
		return ((CompositeNodeWithSemanticElement) node).basicGetFirstChild();
	}
	
	@Override
	protected CompositeNodeWithSemanticElement createCompositeNode() {
		return new CompositeNodeWithSemanticElement();
	}
}
