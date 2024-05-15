/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.backtracking.ui.BeeLangTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.backtracking.ui.contentassist.BeeLangTestLanguageProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBug326948Test extends AbstractXtextTests implements ResourceLoadHelper {
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		with(getSetup());
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
	protected ISetup getSetup() {
		return doGetSetup();
	}

	public void completeInfixExpression_FeatureName(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	}
	
	public void completeInfixExpression_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
	}
	
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
	}

	public static class ProposalProvider extends BeeLangTestLanguageProposalProvider {
		
		@Inject
		private AbstractBug326948Test test;
		
		@Inject
		private BeeLangTestLanguageGrammarAccess grammarAccess;
		
		@Override
		public void completeInfixExpression_FeatureName(EObject model, Assignment assignment,
				ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			test.completeInfixExpression_FeatureName(model, assignment, context, acceptor);
			super.completeInfixExpression_FeatureName(model, assignment, context, acceptor);
		}
		
		@Override
		public void completeInfixExpression_Name(EObject model, Assignment assignment, ContentAssistContext context,
				ICompletionProposalAcceptor acceptor) {
			test.completeInfixExpression_Name(model, assignment, context, acceptor);
			super.completeInfixExpression_Name(model, assignment, context, acceptor);
		}
		
		@Override
		public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
				ICompletionProposalAcceptor acceptor) {
			if (keyword == grammarAccess.getInfixExpressionAccess().getLeftSquareBracketKeyword_1_1_1()) {
				test.completeKeyword(keyword, contentAssistContext, acceptor);
			}
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}
	
	public ISetup doGetSetup() {
		return new BeeLangTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules2.mixin(
								new BeeLangTestLanguageRuntimeModule(), 
								new BeeLangTestLanguageUiModule(TestsActivator.getInstance()) {
									@Override
									public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
										return ProposalProvider.class;
									}
									
									@SuppressWarnings("unused")
									public AbstractBug326948Test bindTest() {
										return AbstractBug326948Test.this;
									}
								},
								new SharedStateModule()));
			}
		};
	}
	
}
