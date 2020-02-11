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
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug326948MissingInvocationTest extends AbstractBug326948Test {

	private boolean featureNameCalled;
	private boolean nameCalled;
	private boolean keywordCalled;
	
	@Override
	public void completeInfixExpression_FeatureName(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		featureNameCalled = true;
		assertEquals("", context.getPrefix());
	}
	
	@Override
	public void completeInfixExpression_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		nameCalled = true;
		assertEquals("", context.getPrefix());
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		if (keyword == ((BeeLangTestLanguageGrammarAccess) getGrammarAccess()).getInfixExpressionAccess().getLeftSquareBracketKeyword_1_1_1()) {
			Assert.assertEquals(".", contentAssistContext.getPrefix());
			keywordCalled = true;
		}
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		featureNameCalled = false;
		nameCalled = false;
		keywordCalled = false;
	}
	
	@Override
	public void tearDown() throws Exception {
		keywordCalled = false;
		featureNameCalled = false;
		nameCalled = false;
		super.tearDown();
	}
	
	@Test public void testAllAlternativesProposed() throws Exception {
		newBuilder()
			.append("function foo() { \"\".")
			.computeCompletionProposals();
		assertTrue(featureNameCalled);
		assertTrue(nameCalled);
		assertTrue(keywordCalled);
	}

}
