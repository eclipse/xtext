/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.RootNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootNodeTest extends TestCase {

	public void testTextOffsetLength() {
		RootNode rootNode = new RootNode();
		String completeContent = "completeContent";
		rootNode.setCompleteContent(completeContent);
		assertEquals(completeContent, rootNode.getText());
		assertEquals(0, rootNode.getTotalOffset());
		assertEquals(completeContent.length(), rootNode.getTotalLength());
	}
	
	public void testSetFirstChild() {
		RootNode rootNode = new RootNode();
		LeafNode leaf = new LeafNode();
		rootNode.setFirstChild(leaf);
		assertSame(leaf, rootNode.getFirstChild());
		assertSame(rootNode, leaf.getParent());
		rootNode.setFirstChild(null);
		assertNull(leaf.getParent());
		assertNull(rootNode.getFirstChild());
	}
	
	public void testAddChild_00() {
		RootNode rootNode = new RootNode();
		LeafNode first = new LeafNode();
		rootNode.addChild(first);
		assertSame(first, rootNode.getFirstChild());
		assertSame(first, first.getNext());
		assertSame(first, first.getPrevious());
	}
	
	public void testAddChild_01() {
		RootNode rootNode = new RootNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		rootNode.addChild(first);
		rootNode.addChild(second);
		assertSame(first, rootNode.getFirstChild());
		assertSame(second, first.getNext());
		assertSame(second, first.getPrevious());
		assertSame(first, second.getPrevious());
		assertSame(first, second.getNext());
		assertSame(rootNode, first.getParent());
		assertSame(rootNode, second.getParent());
	}
	
	public void testAddChild_02() {
		RootNode rootNode = new RootNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		LeafNode third = new LeafNode();
		rootNode.addChild(first);
		rootNode.addChild(second);
		rootNode.addChild(third);
		assertSame(first, rootNode.getFirstChild());
		assertSame(second, first.getNext());
		assertSame(third, second.getNext());
		assertSame(first, third.getNext());
		assertSame(third, first.getPrevious());
		assertSame(second, third.getPrevious());
		assertSame(first, second.getPrevious());
		assertSame(rootNode, first.getParent());
		assertSame(rootNode, second.getParent());
		assertSame(rootNode, third.getParent());
	}
	
	public void testActsAsAdapter() {
		EObject object = EcoreFactory.eINSTANCE.createEObject();
		RootNode rootNode = new RootNode();
		object.eAdapters().add(rootNode);
		assertSame(object, rootNode.getSemanticElement());
		assertSame(object, rootNode.getTarget());
		object.eAdapters().clear();
		assertNull(rootNode.getSemanticElement());
	}
	
}
