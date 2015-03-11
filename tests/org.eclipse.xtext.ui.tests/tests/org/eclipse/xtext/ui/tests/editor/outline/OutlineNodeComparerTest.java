/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineNodeComparer;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.OutlineTestFactory;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineNodeComparerTest extends AbstractXtextTests {

	private IOutlineNodeComparer.Default comparer;
	private Image image;
	private Image image2;
	private EObject eObject;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Injector injector = Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguage");
		with(new ISetup() {
			@Override
			public Injector createInjectorAndDoEMFRegistration() {
				return injector;
			}
		});
		comparer = new IOutlineNodeComparer.Default();
		image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		image2 = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		eObject = OutlineTestFactory.eINSTANCE.createModel();

	}

	@Test public void testNull() {
		assertTrue(comparer.equals(null, null));
		EObjectNode node = new EObjectNode(eObject, null, (ImageDescriptor) null, "parent", false);
		assertFalse(comparer.equals(null, node));
		assertFalse(comparer.equals(node, null));
	}

	@Test public void testPropertyEquality() {
		EObjectNode node = new EObjectNode(eObject, null, image, new StyledString("Node"), false);
		assertFalse(comparer.equals(node, new DocumentRootNode(image, new StyledString("Node"), null, null)));
		assertTrue(comparer.equals(node, new EObjectNode(OutlineTestFactory.eINSTANCE.createElement(), null, image, new StyledString("Node"), false)));
		assertFalse(comparer.equals(node, new EObjectNode(eObject, node, image, new StyledString("Node"), false)));
		assertFalse(comparer.equals(node, new EObjectNode(eObject, null, image2, new StyledString("Node"), false)));
		assertFalse(comparer.equals(node, new EObjectNode(eObject, null, image, new StyledString("Node2"), false)));
		assertTrue(comparer.equals(node, new EObjectNode(eObject, null, image, "Node", false)));
	}
	
	@SuppressWarnings("unused")
	@Test public void testEquivalentIndex() throws Exception {
		DocumentRootNode rootNode = new DocumentRootNode(image, "Root", null, null);
		EObjectNode node = new EObjectNode(eObject, rootNode, image, "Node", false);

		DocumentRootNode rootNode2 = new DocumentRootNode(image, "Root", null, null);
		EObjectNode node2 = new EObjectNode(eObject, rootNode2, image, "Node", false);
		assertTrue(comparer.equals(node, node2));
		EObjectNode node3 = new EObjectNode(eObject, rootNode2, image, "OtherNode", false);
		assertTrue(comparer.equals(node, node2));
		
		DocumentRootNode rootNode3 = new DocumentRootNode(image, "Root", null, null);
		EObjectNode node4 = new EObjectNode(eObject, rootNode3, image, "OtherNode", false);
		EObjectNode node5 = new EObjectNode(eObject, rootNode3, image, "Node", false);
		assertTrue(comparer.equals(node, node5));
		EObjectNode node6 = new EObjectNode(eObject, rootNode3, image, "OtherNode", false);
		assertFalse(comparer.equals(node, node5));
	}

}
