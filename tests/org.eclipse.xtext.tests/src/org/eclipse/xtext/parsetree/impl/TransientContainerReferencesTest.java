/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentFactory;
import org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage;
import org.eclipse.xtext.parsetree.impl.crossContainment.Element;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

/**
 * @author koehnlein - Initial contribution and API
 */
public class TransientContainerReferencesTest extends TestCase {

	public void testCrossResourceContainment() throws Exception {
		Element parent = CrossContainmentFactory.eINSTANCE.createElement();
		Element child = CrossContainmentFactory.eINSTANCE.createElement();
		parent.getContainment().add(child);
		Resource resource0 = new XMIResourceImpl(URI.createFileURI("test0.xmi"));
		resource0.getContents().add(parent);
		DefaultTransientValueService defaultTransientValueService = new DefaultTransientValueService();
		assertTrue(defaultTransientValueService.isTransient(child, CrossContainmentPackage.Literals.ELEMENT__CONTAINER, 0));
		Resource resource1 =new XMIResourceImpl(URI.createFileURI("test0.xmi"));
		resource1.getContents().add(child);
		assertEquals(parent, child.getContainer());
		assertFalse(defaultTransientValueService.isTransient(child, CrossContainmentPackage.Literals.ELEMENT__CONTAINER, 0));
	}
}
