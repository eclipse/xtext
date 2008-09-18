/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Xtext2EcoreTransformerTests extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testRuleWithoutExplicitReturnType() throws Exception {
		Grammar grammar = (Grammar) getModel("language test generate test 'http://test' MyRule: myFeature=INT;");
		EList<AbstractRule> rules = grammar.getRules();
		AbstractRule firstRule = rules.get(0);
		assertNull(firstRule.getType());
		Xtext2EcoreTransformer xtext2EcoreTransformer = new Xtext2EcoreTransformer();
		List<EPackage> metamodels = xtext2EcoreTransformer.transform(grammar);
		assertTrue(metamodels != null && !metamodels.isEmpty());
		EPackage firstEPackage = metamodels.get(0);
		EList<EClassifier> classifiers = firstEPackage.getEClassifiers();
		assertEquals(1, classifiers.size());
		EClassifier implicitlyDefinedMetatype = classifiers.get(0);
		assertEquals("MyRule", implicitlyDefinedMetatype.getName());
	}
}
