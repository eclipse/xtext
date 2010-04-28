/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNodeComparer;

import junit.framework.TestCase;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlineNodeComparerTest extends TestCase {
	
	private static final String PARENT = "parent";
	private static final String CHILD_0 = "child0";
	private static final String CHILD_1 = "child1";
	private static final String CHILD_2 = "child2";
	
	private IContentOutlineNodeComparer comparer;
	private ContentOutlineNode parent;
	private ContentOutlineNode child0;
	private ContentOutlineNode child1;
	private ContentOutlineNode newParent;
	private ContentOutlineNode newChild0;
	private ContentOutlineNode newChild1;
	private ContentOutlineNode newInsertedChild;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		comparer = new IContentOutlineNodeComparer.Default();
		parent = new ContentOutlineNode(PARENT);
		child0 = new ContentOutlineNode(CHILD_0);
		child1 = new ContentOutlineNode(CHILD_1);
		parent.addChildren(child0);
		parent.addChildren(child1);

		newParent = new ContentOutlineNode(PARENT);
		newChild0 = new ContentOutlineNode(CHILD_0);
		newChild1 = new ContentOutlineNode(CHILD_1);
		newInsertedChild = new ContentOutlineNode(CHILD_2);
	}
	
	public void testSameStructureComparer() throws Exception {
		assertFalse(comparer.equals(child0, child1));
		assertFalse(comparer.equals(newChild0, newChild1));
		assertFalse(comparer.equals(newChild1, newInsertedChild));
		assertFalse(comparer.equals(newChild0, newInsertedChild));

		newParent.addChildren(newChild0);
		newParent.addChildren(newChild1);
		checkEqualities();
	}		
	
	public void testInsertBefore() {
		newParent.addChildren(newInsertedChild);
		newParent.addChildren(newChild0);
		newParent.addChildren(newChild1);
		checkEqualities();
	}

	public void testInsertBetween() {
		newParent.addChildren(newChild0);
		newParent.addChildren(newInsertedChild);
		newParent.addChildren(newChild1);
		checkEqualities();		
	}

	public void testInsertAfter() {
		newParent.addChildren(newChild0);
		newParent.addChildren(newChild1);
		newParent.addChildren(newInsertedChild);
		checkEqualities();
	}
	
	private void checkEqualities() {
		assertTrue(comparer.equals(child0, newChild0));
		assertFalse(comparer.equals(child0, newChild1));
		assertFalse(comparer.equals(child0, newInsertedChild));
		assertFalse(comparer.equals(child1, newChild0));
		assertTrue(comparer.equals(child1, newChild1));
		assertFalse(comparer.equals(child1, newInsertedChild));
	}
}
