/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.ecore.impl.EPackageRegistryIndexFeeder;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageRegistryTest extends TestCase {

	public void testRegistry() throws Exception {
		EcorePackage.eINSTANCE.eClass();
		IIndexStore indexStore = IIndexStore.INSTANCE;
		EPackageRegistryIndexFeeder.feedEPackagesFromRegistry(indexStore);
		Iterable<EPackageDescriptor> ePackageDescriptors = indexStore.ePackageDAO().createQueryEPackage(EcorePackage.eINSTANCE).executeListResult();
		assertNotNull(ePackageDescriptors);
		Iterator<EPackageDescriptor> ePackageIterator = ePackageDescriptors.iterator();
		assertEquals("ecore", ePackageIterator.next().getName());
		assertFalse(ePackageIterator.hasNext());
		
		Iterable<EClassDescriptor> eClassDescriptors = indexStore.eClassDAO().createQueryEClass(EcorePackage.Literals.ECLASS).executeListResult();
		assertNotNull(eClassDescriptors);
		Iterator<EClassDescriptor> eClassIterator = eClassDescriptors.iterator();
		assertEquals("EClass", eClassIterator.next().getName());
		assertFalse(eClassIterator.hasNext());
	}
}
