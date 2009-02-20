/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.index.impl.CrossReferenceDescriptorImpl;
import org.eclipse.emf.index.mocks.MockIndexStore;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class TestIndexFeeder extends TestCase {

	private static final String TEST_MODEL = "org/eclipse/emf/index/testmodel.ecore";
	IIndexFeeder feeder;
	MockIndexStore index;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		index = new MockIndexStore();
		feeder = index.indexFeeder();
		feeder.index(EcorePackage.eINSTANCE, true);
	}

	public void testIndexEPackage() {
		assertEquals(1, index.addedEPackageDescriptors.size());
		assertTrue(index.addedEClassDescriptors.size() > 0);
		assertEquals(0, index.addedResourceDescriptors.size());
		assertEquals(0, index.addedEObjectDescriptors.size());
		assertEquals(0, index.addedCrossRefDescriptors.size());
		assertEquals(0, index.removedEPackageDescriptors.size());
		assertEquals(0, index.removedEClassDescriptors.size());
		assertEquals(0, index.removedResourceDescriptors.size());
		assertEquals(0, index.removedEObjectDescriptors.size());
		assertEquals(0, index.removedCrossRefDescriptors.size());
	}

	public void testIndexResource() throws Exception {
		indexExampleResource();
		assertEquals(1, index.addedEPackageDescriptors.size());
		assertTrue(index.addedEClassDescriptors.size() > 0);
		assertEquals(1, index.addedResourceDescriptors.size());
		// four EObjects: an EPackage, an ECLass, an EReference and a genericType
		assertEquals(4, index.addedEObjectDescriptors.size());
		assertEquals(0, index.addedCrossRefDescriptors.size());
		assertEquals(0, index.removedEPackageDescriptors.size());
		assertEquals(0, index.removedEClassDescriptors.size());
		assertEquals(0, index.removedResourceDescriptors.size());
		assertEquals(0, index.removedEObjectDescriptors.size());
		assertEquals(0, index.removedCrossRefDescriptors.size());
	}

	public void testIndexCrossRefs() throws Exception {
		feeder.registerCrossReferenceDescriptorFactory(new CrossReferenceDescriptorImpl.CachingFactory());
		indexExampleResource();
		assertEquals(1, index.addedEPackageDescriptors.size());
		assertTrue(index.addedEClassDescriptors.size() > 0);
		// three resources: one for the resource and one for the target of each crossref
		assertEquals(3, index.addedResourceDescriptors.size());
		// six EObjects: an EPackage, an EClass, an EReference and a genericType
		// and one for each crossref's target
		assertEquals(6, index.addedEObjectDescriptors.size());
		// two crossRefs: someReference and genericType
		assertEquals(2, index.addedCrossRefDescriptors.size());
		assertEquals(0, index.removedEPackageDescriptors.size());
		assertEquals(0, index.removedEClassDescriptors.size());
		assertEquals(0, index.removedResourceDescriptors.size());
		assertEquals(0, index.removedEObjectDescriptors.size());
		assertEquals(0, index.removedCrossRefDescriptors.size());
	}

	private void indexExampleResource() throws IOException {
		URI uri = URI.createFileURI("/" + TEST_MODEL);
		XMIResourceImpl resource = new XMIResourceImpl();
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(TEST_MODEL);
		resource.load(resourceAsStream, null);
		resource.setURI(uri);
		feeder.index(resource, true);
	}
	
}
