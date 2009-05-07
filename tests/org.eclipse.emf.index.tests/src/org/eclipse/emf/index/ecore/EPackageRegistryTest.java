/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore;

import java.util.Iterator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageRegistryTest extends AbstractEmfIndexTest {

	@Inject
	private IndexStore indexStore;
	
	public void testRegistry() throws Exception {
		EcorePackage.eINSTANCE.eClass();
		EcoreIndexFeederImpl ecoreIndexFeeder = new EcoreIndexFeederImpl(indexStore);
		ecoreIndexFeeder.feedEPackagesFromRegistry();
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
