/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.validation.EnumRulesTestLanguageCheckValidator;
import org.eclipse.xtext.validation.CompositeEValidator.EValidatorEqualitySupport;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class CompositeValidatorWithoutEObjectValidatorTest extends AbstractCompositeValidatorTest {

	@Override
	protected EnumRulesTestLanguageStandaloneSetup createStandaloneSetup() {
		return new EnumRulesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.enumrules.EnumRulesTestLanguageRuntimeModule() {
					
					@Override
					public void configure(Binder binder) {
						super.configure(binder);
						binder.bind(boolean.class).annotatedWith(
								Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false);
						binder.bind(EnumRulesTestLanguagePackage.class).toInstance(EnumRulesTestLanguagePackage.eINSTANCE);
					}
					
					@Override
					public Class<? extends EnumRulesTestLanguageCheckValidator> bindEnumRulesTestLanguageCheckValidator() {
						return null;
					}
					
				});
			}
			
		};
	}
	
	@Override
	public void testContentsSize() {
		EValidator validator = registry.getEValidator(pack);
		assertNotNull(validator);
		assertTrue(validator instanceof CompositeEValidator);
		CompositeEValidator composite = (CompositeEValidator) validator;
		Collection<EValidatorEqualitySupport> contents = composite.getContents();
		assertEquals(2, contents.size());
	}
	
}