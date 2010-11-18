/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.RootNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNodeTest extends AbstractCompositeNodeTest {

	@Override
	public void testTextOffsetLength() {
		RootNode root = new RootNode();
		String completeContent = " completeContent ";
		root.setCompleteContent(completeContent);
		LeafNode firstChild = new LeafNode();
		firstChild.setTotalLength(1);
		firstChild.setTotalOffset(0);
		addChild(root, firstChild);
		CompositeNodeWithSemanticElement composite = createCompositeNode();
		LeafNode child = new LeafNode();
		child.setTotalOffset(1);
		child.setTotalLength(completeContent.trim().length());
		addChild(composite, child);
		addChild(root, composite);
		LeafNode lastChild = new LeafNode();
		lastChild.setTotalLength(1);
		lastChild.setTotalOffset(completeContent.length() - 2);
		addChild(root, lastChild);
		assertEquals(completeContent.trim(), composite.getText());
		assertEquals(1, composite.getTotalOffset());
		assertEquals(completeContent.trim().length(), composite.getTotalLength());
	}
	
	@Override
	protected AbstractNode getFirstChild(ICompositeNode node) {
		return ((CompositeNodeWithSemanticElement) node).getFirstChild();
	}
	
	@Override
	protected CompositeNodeWithSemanticElement createCompositeNode() {
		return new CompositeNodeWithSemanticElement();
	}
}
