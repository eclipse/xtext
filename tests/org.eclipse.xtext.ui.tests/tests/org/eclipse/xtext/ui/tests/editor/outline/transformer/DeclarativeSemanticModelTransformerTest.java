/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline.transformer;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.A;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.B;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.SimplestructureFactory;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.root;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractSemanticModelTransformer;
import org.eclipse.xtext.ui.editor.outline.transformer.ISemanticModelTransformer;
import org.eclipse.xtext.ui.tests.editor.outline.TestTransformerHelper;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DeclarativeSemanticModelTransformerTest extends AbstractXtextTests implements IStateAccess<XtextResource> {

	private root theRoot;
	private XtextResource resource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		resource = new XtextResource();
		resource.setURI(URI.createURI("http://foo/bar/test.test"));

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
	
	public void testNullSafety() throws Exception {
		ISemanticModelTransformer transformer = new TestTransformerHelper.TestTransformerWithNamingConvention();
		assertNotNull(transformer.transformSemanticModel(null));
	}

	public void testWithNamingConventions() {
		ISemanticModelTransformer transformer = new TestTransformerHelper.TestTransformerWithNamingConvention();
		transformer.setResourceAccess(this);
		ContentOutlineNode treeModel = (ContentOutlineNode) transformer.transformSemanticModel(theRoot);

		assertEquals(AbstractSemanticModelTransformer.INVISIBLE_ROOT_NODE, treeModel.getLabel());

		List<ContentOutlineNode> children2 = treeModel.getChildren();
		ContentOutlineNode node1 = children2.get(0);
		assertEquals("special a1", node1.getLabel());
		IContentOutlineNode node2 = children2.get(1);
		assertEquals("special a2", node2.getLabel());
		
		List<ContentOutlineNode> children3 = node1.getChildren();
		IContentOutlineNode node3 = children3.get(0);
		IContentOutlineNode node4 = children3.get(1);
		ContentOutlineNode node5 = children3.get(2);
		assertEquals("pimped b1", node3.getLabel());
		assertEquals("pimped b2", node4.getLabel());
		assertEquals("pimped b3", node5.getLabel());
		
		List<ContentOutlineNode> children4 = node5.getChildren();
		assertEquals(0, children4.size());
	}
	
	public void testWithAnnotations() {
		ISemanticModelTransformer transformer = new TestTransformerHelper.TestTransformerWithAnnotations();
		transformer.setResourceAccess(this);
		ContentOutlineNode treeModel = (ContentOutlineNode) transformer.transformSemanticModel(theRoot);

		assertEquals(AbstractSemanticModelTransformer.INVISIBLE_ROOT_NODE, treeModel.getLabel());

		List<ContentOutlineNode> children2 = treeModel.getChildren();
		ContentOutlineNode node1 = children2.get(0);
		assertEquals("special a1", node1.getLabel());
		IContentOutlineNode node2 = children2.get(1);
		assertEquals("special a2", node2.getLabel());
		
		List<ContentOutlineNode> children3 = node1.getChildren();
		IContentOutlineNode node3 = children3.get(0);
		IContentOutlineNode node4 = children3.get(1);
		ContentOutlineNode node5 = children3.get(2);
		assertEquals("pimped b1", node3.getLabel());
		assertEquals("pimped b2", node4.getLabel());
		assertEquals("pimped b3", node5.getLabel());
		
		List<ContentOutlineNode> children4 = node5.getChildren();
		assertEquals(0, children4.size());
	}

	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		try {
			return work.exec(resource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		try {
			return work.exec(resource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
