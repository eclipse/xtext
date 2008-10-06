/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testlanguages.TestLanguageStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class XtextMetamodelResourceTest extends TestCase {

	public void testResourceLoad() throws Exception {
		XtextStandaloneSetup.doSetup();
		TestLanguageStandaloneSetup.doSetup();
		XtextResourceSet rs = new XtextResourceSet();
		rs.setClasspathURIContext(XtextMetamodelResourceTest.class.getClassLoader());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xtext", new XtextMetamodelResourceFactory());
		Resource resource = rs.getResource(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xtext"), true);
		EList<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		assertTrue(contents.get(0) instanceof EPackage);
		EPackage ePackage = (EPackage) contents.get(0);
		assertEquals(6, ePackage.getEClassifiers().size());
	}
}
