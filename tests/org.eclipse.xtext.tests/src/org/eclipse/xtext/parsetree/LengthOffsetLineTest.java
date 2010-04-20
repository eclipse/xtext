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

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;

public class LengthOffsetLineTest extends AbstractXtextTests {

	public void testOffset() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(0,iter.next().getTotalOffset());
		assertEquals(7,iter.next().getTotalOffset());
		assertEquals(8,iter.next().getTotalOffset());
		assertEquals(11,iter.next().getTotalOffset());
		assertEquals(12,iter.next().getTotalOffset());
		assertEquals(13,iter.next().getTotalOffset());
		assertEquals(20,iter.next().getTotalOffset());
		assertEquals(21,iter.next().getTotalOffset());
		assertEquals(24,iter.next().getTotalOffset());
	}

	public void testOffset2() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(0,iter.next().getTotalOffset());
		assertEquals(12,iter.next().getTotalOffset());
		assertFalse(iter.hasNext());
	}

	public void testLineForLeafnodes() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(2,iter.next().getTotalLine());
		assertEquals(2,iter.next().getTotalLine());
		assertEquals(2,iter.next().getTotalLine());
		assertEquals(2,iter.next().getTotalLine());
		assertFalse(iter.hasNext());
	}

	public void testLineForCompositeNodes() throws Exception {
		String model = "element foo;\nelement bar;\nelement bar;\nelement bar;";
		CompositeNode node = getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(1,iter.next().getTotalLine());
		//Note: because preceding whitespace is added to the following node,
		// the '\n' is always added to the following composite node
		assertEquals(1,iter.next().getTotalLine());
		assertEquals(2,iter.next().getTotalLine());
		assertEquals(3,iter.next().getTotalLine());
		assertFalse(iter.hasNext());
	}


	public void testErrors1() throws Exception {
		String model = "element # ;";
		CompositeNode node = getRootNodeAndExpect(model, 1);
		assertEquals(model, node.serialize());
		EList<LeafNode> nodes = node.getLeafNodes();
		assertEquals(5,nodes.size());
		int offset = 0;
		for (LeafNode leafNode : nodes) {
			assertEquals(offset,leafNode.getTotalOffset());
			offset += leafNode.getTotalLength();
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
	}
}
