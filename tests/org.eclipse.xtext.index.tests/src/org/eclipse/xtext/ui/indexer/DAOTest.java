/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.indexer;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;

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
	private IndexDatabase indexDatabase;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexDatabase = new IndexDatabase();
		try {
			indexDatabase.clearAll();
		} catch(Exception exc) {
			// ignore
		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		indexDatabase.clearAll();
		indexDatabase.shutdown();
	}
	
	public void testResourceContainer() throws Exception {
		//test create
		int idX = indexDatabase.getResourceContainerDAO().create(PLATFORM_PLUGIN_X);
		int idY = indexDatabase.getResourceContainerDAO().create(PLATFORM_PLUGIN_Y);
		assertEquals(idX, indexDatabase.getResourceContainerDAO().getID(PLATFORM_PLUGIN_X));
		assertEquals(idY, indexDatabase.getResourceContainerDAO().getID(PLATFORM_PLUGIN_Y));
		assertNotSame(idX, idY);
		
		// test create reference
		indexDatabase.getResourceContainerReferenceDAO().create(idX, PLATFORM_PLUGIN_Y);
		List<URI> dependencyIDs = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(idX);
		assertEquals(1, dependencyIDs.size());
		assertEquals(PLATFORM_PLUGIN_Y, dependencyIDs.get(0).toString());
		
		// delete source -> reference is deleted
		indexDatabase.getResourceContainerDAO().delete(idX);
		dependencyIDs = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(idX);
		assertTrue(dependencyIDs.isEmpty());
		
		// delete target -> reference is not deleted
		int idZ = indexDatabase.getResourceContainerDAO().create(PLATFORM_PLUGIN_Z);
		indexDatabase.getResourceContainerReferenceDAO().create(idZ, PLATFORM_PLUGIN_Y);
		indexDatabase.getResourceContainerDAO().delete(idY);
		dependencyIDs = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(idZ);
		assertEquals(1, dependencyIDs.size());
		assertEquals(PLATFORM_PLUGIN_Y, dependencyIDs.get(0).toString());
		
		// delete reference 
		indexDatabase.getResourceContainerReferenceDAO().deleteBySource(idZ);
		dependencyIDs = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(idZ);
		assertTrue(dependencyIDs.isEmpty());
	}

	public void testResource() throws Exception {
		int containerID = indexDatabase.getResourceContainerDAO().create(PLATFORM_PLUGIN_X);
		Resource resourceA = new ResourceImpl(URI.createURI(RESOURCE_URI_A));
		int idX = indexDatabase.getResourceDAO().create("/folder/a.ecore", containerID);
		int idXByResource = indexDatabase.getResourceDAO().getID(resourceA);
		assertEquals(idX, idXByResource);

		Resource resourceB = new ResourceImpl(URI.createURI(RESOURCE_URI_B));
		int idYByResource = indexDatabase.getResourceDAO().create(resourceB, containerID);
		int idY = indexDatabase.getResourceDAO().getID("folder/b.ecore", containerID);
		assertEquals(idYByResource, idY);

		List<URI> allResources = indexDatabase.getResourceDAO().findAllResources();
		assertEquals(2, allResources.size());
		
		indexDatabase.getResourceDAO().delete(idX);
		allResources = indexDatabase.getResourceDAO().findAllResources();
		assertEquals(1, allResources.size());
	}
	
	public void testEPackageEClassEObject() throws Exception {
		// Workaround for Mac OSX classloader bug
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		
		int idEcore = indexDatabase.getEPackageDAO().create(EcorePackage.eINSTANCE);
		assertEquals(idEcore, indexDatabase.getEPackageDAO().getID(EcorePackage.eINSTANCE));
		int idEClass = indexDatabase.getEClassDAO().create(EcorePackage.Literals.ECLASS, idEcore);
		assertEquals(idEClass, indexDatabase.getEClassDAO().getID(EcorePackage.Literals.ECLASS));
		
		Resource resourceC = new ResourceImpl(URI.createURI(RESOURCE_URI_C));
		int containerID = indexDatabase.getResourceContainerDAO().create(resourceC.getURI());
		int resourceID = indexDatabase.getResourceDAO().create(resourceC, containerID);
		EClass newEClass = EcoreFactory.eINSTANCE.createEClass();
		newEClass.setName("NewEClass");
		resourceC.getContents().add(newEClass);
		EClass referencingEClass = EcoreFactory.eINSTANCE.createEClass();
		referencingEClass.setName("ReferencingEClass");
		resourceC.getContents().add(referencingEClass);
		String fragment = resourceC.getURIFragment(newEClass);
		int idEObject = indexDatabase.getEObjectDAO().create(fragment, idEClass, resourceID);
		assertEquals(idEObject, indexDatabase.getEObjectDAO().getID(newEClass));
		
		String refFragment = resourceC.getURIFragment(referencingEClass);
		int idRefEObject = indexDatabase.getEObjectDAO().create(refFragment, idEClass, resourceID);
		assertEquals(idRefEObject, indexDatabase.getEObjectDAO().getID(referencingEClass));
		String eObjectURI = EcoreUtil.getURI(newEClass).toString();
		indexDatabase.getCrossReferenceDAO().create(idRefEObject, eObjectURI);
		List<URI> referenceURIs = indexDatabase.getCrossReferenceDAO().findReferencesTo(newEClass);
		assertEquals(1, referenceURIs.size());
		assertEquals(RESOURCE_URI_C + "#" + refFragment, referenceURIs.get(0).toString());
	}
	
	public void testEPackageEClass() throws SQLException, NotFoundInIndexException {
		// Workaround for Mac OSX classloader bug
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		
		int idEcore = indexDatabase.getEPackageDAO().create(EcorePackage.eINSTANCE);
		assertEquals(idEcore, indexDatabase.getEPackageDAO().getID(EcorePackage.eINSTANCE));
		int idEClass = indexDatabase.getEClassDAO().create(EcorePackage.Literals.ECLASS, idEcore);
		assertEquals(idEClass, indexDatabase.getEClassDAO().getID(EcorePackage.Literals.ECLASS));
		
		// Test cascading delete
		indexDatabase.getEPackageDAO().delete(idEcore);
		try {
			indexDatabase.getEClassDAO().getID(EcorePackage.Literals.ECLASS);
			fail("EClass should have been deleted");
		} catch(NotFoundInIndexException exc) {
			// success 
		}
	}
}
