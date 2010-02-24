/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.TwoContextsTestLanguageUiModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.AbstractTwoContextsTestLanguageProposalProvider;
import org.eclipse.xtext.util.Modules2;

import com.google.common.base.Predicate;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class TwoContextsContentAssistTest extends AbstractXtextTests {

	public void testTwoContexts() throws Exception {
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
						new TwoContextsTestLanguageUiModule(Activator.getInstance()){
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
		return new ContentAssistProcessorTestBuilder(standAloneSetup, this);
	}

	public static class TwoContextsTestLanguageTestProposals extends AbstractTwoContextsTestLanguageProposalProvider {
		@Override
		public void completeKeyword(Keyword keyword, final ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeKeyword(keyword, context, filter(acceptor, new Predicate<ICompletionProposal>() {
				public boolean apply(ICompletionProposal input) {
					if (!input.getDisplayString().startsWith(context.getPrefix()))
						throw new IllegalStateException("proposed element '"+input.getDisplayString()+"' does not start with '"+ context.getPrefix()+"'");
					return true;
				}
			}));
		}
	}
}
