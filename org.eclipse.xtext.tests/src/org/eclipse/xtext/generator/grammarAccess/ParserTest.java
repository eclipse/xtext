/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		EPackage.Registry.INSTANCE.put(AsubpackagePackage.eNS_URI, AsubpackagePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SubsubpackagePackage.eNS_URI, SubsubpackagePackage.eINSTANCE);
		with(GrammarAccessTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testInstantiate() throws Exception {
		String modelAsText = "foo bar";
		AModel model = (AModel) getModel(modelAsText);
		assertEquals(2, model.getElements().size());
		assertEquals(AsubpackagePackage.Literals.ATYPE, model.getElements().get(0).eClass());
		assertEquals(SubsubpackagePackage.Literals.ANOTHER_TYPE, model.getElements().get(1).eClass());
	}
	
	@Test public void testUriFormat() throws Exception {
		URI uri = EcoreUtil.getURI(SubsubpackagePackage.Literals.ANOTHER_TYPE);
		assertTrue(AsubpackagePackage.eNS_URI.equals(uri.trimFragment().toString()));
		ResourceSet set = new ResourceSetImpl();
		EObject eObject = set.getEObject(uri, true);
		assertSame(SubsubpackagePackage.Literals.ANOTHER_TYPE, eObject);
	}
	
	@Test public void testUriFormat2() throws Exception {
		URI uri = EcoreUtil.getURI(AsubpackagePackage.Literals.ATYPE);
		assertTrue(AsubpackagePackage.eNS_URI.equals(uri.trimFragment().toString()));
		ResourceSet set = new ResourceSetImpl();
		EObject eObject = set.getEObject(uri, true);
		assertSame(AsubpackagePackage.Literals.ATYPE, eObject);
	}
	
}
