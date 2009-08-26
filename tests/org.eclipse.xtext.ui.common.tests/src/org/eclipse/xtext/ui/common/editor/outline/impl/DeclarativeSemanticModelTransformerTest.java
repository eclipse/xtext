/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import java.util.List;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.A;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.B;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.SimplestructureFactory;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.root;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractSemanticModelTransformer;
import org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DeclarativeSemanticModelTransformerTest extends AbstractXtextTests {

	private root theRoot;
	private XtextResource resource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		resource = new XtextResource();

		theRoot = SimplestructureFactory.eINSTANCE.createroot();
		resource.getContents().add(theRoot);

		A a1 = SimplestructureFactory.eINSTANCE.createA();
		a1.setName("a1");
		theRoot.getA().add(a1);

		A a2 = SimplestructureFactory.eINSTANCE.createA();
		a2.setName("a2");
		theRoot.getA().add(a2);

		B b1 = SimplestructureFactory.eINSTANCE.createB();
		b1.setName("b1");
		a1.getB().add(b1);

		B b2 = SimplestructureFactory.eINSTANCE.createB();
		b2.setName("b2");
		a1.getB().add(b2);

		B b3 = SimplestructureFactory.eINSTANCE.createB();
		b3.setName("b3");
		a1.getB().add(b3);
		
		B b4 = SimplestructureFactory.eINSTANCE.createB();
		b4.setName("b4");
		b3.getB().add(b4);
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		resource = null;
		theRoot = null;
	}

	public void testWithNamingConventions() {
		ISemanticModelTransformer transformer = new TestTransformerHelper.TestTransformerWithNamingConvention();
		ContentOutlineNode treeModel = transformer.transformSemanticModel(theRoot);

		assertEquals(AbstractSemanticModelTransformer.INVISIBLE_ROOT_NODE, treeModel.getLabel());

		List<ContentOutlineNode> children = treeModel.getChildren();
		ContentOutlineNode rootNode = children.get(0);
		assertEquals("root", rootNode.getLabel());

		List<ContentOutlineNode> children2 = rootNode.getChildren();
		ContentOutlineNode node1 = children2.get(0);
		assertEquals("special a1", node1.getLabel());
		ContentOutlineNode node2 = children2.get(1);
		assertEquals("special a2", node2.getLabel());
		
		List<ContentOutlineNode> children3 = node1.getChildren();
		ContentOutlineNode node3 = children3.get(0);
		ContentOutlineNode node4 = children3.get(1);
		ContentOutlineNode node5 = children3.get(2);
		assertEquals("pimped b1", node3.getLabel());
		assertEquals("pimped b2", node4.getLabel());
		assertEquals("pimped b3", node5.getLabel());
		
		List<ContentOutlineNode> children4 = node5.getChildren();
		assertEquals(0, children4.size());
	}
	
	public void testWithAnnotations() {
		ISemanticModelTransformer transformer = new TestTransformerHelper.TestTransformerWithAnnotations();
		ContentOutlineNode treeModel = transformer.transformSemanticModel(theRoot);

		assertEquals(AbstractSemanticModelTransformer.INVISIBLE_ROOT_NODE, treeModel.getLabel());

		List<ContentOutlineNode> children = treeModel.getChildren();
		ContentOutlineNode rootNode = children.get(0);
		assertEquals("root", rootNode.getLabel());

		List<ContentOutlineNode> children2 = rootNode.getChildren();
		ContentOutlineNode node1 = children2.get(0);
		assertEquals("special a1", node1.getLabel());
		ContentOutlineNode node2 = children2.get(1);
		assertEquals("special a2", node2.getLabel());
		
		List<ContentOutlineNode> children3 = node1.getChildren();
		ContentOutlineNode node3 = children3.get(0);
		ContentOutlineNode node4 = children3.get(1);
		ContentOutlineNode node5 = children3.get(2);
		assertEquals("pimped b1", node3.getLabel());
		assertEquals("pimped b2", node4.getLabel());
		assertEquals("pimped b3", node5.getLabel());
		
		List<ContentOutlineNode> children4 = node5.getChildren();
		assertEquals(0, children4.size());
	}
	
	
}
