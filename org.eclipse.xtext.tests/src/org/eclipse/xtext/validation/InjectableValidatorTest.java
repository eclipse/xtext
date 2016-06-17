/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguageFactory;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class InjectableValidatorTest extends AbstractXtextTests {
	
	private LanguageSpecificValidator languageSpecificValidator;
	private LanguageAgnosticValidator languageAgnosticValidator;
	private XtextResource xtextResource;
	private Map<Object, Object> context;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
		languageSpecificValidator = get(LanguageSpecificValidator.class);
		languageAgnosticValidator = get(LanguageAgnosticValidator.class);
		xtextResource = get(XtextResource.class);
		context = newHashMap();
	}

	@Test public void testCorrectResource() throws Exception {
		Main main = LangATestLanguageFactory.eINSTANCE.createMain();
		xtextResource.getContents().add(main);
		assertFalse(languageSpecificValidator.validate(main, new BasicDiagnostic(), null));
		assertFalse(languageSpecificValidator.validate(main, new BasicDiagnostic(), context));
		assertEquals(xtextResource.getLanguageName(), context.get(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME));
		
		context.clear();
		assertFalse(languageAgnosticValidator.validate(main, new BasicDiagnostic(), null));
		assertFalse(languageAgnosticValidator.validate(main, new BasicDiagnostic(), context));
		assertNull(context.get(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME));		
	}
	
	@Test public void testArbitraryEPackage() throws Exception {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		xtextResource.getContents().add(ePackage);
		assertFalse(languageSpecificValidator.validate(ePackage, new BasicDiagnostic(), null));
		assertFalse(languageSpecificValidator.validate(ePackage, new BasicDiagnostic(), context));
		assertEquals(xtextResource.getLanguageName(), context.get(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME));		

		context.clear();
		assertFalse(languageAgnosticValidator.validate(ePackage, new BasicDiagnostic(), null));
		assertFalse(languageAgnosticValidator.validate(ePackage, new BasicDiagnostic(), context));
		assertNull(context.get(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME));		
	}
	
	@Test public void testWrongResource() throws Exception {
		Main main = LangATestLanguageFactory.eINSTANCE.createMain();
		XMIResource xmiResource = new XMIResourceImpl();
		xmiResource.getContents().add(main);
		assertTrue(languageSpecificValidator.validate(main, new BasicDiagnostic(), null));
		assertTrue(languageSpecificValidator.validate(main, new BasicDiagnostic(), context));
		context.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME, xtextResource.getLanguageName());
		assertFalse(languageSpecificValidator.validate(main, new BasicDiagnostic(), context));

		context.clear();
		assertFalse(languageAgnosticValidator.validate(main, new BasicDiagnostic(), null));
		assertFalse(languageAgnosticValidator.validate(main, new BasicDiagnostic(), context));
		context.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME, xtextResource.getLanguageName());
		assertFalse(languageAgnosticValidator.validate(main, new BasicDiagnostic(), context));
	}

	static class LanguageSpecificValidator extends AbstractInjectableValidator {

		@Override
		protected boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
				Map<Object, Object> context) {
			return false;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return singletonList((EPackage)LangATestLanguagePackage.eINSTANCE);
		}
	}
	
	static class LanguageAgnosticValidator extends AbstractInjectableValidator {

		@Override
		protected boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
				Map<Object, Object> context) {
			return false;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return singletonList((EPackage)LangATestLanguagePackage.eINSTANCE);
		}
		
		@Override
		public boolean isLanguageSpecific() {
			return false;
		}
	}
 
}
