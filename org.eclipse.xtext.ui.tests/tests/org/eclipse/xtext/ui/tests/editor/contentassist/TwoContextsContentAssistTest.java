/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.TwoContextsTestLanguageUiModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.AbstractTwoContextsTestLanguageProposalProvider;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class TwoContextsContentAssistTest extends AbstractXtextTests implements ResourceLoadHelper {

	@Test public void testTwoContexts() throws Exception {
    	newBuilder(getGrammarSetup()).append("Foo; FooBar; Bar refersTo Foo").assertText(";", "Foo", "FooBar");
    }

    /**
	 * @return
	 */
	private ISetup getGrammarSetup() {
		return new TwoContextsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new TwoContextsTestLanguageRuntimeModule(),
						new TwoContextsTestLanguageUiModule(TestsActivator.getInstance()){
					@Override
					public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
						return TwoContextsTestLanguageTestProposals.class;
					}
				},
				new SharedStateModule()));
			}
		};
	}

	protected ContentAssistProcessorTestBuilder newBuilder(ISetup standAloneSetup) throws Exception {
		with(standAloneSetup);
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}

	public static class TwoContextsTestLanguageTestProposals extends AbstractTwoContextsTestLanguageProposalProvider {
		@Override
		public void completeKeyword(Keyword keyword, final ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeKeyword(keyword, context, new FilteringCompletionProposalAcceptor(acceptor, new Predicate<ICompletionProposal>() {
				@Override
				public boolean apply(ICompletionProposal input) {
					if (!input.getDisplayString().startsWith(context.getPrefix()))
						throw new IllegalStateException("proposed element '"+input.getDisplayString()+"' does not start with '"+ context.getPrefix()+"'");
					return true;
				}
			}));
		}
	}
	

	public static class FilteringCompletionProposalAcceptor extends ICompletionProposalAcceptor.Delegate {

		private final Predicate<ICompletionProposal> filter;

		public FilteringCompletionProposalAcceptor(ICompletionProposalAcceptor delegate, Predicate<ICompletionProposal> filter) {
			super(delegate);
			this.filter = filter;
		}
		
		@Override
		public void accept(ICompletionProposal proposal) {
			if (filter.apply(proposal))
				super.accept(proposal);
		}
		
	}
}
