/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootNodeTest extends AbstractCompositeNodeTest {

	@Override
	@Test public void testTextOffsetLength() {
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
	
	@Test public void testIteratorForEmptyNode() {
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
