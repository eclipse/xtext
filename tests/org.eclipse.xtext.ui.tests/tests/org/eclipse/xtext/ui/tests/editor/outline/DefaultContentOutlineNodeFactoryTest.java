/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultContentOutlineNodeFactoryTest extends AbstractContentOutlineTests {

	public void testNullSafety() {
		ContentOutlineNode contentOutlineNode = contentOutlineNodeFactory.create(null, null, null);
		assertEquals("<unknown>", contentOutlineNode.getLabel());
	}

	public void testGetText() {
		ContentOutlineNode a1OutlineNode = contentOutlineNodeFactory.create(null, a1, null);
		String a1Text = a1OutlineNode.getLabel();
		assertEquals("A1", a1Text);
		ContentOutlineNode a2OutlineNode = contentOutlineNodeFactory.create(null, a2, null);
		String a2Text = a2OutlineNode.getLabel();
		assertEquals("A2", a2Text);
	}

	public void testCreateWithoutParent() {
		ContentOutlineNode contentOutlineNode = contentOutlineNodeFactory.create(null, root, null);
		assertNotNull(contentOutlineNode);
		assertNull(contentOutlineNode.getParent());
	}

	public void testCreateWithParent() {
		ContentOutlineNode parent = contentOutlineNodeFactory.create(null, root, null);
		assertNotNull(parent);
		ContentOutlineNode outlineNode = contentOutlineNodeFactory.create(null, root, parent);
		assertNotNull(outlineNode);
		assertNotNull(outlineNode.getParent());
	}
}
