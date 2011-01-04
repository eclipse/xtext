/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.ecore.EcoreRuntimeModule;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.generic.EmfResourceDescriptionManager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EmfResourceDescriptionManagerTest extends TestCase {
	
	private EmfResourceDescriptionManager getEmfResourceDescriptionsManager() {
		Injector injector = Guice.createInjector(new EcoreRuntimeModule());
		return injector.getInstance(EmfResourceDescriptionManager.class);
	}
	
	public void testNaming() throws Exception {
		EmfResourceDescriptionManager underTest = getEmfResourceDescriptionsManager();
		IResourceDescription description = underTest.getResourceDescription(EcorePackage.eINSTANCE.eResource());
		
		Map<QualifiedName,IEObjectDescription> index = Maps.newHashMap();
		for (IEObjectDescription ieObjectDescription : description.getExportedObjects()) {
			index.put(ieObjectDescription.getName(), ieObjectDescription);
		}
		
		assertEquals(EcorePackage.eINSTANCE, index.get(QualifiedName.create("ecore")).getEObjectOrProxy());
		assertEquals(EcorePackage.Literals.ECLASS, index.get(QualifiedName.create("EClass")).getEObjectOrProxy());
	}
	
	public void testPerformance() throws Exception {
		EmfResourceDescriptionManager manager = getEmfResourceDescriptionsManager();
		Collection<String> uris = ImmutableList.copyOf(EPackage.Registry.INSTANCE.keySet());
		for(String uri: uris) {
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(uri);
			IResourceDescription description = manager.getResourceDescription(pack.eResource());
			assertNotNull(description);
			for(int i = 0; i < 10; i++) {
				Iterator<EObject> iter = EcoreUtil.getAllProperContents(pack, true);
				while(iter.hasNext()) {
					EObject next = iter.next();
					if (next instanceof ENamedElement) {
						String name = ((ENamedElement) next).getName();
//						Iterable<IEObjectDescription> objects = 
						description.getExportedObjects(EcorePackage.Literals.EOBJECT, QualifiedName.create(name), false);
//						assertFalse(name + " - " + uri + " - " + next, Iterables.isEmpty(objects));
					}
				}
			}
		}
	}
	
	public void testCreateDeltaAndIsAffected() {
		EmfResourceDescriptionManager manager = getEmfResourceDescriptionsManager();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		eClass.getESuperTypes().add(EcorePackage.Literals.EPACKAGE);
		Resource resource = new XMIResourceImpl(URI.createFileURI("test.ecore"));
		resource.getContents().add(eClass);

		EPackage copyOfEPackage = (EPackage) EcoreUtil.copy(EcorePackage.eINSTANCE);
		Resource ecoreResource = new XMIResourceImpl(URI.createURI(copyOfEPackage.getNsURI()));
		ecoreResource.getContents().add(copyOfEPackage);
		IResourceDescription oldDescription = manager.getResourceDescription(ecoreResource);
		oldDescription.getExportedObjects();
		copyOfEPackage.setName("ecore_new");
		IResourceDescription newDescription = manager.getResourceDescription(ecoreResource);
		
		Delta delta = manager.createDelta(oldDescription, newDescription);
		assertTrue(delta.haveEObjectDescriptionsChanged());
		
		IResourceDescription referrerDescription = manager.getResourceDescription(resource);
		assertTrue(manager.isAffected(delta, referrerDescription));
	}
}
