/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import static org.junit.Assert.*;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.ContentAssistNoTerminalExtensionTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test that a language that does not inherite from Terminals and does not define ANY_OTHER completes well for tokens.
 * Tests introduced for https://github.com/eclipse/xtext-core/issues/69.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
@InjectWith(ContentAssistNoTerminalExtensionTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
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

}
