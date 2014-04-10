/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NodeIteratorTest extends Assert {

	private static final int NUM_NODES = 11;
	private INode[] nodes;

	@Before
	public void setUp() throws Exception {
		NodeModelBuilder builder = new NodeModelBuilder();
		nodes = new INode[NUM_NODES];
		nodes[0] = new CompositeNode();
		nodes[1] = new LeafNode();
		nodes[2] = new CompositeNode();
		nodes[3] = new CompositeNode();
		nodes[4] = new LeafNode();
		nodes[5] = new LeafNode();
		nodes[6] = new LeafNode();
		nodes[7] = new CompositeNode();
		nodes[8] = new LeafNode();
		nodes[9] = new LeafNode();
		nodes[10]= new CompositeNode();
		
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[1]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[2]);
		builder.addChild((ICompositeNode)nodes[2], (AbstractNode)nodes[3]);
		builder.addChild((ICompositeNode)nodes[3], (AbstractNode)nodes[4]);
		builder.addChild((ICompositeNode)nodes[3], (AbstractNode)nodes[5]);
		builder.addChild((ICompositeNode)nodes[2], (AbstractNode)nodes[6]);
		builder.addChild((ICompositeNode)nodes[2], (AbstractNode)nodes[7]);
		builder.addChild((ICompositeNode)nodes[2], (AbstractNode)nodes[8]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[9]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[10]);
	}

	@Test public void testForward() throws Exception {
		for (int i = 0; i < NUM_NODES; ++i) {
			checkAscending(i);
		}
	}

	@Test public void testBackward() throws Exception {
		for (int i = 0; i < NUM_NODES; ++i) {
			checkDescending(i);
		}
	}

	@Test public void testPruneComposite() throws Exception {
		NodeIterator nodeIterator = new NodeIterator(nodes[3]);
		nodeIterator.prune();
		assertEquals(nodes[6], nodeIterator.next());
		assertEquals(nodes[3], nodeIterator.previous());
		assertEquals(nodes[2], nodeIterator.previous());
		assertEquals(nodes[1], nodeIterator.previous());
	}
	
	@Test public void testPruneLeaf() throws Exception {
		// pruning a leaf should not have any effect
		NodeIterator nodeIterator = new NodeIterator(nodes[8]);
		nodeIterator.prune();
		assertEquals(nodes[9], nodeIterator.next());
		assertEquals(nodes[8], nodeIterator.previous());
		assertEquals(nodes[7], nodeIterator.previous());
		assertEquals(nodes[6], nodeIterator.previous());
	}

	protected void checkAscending(int index) {
		int i = index;
		NodeIterator nodeIterator = new NodeIterator(nodes[i]);
		while (nodeIterator.hasNext()) {
			assertEquals("Ascending " + i, nodes[++i], nodeIterator.next());
		}
	}

	protected void checkDescending(int index) {
		int i = index;
		NodeIterator nodeIterator = new NodeIterator(nodes[i]);
		while (nodeIterator.hasPrevious()) {
			assertEquals(nodes[--i], nodeIterator.previous());
		}
	}
}
