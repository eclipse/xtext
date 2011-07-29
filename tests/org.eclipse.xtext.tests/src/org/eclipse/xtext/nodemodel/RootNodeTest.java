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
public class RootNodeTest extends AbstractCompositeNodeTest {

	@Override
	public void testTextOffsetLength() {
		RootNode rootNode = createCompositeNode();
		String completeContent = "completeContent";
		rootNode.basicSetCompleteContent(completeContent);
		assertEquals(completeContent, rootNode.getText());
		assertEquals(0, rootNode.getTotalOffset());
		assertEquals(completeContent.length(), rootNode.getTotalLength());
	}
	
	@Override
	protected AbstractNode getFirstChild(ICompositeNode node) {
		return ((RootNode) node).basicGetFirstChild();
	}
	
	@Override
	protected RootNode createCompositeNode() {
		return new RootNode();
	}
	
	public void testIteratorForEmptyNode() {
		RootNode rootNode = createCompositeNode();
		BidiTreeIterator<AbstractNode> forwardIterator = rootNode.basicIterator();
		assertTrue(forwardIterator.hasNext());
		assertSame(rootNode, forwardIterator.next());
		assertFalse(forwardIterator.hasNext());
		
		BidiTreeIterator<AbstractNode> backwardsIterator = rootNode.basicIterator();
		assertTrue(backwardsIterator.hasPrevious());
		assertSame(rootNode, backwardsIterator.next());
		assertFalse(backwardsIterator.hasPrevious());
	}
}
