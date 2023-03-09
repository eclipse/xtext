/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.junit.Test;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNodeTest extends AbstractCompositeNodeTest {

	@Override
	@Test public void testTextOffsetLength() {
		RootNode root = new RootNode();
		String completeContent = " completeContent ";
		root.basicSetCompleteContent(completeContent);
		LeafNode firstChild = new LeafNode();
		firstChild.basicSetTotalLength(1);
		firstChild.basicSetTotalOffset(0);
		addChild(root, firstChild);
		CompositeNodeWithSemanticElement composite = createCompositeNode();
		LeafNode child = new LeafNode();
		child.basicSetTotalOffset(1);
		child.basicSetTotalLength(completeContent.trim().length());
		addChild(composite, child);
		addChild(root, composite);
		LeafNode lastChild = new LeafNode();
		lastChild.basicSetTotalLength(1);
		lastChild.basicSetTotalOffset(completeContent.length() - 2);
		addChild(root, lastChild);
		assertEquals(completeContent.trim(), composite.getText());
		assertEquals(1, composite.getTotalOffset());
		assertEquals(completeContent.trim().length(), composite.getTotalLength());
	}
	
	@Test public void testGetTotalOffsetWithoutChildren() {
		RootNode rootNode = new RootNode();
		rootNode.basicSetCompleteContent("my string");
		LeafNode leafNode = new LeafNode();
		leafNode.basicSetTotalOffset(0);
		leafNode.basicSetTotalLength(3);
		addChild(rootNode, leafNode);
		CompositeNodeWithSemanticElement firstChild = createCompositeNode();
		CompositeNodeWithSemanticElement firstGrandChild = createCompositeNode();
		CompositeNodeWithSemanticElement secondChild = createCompositeNode();
		CompositeNodeWithSemanticElement secondGrandChild = createCompositeNode();
		CompositeNodeWithSemanticElement thirdChild = createCompositeNode();
		CompositeNodeWithSemanticElement thirdGrandChild = createCompositeNode();
		addChild(rootNode, firstChild);
		addChild(firstChild, firstGrandChild);
		addChild(rootNode, secondChild);
		addChild(secondChild, secondGrandChild);
		addChild(rootNode, thirdChild);
		addChild(thirdChild, thirdGrandChild);
		
		assertEquals(0, rootNode.getTotalOffset());		
		assertEquals(0, rootNode.getOffset());		
		assertEquals(3, firstChild.getTotalOffset());		
		assertEquals(3, firstChild.getOffset());		
		assertEquals(3, firstGrandChild.getTotalOffset());		
		assertEquals(3, firstGrandChild.getOffset());		
		assertEquals(3, secondChild.getTotalOffset());		
		assertEquals(3, secondChild.getOffset());		
		assertEquals(3, secondGrandChild.getTotalOffset());		
		assertEquals(3, secondGrandChild.getOffset());		
		assertEquals(3, thirdChild.getTotalOffset());		
		assertEquals(3, thirdChild.getOffset());		
		assertEquals(3, thirdGrandChild.getTotalOffset());		
		assertEquals(3, thirdGrandChild.getOffset());		
	}
	
	@Test public void testGetLeafNodes_01() {
		RootNode rootNode = new RootNode();
		rootNode.basicSetCompleteContent("my string");
		CompositeNode first = new CompositeNode();
		CompositeNode childOfFirst = new CompositeNode();
		CompositeNode second = new CompositeNode();
		addChild(rootNode, first);
		addChild(first, childOfFirst);
		addChild(rootNode, second);
		LeafNode leaf = new LeafNode();
		addChild(second, leaf);
		assertTrue(Iterables.isEmpty(first.getLeafNodes()));
		assertTrue(Iterables.isEmpty(childOfFirst.getLeafNodes()));
		assertSame(leaf, Iterables.getOnlyElement(rootNode.getLeafNodes()));
		assertSame(leaf, Iterables.getOnlyElement(second.getLeafNodes()));
		
		assertTrue(Iterables.isEmpty(getReverseLeafNodes(first)));
		assertTrue(Iterables.isEmpty(getReverseLeafNodes(childOfFirst)));
		assertSame(leaf, Iterables.getOnlyElement(getReverseLeafNodes(rootNode)));
		assertSame(leaf, Iterables.getOnlyElement(getReverseLeafNodes(second)));
	}
	
	protected Iterable<ILeafNode> getReverseLeafNodes(final AbstractNode node) {
		return Iterables.filter(new Iterable<INode>() {
			@Override
			public Iterator<INode> iterator() {
				return new AbstractIterator<INode>() {

					private BidiTreeIterator<AbstractNode> delegate = node.basicIterator();
					
					@Override
					protected INode computeNext() {
						if (delegate.hasPrevious())
							return delegate.previous();
						return endOfData();
					}
				};
			}
		}, ILeafNode.class);
	}
	
	@Override
	protected AbstractNode getFirstChild(ICompositeNode node) {
		return ((CompositeNodeWithSemanticElement) node).basicGetFirstChild();
	}
	
	@Override
	protected CompositeNodeWithSemanticElement createCompositeNode() {
		return new CompositeNodeWithSemanticElement();
	}
	
	@Test public void testIsAdapterForType() {
		EObject object = EcoreFactory.eINSTANCE.createEObject();
		CompositeNodeWithSemanticElement node = createCompositeNode();
		object.eAdapters().add(node);
		AdapterFactory adapterFactory = new EcoreAdapterFactory();
		Adapter adapter = adapterFactory.adapt(object, INode.class);
		assertSame(node, adapter);
		// the following line may not throw a ClassCastException
		Adapter secondAdapter = adapterFactory.adapt(object, new Object());
		assertNull(secondAdapter);
	}
}
