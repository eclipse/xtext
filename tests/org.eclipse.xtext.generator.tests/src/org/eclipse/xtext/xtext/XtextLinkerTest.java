/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextLinkerTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	public void testPackageRemovedProperly() throws Exception {
		XtextResource res = getResourceFromStringAndExpect("grammar foo.Bar generate foo 'bar' Model : name=ID;", 1);
		res.load(null);
		Grammar g = (Grammar) res.getContents().get(0);
		GeneratedMetamodel genMM = (GeneratedMetamodel) g.getMetamodelDeclarations().get(0);
		EPackage ePackage = genMM.getEPackage();
		assertEquals(ePackage.eResource().getResourceSet(),res.getResourceSet());
		res.update(40, 0, "");
		assertNull(ePackage.eResource().getResourceSet());
		ePackage = genMM.getEPackage();
		assertEquals(ePackage.eResource().getResourceSet(),res.getResourceSet());
		
	}
}
