/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.label;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class GlobalDescriptionLabelProviderTest extends Assert {

	private GlobalDescriptionLabelProvider globalDescriptionLabelProvider;
	
	@Before
	public void setUp() throws Exception {
		globalDescriptionLabelProvider = new GlobalDescriptionLabelProvider();
	}
	
	@Test public void testReferenceDescription() throws Exception {
		ReferenceDescriptionImpl referenceDescription = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		referenceDescription.setSourceEObjectUri(URI.createURI("test.referringtestlanguage#/"));
		referenceDescription.setTargetEObjectUri(URI.createURI("test.referringtestlanguage#/"));
		assertEquals("<unnamed>", globalDescriptionLabelProvider.getText(referenceDescription));
		assertNotNull(globalDescriptionLabelProvider.getImage(referenceDescription));
	}
	
	@Test public void testEObjectDescription() throws Exception {
		XtextResourceSet resourceSet = new XtextResourceSet();
		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI("test/test.ecore", true));
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		resource.getContents().add(ePackage);
		IEObjectDescription eObjectDescription = EObjectDescription.create("test", ePackage);
		assertEquals("test - EPackage", globalDescriptionLabelProvider.getText(eObjectDescription));
		assertNotNull(globalDescriptionLabelProvider.getImage(eObjectDescription));
	}
	
}
