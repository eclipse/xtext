/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.guice;

import junit.framework.TestSuite;

import org.eclipse.emf.index.TestResourceUnloading;
import org.eclipse.emf.index.dao.EClassDAOTest;
import org.eclipse.emf.index.dao.EObjectDAOTest;
import org.eclipse.emf.index.dao.EPackageDAOTest;
import org.eclipse.emf.index.dao.EReferenceDAOTest;
import org.eclipse.emf.index.ecore.EPackageRegistryTest;
import org.eclipse.emf.index.feeder.DanglingReferenceTest;
import org.eclipse.emf.index.feeder.EObjectTest;
import org.eclipse.emf.index.feeder.ResourceTest;
import org.eclipse.emf.index.feeder.TestIndexing;
import org.eclipse.emf.index.impl.memory.EmfIndexDefaultModule;
import org.eclipse.emf.index.integration.IntegrationTests;

import com.google.inject.Module;

/**
 * Base test suite that handles dependency injection with Google Guice. Implementors of
 * {@link org.eclipse.emf.index.IndexStore} or {@link org.eclipse.emf.index.IDAO<T>} classes should create their own
 * concrete subclass setting the module.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * @see org.eclipse.emf.index.MemoryTestSuite for a concrete example.
 */
public abstract class AbstractEmfIndexTestSuite extends TestSuite {

	// TODO: Eeeek! Global state! Put it away!
	private static Module module;

	public AbstractEmfIndexTestSuite(Module module) {
		AbstractEmfIndexTestSuite.module = module;
		addTestSuite(EClassDAOTest.class);
		addTestSuite(EObjectDAOTest.class);
		addTestSuite(EPackageDAOTest.class);
		addTestSuite(EReferenceDAOTest.class);
		addTestSuite(EObjectDAOTest.class);
		addTestSuite(TestResourceUnloading.class);
		addTestSuite(EPackageRegistryTest.class);
		addTestSuite(IntegrationTests.class);
		addTestSuite(DanglingReferenceTest.class);
		addTestSuite(EObjectTest.class);
		addTestSuite(ResourceTest.class);
		addTestSuite(TestIndexing.class);
		
	}

	public static Module getModule() {
		return (module == null) ? new EmfIndexDefaultModule() : module;
	}
}
