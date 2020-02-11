/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InheritanceGrammarAccessTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		EPackage.Registry.INSTANCE.put(AmetamodelPackage.eNS_URI, AmetamodelPackage.eINSTANCE);
		with(new ConcreteTestLanguageStandaloneSetup());
	}

	@Test public void testSuperGrammarAccessUsesItsOwnGrammar() throws Exception {
		AbstractTestLanguageGrammarAccess access = get(AbstractTestLanguageGrammarAccess.class);
		assertNotNull(access.getExtendableParserRuleAccess().getElementKeyword_0());
	}
}
