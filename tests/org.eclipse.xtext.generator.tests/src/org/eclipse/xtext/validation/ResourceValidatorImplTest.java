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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.Issue.Severity;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceValidatorImplTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
		EValidator.Registry.INSTANCE.put(LangATestLanguagePackage.eINSTANCE, new EValidator(){

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

			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				return validate(eObject,diagnostics,context);
			}

			public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				return false;
			}});
	}
	
	public void testSyntaxError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type foo."), 1);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertTrue(list.get(0).isSyntaxError());
	}
	
	public void testLinkingError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type foo extends Bar"), 1);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertTrue(list.get(0).isSyntaxError());
	}
	
	public void testSemanticError() throws Exception {
		XtextResource resource = getResourceAndExpect(new StringInputStream("type Foo"), 0);
		List<Issue> list = getValidator().validate(resource, CheckMode.NORMAL_AND_FAST, null);
		assertEquals(1,list.size());
		assertFalse(list.get(0).isSyntaxError());
		assertEquals(Severity.ERROR, list.get(0).getSeverity());
	}
	
	public void testSemanticWarning() throws Exception {
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
