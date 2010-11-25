/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNodeTest extends TestCase {

	protected NodeModelBuilder builder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		builder = new NodeModelBuilder();
	}
	
	@Override
	protected void tearDown() throws Exception {
		builder = null;
		super.tearDown();
	}
	
	protected abstract AbstractNode createNode();
	
	public void testGetParent() {
		AbstractNode node = createNode();
		ICompositeNode parent = builder.newRootNode("input");
		builder.addChild(parent, node);
		assertSame(parent, node.getParent());
	}
	
	public void testGetParent_NoParent() {
		AbstractNode node = createNode();
		assertNull(node.getParent());
	}
	
	public void testGetRootNode() {
		AbstractNode node = createNode();
		ICompositeNode rootNode = builder.newRootNode("My input");
		builder.addChild(rootNode, node);
		assertSame(rootNode, node.getRootNode());
	}
	
	public void testGetRootNode_Parent() {
		AbstractNode node = createNode();
		ICompositeNode rootNode = builder.newRootNode("My input");
		ICompositeNode parent = builder.newCompositeNode(null, 0, rootNode);
		builder.addChild(parent, node);
		assertSame(rootNode, node.getRootNode());
	}
	
	public void testGetRootNode_NoParent() {
		AbstractNode node = createNode();
		assertNull(node.getRootNode());
	}
	
	public void testGetRootNode_NoRoot() {
		AbstractNode node = createNode();
		ICompositeNode parent = new CompositeNode();
		builder.addChild(parent, node);
		assertNull(node.getRootNode());
	}
	
	public void testIterator_Next() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasNext());
		assertSame(node, iterator.next());
		assertFalse(iterator.hasNext());
		try {
			iterator.next();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testIterator_Previous() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertFalse(iterator.hasPrevious());
		try {
			iterator.previous();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testIterator_Bidi() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertSame(node, iterator.next());
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertTrue(iterator.hasNext());
	}
	
	public void testTreeIterator_Next() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode node = createNode();
		builder.addChild(rootNode, node);
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasNext());
		assertSame(node, iterator.next());
		assertFalse(iterator.hasNext());
		try {
			iterator.next();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testTreeIterator_Next_NoParent() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasNext());
		assertSame(node, iterator.next());
		assertFalse(iterator.hasNext());
		try {
			iterator.next();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testTreeIterator_Previous() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode node = createNode();
		builder.addChild(rootNode, node);
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertFalse(iterator.hasPrevious());
		try {
			iterator.previous();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testTreeIterator_Previous_NoParent() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertFalse(iterator.hasPrevious());
		try {
			iterator.previous();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// ok
		}
	}
	
	public void testTreeIterator_Bidi() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode node = createNode();
		builder.addChild(rootNode, node);
		BidiIterator<INode> iterator = node.iterator();
		assertSame(node, iterator.next());
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertTrue(iterator.hasNext());
	}
	
	public void testTreeIterator_Bidi_NoParent() {
		AbstractNode node = createNode();
		BidiIterator<INode> iterator = node.iterator();
		assertSame(node, iterator.next());
		assertTrue(iterator.hasPrevious());
		assertSame(node, iterator.previous());
		assertTrue(iterator.hasNext());
	}
	
	public abstract void testGetText_Default();
	
	public void testGetText_NoParent() {
		AbstractNode node = createNode();
		assertNull(node.getText());
	}
	
	public abstract void testGetText_Empty();
	
	public abstract void testTotalOffset();
	
	public abstract void testTotalEndOffset();
	
	public abstract void testTotalLength();
	
	public abstract void testGetGrammarElement();
	
	public abstract void testGetSyntaxErrorMessage();
	
	public abstract void testGetSemanticElement();
	
	public void testGetNextSibling_SingleChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode node = createNode();
		builder.addChild(rootNode, node);
		assertFalse(node.hasNextSibling());
		assertNull(node.getNextSibling());
	}
	
	public void testGetNextSibling_FirstChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode first = createNode();
		AbstractNode second = createNode();
		builder.addChild(rootNode, first);
		builder.addChild(rootNode, second);
		assertTrue(first.hasNextSibling());
		assertSame(second, first.getNextSibling());
	}
	
	public void testGetNextSibling_LastChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode first = createNode();
		AbstractNode second = createNode();
		builder.addChild(rootNode, first);
		builder.addChild(rootNode, second);
		assertFalse(second.hasNextSibling());
		assertNull(second.getNextSibling());
	}
	
	public void testGetPreviousSibling_SingleChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode node = createNode();
		builder.addChild(rootNode, node);
		assertFalse(node.hasPreviousSibling());
		assertNull(node.getPreviousSibling());
		assertFalse(node.hasSiblings());
	}
	
	public void testGetPreviousSibling_FirstChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode first = createNode();
		AbstractNode second = createNode();
		builder.addChild(rootNode, first);
		builder.addChild(rootNode, second);
		assertFalse(first.hasPreviousSibling());
		assertNull(first.getPreviousSibling());
		assertTrue(first.hasSiblings());
	}
	
	public void testGetPreviousSibling_LastChild() {
		ICompositeNode rootNode = builder.newRootNode("input");
		AbstractNode first = createNode();
		AbstractNode second = createNode();
		builder.addChild(rootNode, first);
		builder.addChild(rootNode, second);
		assertTrue(second.hasPreviousSibling());
		assertSame(first, second.getPreviousSibling());
		assertTrue(second.hasSiblings());
	}
	
}
