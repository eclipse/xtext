/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import static org.junit.Assert.*;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.ContentAssistNoTerminalExtensionTestLanguageUiInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test that a language that does not inherite from Terminals and does not define ANY_OTHER completes well for tokens. Tests introduced for
 * https://github.com/eclipse/xtext-core/issues/69.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
@InjectWith(ContentAssistNoTerminalExtensionTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
@Ignore // https://github.com/eclipse/xtext-core/issues/69 is not fixed, hence the tests fail ... enable if a proper bugfix is found
public class ContentAssistNoTerminalExtensionContentAssistTest extends AbstractContentAssistTest {

	@Test
	public void expectedAutocompletionAfterTwoCharacters() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("pr<|>").getProposalsAtCursorIndicator();
		assertEquals(4, proposals.length);
		assertEquals("primersite", proposals[0].getDisplayString());
		assertEquals("promoter", proposals[1].getDisplayString());
		assertEquals("proteasesite", proposals[2].getDisplayString());
		assertEquals("proteinstab", proposals[3].getDisplayString());
	}

	@Test
	public void expectedAutocompletionAfterTwoCharacters1() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("plain pr<|> plain").getProposalsAtCursorIndicator();
		assertEquals(4, proposals.length);
		assertEquals("primersite", proposals[0].getDisplayString());
		assertEquals("promoter", proposals[1].getDisplayString());
		assertEquals("proteasesite", proposals[2].getDisplayString());
		assertEquals("proteinstab", proposals[3].getDisplayString());
	}

	@Test
	public void expectedAutocompletionAfterTwoCharacters2() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("pr<|>omoter").getProposalsAtCursorIndicator();
		assertEquals(4, proposals.length);
		assertEquals("primersite", proposals[0].getDisplayString());
		assertEquals("promoter", proposals[1].getDisplayString());
		assertEquals("proteasesite", proposals[2].getDisplayString());
		assertEquals("proteinstab", proposals[3].getDisplayString());
	}

	@Test
	public void expectedAutocompletionAfterTwoCharacters3() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("pr<|> plain").getProposalsAtCursorIndicator();
		assertEquals(4, proposals.length);
		assertEquals("primersite", proposals[0].getDisplayString());
		assertEquals("promoter", proposals[1].getDisplayString());
		assertEquals("proteasesite", proposals[2].getDisplayString());
		assertEquals("proteinstab", proposals[3].getDisplayString());
	}

	@Test
	public void expectedAutocompletionAfterTwoCharacters4() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("plain pr<|>").getProposalsAtCursorIndicator();
		assertEquals(4, proposals.length);
		assertEquals("primersite", proposals[0].getDisplayString());
		assertEquals("promoter", proposals[1].getDisplayString());
		assertEquals("proteasesite", proposals[2].getDisplayString());
		assertEquals("proteinstab", proposals[3].getDisplayString());
	}

	@Test
	public void expectedAutocompletionAfterTwoCharacters5() throws Exception {
		ICompletionProposal[] proposals = newBuilder().insert("pe<|>").getProposalsAtCursorIndicator();
		assertEquals(1, proposals.length);
		assertEquals("pentagon", proposals[0].getDisplayString());
	}

}
