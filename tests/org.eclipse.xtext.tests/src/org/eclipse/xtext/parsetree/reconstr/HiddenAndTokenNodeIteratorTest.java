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
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.impl.HiddenAndTokenNodeIterator;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;

/**
 * @author koehnlein - Initial contribution and API
 */
public class HiddenAndTokenNodeIteratorTest extends TestCase {

	private static final int NUM_NODES = 10;
	private AbstractNode[] nodes;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		nodes = new AbstractNode[NUM_NODES];
		nodes[0] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[1] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[2] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[3] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[4] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[5] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[6] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[7] = ParsetreeFactory.eINSTANCE.createCompositeNode();
		nodes[8] = ParsetreeFactory.eINSTANCE.createLeafNode();
		nodes[9] = ParsetreeFactory.eINSTANCE.createLeafNode();
		
		((CompositeNode)nodes[0]).getChildren().add(nodes[1]);
		((CompositeNode)nodes[0]).getChildren().add(nodes[5]);
		((CompositeNode)nodes[0]).getChildren().add(nodes[7]);
		((CompositeNode)nodes[0]).getChildren().add(nodes[9]);
		((CompositeNode)nodes[1]).getChildren().add(nodes[2]);
		((CompositeNode)nodes[1]).getChildren().add(nodes[3]);
		((CompositeNode)nodes[1]).getChildren().add(nodes[4]);
		((CompositeNode)nodes[5]).getChildren().add(nodes[6]);
		((CompositeNode)nodes[7]).getChildren().add(nodes[8]);

		((LeafNode) nodes[2]).setHidden(true);
		((LeafNode) nodes[4]).setHidden(true);
		((LeafNode) nodes[8]).setHidden(true);
	}
	
	private TokenUtil getTokenUtil() {
		return new TokenUtil() {
			{
				hiddenTokenHelper = new DefaultHiddenTokenHelper();
			}
			
			@Override
			public boolean isToken(AbstractNode node) {
				return node == nodes[1] || node == nodes[5];
			}
			
			@Override
			public boolean isCommentNode(AbstractNode node) {
				return node == nodes[8];
			}

			@Override
			public boolean isWhitespaceNode(AbstractNode node) {
				return node == nodes[9];
			}
		};
	}

	
	public void testIterator() throws Exception {
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
