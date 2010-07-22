/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline.transformer;

import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.transformer.DefaultSemanticModelTransformer;
import org.eclipse.xtext.ui.tests.editor.outline.AbstractContentOutlineTests;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultSemanticModelTransformerTest extends AbstractContentOutlineTests {
	private DefaultSemanticModelTransformer defaultSemanticModelTransformer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		defaultSemanticModelTransformer = new DefaultSemanticModelTransformer();
		defaultSemanticModelTransformer.setResourceAccess(this);
		defaultSemanticModelTransformer.setContentOutlineNodeFactory(contentOutlineNodeFactory);
	}

	public void testNullSafety() {
		assertNotNull(defaultSemanticModelTransformer.transformSemanticModel(null));
		assertFalse(defaultSemanticModelTransformer.consumeSemanticChildNodes(null));
		assertFalse(defaultSemanticModelTransformer.consumeSemanticNode(null));
	}

	public void testConsumeSemanticNode() {
		boolean consumeSemanticNode = defaultSemanticModelTransformer.consumeSemanticNode(root);
		assertTrue(consumeSemanticNode);
	}

	public void testTransformWithImplicitRootNode() {
		ContentOutlineNode contentOutlineNode = defaultSemanticModelTransformer.transformSemanticModel(root);
		assertNotNull(contentOutlineNode);
		assertNotNull(contentOutlineNode.getChildren());
		assertFalse(contentOutlineNode.getChildren().isEmpty());
		assertEquals(1, contentOutlineNode.getChildren().size());
	}

	public void testChildrenCount() {
		ContentOutlineNode contentOutlineNode = defaultSemanticModelTransformer.transformSemanticModel(root);
		ContentOutlineNode rootNode = contentOutlineNode.getChildren().iterator().next();
		assertNotNull(rootNode);
		assertNotNull(rootNode.getChildren());
		assertFalse(rootNode.getChildren().isEmpty());
		assertEquals(2, rootNode.getChildren().size());
	}

	public void testConsumeSemanticChildNodes() {
		boolean consumeSemanticChildNodes = defaultSemanticModelTransformer.consumeSemanticChildNodes(root);
		assertTrue(consumeSemanticChildNodes);
	}

	public void testGetUri() {
		ContentOutlineNode rootNode = defaultSemanticModelTransformer.transformSemanticModel(root);
		ContentOutlineNode treeRootNode = rootNode.getChildren().get(0);
		assertEquals("classpath:/org/eclipse/xtext/ui/tests/editor/outline/transformer/simplestructure.xmi#/",
				treeRootNode.getURI().toString());
	}

}
