package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

class JavaDocContentAssistTest extends AbstractXtendContentAssistBugTest {

	@Test
	def void testTypeInJavaDoc() {
		newBuilder.append(
		'''
		package foo
		/**
		 * @see java.util.Dat
		 */
		class Foo {}
		''').assertTextAtCursorPosition(37,'java.util.Date')
		.applyProposal(37).
		expectContent('''
		package foo

		import java.util.Date

		/**
		 * @see Date
		 */
		class Foo {}
		''')
	}

	@Test
	def void testTypeInJavaDoc_2() {
		newBuilder.append(
		'''
		package foo
		/**
		 * @see java.lang.StringBuff
		 */
		class Foo {}
		''').assertTextAtCursorPosition(44, "StringBuffer")
		.applyProposal(44).
		expectContent('''
		package foo
		/**
		 * @see StringBuffer
		 */
		class Foo {}
		''')
	}

	@Test
	def void testTypeInJavaDoc_3() {
		assertTrue(newBuilder.append(
		'''
		package foo
		/**
		 * java.lang.StringBuff
		 */
		class Foo {}
		''').computeCompletionProposals(39).isEmpty())
	}


	@Test
	def void testTypeInJavaDoc_4() {
		newBuilder.append(
		'''
		package foo
		/**
		 * @see    java.lang.StringBuff
		 */
		class Foo {}
		''').assertTextAtCursorPosition(47, "StringBuffer")
		.applyProposal(47).
		expectContent('''
		package foo
		/**
		 * @see    StringBuffer
		 */
		class Foo {}
		''')
	}

	@Test
	def void testTypeInJavaDoc_5() {
		newBuilder.append(
		'''
		package foo
		/**
		 * {@link java.lang.StringBuff
		 */
		class Foo {}
		''').assertTextAtCursorPosition(46, "StringBuffer")
		.applyProposal(46).
		expectContent('''
		package foo
		/**
		 * {@link StringBuffer
		 */
		class Foo {}
		''')
	}

	@Test
	def void testTypeInJavaDoc_6() {
		newBuilder.append(
		'''
		package foo
		/**
		 * {@link    java.lang.StringBuff
		 */
		class Foo {}
		''').assertTextAtCursorPosition(49, "StringBuffer")
		.applyProposal(49).
		expectContent('''
		package foo
		/**
		 * {@link    StringBuffer
		 */
		class Foo {}
		''')
	}

}