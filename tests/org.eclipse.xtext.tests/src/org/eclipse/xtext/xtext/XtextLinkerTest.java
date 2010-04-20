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
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextLinkerTest extends AbstractXtextTests {


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	public void testGeneratedPackageRemovedProperly() throws Exception {
		String testGrammar = "grammar foo.Bar generate foo 'bar'  Model : name=ID;";
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("name"), 4, "foo");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("generate foo") + 11, 1, "x");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
	}

	public void testImportedPackageRemovedProperly() throws Exception {
		String testGrammar = "grammar foo.Bar import 'classpath:/org/eclipse/xtext/xtext/Foo.ecore' as foo Model returns foo::Model: name=ID;";
		// package import not influenced by parser rule change
		checkPackageRemovalAfterGrammarChange(false, testGrammar, testGrammar.indexOf("name"), 4, "foo");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("as foo") + 4, 1, "x");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
	}

	private void checkPackageRemovalAfterGrammarChange(boolean isRemoved, String originalGrammar, int offset, int length, String replacement) throws Exception {
		XtextResource res = getResourceFromStringAndExpect(originalGrammar, 1);
		res.load(null);  // triggers linking
		Grammar g = (Grammar) res.getContents().get(0);
		AbstractMetamodelDeclaration  genMM =  g.getMetamodelDeclarations().get(0);
		EPackage ePackage = genMM.getEPackage();
		assertEquals(ePackage.eResource().getResourceSet(),res.getResourceSet());
		res.update(offset, length, replacement);
		if(isRemoved) {
			assertNull(ePackage.eResource().getResourceSet());
		} else {
			assertEquals(ePackage.eResource().getResourceSet(),res.getResourceSet());
		}
		g = (Grammar) res.getContents().get(0);
		genMM = g.getMetamodelDeclarations().get(0);
		ePackage = genMM.getEPackage();
		assertEquals(res.getResourceSet(), ePackage.eResource().getResourceSet());
	}
}
