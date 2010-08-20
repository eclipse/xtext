/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import junit.framework.TestCase;

import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNodeForTextSelectionFinder;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ContentOutlineNodeForTextSelectionFinderTest extends TestCase {

	protected IContentOutlineNodeForTextSelectionFinder.Default finder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		finder = new IContentOutlineNodeForTextSelectionFinder.Default();
	}

	public void testParentHasNullRegion() {
		ContentOutlineNode root = new ContentOutlineNode(new StyledString("root"), null, null, null, null);
		finder.setTextSelection(new Point(0, 1));
		finder.traverse(root);
		assertNull(finder.getBestMatch());

		root = new ContentOutlineNode(new StyledString("root"), null, null, null, null);
		ContentOutlineNode child = createNode("child",0,1);
		root.addChildren(child);
		finder.traverse(root);
		assertEquals(child, finder.getBestMatch());
	}

	public void testTextAreaMustBeSet() {
		ContentOutlineNode root = new ContentOutlineNode(new StyledString("root"), null, null, null, null);
		try {
			finder.traverse(root);
			fail("Exception not thrown");
		} catch(IllegalStateException exc) {
			// normal op
		}
	}
	
	public void testSameRegion() {
		ContentOutlineNode node = createNode("node", 1, 2);
		finder.setTextSelection(new Point(1, 2));
		finder.traverse(node);
		assertEquals(node, finder.getBestMatch());
	}
	
	public void testOverlapRegionLeft() {
		ContentOutlineNode node = createNode("node", 0, 2);
		finder.setTextSelection(new Point(1, 2));
		finder.traverse(node);
		assertEquals(node, finder.getBestMatch());
	}
	
	public void testOverlapRegionRight() {
		ContentOutlineNode node = createNode("node", 1, 3);
		finder.setTextSelection(new Point(1, 2));
		finder.traverse(node);
		assertEquals(node, finder.getBestMatch());
	}	
	
	public void testOverlapRegionBoth() {
		ContentOutlineNode node = createNode("node", 0, 3);
		finder.setTextSelection(new Point(1, 2));
		finder.traverse(node);
		assertEquals(node, finder.getBestMatch());
	}	
	
	public void testOffsetOutsideLeft() {
		ContentOutlineNode node = createNode("node", 1, 3);
		finder.setTextSelection(new Point(0, 2));
		finder.traverse(node);
		assertNull(finder.getBestMatch());
	}	
	
	public void testOffsetOutsideRight() {
		ContentOutlineNode node = createNode("node", 1, 3);
		finder.setTextSelection(new Point(4, 6));
		finder.traverse(node);
		assertNull(finder.getBestMatch());
	}	
	
	public void testEndOutsideLeft() {
		ContentOutlineNode node = createNode("node", 3, 3);
		finder.setTextSelection(new Point(0, 2));
		finder.traverse(node);
		assertNull(finder.getBestMatch());
	}	
	
	public void testEndOutsideRight() {
		ContentOutlineNode node = createNode("node", 1, 2);
		finder.setTextSelection(new Point(2, 4));
		finder.traverse(node);
		assertNull(finder.getBestMatch());
	}	
	
	public void testParentIsBetter() {
		ContentOutlineNode root = createNode("root", 2, 2);
		ContentOutlineNode child = createNode("child", 1, 4);
		root.addChildren(child);
		finder.setTextSelection(new Point(2,4));
		finder.traverse(root);
		assertEquals(root, finder.getBestMatch());
	}
	
	public void testChildIsBetter() {
		ContentOutlineNode root = createNode("root", 1, 4);
		ContentOutlineNode child = createNode("child", 2, 2);
		root.addChildren(child);
		finder.setTextSelection(new Point(2,4));
		finder.traverse(root);
		assertEquals(child, finder.getBestMatch());
	}
	
	protected ContentOutlineNode createNode(String name, int offset, int length) {
		return new ContentOutlineNode(new StyledString(name), null, new Region(offset, length), null, null);
	}

}
