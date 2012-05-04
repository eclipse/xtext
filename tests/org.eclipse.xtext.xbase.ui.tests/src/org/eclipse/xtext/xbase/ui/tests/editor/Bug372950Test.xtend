package org.eclipse.xtext.xbase.ui.tests.editor

import org.junit.Test
import org.junit.Ignore

class Bug372950Test extends AbstractXbaseContentAssistBugTest {

	@Ignore@Test
	def void testProposeStringBuffer_01() throws Exception {
		'if (true) {} else { if (o as String != 1 && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Ignore@Test
	def void testProposeStringBuffer_02() throws Exception {
		'if (true) {} else { if (o as String != 1d && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Ignore@Test
	def void testProposeStringBuffer_03() throws Exception {
		'if (true) {} else { if (o as String != 1.1e5 && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Test
	def void testProposeStringBuffer_04() throws Exception {
		'if (true) {} else { if (o as String != (1) && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Test
	def void testProposeStringBuffer_05() throws Exception {
		'if (true) {} else { if (o as String != "" && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Test
	def void testProposeStringBuffer_06() throws Exception {
		'if (true) {} else { if ((o as String != 1) && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	@Test
	def void testProposeStringBuffer_07() throws Exception {
		'if (true) { if (o as String != 1 && o instanceof StringBuff'.shouldPropose(typeof(StringBuffer))
	}
	
	def protected void shouldPropose(String input, Class<?> proposedType) throws Exception {
		val tester = newBuilder
		val proposals = tester.append(input).computeCompletionProposals
		val proposalStrings = tester.toString(proposals)
		assertTrue(proposalStrings.toString, proposalStrings.contains(proposedType.name))
	}
	
}