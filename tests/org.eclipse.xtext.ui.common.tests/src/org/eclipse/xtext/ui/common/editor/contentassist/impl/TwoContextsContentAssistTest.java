/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class TwoContextsContentAssistTest extends AbstractXtextTests {

	public void testTwoContexts() throws Exception {
    	newBuilder(getGrammarSetup()).append("Foo; FooBar; Bar refersTo Foo").assertText(";", "FooBar");
    }

    /**
	 * @return
	 */
	private ISetup getGrammarSetup() {
		return new TwoContextsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new TwoContextsTestLanguageRuntimeModule(), new TwoContextsTestLanguageUiModule(){

					@Override
					public Class<? extends IProposalProvider> bindIProposalProvider() {
						return TwoContextsTestLanguageTestProposals.class;
					}
				});
			}
		};
	}

	protected ContentAssistProcessorTestBuilder newBuilder(ISetup standAloneSetup) throws Exception {
		with(standAloneSetup);
		return new ContentAssistProcessorTestBuilder(standAloneSetup, this);
	}

	public static class TwoContextsTestLanguageTestProposals extends org.eclipse.xtext.ui.common.editor.contentassist.impl.GenTwoContextsTestLanguageProposals {
		@Override
		public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
				IContentAssistContext contentAssistContext) {
			List<? extends ICompletionProposal> completeKeyword = super.completeKeyword(keyword, contentAssistContext);
			for (ICompletionProposal iCompletionProposal : completeKeyword) {
				if (!iCompletionProposal.getDisplayString().startsWith(contentAssistContext.getMatchString()))
					throw new IllegalStateException("proposed element '"+iCompletionProposal.getDisplayString()+"' does not start with '"+ contentAssistContext.getMatchString()+"'");
			}
			return completeKeyword;
		}
	}
}
