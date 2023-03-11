/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*

/**
 * @author Eva Poell - Initial contribution and API
 */
class ValidationIssue397Test extends AbstractXtendTestCase {
	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	// Severity is "ignore" per Default, but needs to be stronger for testing
	@Inject MapBasedPreferenceValues preferences

	@Inject
	def setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null)
	}

	@Before
	def void setSeverity() {
		preferences.put(TERNARY_EXPRESSION_NOT_ALLOWED, "error")
	}

	@After
	def void clearPreferences() {
		preferences.clear()
	}

	@Test
	def void test_normalIfExp() {
		'''
			class Foo {
				
				def fooMethod(boolean bool) {
					var c = if(bool) 1 else 2
					return c
				}
			}
		'''.parse.assertNoIssues
	}

	@Test
	def void test_ternExpSimple1() {
		"bool? 1 : 2".issue
	}

	@Test
	def void test_ternExpSimple2() {
		"(bool)? 1 : 2".issue
	}

	@Test
	def void test_ternExpSimple3() {
		"a < b? 1 : 2".issue
	}

	@Test
	def void test_ternExpNoElse() {
		"bool? 1".issue
	}

	@Test
	def void test_ternExpNoElse2() {
		"!bool? 1".issue
	}

	@Test
	def void test_ternExpNoElse3() {
		"a < b? 1".issue
	}

	@Test
	def void test_ternExpNestedThen() {
		"bool? if (!bool) 3 else 4 : 2".issue
	}

	@Test
	def void test_ternExpNestedElse() {
		"bool? 1 : if(!bool) 5 else 6".issue
	}

	@Test
	def void test_ternExpNestedBoth() {
		"bool? if (!bool) 3 else 4 : if(!bool) 5 else 6".issue
	}

	@Test
	def void test_ternExpNestedInThen1() {
		"if (bool) (!bool)? 3 : 4 else 2".issue
	}

	@Test
	def void test_ternExpNestedInThen2() {
		"if bool a < b? 3 : 4 else 2".issue
	}

	@Test
	def void test_ternExpNestedInThenBrackets1() {
		"if (bool) (bool? 1) else 2".issue
	}

	@Test
	def void test_ternExpNestedInThenBrackets2() {
		"if (bool) (bool? 3 : 4) else 2".issue
	}

	@Test
	def void test_ternExpNestedInElse() {
		"if (bool) 1 else (!bool)? 5 : 6".issue
	}

	@Test
	def void test_ternExpNestedInElseBrackets() {
		"if (bool) 1 else ((bool)? 5 : 6)".issue
	}

	@Test
	def void test_ternExpNestedDoubleTrouble() {
		"bool? !bool? 5 : 7 : (bool)? 4 : 6".issue
	}

	@Test
	def void test_ternExpDoubleNestedInThenBrackets() {
		"if (bool) (bool? if (a < b) 8 else 9 : 4) else 2".issue
	}

	@Test
	def void test_ternExpSpaces1() {
		"bool  ?         1   :    2".issue
	}

	@Test
	def void test_ternExpSpaces2() {
		"if (bool ) (!bool  )?    3    :   4  else       2".issue
	}

	def private issue(CharSequence input) {
		val start = '''
					class Foo  {
						var a = 1
						var a = 2
					
						def fooMethod(boolean bool) {
							var c = '''
		val end = '''
						
							return c
						}
					}
				'''
		val toTest = start + input + end

		toTest.parse.assertError(XIF_EXPRESSION, TERNARY_EXPRESSION_NOT_ALLOWED, "ternary operator")
	}
}
