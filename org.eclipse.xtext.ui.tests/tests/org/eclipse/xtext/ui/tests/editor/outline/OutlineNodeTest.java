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
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.Element;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.Model;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.OutlineTestPackage;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineNodeTest extends AbstractXtextTests {

	private XtextResource resource;
	private Element parentElement;
	private Element child0Element;

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
		resource = getResource("parent { child0 {} }", "test.outlinetestlanguage");
		parentElement = ((Model) resource.getContents().get(0)).getElements().get(0);
		child0Element = parentElement.getChildren().get(0);
	}

	@Test public void testParentChildOpposites() {
		EObjectNode parentNode = new EObjectNode(parentElement, null, (ImageDescriptor) null, "parent", false);
		EObjectNode childNode = new EObjectNode(child0Element, parentNode, (ImageDescriptor) null, "child", false);
		assertEquals(childNode.getParent(), parentNode);
		assertTrue(parentNode.getChildren().contains(childNode));
	}

	@Test public void testAddChildToLeafNode() {
		EObjectNode parentNode = new EObjectNode(parentElement, null, (ImageDescriptor) null, "parent", true);
		assertFalse(parentNode.hasChildren());
		assertTrue(parentNode.getChildren().isEmpty());
		EObjectNode childNode = new EObjectNode(child0Element, parentNode, (ImageDescriptor) null, "child", false);
		assertTrue(parentNode.hasChildren());
		assertTrue(parentNode.getChildren().contains(childNode));
	}

	@Test public void testMethodsDelegateToParent() {
		DocumentRootNode rootNode = createRootNode();
		EObjectNode parentNode = new EObjectNode(parentElement, rootNode, (ImageDescriptor) null, "parent", false);
		assertNotNull(parentNode.getDocument());
		assertNotNull(parentNode.getTreeProvider());
		assertEquals(rootNode.getDocument(), parentNode.getDocument());
		assertEquals(rootNode.getTreeProvider(), parentNode.getTreeProvider());
	}

	@Test public void testCreateChildrenLazily() {
		DocumentRootNode rootNode = createRootNode();
		EObjectNode parentNode = new EObjectNode(parentElement, rootNode, (ImageDescriptor) null, "parent", false);
		assertFalse(parentNode.getChildren().isEmpty());
	}

	@Test public void testStateAccess() {
		DocumentRootNode rootNode = createRootNode();
		EObjectNode parentNode = new EObjectNode(parentElement, rootNode, (ImageDescriptor) null, "parent", false);
		EStructuralFeatureNode featureNode = new EStructuralFeatureNode(parentElement,
				OutlineTestPackage.Literals.ELEMENT__XREFS, parentNode, (ImageDescriptor) null, "eClassifiers", true);
		IUnitOfWork<Boolean, EObject> work = new IUnitOfWork<Boolean, EObject>() {
			@Override
			public Boolean exec(EObject state) throws Exception {
				return state != null;
			}
		};
		assertTrue(rootNode.readOnly(work));
		assertTrue(parentNode.readOnly(work));
		assertTrue(featureNode.readOnly(work));
	}
	
	@Test public void testEqualsNotImplemented() throws Exception {
		EObjectNode node0 = new EObjectNode(parentElement, null, (ImageDescriptor) null, "parent", false);
		EObjectNode node1 = new EObjectNode(parentElement, null, (ImageDescriptor) null, "parent", false);
		assertNotSame(node0, node1);
	}

	protected DocumentRootNode createRootNode() {
		XtextDocument document = get(XtextDocument.class);
		document.setInput(resource);
		IOutlineTreeStructureProvider treeStructureProvider = new IOutlineTreeStructureProvider() {
			@Override
			public void createChildren(IOutlineNode parentNode, EObject modelElement) {
				new EObjectNode(child0Element, parentNode, (ImageDescriptor) null, "child", false);
			}
		};
		DocumentRootNode rootNode = new DocumentRootNode((ImageDescriptor) null, "root", document, treeStructureProvider);
		return rootNode;
	}

}
