/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.linking.bug362902.Model;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug362902Test extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug362902StandaloneSetup.class);
	}
	
	@Test public void testNoExceptionUncaught() throws Exception {
		String modelAsString = "Hello max ! Hello peter! favourite peter";
		Model model = (Model)getModelAndExpect(modelAsString, 2);
		EList<Diagnostic> errors = model.eResource().getErrors();
		Diagnostic diagnosticSyntax = errors.get(0);
		Diagnostic diagnosticLinking = errors.get(1);
		assertTrue(diagnosticSyntax instanceof XtextSyntaxDiagnostic);
		assertTrue(diagnosticLinking instanceof XtextLinkingDiagnostic);
	}
}
