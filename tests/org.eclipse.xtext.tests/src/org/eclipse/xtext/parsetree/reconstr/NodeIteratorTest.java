/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import junit.framework.TestCase;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;

/**
 * @author koehnlein - Initial contribution and API
 */
public class NodeIteratorTest extends TestCase {

	private static final int NUM_NODES = 11;
	private AbstractNode[] nodes;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		nodes = new AbstractNode[NUM_NODES];
		nodes[0] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[1] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[2] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[3] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[4] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[5] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[6] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[7] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[8] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[9] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[10] = ParsetreeFactory.eINSTANCE.createCompositeNode();

		((CompositeNode) nodes[0]).getChildren().add(nodes[1]);
		((CompositeNode) nodes[0]).getChildren().add(nodes[2]);
		((CompositeNode) nodes[2]).getChildren().add(nodes[3]);
		((CompositeNode) nodes[3]).getChildren().add(nodes[4]);
		((CompositeNode) nodes[3]).getChildren().add(nodes[5]);
		((CompositeNode) nodes[2]).getChildren().add(nodes[6]);
		((CompositeNode) nodes[2]).getChildren().add(nodes[7]);
		((CompositeNode) nodes[2]).getChildren().add(nodes[8]);
		((CompositeNode) nodes[0]).getChildren().add(nodes[9]);
		((CompositeNode) nodes[0]).getChildren().add(nodes[10]);
	}

	public void testForward() throws Exception {
		for (int i = 0; i < NUM_NODES; ++i) {
			checkAscending(i);
		}
	}

	public void testBackward() throws Exception {
		for (int i = 0; i < NUM_NODES; ++i) {
			checkDescending(i);
		}
	}

	public void testPruneComposite() throws Exception {
		NodeIterator nodeIterator = new NodeIterator(nodes[3]);
		nodeIterator.prune();
		assertEquals(nodes[6], nodeIterator.next());
		assertEquals(nodes[6], nodeIterator.previous());
		assertEquals(nodes[3], nodeIterator.previous());
		assertEquals(nodes[2], nodeIterator.previous());
	}
	
	public void testPruneLeaf() throws Exception {
		// pruning a leaf should not have any effect
		NodeIterator nodeIterator = new NodeIterator(nodes[8]);
		nodeIterator.prune();
		assertEquals(nodes[9], nodeIterator.next());
		assertEquals(nodes[9], nodeIterator.previous());
		assertEquals(nodes[8], nodeIterator.previous());
		assertEquals(nodes[7], nodeIterator.previous());
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
			assertEquals(nodes[i--], nodeIterator.previous());
		}
	}
}
