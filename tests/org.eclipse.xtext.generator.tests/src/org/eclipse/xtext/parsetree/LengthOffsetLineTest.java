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
import org.eclipse.xtext.dummy.DummyLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class LengthOffsetLineTest extends AbstractGeneratorTest {

	public void testOffset() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(0,iter.next().getOffset());
		assertEquals(7,iter.next().getOffset());
		assertEquals(8,iter.next().getOffset());
		assertEquals(11,iter.next().getOffset());
		assertEquals(12,iter.next().getOffset());
		assertEquals(13,iter.next().getOffset());
		assertEquals(20,iter.next().getOffset());
		assertEquals(21,iter.next().getOffset());
		assertEquals(24,iter.next().getOffset());
	}
	
	public void testOffset2() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(0,iter.next().getOffset());
		assertEquals(12,iter.next().getOffset());
		assertFalse(iter.hasNext());
	}

	public void testLineForLeafnodes() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(1,iter.next().getLine());
		assertEquals(1,iter.next().getLine());
		assertEquals(1,iter.next().getLine());
		assertEquals(1,iter.next().getLine());
		assertEquals(1,iter.next().getLine());
		assertEquals(2,iter.next().getLine());
		assertEquals(2,iter.next().getLine());
		assertEquals(2,iter.next().getLine());
		assertEquals(2,iter.next().getLine());
		assertFalse(iter.hasNext());
	}
	
	public void testLineForCompositeNodes() throws Exception {
		String model = "element foo;\nelement bar;\nelement bar;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(1,iter.next().getLine());
		//Note: because preceding whitespace is added to the following node,
		// the '\n' is always added to the following composite node
		assertEquals(1,iter.next().getLine());
		assertEquals(2,iter.next().getLine());
		assertEquals(3,iter.next().getLine());
		assertFalse(iter.hasNext());
	}
	
	
	public void testErrors1() throws Exception {
		String model = "element # ;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		assertEquals(model, node.serialize());
		EList<LeafNode> nodes = node.getLeafNodes();
		assertEquals(5,nodes.size());
		int offset = 0;
		for (LeafNode leafNode : nodes) {
			assertEquals(offset,leafNode.getOffset());
			offset += leafNode.length();
		}
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(DummyLanguageStandaloneSetup.class);
	}
}
