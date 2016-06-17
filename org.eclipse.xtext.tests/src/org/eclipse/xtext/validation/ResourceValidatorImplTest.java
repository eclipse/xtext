/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceValidatorImplTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
		EValidator.Registry.INSTANCE.put(LangATestLanguagePackage.eINSTANCE, new EValidator(){

			@Override
			public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				if (eObject instanceof Type) {
					String name = ((Type)eObject).getName();
					if (name.equals("Foo"))
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,"",12,"Foo",null));
					if (name.equals("Bar"))
						diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,"",12,"Foo",null));
				}
				return true;
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				return validate(eObject,diagnostics,context);
			}

			@Override
			public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				return false;
			}});
	}
	
	@Test public void testSyntaxError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type foo."), 1);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertTrue(list.get(0).isSyntaxError());
	}
	
	@Test public void testLinkingError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type foo extends Bar"), 1);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertTrue(!list.get(0).isSyntaxError());
		assertEquals(org.eclipse.xtext.diagnostics.Diagnostic.LINKING_DIAGNOSTIC, list.get(0).getCode());
	}
	
	@Test public void testSemanticError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type Foo"), 0);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertFalse(list.get(0).isSyntaxError());
		assertEquals(Severity.ERROR, list.get(0).getSeverity());
	}
	
	@Test public void testSemanticWarning() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type Bar"), 0);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertFalse(list.get(0).isSyntaxError());
		assertEquals(Severity.WARNING, list.get(0).getSeverity());
	}
	
	private IResourceValidator getValidator() {
		return get(IResourceValidator.class);
	}
	
}
