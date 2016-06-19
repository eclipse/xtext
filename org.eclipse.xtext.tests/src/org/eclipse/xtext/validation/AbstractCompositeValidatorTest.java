/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguageFactory;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.validation.CompositeEValidator.EValidatorEqualitySupport;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCompositeValidatorTest extends AbstractXtextTests {

	protected EValidator.Registry registry;
	protected EnumRulesTestLanguagePackage pack;
	private First first;
	private Second second;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(createStandaloneSetup());
		registry = get(EValidator.Registry.class);
		registry.clear();
		pack = get(EnumRulesTestLanguagePackage.class);
		first = get(First.class);
		second = get(Second.class);
	}
	
	@Override
	public void tearDown() throws Exception {
		registry = null;
		pack = null;
		first = null;
		second = null;
		super.tearDown();
	}
	
	protected abstract EnumRulesTestLanguageStandaloneSetup createStandaloneSetup();

	public static class First extends AbstractInjectableValidator {
		private final EnumRulesTestLanguagePackage pack;

		@Override
		protected boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
			return true;
		}
		
		@Inject
		public First(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	public static class Second extends AbstractInjectableValidator {
		private final EnumRulesTestLanguagePackage pack;
		
		@Override
		protected boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
			return true;
		}
		
		@Inject
		public Second(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	@Test public void testSetup() {
		assertNotNull("registry", registry);
	}
	
	@Test public void testFirstAndSecond() {
		EValidator validator = registry.getEValidator(pack);
		assertNotNull(validator);
		assertTrue(validator instanceof CompositeEValidator);
		CompositeEValidator composite = (CompositeEValidator) validator;
		Collection<EValidatorEqualitySupport> contents = composite.getContents();
		EValidatorEqualitySupport equalitySupport = get(EValidatorEqualitySupport.class);
		equalitySupport.setDelegate(first);
		assertTrue(contents.contains(equalitySupport));
		equalitySupport.setDelegate(second);
		assertTrue(contents.contains(equalitySupport));
	}
	
	@Test public void testBug_279962() {
		EValidator validator = registry.getEValidator(pack);
		assertTrue(validator instanceof CompositeEValidator);
		CompositeEValidator composite = (CompositeEValidator) validator;
		
		int prevSize = composite.getContents().size();
		
		get(Val_279962_01.class);
		get(Val_279962_04.class);
		assertEquals(prevSize + 2, composite.getContents().size());
		assertNotNull(validator);
		Resource resource = get(XtextResource.class);
		Model model = EnumRulesTestLanguageFactory.eINSTANCE.createModel();
		resource.getContents().add(model);
		// do not expect an exception
		validator.validate(model, new BasicDiagnostic(), null);
		assertEquals(prevSize + 4, composite.getContents().size());
	}
	
	@ComposedChecks(validators = { Val_279962_02.class })
	public static class Val_279962_01 extends AbstractDeclarativeValidator {
		private final EnumRulesTestLanguagePackage pack;
		
		@Inject
		public Val_279962_01(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	@ComposedChecks(validators = { Val_279962_03.class })
	public static class Val_279962_02 extends AbstractDeclarativeValidator {
		private final EnumRulesTestLanguagePackage pack;
		
		@Inject
		public Val_279962_02(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	public static class Val_279962_03 extends AbstractDeclarativeValidator {
		private final EnumRulesTestLanguagePackage pack;
		
		@Inject
		public Val_279962_03(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	@ComposedChecks(validators = { Val_279962_03.class })
	public static class Val_279962_04 extends AbstractDeclarativeValidator {
		private final EnumRulesTestLanguagePackage pack;
		
		@Inject
		public Val_279962_04(EnumRulesTestLanguagePackage pack) {
			this.pack = pack;
		}
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(pack);
		}
	}
	
	public abstract void testContentsSize();
}
