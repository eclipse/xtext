package org.eclipse.xtext.xbase.ui.tests.editor

import org.junit.Test
import org.junit.Ignore

class Bug350007Test extends AbstractXbaseContentAssistBugTest {

	@Test
	def void testTypeLiteral_01() {
		expectArrayList("typeof(java.util");
	}
	
	@Test
	def void testTypeLiteral_02() {
		expectArrayList("typeof(java.util.A");
	}
	
	@Test
	@Ignore
	def void testTypeLiteral_03() {
		expectArrayList("typeof(java.util.")
	}
	
	@Test
	def void testInstanceOf_01() {
		expectArrayList("null instanceof java.util");
	}
	
	@Test
	def void testInstanceOf_02() {
		expectArrayList("null instanceof java.util.A");
	}
	
	@Test
	@Ignore
	def void testInstanceOf_03() {
		expectArrayList("null instanceof java.util.")
	}
	
	@Test
	def void testCast_01() {
		expectArrayList("null as java.util");
	}
	
	@Test
	def void testCast_02() {
		expectArrayList("null as java.util.A");
	}
	
	@Test
	@Ignore
	def void testCast_03() {
		expectArrayList("null as java.util.")
	}

	@Test
	def void testConstructor_01() {
		expectArrayList("new java.util");
	}

	@Test
	def void testConstructor_02() {
		expectArrayList("new java.util.A");
	}

	@Test
	@Ignore 
	def void testConstructor_03() {
		expectArrayList("new java.util.")
	}
	
	def protected void expectArrayList(String input) {
		val tester = newBuilder
		val proposals = tester.append(input).computeCompletionProposals
		val proposalStrings = tester.toString(proposals)
		assertTrue(proposalStrings.toString(), proposalStrings.contains("java.util.ArrayList"))
	}
	
}