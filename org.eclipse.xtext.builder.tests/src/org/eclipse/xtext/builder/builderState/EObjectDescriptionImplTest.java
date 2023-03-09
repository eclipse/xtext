/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EObjectDescriptionImplTest {

	@Test public void testNoNPE() {
		EObjectDescriptionImpl objectDescription = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
		objectDescription.setFragment("myFragment");
		ResourceDescriptionImpl resourceDescription = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		resourceDescription.getExportedObjects().add(objectDescription);
		resourceDescription.setURI(URI.createURI("does.not.matter"));
		EClass doesNotExist = EcoreFactory.eINSTANCE.createEClass();
		InternalEObject proxy = (InternalEObject) doesNotExist;
		proxy.eSetProxyURI(URI.createURI("does.not.exist"));
		objectDescription.setEClass(doesNotExist);
		assertSame(doesNotExist, objectDescription.getEClass());
		assertNull(objectDescription.getEObjectOrProxy());
		assertEquals("does.not.matter#myFragment", objectDescription.getEObjectURI().toString());
	}
	
	@Test public void testContainerAndFragmentChange() {
		EObjectDescriptionImpl objectDescription = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
		objectDescription.setFragment("myFragment");
		ResourceDescriptionImpl resourceDescription = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		resourceDescription.getExportedObjects().add(objectDescription);
		resourceDescription.setURI(URI.createURI("some.uri"));
		assertEquals(URI.createURI("some.uri#myFragment"), objectDescription.getEObjectURI());
		resourceDescription.setURI(URI.createURI("some2.uri"));
		assertEquals(URI.createURI("some2.uri#myFragment"), objectDescription.getEObjectURI());
		objectDescription.setFragment("newFragment");
		assertEquals(URI.createURI("some2.uri#newFragment"), objectDescription.getEObjectURI());
	}
	
}
