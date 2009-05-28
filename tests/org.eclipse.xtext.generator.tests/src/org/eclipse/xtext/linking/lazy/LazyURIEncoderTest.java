/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import junit.framework.TestCase;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LazyURIEncoderTest extends TestCase {
	
	public void testNodePath() throws Exception {
		ParsetreeFactory f = ParsetreeFactory.eINSTANCE;
		CompositeNode n = f.createCompositeNode();
		CompositeNode n1 = f.createCompositeNode();
		n.getChildren().add(n1);
		CompositeNode n2 = f.createCompositeNode();
		n.getChildren().add(n2);
		LeafNode l1 = f.createLeafNode();
		n2.getChildren().add(l1);
		LeafNode l2 = f.createLeafNode();
		n2.getChildren().add(l2);
		
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
	
	private AbstractNode find(AbstractNode parent, AbstractNode toFind) {
		StringBuilder builder = new StringBuilder();
		encoder.getRelativePath(builder, parent, toFind);
		String string = builder.toString();
		return encoder.getNode(parent, string);
	}
}
