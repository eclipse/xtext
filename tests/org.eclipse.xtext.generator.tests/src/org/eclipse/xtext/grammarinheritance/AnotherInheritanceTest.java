/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest2LanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class AnotherInheritanceTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EPackage aMetamodel = AmetamodelPackage.eINSTANCE;
		EPackage.Registry.INSTANCE.put(aMetamodel.getNsURI(), aMetamodel);
		with(new InheritanceTest2LanguageStandaloneSetup());
	}

	public void testSimple() throws Exception {
		InheritanceTest2LanguageGrammarAccess g = (InheritanceTest2LanguageGrammarAccess) getGrammarAccess();
		assertNotNull(g.getFQNAccess());
		assertNotNull(g.getModelAccess());
	}
}
