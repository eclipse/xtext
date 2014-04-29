/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class Bu427440Test extends AbstractXtendContentAssistBugTest {

	@Test def void testStaticMemberPriority() throws Exception {
		val proposals = newBuilder().append(
				'''
					class Test {
						static def augument() {}
					}
					
					class Main {
						def static void main(String[] args) {
							Test.a|
						}
						
					}
				''').computeCompletionProposals('|').iterator
		proposals.next.assertContains("augument")
		proposals.next.assertContains("annotation")
		proposals.next.assertContains("annotations")
		proposals.next.assertContains("anonymousClass")
		proposals.next.assertContains("array")
		proposals.next.assertContains("asSubclass()")
	}
	
	def void assertContains(ICompletionProposal proposal, String text) {
		assertEquals(text, proposal.proposedText)
	}
	
	def String getProposedText(ICompletionProposal completionProposal) {
		var proposedText = completionProposal.getDisplayString();
		if (completionProposal instanceof ConfigurableCompletionProposal) {
			proposedText = completionProposal.getReplacementString();
			if (completionProposal.getTextApplier() instanceof ReplacementTextApplier) {
				proposedText = (completionProposal.getTextApplier() as ReplacementTextApplier).getActualReplacementString(completionProposal);
			}
		}
		return proposedText;
	}
				

}