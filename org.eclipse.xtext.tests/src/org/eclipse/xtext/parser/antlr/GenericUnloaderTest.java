/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class GenericUnloaderTest extends Assert {

	@Test public void testHandleContentAdapter() throws Exception {
		EPackage root = createExample();
		EContentAdapter eContentAdapter = new EContentAdapter();
		root.eAdapters().add(eContentAdapter);
		IReferableElementsUnloader.GenericUnloader genericUnloader = new IReferableElementsUnloader.GenericUnloader();
		try {
			genericUnloader.unloadRoot(root);
		} catch (StackOverflowError e) {
			e.printStackTrace();
			fail("Unload does not cope with contentAdpaters");
		}
		// isEmtpy() does not work in EMF 3.5
		assertEquals(0, root.eAdapters().size());
	}
	
	protected EPackage createExample() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = new XMIResourceImpl(URI.createURI("test"));
		resourceSet.getResources().add(resource);
		EPackage root = EcoreFactory.eINSTANCE.createEPackage();
		resource.getContents().add(root);
		EClass child = EcoreFactory.eINSTANCE.createEClass();
		root.getEClassifiers().add(child);
		return root;
	}
	
}
