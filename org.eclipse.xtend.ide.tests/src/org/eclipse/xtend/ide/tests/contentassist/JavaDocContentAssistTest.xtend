/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test
import java.util.List

class JavaDocContentAssistTest extends AbstractXtendContentAssistBugTest {

	// cursor position marker
	val c = '''<|>'''

	@Test def testTypeInJavaDoc_1() {
		'''
			package foo
			/**
			 * @see java.util.Dat«c»
			 */
			class Foo {}
		'''.testContentAssistant(#["java.util.Date"], '''
			package foo

			import java.util.Date

			/**
			 * @see Date
			 */
			class Foo {}
		''')
	}

	@Test def testTypeInJavaDoc_2() {
		'''
			package foo
			/**
			 * @see java.lang.StringBuff«c»
			 */
			class Foo {}
		'''.testContentAssistant(#["StringBuffer"], '''
			package foo
			/**
			 * @see StringBuffer
			 */
			class Foo {}
		''')
	}

	@Test def testTypeInJavaDoc_3() {
		'''
			package foo
			/**
			 * java.lang.StringBuff«c»
			 */
			class Foo {}
		'''.testEmptyContentAssistant
	}

	@Test def testTypeInJavaDoc_4() {
		'''
			package foo
			/**
			 * @see    java.lang.StringBuff«c»
			 */
			class Foo {}
		'''.testContentAssistant(#["StringBuffer"], '''
			package foo
			/**
			 * @see    StringBuffer
			 */
			class Foo {}
		''')
	}

	@Test def testTypeInJavaDoc_5() {
		'''
			package foo
			/**
			 * {@link java.lang.StringBuff«c»
			 */
			class Foo {}
		'''.testContentAssistant(#["StringBuffer"], '''
			package foo
			/**
			 * {@link StringBuffer
			 */
			class Foo {}
		''')
	}

	@Test def testTypeInJavaDoc_6() {
		'''
			package foo
			/**
			 * {@link    java.lang.StringBuff«c»
			 */
			class Foo {}
		'''.testContentAssistant(#["StringBuffer"], '''
			package foo
			/**
			 * {@link    StringBuffer
			 */
			class Foo {}
		''')
	}

	private def testEmptyContentAssistant(CharSequence it) {
		testContentAssistant(#[], null, null)
	}
	
	private def testContentAssistant(CharSequence it, List<String> expectedProposals, String expectedContent) {
		testContentAssistant(expectedProposals, expectedProposals.head, expectedContent)	
	}

	private def void testContentAssistant(CharSequence text, List<String> expectedProposals,
		String proposalToApply, String expectedContent) {
		
		val cursorPosition = text.toString.indexOf(c)
		if(cursorPosition == -1) {
			fail("Can't locate cursor position symbols '" + c + "' in the input text.")
		}
		
		val content = text.toString.replace(c, "")
		
		val builder = newBuilder.append(content).assertTextAtCursorPosition(cursorPosition, expectedProposals)
		
		if(proposalToApply !== null) {
			builder.applyProposal(cursorPosition, proposalToApply).expectContent(expectedContent)
		}
	}
}