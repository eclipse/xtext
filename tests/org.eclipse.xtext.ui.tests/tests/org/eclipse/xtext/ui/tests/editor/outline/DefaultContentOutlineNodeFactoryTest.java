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
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultContentOutlineNodeFactoryTest extends AbstractContentOutlineTests {

	public void testNullSafety() {
		IContentOutlineNode contentOutlineNode = contentOutlineNodeFactory.create(null, null, null);
		assertEquals("", contentOutlineNode.getLabel());
	}

	public void testGetText() {
		IContentOutlineNode a1OutlineNode = contentOutlineNodeFactory.create(null, a1, null);
		String a1Text = a1OutlineNode.getLabel();
		assertEquals("A1", a1Text);
		IContentOutlineNode a2OutlineNode = contentOutlineNodeFactory.create(null, a2, null);
		String a2Text = a2OutlineNode.getLabel();
		assertEquals("A2", a2Text);
	}

	public void testCreateWithoutParent() {
		IContentOutlineNode contentOutlineNode = contentOutlineNodeFactory.create(null, root, null);
		assertNotNull(contentOutlineNode);
		assertNull(contentOutlineNode.getParent());
	}

	public void testCreateWithParent() {
		ContentOutlineNode parent = contentOutlineNodeFactory.create(null, root, null);
		assertNotNull(parent);
		IContentOutlineNode outlineNode = contentOutlineNodeFactory.create(null, root, parent);
		assertNotNull(outlineNode);
		assertNotNull(outlineNode.getParent());
	}
}
