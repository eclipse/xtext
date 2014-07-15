/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription;
import org.eclipse.xtext.ecore.EcoreRuntimeModule;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.generic.GenericResourceDescriptionManager;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class GenericResourceDescriptionManagerTest extends Assert {

	@Test public void testCreateDeltaAndIsAffected() {
		GenericResourceDescriptionManager manager = getEmfResourceDescriptionsManager();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		eClass.getESuperTypes().add(EcorePackage.Literals.EPACKAGE);
		Resource resource = new XMIResourceImpl(URI.createFileURI("test.ecore"));
		resource.getContents().add(eClass);

		EPackage copyOfEPackage = EcoreUtil.copy(EcorePackage.eINSTANCE);
		Resource ecoreResource = new XMIResourceImpl(URI.createURI(copyOfEPackage.getNsURI()));
		ecoreResource.getContents().add(copyOfEPackage);
		
		IResourceDescription oldDescription = new CopiedResourceDescription(manager.getResourceDescription(ecoreResource));
		oldDescription.getExportedObjects();
		copyOfEPackage.setName("ecore_new");
		IResourceDescription newDescription = manager.getResourceDescription(ecoreResource);
		
		Delta delta = manager.createDelta(oldDescription, newDescription);
		assertTrue(delta.haveEObjectDescriptionsChanged());
		
		IResourceDescription referrerDescription = manager.getResourceDescription(resource);
		assertTrue(manager.isAffected(delta, referrerDescription));
	}

	private GenericResourceDescriptionManager getEmfResourceDescriptionsManager() {
		Injector injector = Guice.createInjector(new EcoreRuntimeModule());
		return injector.getInstance(GenericResourceDescriptionManager.class);
	}

}
