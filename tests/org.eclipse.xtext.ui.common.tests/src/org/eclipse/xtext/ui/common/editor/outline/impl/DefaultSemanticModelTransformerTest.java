/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.DefaultSemanticModelTransformer;
import org.eclipse.xtext.ui.core.DefaultLabelProvider;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;

import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultSemanticModelTransformerTest extends AbstractXtextTests {

	private static ILocationInFileProvider myLocationProvider = new ILocationInFileProvider() {
		public Region getLocation(EObject obj) {
			return new Region(0, 0);
		}
	};

	private static ILabelProvider myLabelProvider = new DefaultLabelProvider() {
		@Override
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			return null;
		}
	};
	
	private static Provider<ContentOutlineNode> myNodeProvider = new Provider<ContentOutlineNode>() {
		public ContentOutlineNode get() {
			return new ContentOutlineNode();
		}
	};

	private EObject root;
	private EObject a1;
	private EObject a2;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI
				.createURI("classpath:/org/eclipse/xtext/ui/common/editor/outline/impl/simplestructure.xmi"));
		resource.load(null);
		root = resource.getContents().get(0);
		a1 = root.eContents().get(0);
		a2 = root.eContents().get(1);
	}

	protected DefaultSemanticModelTransformer getSemanticModelTransformer() {
		DefaultSemanticModelTransformer tr = new DefaultSemanticModelTransformer();
		tr.setLabelProvider(myLabelProvider);
		tr.setLocationProvider(myLocationProvider);
		tr.setOutlineNodeProvider(myNodeProvider);
		return tr;
	}

	public void testNullSafety() {
		DefaultSemanticModelTransformer transformer = getSemanticModelTransformer();
		assertFalse(transformer.consumeSemanticChildNodes(null));
		assertFalse(transformer.consumeSemanticNode(null));
		assertEquals("<unknown>", transformer.getText(null));
	}

	public void testGetText() {
		DefaultSemanticModelTransformer transformer = getSemanticModelTransformer();
		String a1Text = transformer.getText(a1);
		assertEquals("A1", a1Text);
		String a2Text = transformer.getText(a2);
		assertEquals("A2", a2Text);
	}

	public void testGetUri() {
		DefaultSemanticModelTransformer transformer = getSemanticModelTransformer();
		ContentOutlineNode rootNode = transformer.transformSemanticModel(root);

		ContentOutlineNode treeRootNode = rootNode.getChildren().get(0);
		assertEquals("classpath:/org/eclipse/xtext/ui/common/editor/outline/impl/simplestructure.xmi#/", treeRootNode
				.getUri().toString());
	}

}
