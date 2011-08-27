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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EObjectDescriptionImplTest extends AbstractXtextTests {

	public void testNoNPE() {
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
	
}
