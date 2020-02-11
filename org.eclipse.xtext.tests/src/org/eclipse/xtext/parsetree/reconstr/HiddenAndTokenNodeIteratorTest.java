/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.impl.HiddenAndTokenNodeIterator;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class HiddenAndTokenNodeIteratorTest extends Assert {

	private static final int NUM_NODES = 10;
	private INode[] nodes;

	@Before
	public void setUp() throws Exception {
		nodes = new INode[NUM_NODES];
		NodeModelBuilder builder = new NodeModelBuilder();
		nodes[0] = new CompositeNode();
		nodes[1] = new CompositeNode();
		nodes[2] = new HiddenLeafNode();
		nodes[3] = new LeafNode();
		nodes[4] = new HiddenLeafNode();
		nodes[5] = new CompositeNode();
		nodes[6] = new LeafNode();
		nodes[7] = new CompositeNode();
		nodes[8] = new HiddenLeafNode();
		nodes[9] = new LeafNode();
		
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[1]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[5]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[7]);
		builder.addChild((ICompositeNode)nodes[0], (AbstractNode)nodes[9]);
		builder.addChild((ICompositeNode)nodes[1], (AbstractNode)nodes[2]);
		builder.addChild((ICompositeNode)nodes[1], (AbstractNode)nodes[3]);
		builder.addChild((ICompositeNode)nodes[1], (AbstractNode)nodes[4]);
		builder.addChild((ICompositeNode)nodes[5], (AbstractNode)nodes[6]);
		builder.addChild((ICompositeNode)nodes[7], (AbstractNode)nodes[8]);
	}
	
	private TokenUtil getTokenUtil() {
		return new TokenUtil() {
			{
				hiddenTokenHelper = new DefaultHiddenTokenHelper();
			}
			
			@Override
			public boolean isToken(INode node) {
				return node == nodes[1] || node == nodes[5];
			}
			
			@Override
			public boolean isCommentNode(INode node) {
				return node == nodes[8];
			}

			@Override
			public boolean isWhitespaceNode(INode node) {
				return node == nodes[9];
			}
		};
	}

	
	@Test public void testIterator() throws Exception {
		HiddenAndTokenNodeIterator iterator = new HiddenAndTokenNodeIterator(nodes[0], getTokenUtil());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[2], iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[1], iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[4], iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[5], iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[8], iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nodes[9], iterator.next());
		assertFalse(iterator.hasNext());
	}
}
