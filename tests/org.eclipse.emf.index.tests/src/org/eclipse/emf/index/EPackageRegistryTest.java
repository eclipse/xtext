/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.index.ecore.EPackageRegistryIndexFeeder;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageRegistryTest extends TestCase {

	public void testRegistry() throws Exception {
		EcorePackage.eINSTANCE.eClass();
		IIndexStore indexStore = IIndexStore.eINSTANCE;
		EPackageRegistryIndexFeeder.feedEPackagesFromRegistry(indexStore);
		Collection<EPackageDescriptor> ePackageDescriptors = indexStore.ePackageDAO().createQueryEPackage(EcorePackage.eINSTANCE).executeListResult();
		assertNotNull(ePackageDescriptors);
		assertEquals(1, ePackageDescriptors.size());
		assertEquals("ecore", ePackageDescriptors.iterator().next().getName());
		
		Collection<EClassDescriptor> eClassDescriptors = indexStore.eClassDAO().createQueryEClass(EcorePackage.Literals.ECLASS).executeListResult();
		assertNotNull(eClassDescriptors);
		assertEquals(1, eClassDescriptors.size());
		assertEquals("EClass", eClassDescriptors.iterator().next().getName());
	}
}
