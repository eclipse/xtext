/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.Iterator;

import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class LengthOffsetLineTest extends AbstractXtextTests {

	@Test public void testOffset() throws Exception {
		String model = "element foo;\nelement bar;";
		ICompositeNode node = getRootNode(model);
		Iterator<ILeafNode> iter = node.getLeafNodes().iterator();
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

	@Test public void testOffset2() throws Exception {
		String model = "element foo;\nelement bar;";
		ICompositeNode node = getRootNode(model);
		Iterator<INode> iter = node.getChildren().iterator();
		assertEquals(0,iter.next().getTotalOffset());
		assertEquals(12,iter.next().getTotalOffset());
		assertFalse(iter.hasNext());
	}

	@Test public void testLineForLeafnodes() throws Exception {
		String model = "element foo;\nelement bar;";
		ICompositeNode node = getRootNode(model);
		Iterator<ILeafNode> iter = node.getLeafNodes().iterator();
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(2,iter.next().getTotalStartLine());
		assertEquals(2,iter.next().getTotalStartLine());
		assertEquals(2,iter.next().getTotalStartLine());
		assertEquals(2,iter.next().getTotalStartLine());
		assertFalse(iter.hasNext());
	}

	@Test public void testLineForCompositeNodes() throws Exception {
		String model = "element foo;\nelement bar;\nelement bar;\nelement bar;";
		ICompositeNode node = getRootNode(model);
		Iterator<INode> iter = node.getChildren().iterator();
		assertEquals(1,iter.next().getTotalStartLine());
		//Note: because preceding whitespace is added to the following node,
		// the '\n' is always added to the following composite node
		assertEquals(1,iter.next().getTotalStartLine());
		assertEquals(2,iter.next().getTotalStartLine());
		assertEquals(3,iter.next().getTotalStartLine());
		assertFalse(iter.hasNext());
	}


	@Test public void testErrors1() throws Exception {
		String model = "element # ;";
		ICompositeNode node = getRootNodeAndExpect(model, 1);
		assertEquals(model, node.getText());
		Iterator<ILeafNode> iter = node.getLeafNodes().iterator();
		int offset = 0;
		int count = 0;
		while(iter.hasNext()) {
			ILeafNode leafNode = iter.next();
			count++;
			assertEquals(offset,leafNode.getTotalOffset());
			offset += leafNode.getTotalLength();
		}
		assertEquals(5, count);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
	}
}
