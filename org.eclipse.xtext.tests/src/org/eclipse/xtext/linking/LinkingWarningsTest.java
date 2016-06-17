/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingWarningsTest extends AbstractXtextTests implements ILinkingDiagnosticMessageProvider {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	private final String expected = "Expected Message";
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.linking.LangATestLanguageRuntimeModule() {
					@SuppressWarnings("unused")
					public ILinkingDiagnosticMessageProvider bindLinkingMessageProvider() {
						return LinkingWarningsTest.this;
					}
				});
			}
		});
	}
	
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		return new DiagnosticMessage(expected, Severity.WARNING, Diagnostic.LINKING_DIAGNOSTIC);
	}

	@Test public void testNoErrors() throws Exception {
		XtextResource resource = getResourceFromString(" type A extends B \n type B extends A");
		assertTrue(resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().isEmpty());
	}

	@Test public void testLinkingProblemAsWarning() throws Exception {
		String modelAsText = "type A extends B \n type B extends C";
		XtextResource resource = getResourceFromStringAndExpect(modelAsText, 0);
		assertTrue(resource.getErrors().isEmpty());
		assertEquals(1, resource.getWarnings().size());

		Diagnostic warning = (Diagnostic) resource.getWarnings().get(0);
		assertEquals(2, warning.getLine());
		assertEquals(expected, warning.getMessage());
	}
	
	@Test public void testFixedLinkingProblem() throws Exception {
		String modelAsText = "type A extends B \n type B extends C";
		XtextResource resource = getResourceFromStringAndExpect(modelAsText, 0);
		assertTrue(resource.getErrors().isEmpty());
		assertEquals(1, resource.getWarnings().size());

		resource.update(modelAsText.indexOf('C'), 1, "A");
		
		assertTrue(resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().isEmpty());
	}
	

}
