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
public class Bug350007Test extends AbstractXbaseContentAssistBugTest {
	@Test
	public void testTypeLiteral_01() {
		expectArrayList("typeof(java.util");
	}

	@Test
	public void testTypeLiteral_02() {
		expectArrayList("typeof(java.util.A");
	}

	@Test
	@Ignore
	public void testTypeLiteral_03() {
		expectArrayList("typeof(java.util.");
	}

	@Test
	public void testInstanceOf_01() {
		expectArrayList("null instanceof java.util");
	}

	@Test
	public void testInstanceOf_02() {
		expectArrayList("null instanceof java.util.A");
	}

	@Test
	@Ignore
	public void testInstanceOf_03() {
		expectArrayList("null instanceof java.util.");
	}

	@Test
	public void testCast_01() {
		expectArrayList("null as java.util");
	}

	@Test
	public void testCast_02() {
		expectArrayList("null as java.util.A");
	}

	@Test
	@Ignore
	public void testCast_03() {
		expectArrayList("null as java.util.");
	}

	@Test
	public void testConstructor_01() {
		expectArrayList("new java.util");
	}

	@Test
	public void testConstructor_02() {
		expectArrayList("new java.util.A");
	}

	@Test
	@Ignore
	public void testConstructor_03() {
		expectArrayList("new java.util.");
	}

	protected void expectArrayList(String input) {
		List<String> proposalStrings;
		try {
			proposalStrings = getProposals(input);
		} catch (Exception e) {
			throw new AssertionError("Could not calculate proposals.", e);
		}
		assertTrue(proposalStrings.toString(), proposalStrings.contains("java.util.ArrayList"));
	}

	private List<String> getProposals(String input) throws Exception {
		ContentAssistProcessorTestBuilder tester = newBuilder();
		ICompletionProposal[] proposals = tester.append(input).computeCompletionProposals();
		List<String> proposalStrings = tester.toString(proposals);
		return proposalStrings;
	}
}
