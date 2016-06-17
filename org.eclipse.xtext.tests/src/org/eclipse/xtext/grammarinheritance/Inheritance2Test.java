/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Inheritance2Test extends AbstractXtextTests {

	private InheritanceTestLanguageGrammarAccess grammarAccess;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(InheritanceTestLanguageStandaloneSetup.class);
		grammarAccess = get(InheritanceTestLanguageGrammarAccess.class);
	}

	@Test public void testReturnTypes_01() {
		ParserRule rule = grammarAccess.getModelRule();
		EClassifier classifier = rule.getType().getClassifier();
		assertEquals("Model", classifier.getName());
		EPackage pack = classifier.getEPackage();
		assertNotNull(pack);
		assertEquals(grammarAccess.getGrammar().getMetamodelDeclarations().get(0).getEPackage(), pack);
		EClassifier superClassifier = ((EClass)classifier).getESuperTypes().get(0);
		assertEquals("Model", superClassifier.getName());
		EPackage superPack = superClassifier.getEPackage();
		assertNotNull(superPack);
		assertEquals(grammarAccess.getGrammar().getUsedGrammars().get(0).getMetamodelDeclarations().get(0).getEPackage(), superPack);
	}

	@Test public void testReturnTypes_02() {
		ParserRule rule = grammarAccess.getElementRule();
		EClassifier classifier = rule.getType().getClassifier();
		assertEquals("Element", classifier.getName());
		EPackage pack = classifier.getEPackage();
		assertNotNull(pack);
		assertEquals(grammarAccess.getGrammar().getMetamodelDeclarations().get(0).getEPackage(), pack);
	}

	@Test public void testParse_01() throws Exception {
		String model = "model foo { element bar }";
		Resource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
	}
}
