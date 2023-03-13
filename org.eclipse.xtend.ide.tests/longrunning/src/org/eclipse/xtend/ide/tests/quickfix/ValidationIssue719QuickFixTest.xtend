/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtend.core.validation.IssueCodes.MODIFIER_DOES_NOT_MATCH_TYPENAME

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author Eva Poell - Initial contribution
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class ValidationIssue719QuickFixTest extends AbstractQuickfixTest {

	@Before
	def void setup() {
		// Xbase-based languages require java project
		projectName.createJavaProject
	}

	@Test
	def void add_abstract_simple() {
		'''
			class AbstractSample {
			}
		'''.applyFix('''
			abstract class AbstractSample {
			}
		''')
	}

	@Test
	def void add_abstract_final_simple() {
		'''
			final class AbstractSample {
			}
		'''.applyFix('''
			abstract class AbstractSample {
			}
		''')
	}

	@Test
	def void add_abstract_package() {
		'''
			package class AbstractSample {
			}
		'''.applyFix('''
			package abstract class AbstractSample {
			}
		''')
	}

	@Test
	def void add_abstract_package_final() {
		'''
			package final class AbstractSample {
			}
		'''.applyFix('''
			package abstract class AbstractSample {
			}
		''')
	}

	@Test
	def void add_abstract_static() {
		'''
			static class AbstractSample {
			}
		'''.applyFix('''
			abstract static class AbstractSample {
			}
		''')
	}

	@Test
	def void add_abstract_nested_classes_outer() {
		'''
			class AbstractX{
				abstract static class AbstractY{
				}
			}
		'''.applyFix('''
			abstract class AbstractX{
				abstract static class AbstractY{
				}
			}
		''')
	}

	@Test
	def void add_abstract_nested_classes_inner() {
		'''
			abstract class AbstractX{
				class AbstractY{
				}
			}
		'''.applyFix('''
			abstract class AbstractX{
				abstract class AbstractY{
				}
			}
		''')
	}

	@Test
	def void add_abstract_nested_classes_outer_static() {
		'''
			static class AbstractX{
				class SampleInner{
				}
			}
		'''.applyFix('''
			abstract static class AbstractX{
				class SampleInner{
				}
			}
		''')
	}

	@Test
	def void add_abstract_annotation() {
		'''
			@Deprecated
			class AbstractX{
			}
		'''.applyFix('''
			@Deprecated
			abstract class AbstractX{
			}
		''')
	}

	@Test
	def void add_abstract_javadoc() {
		'''
			/**
			 * This is a doc for this abstract class.
			 * It even has two lines.
			 */
			class AbstractX{
			}
		'''.applyFix('''
			/**
			 * This is a doc for this abstract class.
			 * It even has two lines.
			 */
			abstract class AbstractX{
			}
		''')
	}

	def private applyFix(CharSequence input, CharSequence result) {
		val issueCode = MODIFIER_DOES_NOT_MATCH_TYPENAME
		val fixlabel = "Add missing abstract modifier."
		val fixdescription = "Add the abstract modifier to match naming conventions for the type name. Delete final modifier if necessary."

		input.testQuickfixesOn(issueCode, new Quickfix(fixlabel, fixdescription, result.toString))
	}
}
