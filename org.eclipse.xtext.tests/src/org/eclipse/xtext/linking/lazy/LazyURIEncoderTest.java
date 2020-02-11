/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LazyURIEncoderTest extends Assert {
	
	@Test public void testNodePath() throws Exception {
		NodeModelBuilder builder = new NodeModelBuilder();
		ICompositeNode n = new CompositeNode();
		ICompositeNode n1 = new CompositeNode();
		builder.addChild(n, (AbstractNode) n1);
		ICompositeNode n2 = new CompositeNode();
		builder.addChild(n, (AbstractNode) n2);
		ILeafNode l1 = new LeafNode();
		builder.addChild(n2, (AbstractNode) l1);
		ILeafNode l2 = new LeafNode();
		builder.addChild(n2, (AbstractNode) l2);
		
		assertEquals(n, find(n,n));
		assertEquals(n1, find(n,n1));
		assertEquals(n2, find(n,n2));
		assertEquals(l1, find(n,l1));
		assertEquals(l2, find(n,l2));
	}
	
	private LazyURIEncoder encoder;
	
	@Before
	public void setUp() throws Exception {
		encoder = new LazyURIEncoder();
	}
	
	@After
	public void tearDown() throws Exception {
		encoder = null;
	}
	
	private INode find(INode parent, INode toFind) {
		StringBuilder builder = new StringBuilder();
		encoder.getRelativePath(builder, parent, toFind);
		String string = builder.toString();
		return encoder.getNode(parent, string);
	}
}
