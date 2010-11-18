/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCompositeNodeTest extends TestCase {

	public abstract void testTextOffsetLength();

	protected abstract ICompositeNode createCompositeNode();
	
	protected abstract AbstractNode getFirstChild(ICompositeNode node);

	protected abstract void addChild(ICompositeNode composite, LeafNode leaf);
	
	public void testAddChild_00() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		addChild(composite, first);
		assertSame(first, getFirstChild(composite));
		assertSame(composite, first.getParent());
		assertSame(first, first.getNext());
		assertSame(first, first.getPrevious());
	}

	public void testAddChild_01() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		addChild(composite, first);
		addChild(composite, second);
		assertSame(first, getFirstChild(composite));
		assertSame(second, first.getNext());
		assertSame(second, first.getPrevious());
		assertSame(first, second.getPrevious());
		assertSame(first, second.getNext());
		assertSame(composite, first.getParent());
		assertSame(composite, second.getParent());
	}
	
	public void testAddChild_02() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		LeafNode third = new LeafNode();
		addChild(composite, first);
		addChild(composite, second);
		addChild(composite, third);
		assertSame(first, getFirstChild(composite));
		assertSame(second, first.getNext());
		assertSame(third, second.getNext());
		assertSame(first, third.getNext());
		assertSame(third, first.getPrevious());
		assertSame(second, third.getPrevious());
		assertSame(first, second.getPrevious());
		assertSame(composite, first.getParent());
		assertSame(composite, second.getParent());
		assertSame(composite, third.getParent());
	}
	
	public void testActsAsAdapter() {
		EObject object = EcoreFactory.eINSTANCE.createEObject();
		ICompositeNode composite = createCompositeNode();
		object.eAdapters().add((Adapter) composite);
		assertSame(object, composite.getSemanticElement());
		assertSame(object, ((Adapter) composite).getTarget());
		object.eAdapters().clear();
		assertNull(composite.getSemanticElement());
	}

}
