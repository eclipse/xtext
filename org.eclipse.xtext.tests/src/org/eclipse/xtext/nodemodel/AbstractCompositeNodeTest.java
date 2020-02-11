/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCompositeNodeTest extends Assert {

	private NodeModelBuilder mutator;

	public abstract void testTextOffsetLength();

	protected abstract ICompositeNode createCompositeNode();
	
	protected abstract AbstractNode getFirstChild(ICompositeNode node);

	protected final void addChild(ICompositeNode composite, AbstractNode leaf) {
		mutator.addChild(composite, leaf);
	}
	
	@Before
	public void setUp() throws Exception {
		this.mutator = new NodeModelBuilder();
	}
	
	@After
	public void tearDown() throws Exception {
		this.mutator = null;
	}
	
	@Test public void testAddChild_00() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		addChild(composite, first);
		assertSame(first, getFirstChild(composite));
		assertSame(composite, first.getParent());
		assertSame(first, first.basicGetNextSibling());
		assertSame(first, first.basicGetPreviousSibling());
	}

	@Test public void testAddChild_01() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		addChild(composite, first);
		addChild(composite, second);
		assertSame(first, getFirstChild(composite));
		assertSame(second, first.getNextSibling());
		assertSame(second, first.basicGetPreviousSibling());
		assertSame(first, second.getPreviousSibling());
		assertSame(first, second.basicGetNextSibling());
		assertSame(composite, first.getParent());
		assertSame(composite, second.getParent());
	}
	
	@Test public void testAddChild_02() {
		ICompositeNode composite = createCompositeNode();
		LeafNode first = new LeafNode();
		LeafNode second = new LeafNode();
		LeafNode third = new LeafNode();
		addChild(composite, first);
		addChild(composite, second);
		addChild(composite, third);
		assertSame(first, getFirstChild(composite));
		assertSame(second, first.getNextSibling());
		assertSame(third, second.getNextSibling());
		assertSame(first, third.basicGetNextSibling());
		assertSame(third, first.basicGetPreviousSibling());
		assertSame(second, third.getPreviousSibling());
		assertSame(first, second.getPreviousSibling());
		assertSame(composite, first.getParent());
		assertSame(composite, second.getParent());
		assertSame(composite, third.getParent());
	}
	
	@Test public void testActsAsAdapter() {
		EObject object = EcoreFactory.eINSTANCE.createEObject();
		ICompositeNode composite = createCompositeNode();
		object.eAdapters().add((Adapter) composite);
		assertSame(object, composite.getSemanticElement());
		assertSame(object, ((Adapter) composite).getTarget());
		object.eAdapters().clear();
		assertNull(composite.getSemanticElement());
	}

}
