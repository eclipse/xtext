/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LazyURIEncoderTest extends TestCase {
	
	public void testNodePath() throws Exception {
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
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		encoder = new LazyURIEncoder();
	}
	
	@Override
	protected void tearDown() throws Exception {
		encoder = null;
		super.tearDown();
	}
	
	private INode find(INode parent, INode toFind) {
		StringBuilder builder = new StringBuilder();
		encoder.getRelativePath(builder, parent, toFind);
		String string = builder.toString();
		return encoder.getNode(parent, string);
	}
}
