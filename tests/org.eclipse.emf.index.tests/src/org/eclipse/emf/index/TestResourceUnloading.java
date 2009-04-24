/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;

public class TestResourceUnloading extends TestCase {

	private File testFile;

	public void testResourceUnloading() throws Exception {
		// 1. create test data
		ResourceSet rs = new ResourceSetImpl();

		URI uri = URI.createFileURI(testFile.getAbsolutePath());
		Resource r = rs.createResource(uri);

		EClass c1 = EcoreFactory.eINSTANCE.createEClass();
		c1.setName("class1");
		r.getContents().add(c1);

		// 2. persist the resource
		r.save(null);
		r = null;

		InMemoryIndex index = new InMemoryIndex();

		EcoreIndexFeeder indexFeeder = new EcoreIndexFeederImpl(index);
		indexFeeder.index(EcorePackage.eINSTANCE, true);

		IndexFeederImpl feeder = new IndexFeederImpl(index);

		feeder.begin();

		// 3. create a new resource set
		rs = new ResourceSetImpl();
		r = rs.getResource(uri, true);

		feeder.createResourceDescriptor(r, null);

		for (Iterator<EObject> i = EcoreUtil.getAllProperContents(r, false); i.hasNext();) {
			EObject element = i.next();
			feeder.createEObjectDescriptor(element, this.getEObjectName(element), this.getEObjectDisplayName(element),
					null);

			URI sourceURI = EcoreUtil.getURI(element);
			for (EReference eReference : element.eClass().getEAllReferences()) {
				String eReferenceName = eReference.getName();
				if (isIndexReference(eReference, element)) {
					if (eReference.isMany()) {
						List<?> targets = (List<?>) ((InternalEObject) element).eGet(eReference, false);
						for (int j = 0; j < targets.size(); ++j) {
							Object target = targets.get(j);
							createECrossReferenceDescriptor(feeder, sourceURI, eReferenceName, j, target);
						}
					}
					else {
						Object target = ((InternalEObject) element).eGet(eReference, false);
						createECrossReferenceDescriptor(feeder, sourceURI, eReferenceName,
								ECrossReferenceDescriptor.NO_INDEX, target);
					}
				}
			}
		}

		// 4. unload resource set. this is where the NPE happened
		r.unload();

		feeder.commit();

		// 5. assert we indexed what was intended
		EObjectDescriptor desc = index.eObjectDAO().createQueryEObjectsByType(EcorePackage.eINSTANCE.getEClass())
				.executeSingleResult();

		assertNotNull("Didn't return the object descriptor.", desc);
		assertEquals(EcoreUtil.getURI(c1), desc.getFragmentURI());
	}

	private void createECrossReferenceDescriptor(IndexFeeder feeder, URI sourceURI, String eReferenceName, int index,
			Object target) {
		if (target instanceof EObject) {
			URI targetURI = EcoreUtil.getURI((EObject) target);
			if (targetURI != null) {
				feeder.createECrossReferenceDescriptor(sourceURI, eReferenceName, index, targetURI);
			}
		}
	}

	private boolean isIndexReference(EReference eReference, EObject element) {

		return element.eIsSet(eReference);
	}

	protected String getEObjectName(EObject eObject) {

		return ((EClass) eObject).getName();
	}

	protected String getEObjectDisplayName(EObject eObject) {

		String displayName = this.getEObjectName(eObject);
		if (displayName == null) {
			displayName = eObject.eResource().getURIFragment(eObject);
		}
		return displayName;
	}

	public void setUp() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		testFile = File.createTempFile("resourceUnloadingTest", ".xmi");
	}

	public void tearDown() {
		if (testFile.exists()) {
			testFile.delete();
		}
	}

}
