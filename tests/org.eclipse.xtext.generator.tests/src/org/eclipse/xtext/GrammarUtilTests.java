/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.crossrefs.LangAStandaloneSetup;
import org.eclipse.xtext.crossrefs.services.LangAGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestStandaloneSetup;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class GrammarUtilTests extends AbstractGeneratorTest {

	public void testGetEPackage() throws Exception {
		with(LangAStandaloneSetup.class);
		Grammar grammar = (new LangAGrammarAccess()).getGrammar();
		EObject model = getModel("type A extends A");
		assertNotNull(model);
		ResourceSet resourceSet = model.eResource().getResourceSet();

		assertNull(GrammarUtil.getEPackage(resourceSet, grammar, "unknownAlias"));

		EPackage ePackage = GrammarUtil.getEPackage(resourceSet, grammar, null);
		assertEquals(3, ePackage.getEClassifiers().size());
		assertNotNull(ePackage.getEClassifier("Type"));
	}
	
	public void testImport() throws Exception {
		with(MetamodelRefTestStandaloneSetup.class);
		Grammar grammar = (new MetamodelRefTestGrammarAccess()).getGrammar();
		EObject model = getModel("test");
		assertNotNull(model);
		ResourceSet resourceSet = model.eResource().getResourceSet();

		assertNull(GrammarUtil.getEPackage(resourceSet, grammar, "unknownAlias"));
		
		EPackage ePackage = GrammarUtil.getEPackage(resourceSet, grammar, null);
		assertEquals(1, ePackage.getEClassifiers().size());
		assertNotNull(ePackage.getEClassifier("Foo"));
		
		ePackage = GrammarUtil.getEPackage(resourceSet, grammar, "xtext");
		assertEquals(16, ePackage.getEClassifiers().size());
		assertNotNull(ePackage.getEClassifier("RuleCall"));
	}
	
	public void testGetEClass() throws Exception {
		with(LangAStandaloneSetup.class);
		XtextResource resource = getResourceFromString("type A extends A");
		
		ParserRule prType = (new LangAGrammarAccess()).pr_Type();
		Assignment asExtends = (Assignment)((Group)prType.getAlternatives()).getAbstractTokens().get(1);
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		
		
		EClass referencedEClass = GrammarUtil.getReferencedEClass(resource, xref);
		assertNotNull(referencedEClass);
		
		EObject model = getModel(resource);
		EObject typeA = (EObject) invokeWithXtend("types.first()", model);
		assertEquals(typeA.eClass(), referencedEClass);
	}

}
