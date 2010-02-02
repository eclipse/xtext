/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.DefaultLabelProvider;
import org.eclipse.xtext.ui.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.outline.DefaultContentOutlineNodeFactory;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractContentOutlineTests extends AbstractXtextTests {
	protected EObject root;
	protected EObject a1;
	protected EObject a2;
	protected DefaultContentOutlineNodeFactory contentOutlineNodeFactory;

	private static ILocationInFileProvider locationProvider = new ILocationInFileProvider() {
		public Region getLocation(EObject obj) {
			return new Region(0, 0);
		}
	};

	private static IStyledLabelProvider labelProvider = new DefaultLabelProvider() {
		@Override
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			return null;
		}
	};

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI
				.createURI("classpath:/org/eclipse/xtext/ui/common/editor/outline/transformer/simplestructure.xmi"),
				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		resource.load(null);
		root = resource.getContents().get(0);
		a1 = root.eContents().get(0);
		a2 = root.eContents().get(1);
		contentOutlineNodeFactory = new DefaultContentOutlineNodeFactory(labelProvider, locationProvider);
	}
}
