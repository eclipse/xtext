/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext2ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.testlanguages.ActionTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageMetamodelAccess;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ActionTest extends AbstractGeneratorTest {
	
	public void testMetamodelCreation() throws Exception {
		EClass model = checkEClassExists("Model");
		EClass type = checkEClassExists("Type");
		EClass item = checkEClassExists("Item");
		EClass thing = checkEClassExists("Thing");
		checkContainmentReferenceExists(model, type, "children");
		checkContainmentReferenceExists(item, type, "items");
		checkContainmentReferenceExists(thing, type, "content");
		assertTrue(item.getESuperTypes().contains(type));
		assertTrue(thing.getESuperTypes().contains(type));
		EPackage actionLangEPackage = getActionLangEPackage();
		assertNull(actionLangEPackage.getEClassifier("Element"));
	}

    private EPackage getActionLangEPackage() {
		EPackage actionLangEPackage = ActionTestLanguageMetamodelAccess.getActionLangEPackage();
		return actionLangEPackage;
    }
	
	private EClass checkEClassExists(String name) {
		EPackage actionLangEPackage = getActionLangEPackage();
		EClassifier classifier = actionLangEPackage.getEClassifier(name);
		assertNotNull(classifier);
		assertTrue(classifier instanceof EClass);
		return (EClass) classifier;
	}
	
	private void checkContainmentReferenceExists(EClass eClass, EClass type, String name) {
		EStructuralFeature structuralFeature = eClass.getEStructuralFeature(name);
		assertNotNull(structuralFeature);
		assertTrue(structuralFeature instanceof EReference);
		assertTrue(((EReference)structuralFeature).isContainment());
		assertEquals(type, structuralFeature.getEType());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ActionTestLanguageStandaloneSetup.doSetup();
		with(ActionTestLanguageStandaloneSetup.class);
	}
}
