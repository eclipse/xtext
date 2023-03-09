/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.ChainedExpression;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.ValueLiteral;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug326948WrongContextTest extends AbstractBug326948Test {

	@Override
	public void completeInfixExpression_FeatureName(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		assertContextAsExpected(context);
	}

	protected void assertContextAsExpected(ContentAssistContext context) {
		assertTrue(String.valueOf(context.getPreviousModel()), context.getPreviousModel() instanceof ValueLiteral);
		assertTrue(String.valueOf(context.getPreviousModel()), context.getCurrentModel() instanceof ChainedExpression);
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		assertContextAsExpected(contentAssistContext);
	}
	
	@Override
	public void completeInfixExpression_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		assertContextAsExpected(context);
	}
	
	@Test public void testCurrentModel_01() throws Exception {
		newBuilder()
			.append("function foo() { \"\".")
			.computeCompletionProposals();
	}
	
	@Test public void testCurrentModel_02() throws Exception {
		newBuilder()
			.append("function foo() { \"\". ;")
			.computeCompletionProposals(" ;");
	}
	
	@Test public void testCurrentModel_03() throws Exception {
		newBuilder()
			.append("function foo() { \"\". ; }")
			.computeCompletionProposals(" ;");
	}

}
