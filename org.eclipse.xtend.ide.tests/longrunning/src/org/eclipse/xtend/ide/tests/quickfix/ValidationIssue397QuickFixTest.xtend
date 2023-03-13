/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtend.core.validation.IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author Eva Poell - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class ValidationIssue397QuickFixTest extends AbstractQuickfixTest {

	// Severity is "ignore" per Default, but needs to be stronger for testing
	@Inject IPreferenceStoreAccess preferenceStoreAccess

	@Before
	def void setup() {
		// Xbase-based languages require java project
		val project = projectName.createJavaProject.project

		val prefStore = preferenceStoreAccess.getWritablePreferenceStore(project)
		prefStore.setValue(TERNARY_EXPRESSION_NOT_ALLOWED, "error")
	}

	@Test
	def void test_fixTernExpSimple1() {
		"bool? 1 : 2".applyFix(
		"if (bool) 1 else 2")
	}

	@Test
	def void test_fixTernExpSimple2() {
		"(bool)? 1 : 2".applyFix(
		"if (bool) 1 else 2")
	}

	@Test
	def void test_fixTernExpSimple3() {
		"a < b? 1 : 2".applyFix(
		"if (a < b) 1 else 2")
	}

	@Test
	def void test_fixTernExpNoElse() {
		"bool? 1".applyFix(
		"if (bool) 1")
	}

	@Test
	def void test_fixTernExpNoElse2() {
		"!bool? 1".applyFix(
		"if (!bool) 1")
	}

	@Test
	def void test_fixTernExpNoElse3() {
		"a < b? 1".applyFix(
		"if (a < b) 1")
	}

	@Test
	def void test_fixTernExpNestedThen() {
		"bool? if (!bool) 3 else 4 : 2".applyFix(
		"if (bool) if (!bool) 3 else 4 else 2")
	}

	@Test
	def void test_fixTernExpNestedElse() {
		"bool? 1 : if(!bool) 5 else 6".applyFix(
		"if (bool) 1 else if(!bool) 5 else 6")
	}

	@Test
	def void test_fixTernExpNestedBoth() {
		"bool? if (!bool) 3 else 4 : if(!bool) 5 else 6".applyFix(
		"if (bool) if (!bool) 3 else 4 else if(!bool) 5 else 6")
	}

	@Test
	def void test_fixTernExpNestedInThen1() {
		"if (bool) (!bool)? 3 : 4 else 2".applyFix(
		"if (bool) if (!bool) 3 else 4 else 2")
	}

	@Test
	def void test_fixTernExpNestedInThen2() {
		"if (bool) a < b? 3 : 4 else 2".applyFix(
		"if (bool) if (a < b) 3 else 4 else 2")
	}

	@Test
	def void test_fixTernExpNestedInThenBrackets1() {
		"if (bool) (bool? 1) else 2".applyFix(
		"if (bool) (if (bool) 1) else 2")
	}

	@Test
	def void test_fixTernExpNestedInThenBrackets2() {
		"if (bool) (bool? 3 : 4) else 2".applyFix(
		"if (bool) (if (bool) 3 else 4) else 2")
	}

	@Test
	def void test_fixTernExpNestedInElse() {
		"if (bool) 1 else (!bool)? 5 : 6".applyFix(
		"if (bool) 1 else if (!bool) 5 else 6")
	}

	@Test
	def void test_fixTernExpNestedInElseBrackets() {
		"if (bool) 1 else ((bool)? 5 : 6)".applyFix(
		"if (bool) 1 else (if (bool) 5 else 6)")
	}

	@Test
	def void test_fixTernExpNestedDoubleTrouble1() {
		"if (bool) !bool? 5 : 7 else if (bool) 4 else 6".applyFix(
		"if (bool) if (!bool) 5 else 7 else if (bool) 4 else 6")
	}

	@Test
	def void test_fixTernExpNestedDoubleTrouble2() {
		"bool? !bool? 5 : 7 : (bool)? 4 : 6".applyFix(
		"if (bool) if (!bool) 5 else 7 else if (bool) 4 else 6")
	}

	@Test
	def void test_fixTernExpNestedDoubleTrouble3() {
		"bool? !bool? if (!bool) 1 else 2 : 3 : (bool)? 5 : 4".applyFix(
		"if (bool) if (!bool) if (!bool) 1 else 2 else 3 else if (bool) 5 else 4")
	}

	@Test
	def void test_fixTernExpDoubleNestedInThenBrackets() {
		"if (bool) (bool? if (a < b) 8 else 9 : 4) else 2".applyFix(
		"if (bool) (if (bool) if (a < b) 8 else 9 else 4) else 2")
	}

	@Test
	def void test_fixTernExpSpaces1() {
		"bool  ?         1   :    2".applyFix(
		"if (bool) 1 else 2")
	}

	@Test
	def void test_fixTernExpSpaces2() {
		"if (bool ) (!bool  )?    3    :   4  else       2".applyFix(
		"if (bool ) if (!bool  ) 3 else 4  else       2")
	}

	@Test
	def void test_fixTernExpSimpleWithHardEnd() {
		"(a < b)? 4 : 2;System.out.println(\"test\")".applyFix(
		"if (a < b) 4 else 2;System.out.println(\"test\")")
	}

	@Test
	def void test_fixTernExpNestedWithHardEnd() {
		"if (a < b) 4 else (a > b)           ? 3 : 2;System.out.println(\"test\")".applyFix(
		"if (a < b) 4 else if (a > b) 3 else 2;System.out.println(\"test\")")
	}

	def private applyFix(CharSequence input, CharSequence result) {
		val issueCode = TERNARY_EXPRESSION_NOT_ALLOWED
		val fixlabel = "Refactor into inline if-expression."
		val fixdescription = "Refactor ternary expression (cond? a : b) \ninto an inline if-expression (if cond a else b).";

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
		val toExpect = start + result + end

		toTest.testQuickfixesOn(issueCode, new Quickfix(fixlabel, fixdescription, toExpect))
	}
}
