/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class InvalidTokenTest extends AbstractGeneratorTest {

	public void testInvalidTokenError() throws Exception {
		with(OptionalEmptyTestLanguageStandaloneSetup.class);
		CompositeNode rootNode = getRootNodeAndExpect("/*", 1);
		EList<SyntaxError> allSyntaxErrors = rootNode.allSyntaxErrors();
		assertFalse(allSyntaxErrors.isEmpty());
		SyntaxError syntaxError = allSyntaxErrors.get(0);
		assertTrue(syntaxError.getMessage().contains("mismatched character"));
	}
}
