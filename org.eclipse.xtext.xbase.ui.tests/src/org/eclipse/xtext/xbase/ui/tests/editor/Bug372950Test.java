/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug372950Test extends AbstractXbaseContentAssistBugTest {
	@Ignore
	@Test
	public void testProposeStringBuffer_01() throws Exception {
		shouldPropose("if (true) {} else { if (o as String != 1 && o instanceof StringBuff", StringBuffer.class);
	}

	@Ignore
	@Test
	public void testProposeStringBuffer_02() throws Exception {
		shouldPropose("if (true) {} else { if (o as String != 1d && o instanceof StringBuff", StringBuffer.class);
	}

	@Ignore
	@Test
	public void testProposeStringBuffer_03() throws Exception {
		shouldPropose("if (true) {} else { if (o as String != 1.1e5 && o instanceof StringBuff", StringBuffer.class);
	}

	@Test
	public void testProposeStringBuffer_04() throws Exception {
		shouldPropose("if (true) {} else { if (o as String != (1) && o instanceof StringBuff", StringBuffer.class);
	}

	@Test
	public void testProposeStringBuffer_05() throws Exception {
		shouldPropose("if (true) {} else { if (o as String != \"\" && o instanceof StringBuff", StringBuffer.class);
	}

	@Test
	public void testProposeStringBuffer_06() throws Exception {
		shouldPropose("if (true) {} else { if ((o as String != 1) && o instanceof StringBuff", StringBuffer.class);
	}

	@Test
	public void testProposeStringBuffer_07() throws Exception {
		shouldPropose("if (true) { if (o as String != 1 && o instanceof StringBuff", StringBuffer.class);
	}

	protected void shouldPropose(String input, Class<?> proposedType) throws Exception {
		ContentAssistProcessorTestBuilder tester = newBuilder();
		ICompletionProposal[] proposals = tester.append(input).computeCompletionProposals();
		List<String> proposalStrings = tester.toString(proposals);
		assertTrue(proposalStrings.toString(), proposalStrings.contains(proposedType.getSimpleName()));
	}
}
