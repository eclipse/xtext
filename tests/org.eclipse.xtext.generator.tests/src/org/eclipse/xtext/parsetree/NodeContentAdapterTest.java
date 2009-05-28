/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class NodeContentAdapterTest extends TestCase {
	
	private static final String TEXT0 = "Tests\n";
	private static final String TEXT1 = "are\n";
	private static final String TEXT2 = "so\n";
	private static final String TEXT3 = "great\n";
	private static final String TEXT4 = "not\n";
	private static final String TEXT5 = "text5\n";

	private CompositeNode root;
	private CompositeNode comp0;
	private CompositeNode comp1;
	private LeafNode leaf0;
	private LeafNode leaf1;
	private LeafNode leaf2;
	private LeafNode leaf3;
	private NodeContentAdapter contentAdapter;

	/**
	 * root +- leaf0 = TEXT0
	 *      +- comp0 +- leaf1 = TEXT1
	 *      +- comp1 +- leaf2 = TEXT2
	 *      +- leaf3 = TEXT3
	 */
	@Override
	protected void setUp() throws Exception {
		root = ParsetreeFactory.eINSTANCE.createCompositeNode();
		contentAdapter = new NodeContentAdapter();
	}

	private void createTree(CompositeNode root) {
		comp0 = ParsetreeFactory.eINSTANCE.createCompositeNode();
		comp1 = ParsetreeFactory.eINSTANCE.createCompositeNode();
		leaf0 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf1 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf2 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf3 = ParsetreeFactory.eINSTANCE.createLeafNode();
		
		leaf0.setText(TEXT0);
		leaf1.setText(TEXT1);
		leaf2.setText(TEXT2);
		leaf3.setText(TEXT3);
		
		root.getChildren().add(leaf0);
		root.getChildren().add(comp0);
		comp0.getChildren().add(leaf1);
		root.getChildren().add(comp1);
		comp1.getChildren().add(leaf2);
		root.getChildren().add(leaf3);
	}
	
	public void testAdaptContainment() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		assertInitialSetting();		
	}

	public void testAdaptOnAdd() throws Exception {
		contentAdapter.addToNode(root);
		createTree(root);
		assertInitialSetting();		
	}

	private void assertInitialSetting() {
		assertTrue(comp0.eAdapters().contains(contentAdapter));
		assertTrue(comp1.eAdapters().contains(contentAdapter));
		assertTrue(leaf0.eAdapters().contains(contentAdapter));
		assertTrue(leaf1.eAdapters().contains(contentAdapter));
		assertTrue(leaf2.eAdapters().contains(contentAdapter));
		assertTrue(leaf3.eAdapters().contains(contentAdapter));
		
		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length(), leaf3.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, comp0.getTotalLine());
		assertEquals(2, leaf1.getTotalLine());
		assertEquals(3, comp1.getTotalLine());
		assertEquals(3, leaf2.getTotalLine());
		assertEquals(4, leaf3.getTotalLine());
	}
	
	public void testRemove() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		comp0.getChildren().remove(leaf1);

		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT2.length(), leaf3.getTotalOffset());
		
		assertEquals(TEXT0.length() + TEXT2.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(0, comp0.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());		
		assertEquals(TEXT2.length(), leaf2.getTotalLength());		
		assertEquals(TEXT3.length(), leaf3.getTotalLength());		
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, comp0.getTotalLine());
		assertEquals(2, comp1.getTotalLine());
		assertEquals(2, leaf2.getTotalLine());
		assertEquals(3, leaf3.getTotalLine());
	}
	
	public void testMoveRight() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		root.getChildren().move(2, comp0);
		
		assertTrue(comp0.eAdapters().contains(contentAdapter));
		assertTrue(comp1.eAdapters().contains(contentAdapter));
		assertTrue(leaf0.eAdapters().contains(contentAdapter));
		assertTrue(leaf1.eAdapters().contains(contentAdapter));
		assertTrue(leaf2.eAdapters().contains(contentAdapter));
		assertTrue(leaf3.eAdapters().contains(contentAdapter));
		
		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT2.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT2.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length(), leaf3.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(3, comp0.getTotalLine());
		assertEquals(3, leaf1.getTotalLine());
		assertEquals(2, comp1.getTotalLine());
		assertEquals(2, leaf2.getTotalLine());
		assertEquals(4, leaf3.getTotalLine());
	}
	
	public void testMoveLeft() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		root.getChildren().move(1, comp1);
		
		assertTrue(comp0.eAdapters().contains(contentAdapter));
		assertTrue(comp1.eAdapters().contains(contentAdapter));
		assertTrue(leaf0.eAdapters().contains(contentAdapter));
		assertTrue(leaf1.eAdapters().contains(contentAdapter));
		assertTrue(leaf2.eAdapters().contains(contentAdapter));
		assertTrue(leaf3.eAdapters().contains(contentAdapter));
		
		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT2.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT2.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length(), leaf3.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(3, comp0.getTotalLine());
		assertEquals(3, leaf1.getTotalLine());
		assertEquals(2, comp1.getTotalLine());
		assertEquals(2, leaf2.getTotalLine());
		assertEquals(4, leaf3.getTotalLine());
	}
	
	public void testRemoveManyLastFirst() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		Collection<AbstractNode> removeUs = new ArrayList<AbstractNode>();
		removeUs.add(comp1);
		removeUs.add(comp0);
		
		root.getChildren().removeAll(removeUs);

		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf3.getTotalOffset());
		
		assertEquals(TEXT0.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());		
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, leaf3.getTotalLine());
	}
	
	public void testRemoveMany() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		Collection<AbstractNode> removeUs = new ArrayList<AbstractNode>();
		removeUs.add(comp0);
		removeUs.add(comp1);
		
		root.getChildren().removeAll(removeUs);

		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf3.getTotalOffset());
		
		assertEquals(TEXT0.length() + TEXT3.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());		
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, leaf3.getTotalLine());
	}
	
	public void testSet() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		LeafNode leaf4 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf4.setText(TEXT4);
		
		root.getChildren().set(3, leaf4);

		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length(), leaf4.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT4.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT4.length(), leaf4.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, comp0.getTotalLine());
		assertEquals(2, leaf1.getTotalLine());
		assertEquals(3, comp1.getTotalLine());
		assertEquals(3, leaf2.getTotalLine());
		assertEquals(4, leaf4.getTotalLine());
	}
	
	public void testAddMany() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		LeafNode leaf4 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf4.setText(TEXT4);
		LeafNode leaf5 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf5.setText(TEXT5);
		
		Collection<AbstractNode> addUs = new ArrayList<AbstractNode>();
		addUs.add(leaf4);
		addUs.add(leaf5);

		comp0.getChildren().addAll(0, addUs);
		
		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf4.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT4.length(), leaf5.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT4.length() + TEXT5.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT4.length() + TEXT5.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT4.length() + TEXT5.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT4.length() + TEXT5.length(), leaf3.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT3.length() + TEXT4.length() + TEXT5.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT4.length() + TEXT5.length() + TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT4.length(), leaf4.getTotalLength());
		assertEquals(TEXT5.length(), leaf5.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, comp0.getTotalLine());
		assertEquals(2, leaf4.getTotalLine());
		assertEquals(3, leaf5.getTotalLine());
		assertEquals(4, leaf1.getTotalLine());
		assertEquals(5, comp1.getTotalLine());
		assertEquals(5, leaf2.getTotalLine());
		assertEquals(6, leaf3.getTotalLine());
	}

	public void testAdd() throws Exception {
		createTree(root);
		contentAdapter.addToNode(root);
		
		LeafNode leaf4 = ParsetreeFactory.eINSTANCE.createLeafNode();
		leaf4.setText(TEXT4);
		
		comp0.getChildren().add(0, leaf4);

		assertEquals(0, root.getTotalOffset());
		assertEquals(0, leaf0.getTotalOffset());
		assertEquals(TEXT0.length(), comp0.getTotalOffset());
		assertEquals(TEXT0.length(), leaf4.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT4.length(), leaf1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT4.length(), comp1.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT4.length(), leaf2.getTotalOffset());
		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT4.length(), leaf3.getTotalOffset());

		assertEquals(TEXT0.length() + TEXT1.length() + TEXT2.length() + TEXT3.length() + TEXT4.length(), root.getTotalLength());
		assertEquals(TEXT0.length(), leaf0.getTotalLength());
		assertEquals(TEXT4.length() + TEXT1.length(), comp0.getTotalLength());
		assertEquals(TEXT4.length(), leaf4.getTotalLength());
		assertEquals(TEXT1.length(), leaf1.getTotalLength());
		assertEquals(TEXT2.length(), comp1.getTotalLength());
		assertEquals(TEXT2.length(), leaf2.getTotalLength());
		assertEquals(TEXT3.length(), leaf3.getTotalLength());
		
		assertEquals(1, root.getTotalLine());
		assertEquals(1, leaf0.getTotalLine());
		assertEquals(2, comp0.getTotalLine());
		assertEquals(2, leaf4.getTotalLine());
		assertEquals(3, leaf1.getTotalLine());
		assertEquals(4, comp1.getTotalLine());
		assertEquals(4, leaf2.getTotalLine());
		assertEquals(5, leaf3.getTotalLine());
	}
}
