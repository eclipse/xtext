/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.indexer;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.index.internal.dbaccess.EClassDAO;
import org.eclipse.xtext.index.internal.dbaccess.EObjectDAO;
import org.eclipse.xtext.index.internal.dbaccess.EPackageDAO;
import org.eclipse.xtext.index.internal.dbaccess.ResourceContainerDAO;
import org.eclipse.xtext.index.internal.dbaccess.ResourceDAO;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class DAOTest extends TestCase {

	private static final String PLATFORM_PLUGIN_X = "platform:/plugin/x";
	private static final String PLATFORM_PLUGIN_Y = "platform:/plugin/y";
	private static final String PLATFORM_PLUGIN_Z = "platform:/plugin/z";
	private static final String RESOURCE_URI_A = PLATFORM_PLUGIN_X + "/folder/a.ecore";
	private static final String RESOURCE_URI_B = PLATFORM_PLUGIN_X + "/folder/b.ecore";
	private static final String RESOURCE_URI_C = PLATFORM_PLUGIN_Z + "/folder/c.ecore";
	
	public void testResourceContainer() throws Exception {
		int idX = ResourceContainerDAO.create(PLATFORM_PLUGIN_X);
		int idY = ResourceContainerDAO.create(PLATFORM_PLUGIN_Y);
		assertEquals(idX, ResourceContainerDAO.getID(PLATFORM_PLUGIN_X));
		assertEquals(idY, ResourceContainerDAO.getID(PLATFORM_PLUGIN_Y));
		assertNotSame(idX, idY);
		ResourceContainerDAO.createReference(idX, idY);
		List<Integer> dependencyIDs = ResourceContainerDAO.findDependencyIDs(idX);
		assertEquals(1, dependencyIDs.size());
		assertEquals(idY, dependencyIDs.get(0).intValue());
	}

	public void testResource() throws Exception {
		int containerID = ResourceContainerDAO.create(PLATFORM_PLUGIN_X);
		Resource resourceA = new ResourceImpl(URI.createURI(RESOURCE_URI_A));
		int idX = ResourceDAO.create("/folder/a.ecore", containerID);
		int idXByResource = ResourceDAO.getID(resourceA);
		assertEquals(idX, idXByResource);

		Resource resourceB = new ResourceImpl(URI.createURI(RESOURCE_URI_B));
		int idYByResource = ResourceDAO.create(resourceB, containerID);
		int idY = ResourceDAO.getID("folder/b.ecore", containerID);
		assertEquals(idYByResource, idY);
	}
	
	public void testEPackageEClassEObject() throws Exception {
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		int idEcore = EPackageDAO.create(EcorePackage.eINSTANCE);
		assertEquals(idEcore, EPackageDAO.getID(EcorePackage.eINSTANCE));
		int idEClass = EClassDAO.create(EcorePackage.Literals.ECLASS, idEcore);
		assertEquals(idEClass, EClassDAO.getID(EcorePackage.Literals.ECLASS));
		
		Resource resourceC = new ResourceImpl(URI.createURI(RESOURCE_URI_C));
		int containerID = ResourceContainerDAO.create(resourceC.getURI());
		int resourceID = ResourceDAO.create(resourceC, containerID);
		EClass newEClass = EcoreFactory.eINSTANCE.createEClass();
		newEClass.setName("NewEClass");
		resourceC.getContents().add(newEClass);
		String fragment = resourceC.getURIFragment(newEClass);
		int idEObject = EObjectDAO.create(fragment, idEClass, resourceID);
		assertEquals(idEObject, EObjectDAO.getID(newEClass));
	}
}
