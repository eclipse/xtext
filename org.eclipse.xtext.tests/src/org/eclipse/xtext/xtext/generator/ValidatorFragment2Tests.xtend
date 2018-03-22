/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
import org.junit.Test
import org.eclipse.xtext.AbstractRule

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
		val generatedString = fragment.generateValidationToDeprecateRules.concatenationClientToString
		assertTrue(generatedString.length === 0)
	}

	@Test
	def testGenerate() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
		''')

		
		val deprecatedRulesFromGrammar = fragment.deprecatedRulesFromGrammar
		assertEquals(1, deprecatedRulesFromGrammar.size)
		assertEquals('''
		
		@interface org.eclipse.xtext.validation.Check
		public void checkDeprecatedRule(org.xtext.foo.Rule element) {
			warning("This part of the language is marked as deprecated and might get removed in the future!", element, null);
		}
		'''.toString, fragment.generateValidationToDeprecateRules.concatenationClientToString)
	}

}
