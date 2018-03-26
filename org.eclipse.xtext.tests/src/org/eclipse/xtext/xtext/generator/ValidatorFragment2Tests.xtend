/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
import org.eclipse.xtext.xtext.generator.validation.ValidatorNaming
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
class ValidatorFragment2Tests extends AbstractGeneratorFragmentTests {

	static class TestableValidatorFragment2 extends ValidatorFragment2 {

		override protected getDeprecatedRulesFromGrammar() {
			super.getDeprecatedRulesFromGrammar()
		}

		override protected generateValidationToDeprecateRules() {
			super.generateValidationToDeprecateRules()
		}

		override protected generateGenValidator() {
			super.generateGenValidator()
		}

	}

	@Test
	def testGenerateNothing() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			Rule: name=ID;
		''')
		val deprecatedRules = fragment.deprecatedRulesFromGrammar
		assertTrue(deprecatedRules.empty)
		assertEquals('''
			package org.xtext.validation;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
			
			public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {
				
				@Override
				protected List<EPackage> getEPackages() {
					List<EPackage> result = new ArrayList<EPackage>();
					result.add(org.xtext.foo.FooPackage.eINSTANCE);
					return result;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateGenValidator))
	}

	@Test
	def testGenerate() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')

		val deprecatedRulesFromGrammar = fragment.deprecatedRulesFromGrammar
		assertEquals(1, deprecatedRulesFromGrammar.size)
		assertEquals('''
			package org.xtext.validation;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
			import org.eclipse.xtext.validation.Check;
			import org.xtext.foo.Rule;
			
			public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {
				
				@Override
				protected List<EPackage> getEPackages() {
					List<EPackage> result = new ArrayList<EPackage>();
					result.add(org.xtext.foo.FooPackage.eINSTANCE);
					return result;
				}
				
				@Check
				public void checkDeprecatedRule(Rule element) {
					warning("This part of the language is marked as deprecated and might get removed in the future!", element, null);
				}
			}
		'''.toString,concatenationClientToString(fragment.generateGenValidator))
	}

	@Test
	def testGenerate_NoValidation() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = false
		val deprecatedRulesFromGrammar = fragment.deprecatedRulesFromGrammar
		assertEquals(1, deprecatedRulesFromGrammar.size)
		assertEquals('''
			package org.xtext.validation;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
			
			public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {
				
				@Override
				protected List<EPackage> getEPackages() {
					List<EPackage> result = new ArrayList<EPackage>();
					result.add(org.xtext.foo.FooPackage.eINSTANCE);
					return result;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateGenValidator))
	}

}
