/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator
import org.junit.Test

import static org.junit.Assert.*

import static extension org.eclipse.xtext.util.Strings.*
import org.eclipse.xtext.diagnostics.Diagnostic

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class ValidatorTest extends AbstractTestLangLanguageServerTest {

	@Test
	def void testMultilineDiagnostic() {
		'MyType1.testlang'.writeFile('''
			type Multiline_Demo {
			}
		'''.toUnixLineSeparator)
		initialize
		val problems = diagnostics.entrySet.head.value
		assertEquals("problems found:\n" + problems.join("\n"), 1, problems.size)
		val problem = problems.head
		assertEquals("Test Validation to mark the whole type", problem.message)
		assertEquals(TestLanguageValidator.MULTILINE_PROBLEM, problem.code)
		val range = problem.range
		assertEquals(0, range.start.line)
		assertEquals(0, range.start.character)
		assertEquals(1, range.end.line)
		assertEquals(1, range.end.character)
	}
	@Test
	def void testMultilineDiagnostic_02() {
		'MyType1.testlang'.writeFile('''
			type Multiline_Demo2 {
			string sample}
		'''.toUnixLineSeparator)
		initialize
		val problems = diagnostics.entrySet.head.value
		assertEquals("problems found:\n" + problems.join("\n"), 1, problems.size)
		val problem = problems.head
		assertEquals("Test Validation to mark the whole type", problem.message)
		assertEquals(TestLanguageValidator.MULTILINE_PROBLEM, problem.code)
		val range = problem.range
		assertEquals(0, range.start.line)
		assertEquals(0, range.start.character)
		assertEquals(1, range.end.line)
		assertEquals(14, range.end.character)
	}

	@Test
	def void testDiagnosticAtEndOfLineExcludingNewline() {
		'MyType1.testlang'.writeFile('''
			type lowercase
			{
			}
		'''.toUnixLineSeparator)
		initialize
		val problems = diagnostics.entrySet.head.value
		assertEquals("problems found:\n" + problems.join("\n"), 1, problems.size)
		val problem = problems.head
		assertEquals("Name should start with a capital", problem.message)
		assertEquals(TestLanguageValidator.INVALID_NAME, problem.code)
		val range = problem.range
		assertEquals(0, range.start.line)
		assertEquals(5, range.start.character)
		assertEquals(0, range.end.line)
		assertEquals(14, range.end.character)
	}

	@Test
	def void testDiagnosticAtEndOfLineIncludingNewline() {
		// If you want to specify a range that contains a line including the line ending character(s)
		// then use an end position denoting the start of the next line.
		'MyType1.testlang'.writeFile('''
			type
		'''.toUnixLineSeparator)
		initialize
		val problems = diagnostics.entrySet.head.value
		assertEquals("problems found:\n" + problems.join("\n"), 1, problems.size)
		val problem = problems.head
		assertEquals("mismatched input '<EOF>' expecting RULE_ID", problem.message)
		assertEquals(Diagnostic.SYNTAX_DIAGNOSTIC, problem.code)
		val range = problem.range
		assertEquals(0, range.start.line)
		assertEquals(4, range.start.character)
		assertEquals(1, range.end.line)
		assertEquals(0, range.end.character)
	}

}
